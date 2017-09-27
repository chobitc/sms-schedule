package org.sagesource.smsschedule.thirdservice.sms;

import org.sagesource.smsschedule.commons.ObjectUtils;
import org.sagesource.smsschedule.commons.SignUtils;
import org.sagesource.smsschedule.commons.StringUtils;
import org.sagesource.smsschedule.commons.http.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;
import java.util.TreeMap;


/**
 * <p>阿里短信服务Wrapper</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/27
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@Service
public class AliSmsWrapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(AliSmsWrapper.class);

	@Value("${api.alibaba.sms.url}")
	private String aliSmsUrl;

	@Autowired
	private RestClient restClient;

	/**
	 * 发送短信
	 *
	 * @param sendConfig
	 */
	public void send(SendConfig sendConfig) throws Exception {
		try {
			// 组装request对象
			AliSmsSendRequest request = new AliSmsSendRequest();
			request.setAccessKeyId(sendConfig.getAccessKeyId());
			request.setAccessSecret(sendConfig.getAccessSecret());
			request.setPhoneNumbers(sendConfig.getPhoneNumber());
			request.setSignName(sendConfig.getSignName());
			request.setTemplateCode(sendConfig.getTemplateCode());
			request.setTemplateParam(sendConfig.getTemplateParam());
			request.setOutId("sms-schedule");

			LOGGER.info("[send]发送短信 | phoneNumber=[{}],signName=[{}],templateParam=[{}],templateCode=[{}]",
					sendConfig.getPhoneNumber(), sendConfig.getSignName(), sendConfig.getTemplateParam(), sendConfig.getTemplateCode());

			// 转换为Map
			TreeMap<String, Object> parasMap = ObjectUtils.convertToTreeMap(request);
			// 构建查询和待加签字符串
			String sortedQueryString = builtParasStr(parasMap);
			// 加签
			String signature = sign(request, sortedQueryString);
			// 构建请求URL
			StringBuilder url = new StringBuilder(aliSmsUrl).append("Signature=").append(signature).append("&").append(sortedQueryString);
			restClient.getForJson(url.toString());
		} catch (HttpClientErrorException e) {
			LOGGER.error("[send]发送短信 | http_status=[{}] | http_body=[{}]", e.getStatusCode(), e.getResponseBodyAsString());
		} catch (Exception e) {
			throw e;
		}
	}

	//.............//

	/**
	 * 构建参数字符串
	 *
	 * @param parasMap
	 * @return
	 * @throws Exception
	 */
	private String builtParasStr(TreeMap<String, Object> parasMap) throws Exception {
		StringBuilder sortQueryStringTmp = new StringBuilder();
		for (Map.Entry<String, Object> entry : parasMap.entrySet()) {
			sortQueryStringTmp.append("&")
					.append(StringUtils.specialUrlEncode(entry.getKey()))
					.append("=")
					.append(StringUtils.specialUrlEncode(entry.getValue().toString()));
		}
		// 去除第一个多余的&符号
		String sortedQueryString = sortQueryStringTmp.substring(1);
		return sortedQueryString;
	}

	/**
	 * 参数加签
	 *
	 * @param request
	 * @param sortedQueryString
	 * @return
	 * @throws Exception
	 */
	private String sign(AliSmsSendRequest request, String sortedQueryString) throws Exception {
		StringBuilder stringToSign = new StringBuilder();
		stringToSign.append("GET").append("&");
		stringToSign.append(StringUtils.specialUrlEncode("/")).append("&");
		stringToSign.append(StringUtils.specialUrlEncode(sortedQueryString));
		// 加签
		String signStr = SignUtils.signByHmacSHA1(request.getAccessSecret() + "&", stringToSign.toString());
		// 签名最后也要做特殊URL编码
		String signature = StringUtils.specialUrlEncode(signStr);
		return signature;
	}

	//.............//
	public static class SendConfig {
		private String accessKeyId;
		private String accessSecret;
		/**
		 * 手机号
		 */
		private String phoneNumber;
		/**
		 * 签名
		 */
		private String signName;
		/**
		 * 模板参数值
		 */
		private String templateParam;
		/**
		 * 模板编号
		 */
		private String templateCode;

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

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
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
	}
}
