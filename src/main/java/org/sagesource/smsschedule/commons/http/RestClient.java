package org.sagesource.smsschedule.commons.http;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * <p>REST API Client</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/27
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@Component
public class RestClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class);

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * GET方法,将json返回为对象
	 *
	 * @param url
	 * @param <T>
	 * @return
	 */
	public <T> T getForJson(String url) throws Exception {
		// 由于Spring会对请求的url再做一次encode,这里要用URI的方式才不会
		String result = restTemplate.getForObject(new URI(url), String.class);
		LOGGER.info("[getForJson]GET请求 | url=[{}] | result=[{}]", url, result);
		return (T) JSON.parseObject(result);
	}
}
