package com.happy.controller;

import com.alibaba.fastjson.JSONObject;
import com.happy.entity.Response;
import com.happy.enums.ResultEnum;
import com.happy.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @author wangjun
 * @Title: WXLoginController
 * @ProjectName newHappy
 * @Description: 微信登陆授权
 * @date 2018/10/10 10:29
 */
@RestController
@RequestMapping("/wx/auth")
public class WXLoginController extends BaseController {

    @Value("${wx.auth.appId}")
    private String appId;

    @Value("${wx.auth.secret}")
    private String secret;

    @Value("${wx.auth.code.url}")
    private String codeUrl;

    @Value("${wx.auth.code.redirectUrl}")
    private String redirectUrl;

    @Value("${wx.auth.code.responseType}")
    private String responseType;

    @Value("${wx.auth.code.scope}")
    private String scope;

    @Value("${wx.auth.code.state}")
    private String state;

    @Value("${wx.auth.accessToken.url}")
    private String accessTokenUrl;

    @Value("${wx.auth.accessToken.grantType}")
    private String grantType;

    @Value("${wx.auth.customerInfo.url}")
    private String customerInfoUrl;

    @Value("${property.index.url}")
    private String indexUrl;



    /**
     * 登陆授权码获取
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/getCode")
    public Object getCode(HttpServletResponse response) throws Exception{
        StringBuffer sb = new StringBuffer();
        sb.append(codeUrl);
        sb.append("appid=");
        sb.append(appId);
        sb.append("&");
        sb.append("redirect_uri=");
        //sb.append(URLEncoder.encode(redirectUrl, "UTF-8"));
        sb.append(redirectUrl);
        sb.append("&");
        sb.append("response_type=");
        sb.append(responseType);
        sb.append("&");
        sb.append("scope=");
        sb.append(scope);
        sb.append("&");
        sb.append("state=#");
        sb.append(state);
        String authUrl = sb.toString();
        response.sendRedirect(authUrl);
        Response result = new Response();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return buildResponse(result);
    }

    @RequestMapping("/getAccessToken")
    public Object getAccessToken(@RequestParam String code, HttpServletResponse response) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(accessTokenUrl);
        sb.append("appid=").append(appId).append("&");
        sb.append("secret=").append(secret).append("&");
        sb.append("code=").append(code).append("&");
        sb.append("grant_type=").append(grantType);
        String accessTokenUrl = sb.toString();
        String accessTokenData = HttpClientUtil.httpGetRequest(accessTokenUrl);
        JSONObject accessTokenJson = JSONObject.parseObject(accessTokenData);
        String accessToken = accessTokenJson.getString("access_token");
        String openId = accessTokenJson.getString("openid");

        StringBuffer userInfo = new StringBuffer();
        userInfo.append(customerInfoUrl);
        userInfo.append("access_token=").append(accessToken).append("&");
        userInfo.append("openid=").append(openId);
        String userInfoUrl = userInfo.toString();
        String userInfoData = HttpClientUtil.httpGetRequest(userInfoUrl);
        response.sendRedirect(indexUrl);
        Response result = new Response();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return buildResponse(result);
    }
}
