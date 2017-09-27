package org.sagesource.smsschedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * <p>组件配置</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/27
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@Configuration
public class CompentConfig {

	/**
	 * 创建RestTemplate
	 *
	 * @return
	 */
	@Bean
	@Primary
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
