package com.liuhao.weixin.controller;

import com.liuhao.weixin.model.Config;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wx")
@RestController
public class WeixinController {

    @GetMapping
    public String initConfig(Config config) {
        return config.getEchostr();
    }

}
