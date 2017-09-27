package org.sagesource.smsschedule.thirdservice.sms;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>阿里短信服务Request</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/27
 *     email       sage.xue@vipshop.com
 * </pre>
 */
public class AliSmsSendRequest extends AliSmsSysConfig {
	/**
	 * API名称
	 */
	@JSONField(name = "Action")
	private String action = "SendSms";
	/**
	 * API版本号
	 */
	@JSONField(name = "Version")
	private String version = "2017-05-25";
	/**
	 * API区域ID
	 */
	@JSONField(name = "RegionId")
	private String regionId = "cn-hangzhou";
	/**
	 * 短信手机号码
	 */
	@JSONField(name = "PhoneNumbers")
	private String phoneNumbers;
	/**
	 * 短信签名
	 */
	@JSONField(name = "SignName")
	private String signName;
	/**
	 * 短信模板参数
	 */
	@JSONField(name = "TemplateParam")
	private String templateParam;
	/**
	 * 短信模板编号
	 */
	@JSONField(name = "TemplateCode")
	private String templateCode;
	/**
	 * 外部流水扩展字段
	 */
	@JSONField(name = "OutId")
	private String outId;

	public String getAction() {
		return action;
	}

	public String getVersion() {
		return version;
	}

	public String getRegionId() {
		return regionId;
	}

	public String getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getTemplateParam() {
		return templateParam;
	}

	public void setTemplateParam(String templateParam) {
		this.templateParam = templateParam;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}
}
