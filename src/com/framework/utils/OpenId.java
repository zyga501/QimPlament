package com.framework.utils;

import net.sf.json.JSONObject;

public class OpenId extends HttpClient {
    private final static String OPENID_API = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    public OpenId(String appid, String appSecret , String code) {
        appid_ = appid;
        appSecret_ = appSecret;
        code_ = code;
    }

    public String getOpenId() { return openid_; }

    @Override
    protected String getAPIUri() {
        return String.format(OPENID_API, appid_, appSecret_, code_);
    }

    @Override
    protected boolean handlerResponse(String responseResult) throws Exception {
        JSONObject jsonParse = JSONObject.fromObject(responseResult);
        if (jsonParse.get("openid") != null) {
            openid_ = jsonParse.get("openid").toString();
            return true;
        }

        Logger.error(this.getClass().getName() + " Get OpenId Failed!");
        Logger.error("Request Url:\r\n" + getAPIUri() + "\r\nResponse Data:\r\n" + responseResult);
        return false;
    }

    private String appid_;
    private String appSecret_;
    private String code_;
    private String openid_;
}
