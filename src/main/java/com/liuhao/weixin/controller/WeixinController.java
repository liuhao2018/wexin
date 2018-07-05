package com.liuhao.weixin.controller;

import com.liuhao.weixin.model.WeixinMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wx")
@RestController
public class WeixinController {

    @RequestMapping(produces = "application/xml;charset=UTF-8")
    public WeixinMessage responseMessage(WeixinMessage weixinMessage) {
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
