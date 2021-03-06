package com.xcompany.xproject.zuul.server;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableResourceServer
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SpringApplication.run(Application.class, args);
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                LOGGER.debug(beanName);
            }
        };
    }
	
//	@Bean
//	public AccessFilter accessFilter() {
//		return new AccessFilter();
//	}
	
//	@Bean
//	public ExceptionFilter exceptionFilter() {
//		return new ExceptionFilter();
//	}
	
//	@Bean
//	public RequestInterceptor requestTokenBearerInterceptor() {
//	    return new RequestInterceptor() {
//			@Override
//			public void apply(feign.RequestTemplate template) {
//				// TODO Auto-generated method stub
//				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
//	                    SecurityContextHolder.getContext().getAuthentication().getDetails();
//
//				template.header("Authorization", "bearer " + details.getTokenValue());
//			}
//
//	    };
//	}
	
	
}
