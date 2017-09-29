package org.sagesource.smsschedule.entity;

import java.io.Serializable;

/**
 * <p>短信模板实体</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public class SmsTemplateInfoEntity implements Serializable {
	private static final long serialVersionUID = -7887813003637056259L;

	/**
	 * 模板类型
	 */
	private String templateType;
	/**
	 * 渠道名称
	 */
	private String channelName;
	/**
	 * 渠道模板编号
	 */
	private String templateCode;
	/**
	 * 模板签名
	 */
	private String templateSign;
	/**
	 * 渠道模板参数
	 */
	private String templatePara;

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTemplatePara() {
		return templatePara;
	}

	public void setTemplatePara(String templatePara) {
		this.templatePara = templatePara;
	}

	public String getTemplateSign() {
		return templateSign;
	}

	public void setTemplateSign(String templateSign) {
		this.templateSign = templateSign;
	}
}
