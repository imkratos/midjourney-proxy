package com.github.novicezk.midjourney.controller;

import cn.hutool.core.text.CharSequenceUtil;
import com.github.novicezk.midjourney.domain.DiscordAccount;
import com.github.novicezk.midjourney.dto.SettingsDTO;
import com.github.novicezk.midjourney.loadbalancer.DiscordInstance;
import com.github.novicezk.midjourney.loadbalancer.DiscordLoadBalancer;
import com.github.novicezk.midjourney.result.Message;
import com.github.novicezk.midjourney.util.AsyncLockUtils;
import com.github.novicezk.midjourney.util.SnowFlake;
import com.github.novicezk.midjourney.wss.handle.AccountInfoHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

import static com.github.novicezk.midjourney.ReturnCode.VALIDATION_ERROR;

@Api(tags = "账号查询")
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
	private final DiscordLoadBalancer loadBalancer;

	@ApiOperation(value = "指定ID获取账号")
	@GetMapping("/{id}/fetch")
	public DiscordAccount fetch(@ApiParam(value = "账号ID") @PathVariable String id) {
		DiscordInstance instance = this.loadBalancer.getDiscordInstance(id);
		return instance == null ? null : instance.account();
	}

	@ApiOperation(value = "查询所有账号")
	@GetMapping("/list")
	public List<DiscordAccount> list() {
		return this.loadBalancer.getAllInstances().stream().map(DiscordInstance::account).toList();
	}


	@ApiOperation(value = "info信息")
	@GetMapping("{id}/info")
	public Message<DiscordAccount> info(@ApiParam(value = "channel-id") @PathVariable String id) {
		DiscordInstance instance = this.loadBalancer.getDiscordInstance(id);
		if(Objects.isNull(instance)){
			return Message.failure("channel-id 不存在");
		}
		if(CharSequenceUtil.isBlank(instance.account().getFastTimeRemaining())){
			try {
				instance.info(SnowFlake.INSTANCE.nextId());
				AsyncLockUtils.waitForLock(AccountInfoHandler.ACCOUNT_INFO_LOCK_KEY+instance.getInstanceId(), Duration.ofMinutes(1L));
			} catch (TimeoutException e) {
				return Message.failure("获取info 信息失败: "+e.getMessage());
			}
		}
		return Message.success(instance.account());
	}

	@ApiOperation(value = "settings")
	@PostMapping("{id}/settings")
	public  Message<Void> settings(@ApiParam(value = "账号ID") @PathVariable String id,
											 @RequestBody SettingsDTO value){
		DiscordInstance instance = this.loadBalancer.getDiscordInstance(id);
		if(Objects.isNull(instance)){
			return Message.failure("channel-id 不存在");
		}

		if(Objects.isNull(value) || Objects.isNull(value.getAttr())){
			return Message.of(VALIDATION_ERROR,"value参数错误");
		}

		Message<Void> response = instance.settings(SnowFlake.INSTANCE.nextId(),value.getAttr().getValue());
		return response;
	}

}