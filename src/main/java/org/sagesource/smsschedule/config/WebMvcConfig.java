package org.sagesource.smsschedule.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * <p>Spring Web Mvc 配置</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/28
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@Configuration
@ConditionalOnClass({JSON.class}) // 判断JSON这个类文件是否存在，存在才会创建配置
public class WebMvcConfig {

	/**
	 * 使用fastjson作为message converts
	 *
	 * @return
	 */
	@Bean
	public HttpMessageConverters messageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();//2

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);

		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}

}
