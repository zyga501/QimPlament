package com.qimpay.OA.action;

import com.AjaxActionSupport;
import com.framework.ProjectSettings;
import com.framework.utils.OpenId;
import com.framework.utils.PublicFunc;
import com.framework.utils.StringUtils;
import com.qimpay.database.Khzl;
import com.qimpay.database.UserInfo;
import com.qimpay.database.weixin.MerchantInfo;
import org.apache.commons.fileupload.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class KhzlglAction extends AjaxActionSupport {
    public void login() throws IOException {
        String appid = "";
        MerchantInfo merchantInfo = MerchantInfo.getMerchantInfoById((ProjectSettings.getId()));
        if (merchantInfo != null) {
            appid = merchantInfo.getAppid();
        }
        else
            return;
        String redirect_uri =  getRequest().getScheme()+"://" + getRequest().getServerName() + getRequest().getContextPath() + "/weixin/wxlogin.jsp";
        String petOpenidUri = String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +
                        "%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=login#wechat_redirect",
                appid, redirect_uri);
        getResponse().sendRedirect(petOpenidUri);
    }

    public String fetchopenid() throws Exception {
        MerchantInfo merchantInfo = MerchantInfo.getMerchantInfoById((ProjectSettings.getId()));
        String appid =  merchantInfo.getAppid();
        String appsecret =  merchantInfo.getAppsecret();
        OpenId openId = new OpenId(appid, appsecret, getParameter("code").toString());
        if (!openId.getRequest()) {
            return AjaxActionComplete(false) ;
        }
        System.out.println("fopenId="+openId.getOpenId());
        UserInfo userInfo = UserInfo.getUserInfoByOpenid(openId.getOpenId());
        if (null != userInfo) {
            if (userInfo.getActive()!=1){
                return AjaxActionComplete(false) ;
            }
            getRequest().getSession().setAttribute("uname", userInfo.getUname());
            getRequest().getSession().setAttribute("unick", userInfo.getUnick());
            getRequest().getSession().setAttribute("uid", userInfo.getId());
            getRequest().getSession().setAttribute("roleval", userInfo.getRole());
            getRequest().getSession().setAttribute("role", userInfo.getRole() == 999 ? "管理员" : userInfo.getRole() == 1 ? "机构" : userInfo.getRole() == 2 ? "销售" : userInfo.getRole() == 3 ? "职员" : "未知");

            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("URL","../Khzlgl!OAkhzlgl");
            return AjaxActionComplete(true,resultMap);
        } else {
            return AjaxActionComplete(false) ;
        }
    }

    public String uploadkhzlinfo()   {
//        if ((null==getParameter("cardno")) || getParameter("cardno").toString().equals("")) return  AjaxActionComplete(false);
//        Map para = new HashMap<>();
//        para.put("frxm", StringUtils.convertEmptyString(getParameter("frxm").toString()));
//        para.put("zjhm",StringUtils.convertEmptyString(getParameter("zjhm").toString()));
//        para.put("address",StringUtils.convertEmptyString(getParameter("address").toString()));
//        para.put("expirydate",StringUtils.convertEmptyString(getParameter("expirydate").toString()));
//        para.put("fzjg",StringUtils.convertEmptyString(getParameter("fzjg").toString()));
//        para.put("cardno",StringUtils.convertEmptyString(getParameter("cardno").toString()));
//        para.put("cardbank",StringUtils.convertEmptyString(getParameter("cardbank").toString()));
//        para.put("mobilenum",StringUtils.convertEmptyString(getParameter("mobilenum").toString()));
//        para.put("hy",StringUtils.convertEmptyString(getParameter("hy").toString()));
//        para.put("storenum",StringUtils.convertEmptyString(getParameter("storenum").toString()));
//        para.put("rate",StringUtils.convertEmptyString(getParameter("rate").toString()));
//        para.put("area",StringUtils.convertEmptyString(getParameter("area").toString()));
//        para.put("tzero",StringUtils.convertNullableString(getParameter("tzero"),"0"));
//        para.put("postype",StringUtils.convertEmptyString(getParameter("postype").toString()));
//        para.put("wyuserid",StringUtils.convertNullableString(getParameter("wyuserid"),("0")));
//        if (!Khzl.insertkhzlb(para)) {
//            return AjaxActionComplete(false);
//        }
//        Khzl khzl= Khzl.getkhzlb(getParameter("cardno").toString());
//        if (khzl == null) {
//            return AjaxActionComplete(false);
//        }
        System.out.println(getParameter("hfsfzf"));
//        File ff = (File) getParameter("fsfzz");//fdphy,fyhkf,fyhkz,fsfzf,fsfzz
//        if (null!=ff && ff.length()>10) {
//            para.clear();
//            para.put("khid",khzl.getKhid());
//            para.put("zlname","身份证正面");
//            Khzl.insertkhzltab(para);
//            File fm = new File(ProjectSettings.getPicpath() + String.valueOf(khzl.getKhid())+"sfzz.jpg");
//            if (fm.exists()) {
//                return AjaxActionComplete(false);
//            } else {
//                PublicFunc.copyFile(ff.getAbsolutePath(), fm.getAbsolutePath(), false);
//            }
//        }
//        ff = (File) getParameter("fsfzf");//fdphy,fyhkf,fyhkz,fsfzf,fsfzz
//        if (null!= ff && ff.length()>10) {
//            para.clear();
//            para.put("khid",khzl.getKhid());
//            para.put("zlname","身份证反面");
//            Khzl.insertkhzltab(para);
//            File fm = new File(ProjectSettings.getPicpath() + String.valueOf(khzl.getKhid())+"sfzf.jpg");
//            if (fm.exists()) {
//                return AjaxActionComplete(false);
//            } else {
//                PublicFunc.copyFile(ff.getAbsolutePath(), fm.getAbsolutePath(), false);
//            }
//        }
        return AjaxActionComplete(true);
    }

    public String OAkhzlgl(){
        System.out.println("OAkhzlgl");
        return "OAkhzlgl";
    }
}
