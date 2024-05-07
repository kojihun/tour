package com.develop.tour;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class TourApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TourApplication.class, args); // SpringApplication.run 메서드를 실행하면 스프링 빈 컨테이너인 Application Context를 리턴한다.

		Environment env = ctx.getBean(Environment.class); // ApplicationContext의 getBean 메서드는 인자에 맞는 스프링 빈 객체를 리턴한다. application.properties에 저장된 키-밸류 값을 확인하기 위해 Environment 객체를 가져온다.
		String portValue = env.getProperty("server.port");
		log.info("Port : {}", portValue);

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(name -> log.info("Bean Name : {}", name)); // ApplicationContext가 관리하고 있는 스프링 빈들의 이름을 배열로 가져온다.
	}
}
