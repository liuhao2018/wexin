package com.liuhao.weixin;

import com.liuhao.weixin.model.AccessTokenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@SpringBootApplication
public class WeixinApplication {

	@Value("${weixin.granttype}")
	private String grantType;

	@Value("${weixin.appid}")
	private String appid;

	@Value("${weixin.secret}")
	private String secret;

	public static void main(String[] args) {
		SpringApplication.run(WeixinApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public AccessTokenRequest accessToken() {
		return new AccessTokenRequest(grantType,appid,secret);
	}

}
