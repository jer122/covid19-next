package com.covid19next;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableBatchProcessing // 배치 기능 활성화
@EnableJpaAuditing
@EnableAspectJAutoProxy
@SpringBootApplication
public class Covid19NextBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19NextBatchApplication.class, args);
	}

}
