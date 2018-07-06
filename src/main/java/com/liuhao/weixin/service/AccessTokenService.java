package com.liuhao.weixin.service;

import com.liuhao.weixin.model.AccessToken;
import com.liuhao.weixin.model.AccessTokenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class AccessTokenService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccessTokenRequest accessTokenRequest;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${weixin.accesstoken.url}")
    private String accessTokenUrl;


    @Scheduled(fixedRate = 7200 * 1000)
    public void refreshToken() {
        AccessToken accessToken = restTemplate.getForObject(accessTokenUrl,
                AccessToken.class,accessTokenRequest.getGrant_type(),
                accessTokenRequest.getAppid(),accessTokenRequest.getSecret());
        if (accessToken != null && accessToken.getAccess_token() != null) {
            stringRedisTemplate.boundValueOps("access_token").set(accessToken.getAccess_token());
            stringRedisTemplate.expire("access_token",7200 * 1000, TimeUnit.MILLISECONDS);
        }
    }
}
