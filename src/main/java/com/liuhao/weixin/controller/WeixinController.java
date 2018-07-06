package com.liuhao.weixin.controller;

import com.liuhao.weixin.model.WeixinMessage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wx")
@RestController
public class WeixinController {

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public WeixinMessage responseMessage(@RequestBody WeixinMessage weixinMessage) {
        WeixinMessage response = new WeixinMessage();
        if ("text".equals(weixinMessage.getMsgType())) {
            response.setToUserName(weixinMessage.getFromUserName());
            response.setFromUserName(weixinMessage.getToUserName());
            response.setMsgType("text");
            response.setCreateTime(System.currentTimeMillis());
            response.setContent(weixinMessage.getContent());
        }else {

        }
        return response;
    }

}
