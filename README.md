<div align="center">

<h1 align="center">midjourney-proxy</h1>

[![GitHub release](https://img.shields.io/static/v1?label=release&message=v2.5.1&color=blue)](https://www.github.com/novicezk/midjourney-proxy)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

## 主要功能
- [x] 支持 Imagine 指令和相关动作
- [x] Imagine 时支持添加图片base64，作为垫图
- [x] 支持 Blend(图片混合)、Describe(图生文) 指令
- [x] 支持任务实时进度
- [x] 支持中文prompt翻译，需配置百度翻译或gpt
- [x] prompt 敏感词预检测，支持覆盖调整
- [x] user-token 连接 wss，可以获取错误信息和完整功能
- [x] 支持 discord域名(server、cdn、wss)反代，配置 mj.ng-discord
- [x] 支持多账号配置，每个账号可设置对应的任务队列

## 以下为在原版基础增加的功能
- [x] 支持U之后的所有相关动作：Zoom(图片变焦)、Pan(焦点移动) 等
- [x] 支持U之后的所有相关动作：Vary(Strong)、Vary(Subtle) 等
- [x] 支持帐户info功能
- [x] 支持settings所有属性
- [x] 支持Upscale(2x)、Upscale(4x)

## 使用前提
1. 注册并订阅 MidJourney，创建自己的频道，参考 https://docs.midjourney.com/docs/quick-start
2. 获取用户Token、服务器ID、频道ID：[获取方式](./docs/discord-params.md)

## 配置项
- mj.accounts: 参考 [账号池配置](./docs/config.md#%E8%B4%A6%E5%8F%B7%E6%B1%A0%E9%85%8D%E7%BD%AE%E5%8F%82%E8%80%83)
- mj.task-store.type: 任务存储方式，默认in_memory(内存\重启后丢失)，可选redis
- mj.task-store.timeout: 任务存储过期时间，过期后删除，默认30天
- mj.api-secret: 接口密钥，为空不启用鉴权；调用接口时需要加请求头 mj-api-secret
- mj.translate-way: 中文prompt翻译成英文的方式，可选null(默认)、baidu、gpt、deepl
- 更多配置查看 [配置项](./docs/config.md)

## 相关文档
1. [API接口说明](./docs/api.md)
2. [版本更新记录](https://github.com/imkratos/midjourney-proxy/wiki/%E6%9B%B4%E6%96%B0%E8%AE%B0%E5%BD%95)

## 注意事项
1. 作图频繁等行为，可能会触发midjourney账号警告，请谨慎使用
2. 常见问题及解决办法见 [Wiki / FAQ](https://github.com/imkratos/midjourney-proxy/wiki/FAQ)
3. 在 [Issues](https://github.com/imkratos/midjourney-proxy/issues) 中提出其他问题或建议

## 应用项目
依赖此项目且开源的，欢迎联系作者，加到此处展示
- [wechat-midjourney](https://github.com/novicezk/wechat-midjourney) : 代理微信客户端，接入MidJourney，仅示例应用场景，不再更新
- [stable-diffusion-mobileui](https://github.com/yuanyuekeji/stable-diffusion-mobileui) : SDUI，基于本接口和SD，可一键打包生成H5和小程序
- [ChatGPT-Midjourney](https://github.com/Licoy/ChatGPT-Midjourney) : 一键拥有你自己的 ChatGPT+Midjourney 网页服务
- [MidJourney-Web](https://github.com/ConnectAI-E/MidJourney-Web) : 🍎 Supercharged Experience For MidJourney On Web UI

## 其它
如果觉得这个项目对你有所帮助，请帮忙点个star；也可以请作者喝杯茶～

  <img src="https://raw.githubusercontent.com/imkratos/midjourney-proxy/main/docs/wxcode.png" width="220" alt="微信二维码"/>

