package org.sagesource.smsschedule.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <p>Redis 配置</p>
 * <pre>
 *     author      XueQi
 *     date        2017/9/27
 *     email       job.xueqi@gmail.com
 * </pre>
 */
@Configuration
public class RedisConfig {

	/**
	 * 连接池配置
	 *
	 * @return
	 */
	@Bean("jedisPoolConfig")
	@ConfigurationProperties(prefix = "redis.poolConfig")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		return jedisPoolConfig;
	}

	@Bean("connectionFactory")
	@ConfigurationProperties(prefix = "redis")
	public JedisConnectionFactory connectionFactory(@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig) {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setUsePool(true);
		factory.setPoolConfig(jedisPoolConfig);
		return factory;
	}

	@Bean
	public RedisTemplate<String, Object> getRedisTemplate(@Qualifier("connectionFactory") JedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new JdkSerializationRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new JdkSerializationRedisSerializer());

		return template;
	}

}
