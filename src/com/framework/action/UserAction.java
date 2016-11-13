package com.framework.action;

import com.AjaxActionSupport;
import com.framework.ProjectSettings;
import com.framework.utils.Logger;
import com.framework.utils.OpenId;
import com.qimpay.database.MenuTree;
import com.qimpay.database.UserInfo;
import com.qimpay.database.weixin.MerchantInfo;
import com.qimpay.database.weixin.WXUserInfo;

import java.io.IOException;
import java.text.DateFormat;
import java.util.*;

public class UserAction extends AjaxActionSupport {
    private static String  MAINPAGE ="mainpage";
    private static String  LOGIN="loginpage";
    private static String  USERINFOJSP="userinfojsp";
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    private String loginErrorMessage;
    private List<Object> menulist = new ArrayList<>();
    public List<Object> getMenulist() {
        return menulist;
    }

    public void setMenulist(List<Object> menulist) {
        this.menulist = menulist;
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public void setLoginErrorMessage(String loginErrorMessage) {
        this.loginErrorMessage = loginErrorMessage;
    }

    public String Login() {
        try {
            if (getParameter("loginrole").toString().equals("1")) {
                Map paramap = new HashMap();
                paramap.put("uname", getParameter("uname").toString());
                paramap.put("upwd", getParameter("upwd").toString());
                paramap.put("merchantid",ProjectSettings.getId());
                UserInfo userInfo = UserInfo.getUserInfoByAcount(paramap);
                if (null != userInfo) {
                    if (userInfo.getActive()!=1){
                        loginErrorMessage = "账号已经冻结";
                        return LOGIN;
                    }
                    getRequest().getSession().setAttribute("uname", userInfo.getUname());
                    getRequest().getSession().setAttribute("unick", userInfo.getUnick());
                    getRequest().getSession().setAttribute("uid", userInfo.getId());
                    getRequest().getSession().setAttribute("roleval", userInfo.getRole());
                    getRequest().getSession().setAttribute("role", userInfo.getRole() == 999 ? "管理员" : userInfo.getRole() == 1 ? "机构" : userInfo.getRole() == 2 ? "销售" : userInfo.getRole() == 3 ? "职员" : "未知");
                    return "gomainpage";
                } else {
                    loginErrorMessage = "账号密码，验证码有校验不通过"+getParameter("uname").toString();
                    return LOGIN;
                }
            }
            else if (getParameter("loginrole").toString().equals("2")) {
                Map paramap = new HashMap();
                paramap.put("uname", getParameter("uname").toString());
                paramap.put("upwd", getParameter("upwd").toString());
                WXUserInfo  wxuserInfo = WXUserInfo.getWXUserInfoByAcount(paramap);
                if (null != wxuserInfo) {
                    getRequest().getSession().setAttribute("uname",wxuserInfo.getSubmchid());
                    getRequest().getSession().setAttribute("unick",wxuserInfo.getSubmchid());
                    getRequest().getSession().setAttribute("uid",0);
                    getRequest().getSession().setAttribute("roleval", -1);//微信-1 京东-2 支付宝-3
                    getRequest().getSession().setAttribute("role","商户");
                    return "gomainpage";
                } else {
                    loginErrorMessage = "账号密码，验证码有校验不通过";
                    return LOGIN;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            loginErrorMessage = "账号密码，验证码有校验不通过";
            return LOGIN;
        }
        return LOGIN;
    }

    public String Initmainpage() {
        List<MenuTree> menutreelist = MenuTree.getMenuNodeByUid(Long.parseLong(getRequest().getSession().getAttribute("roleval").toString()));
        for (MenuTree m : menutreelist) {
            List<MenuTree> prem = MenuTree.getMenuNodeByPreId(m.getId(),Long.parseLong(getRequest().getSession().getAttribute("roleval").toString()));
            Map mapitem = new HashMap();
            mapitem.put("prenode",m);
            mapitem.put("subnode",prem);
            menulist.add(mapitem);
        }
        return "mainpagejsp";
    }

    public String updateUserInfoPwd() {
        Map<String, Object> param=new HashMap<String, Object>();
        if (getAttribute("roleval").equals(999)){
            param.put("upwd","123");
            param.put("uname",getParameter("salemanname"));
            param.put("merchantid",(ProjectSettings.getId()));
           if ( UserInfo.updateUserInfoPwd(param)){
               return AjaxActionComplete(true);
           }
            else
               return AjaxActionComplete(false);
        }
        return AjaxActionComplete(false);
    }

    public String Logout(){
        getRequest().getSession().removeAttribute("uname");
        getRequest().getSession().invalidate();
        return LOGIN;
    }

    public String Usergroup(){
        return "usergroup";
    }

    public String FetchRole(){
        Map map = new HashMap<>();
        if (null!=getParameter("roleval") && !getParameter("roleval").equals("")){
            map.put("roleval",Integer.parseInt(getParameter("roleval").toString()));
            map.put("merchantid",ProjectSettings.getId());
            List<HashMap> userInfo = UserInfo.getAllUserInfo(map);
            map.clear();
            map.put("totalcount",userInfo.size());
            userInfo.add(0, (HashMap) map);
            return AjaxActionComplete(userInfo);
        }
        else
            map.put("errorMessage","Error!") ;
        return AjaxActionComplete(map);
    }

    public String userInfo(){
        try {
            String uname = getParameter("uname").toString();
            Map<String, Object> param=new HashMap<String, Object>();
            param.put("uname",uname);
            param.put("merchantid",ProjectSettings.getId());
            userInfo = UserInfo.getUserInfoByAcount(param);
            if (null!=userInfo){
                return USERINFOJSP;
            }
            return AjaxActionComplete("page404");
        }
        catch (Exception e){
            return AjaxActionComplete("page404");
        }
    }


    public void bindwx() throws IOException {
        String subMerchantId = getParameter("tuid").toString();
        UserInfo userInfo = UserInfo.getUserInfoById(Long.parseLong(subMerchantId));
        if (userInfo != null) {
            MerchantInfo merchantInfo = MerchantInfo.getMerchantInfoById(ProjectSettings.getId());
            if (merchantInfo != null) {
//                String redirect_uri = getRequest().getRequestURL().toString();
//                redirect_uri = redirect_uri.substring(0, redirect_uri.lastIndexOf('/'));
//                redirect_uri = redirect_uri.substring(0, redirect_uri.lastIndexOf('/') + 1) + "/weixin/rtopenid.jsp";
                String redirect_uri =  getRequest().getScheme()+"://" + getRequest().getServerName() + getRequest().getContextPath() + "/weixin/rtopenid.jsp";
                String perPayUri = String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +
                                "%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=%s#wechat_redirect",
                        merchantInfo.getAppid(), redirect_uri, subMerchantId);
                getResponse().sendRedirect(perPayUri);
                return;
            }
        }
    }

    public String updateWeixinIdById() throws Exception {
        String subMerchantId = getParameter("id").toString();
        String code = getParameter("code").toString();
        if (subMerchantId.isEmpty() || code.isEmpty()) {
            return AjaxActionComplete(false);
        }
        MerchantInfo merchantInfo = MerchantInfo.getMerchantInfoById((ProjectSettings.getId()));
        String appid =  merchantInfo.getAppid();
        String appsecret =  merchantInfo.getAppsecret();
        System.out.println("code="+ getParameter("code").toString());
        System.out.println("appid="+appid);
        System.out.println("appsecret="+appsecret);
        OpenId openId = new OpenId(appid, appsecret, getParameter("code").toString());
        if (!openId.getRequest()) {
        }
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("uid",subMerchantId);
        resultMap.put("openid","");
        UserInfo.updateUserInfoOpenid(resultMap);
        resultMap.put("openid",openId.getOpenId());
        if (UserInfo.updateUserInfoOpenid(resultMap)){
            return AjaxActionComplete(true);
        }
        else
        return AjaxActionComplete(false) ;
    }

    public String getdt(){
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM,Locale.CHINA);
        String dt = df.format(date);
        Map  map=new HashMap<>();
        map.put("new",dt);
        return   AjaxActionComplete(map);
    }
}
