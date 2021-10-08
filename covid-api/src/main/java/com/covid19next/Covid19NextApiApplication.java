package com.covid19next;

import com.covid19next.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Covid19NextApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19NextApiApplication.class, args);
	}

}
