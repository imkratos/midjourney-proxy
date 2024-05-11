package com.github.novicezk.midjourney.wss.handle;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.github.novicezk.midjourney.enums.MessageType;
import com.github.novicezk.midjourney.loadbalancer.DiscordInstance;
import com.github.novicezk.midjourney.loadbalancer.DiscordLoadBalancer;
import com.github.novicezk.midjourney.util.AsyncLockUtils;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.springframework.stereotype.Component;

import java.util.Objects;


//@Component
@RequiredArgsConstructor
public class AccountInfoHandler{

    public static final String ACCOUNT_INFO_LOCK_KEY = "mp:account:info:lock:";

    private final DiscordLoadBalancer loadBalancer;

//    @Override
    public void handle(DiscordInstance instance,MessageType messageType, DataObject message) {
        String channelId = message.getString("channel_id");
        DiscordInstance discordInstance = loadBalancer.getDiscordInstance(channelId);
        if(messageType.equals(MessageType.UPDATE) && !Objects.isNull(discordInstance) && CollectionUtil.isNotEmpty(message.getArray("embeds"))){
            parseInfoData(discordInstance,message.getArray("embeds").getObject(0).getString("description"));
            AsyncLockUtils.LockObject lock = AsyncLockUtils.getLock(ACCOUNT_INFO_LOCK_KEY+channelId);
            if(lock !=null){
                lock.awake();
            }
        }
    }

    private void parseInfoData(DiscordInstance discordInstance,String description){
        String[] split = description.split("\n");
        for (String s : split) {
            if (StrUtil.isBlank(s)){
                continue;
            }
            String[] line = s.split(":");
            String key = line[0];
            String value = line[1];
            value = StrUtil.trimToEmpty(value);
            if (key.contains("Fast Time Remaining")) {
                discordInstance.account().setFastTimeRemaining(value);
            } else if (key.contains("Lifetime Usage")) {
                discordInstance.account().setLifeTimeUsage(value);
            } else if (key.contains("Relaxed Usage")) {
                discordInstance.account().setRelaxedUsage(value);
            } else if (key.contains("User ID")) {
                discordInstance.account().setUserId(value);
            } else if (key.contains("Subscription")) {
                discordInstance.account().setSubscription(value+":"+line[2]);
            } else if (key.contains("fast")) {
                discordInstance.account().setFastQueuedJobs(value);
            } else if (key.contains("relax")) {
                discordInstance.account().setRelaxQueuedJobs(value);
            } else if (key.contains("Running Jobs")) {
                discordInstance.account().setRunningJobs(value);
            }
        }
    }
}
