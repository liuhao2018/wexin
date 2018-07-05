package com.liuhao.weixin.model;

public class AccessTokenRequest {
    private String grant_type;
    private String appid;
    private String secret;

    public AccessTokenRequest() {
    }

    public AccessTokenRequest(String grant_type, String appid, String secret) {
        this.grant_type = grant_type;
        this.appid = appid;
        this.secret = secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "AccessTokenRequest{" +
                "grant_type='" + grant_type + '\'' +
                ", appid='" + appid + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
