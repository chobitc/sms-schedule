# sms-schedule #
一个基于Spring-Boot的短信定时发送任务平台.短信的发送供应商基于阿里云.

## 快速开始 ##
在快速开始前,我们首先需要做的是申请开通阿里云的短信服务.获得应用的Access Key Secret和Access Key ID等信息.
具体可以参考
> https://help.aliyun.com/document_detail/59210.html?spm=5176.doc56189.6.542.I6pKai

### 环境变量 ###
由于安全的考虑,所有的配置选项都写到了系统环境变量中.我也强烈建议使用者遵循此方法.
 1.  API_ALIBABA_ACCESSKEY  # Access Key ID
 2.  API_ALIBABA_ACCESSSEC  # Access Key Secret
