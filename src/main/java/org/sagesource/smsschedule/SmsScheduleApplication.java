package org.sagesource.smsschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class SmsScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsScheduleApplication.class, args);
	}
}
