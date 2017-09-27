package org.sagesource.smsschedule.thirdservice;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sagesource.smsschedule.SmsScheduleApplication;
import org.sagesource.smsschedule.thirdservice.sms.AliSmsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>阿里短信服务测试</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/26
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SmsScheduleApplication.class)// 指定spring-boot的启动类
public class AliSmsWrapperTest {

	@Value("${api.alibaba.accessKeyId}")
	private String accessKeyId;
	@Value("${api.alibaba.accessSecret}")
	private String accessSecret;

	@Autowired
	private AliSmsWrapper aliSmsWrapper;

	@Test
	public void sendTest() throws Exception {
		AliSmsWrapper.SendConfig sendConfig = new AliSmsWrapper.SendConfig();
		sendConfig.setAccessKeyId(accessKeyId);
		sendConfig.setAccessSecret(accessSecret);
		sendConfig.setPhoneNumber("15900264873");
		sendConfig.setSignName("7妹每日温馨");
		sendConfig.setTemplateCode("SMS_100270018");

		Map<String, String> paras = new HashMap<>();
		paras.put("name","小宝~");
		paras.put("city","上海");
		paras.put("weather","晴天");
		paras.put("days","120");
		sendConfig.setTemplateParam(JSON.toJSONString(paras));

		aliSmsWrapper.send(sendConfig);
	}

	/**
	 * 签名测试
	 */
	@Test
	public void signTest() throws Exception {
		String                     accessKeyId  = "testId";
		String                     accessSecret = "testSecret";
		java.text.SimpleDateFormat df           = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));// 这里一定要设置GMT时区
		java.util.Map<String, String> paras = new java.util.HashMap<>();
		// 1. 系统参数
		paras.put("SignatureMethod", "HMAC-SHA1");
		paras.put("SignatureNonce", java.util.UUID.randomUUID().toString());
		paras.put("AccessKeyId", accessKeyId);
		paras.put("SignatureVersion", "1.0");
		paras.put("Timestamp", df.format(new java.util.Date()));
		paras.put("Format", "JSON");
		// 2. 业务API参数
		paras.put("Action", "SendSms");
		paras.put("Version", "2017-05-25");
		paras.put("RegionId", "cn-hangzhou");
		paras.put("PhoneNumbers", "15300000001");
		paras.put("SignName", "阿里云短信测试专用");
		paras.put("TemplateParam", "{\"customer\":\"test\"}");
		paras.put("TemplateCode", "SMS_71390007");
		paras.put("OutId", "123");
		// 3. 去除签名关键字Key
		if (paras.containsKey("Signature"))
			paras.remove("Signature");
		// 4. 参数KEY排序
		java.util.TreeMap<String, String> sortParas = new java.util.TreeMap<>();
		sortParas.putAll(paras);
		// 5. 构造待签名的字符串
		java.util.Iterator<String> it                 = sortParas.keySet().iterator();
		StringBuilder              sortQueryStringTmp = new StringBuilder();
		while (it.hasNext()) {
			String key = it.next();
			sortQueryStringTmp.append("&").append(specialUrlEncode(key)).append("=").append(specialUrlEncode(paras.get(key)));
		}
		String        sortedQueryString = sortQueryStringTmp.substring(1);// 去除第一个多余的&符号
		StringBuilder stringToSign      = new StringBuilder();
		stringToSign.append("GET").append("&");
		stringToSign.append(specialUrlEncode("/")).append("&");
		stringToSign.append(specialUrlEncode(sortedQueryString));
		String sign = sign(accessSecret + "&", stringToSign.toString());
		// 6. 签名最后也要做特殊URL编码
		String signature = specialUrlEncode(sign);
		System.out.println(paras.get("SignatureNonce"));
		System.out.println("\r\n=========\r\n");
		System.out.println(paras.get("Timestamp"));
		System.out.println("\r\n=========\r\n");
		System.out.println(sortedQueryString);
		System.out.println("\r\n=========\r\n");
		System.out.println(stringToSign.toString());
		System.out.println("\r\n=========\r\n");
		System.out.println(sign);
		System.out.println("\r\n=========\r\n");
		System.out.println(signature);
		System.out.println("\r\n=========\r\n");
		// 最终打印出合法GET请求的URL
		System.out.println("http://dysmsapi.aliyuncs.com/?Signature=" + signature + sortQueryStringTmp);
	}

	private String specialUrlEncode(String value) throws Exception {
		return java.net.URLEncoder.encode(value, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
	}

	private String sign(String accessSecret, String stringToSign) throws Exception {
		javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
		mac.init(new javax.crypto.spec.SecretKeySpec(accessSecret.getBytes("UTF-8"), "HmacSHA1"));
		byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
		return new BASE64Encoder().encode(signData);
	}
}
