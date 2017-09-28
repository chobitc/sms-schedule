# sms-schedule #
一个基于Spring-Boot的短信定时发送任务平台.短信的发送供应商基于阿里云(可扩展).

## 快速开始 ##
在快速开始前,我们首先需要做的是申请开通阿里云的短信服务.获得应用的Access Key Secret和Access Key ID等信息.
具体可以参考
> https://help.aliyun.com/document_detail/59210.html?spm=5176.doc56189.6.542.I6pKai

### 环境变量 ###
由于安全的考虑,所有的配置选项都写到了系统环境变量中.我也强烈建议使用者遵循此方法.
 1.  API_ALIBABA_ACCESSKEY  # Access Key ID
 2.  API_ALIBABA_ACCESSSEC  # Access Key Secret
 3.  ALIYUN_REDIS_HOST      # Redis的host地址
 4.  ALIYUN_REDIS_PORT      # Redis的port地址
 5.  ALIYUN_REDIS_PASSWORD  # Redis的密码(如果存在的话,不存在请删除redis.password配置)
 
## 设计思路 ##
### 缓存key-value的设计 ###
系统中现阶段规划了以下几个类型key:
 1. sms:channel:list 存放短信通道信息
 2. sms_channel_format: 存放每种类型的短信模板在不同渠道的编号/签名等信息(每个渠道的短信模板占位符的名称最好相同,减少开发量)
 3. sms_channel_receiver: 存放每种类型的短信模板接收者电话列表
#### sms_channel_list ####
```
    数据格式 : map
    key : 渠道名称(ali_sms)
    value : 通信 handler名称 优先级
```

## API 文档 ##

## 待改进计划 ##