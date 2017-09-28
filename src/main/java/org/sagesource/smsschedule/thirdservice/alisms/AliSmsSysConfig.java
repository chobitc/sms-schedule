package org.sagesource.smsschedule.thirdservice.alisms;

import com.alibaba.fastjson.annotation.JSONField;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * <p>阿里短信服务系统配置</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/27
 *     email       job.xueqi@gmail.com
 * </pre>
 */
public class AliSmsSysConfig {

	/**
	 * 阿里云accessKeyId
	 */
	@JSONField(name = "AccessKeyId")
	private String accessKeyId;
	/**
	 * 阿里云access Secret
	 */
	@JSONField(serialize = false)
	private String accessSecret;
	/**
	 * 加签方式
	 */
	@JSONField(name = "SignatureMethod")
	private String signatureMethod = "HMAC-SHA1";
	/**
	 * 签名验证流水号
	 */
	@JSONField(name = "SignatureNonce")
	private String signatureNonce;
	/**
	 * 签名版本号
	 */
	@JSONField(name = "SignatureVersion")
	private String signatureVersion = "1.0";
	/**
	 * 请求时间戳
	 */
	@JSONField(name = "Timestamp")
	private String timestamp;
	/**
	 * 消息返回格式
	 */
	@JSONField(name = "Format")
	private String format = "JSON";

	public AliSmsSysConfig() {
		signatureNonce = UUID.randomUUID().toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));// 这里一定要设置GMT时区
		timestamp = df.format(new java.util.Date());
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessSecret() {
		return accessSecret;
	}

	public void setAccessSecret(String accessSecret) {
		this.accessSecret = accessSecret;
	}

	public String getSignatureMethod() {
		return signatureMethod;
	}

	public String getSignatureNonce() {
		return signatureNonce;
	}

	public String getSignatureVersion() {
		return signatureVersion;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getFormat() {
		return format;
	}


}
