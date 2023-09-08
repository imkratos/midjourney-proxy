package com.github.novicezk.midjourney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.novicezk.midjourney.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("Discord账号")
public class DiscordAccount extends DomainObject {

	@ApiModelProperty("服务器ID")
	private String guildId;
	@ApiModelProperty("频道ID")
	private String channelId;
	@ApiModelProperty("用户Token")
	private String userToken;
	@ApiModelProperty("用户UserAgent")
	private String userAgent = Constants.DEFAULT_DISCORD_USER_AGENT;

	@ApiModelProperty("是否可用")
	private boolean enable = true;

	@ApiModelProperty("并发数")
	private int coreSize = 3;
	@ApiModelProperty("等待队列长度")
	private int queueSize = 10;
	@ApiModelProperty("任务超时时间(分钟)")
	private int timeoutMinutes = 5;


	@ApiModelProperty("userid")
	private String userId;
	@ApiModelProperty("订阅计划剩余")
	private String subscription;

	@ApiModelProperty("快速图片剩余时间(小时)")
	private String fastTimeRemaining;
	@ApiModelProperty("总生成图片数量 (小时)")
	private String lifeTimeUsage;
	@ApiModelProperty("慢速图片数量 (小时)")
	private String relaxedUsage;
	@ApiModelProperty("快速任务")
	private String fastQueuedJobs;
	@ApiModelProperty("慢速任务")
	private String relaxQueuedJobs;
	@ApiModelProperty("运行中任务")
	private String runningJobs;


	@JsonIgnore
	public String getDisplay() {
		return this.channelId;
	}
}
