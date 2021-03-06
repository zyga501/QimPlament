package com.qimpay.database.weixin;

import com.qimpay.database.WxDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderInfo {
    public static void main(String[] args) throws Exception {
        getOrderInfoById(0);
    }

    public static OrderInfo getOrderInfoById(long id) {
        String statement = "com.qimpay.database.mapping.weixin.orderInfo.getOrderInfoById";
        return WxDatabase.Instance().selectOne(statement, id);
    }

    public static OrderInfo getOrderInfoByTransactionId(String transactionId) {
        String statement = "com.qimpay.database.mapping.weixin.orderInfo.getOrderInfoByTransactionId";
        return WxDatabase.Instance().selectOne(statement, transactionId);
    }

    public static List<HashMap> getOrderInfoListByDate(Map param) {
        String statement = "com.qimpay.database.mapping.weixin.orderInfo.getOrderInfoListByDate";
//        Map<String, Object> param=new HashMap<String, Object>();
//        param.put("createuser",createuser);
//        param.put("startdate",startDate);
//        param.put("enddate",endDate);
        return WxDatabase.Instance().selectList(statement,param);
    }

    public static List<HashMap> getOrderInfoList(Map param) {
        String statement = "com.qimpay.database.mapping.weixin.orderInfo.getOrderInfoList";
        return WxDatabase.Instance().selectList(statement,param);
    }

    public static Map getOrderInfoSum(Map param) {
        String statement = "com.qimpay.database.mapping.weixin.orderInfo.getOrderInfoSum";
        return WxDatabase.Instance().selectOne(statement,param);
    }
    
    public static List<HashMap> getOrderExpListByDate(String createuser, String startDate, String endDate) {
        String statement = "com.qimpay.database.mapping.weixin.orderInfo.getOrderExpListByDate";
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("createuser",createuser);
        param.put("startdate",startDate);
        param.put("enddate",endDate);
        return WxDatabase.Instance().selectList(statement,param);
    }

    public static boolean insertOrderInfo(OrderInfo orderInfo) {
        String statement = "com.qimpay.database.mapping.weixin.orderInfo.insertOrderInfo";
        return WxDatabase.Instance().insert(statement, orderInfo) == 1;
    }

    public static List<HashMap> getOrderStatistics(Map param) {
        String statement = "com.qimpay.database.mapping.weixin.orderInfo.getOrderStatistics";
        return WxDatabase.Instance().selectList(statement,param);
    }

    public long getId() {
        return id_;
    }

    public void setId(long id) {
        this.id_ = id;
    }

    public String getAppid() {
        return appid_;
    }

    public void setAppid(String appid) {
        this.appid_ = appid;
    }

    public String getMchId() {
        return mchId_;
    }

    public void setMchId(String mchId) {
        this.mchId_ = mchId;
    }

    public String getSubMchId() {
        return subMchId_;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId_ = subMchId;
    }

    public String getBody() {
        return body_;
    }

    public void setBody(String body) {
        this.body_ = body;
    }

    public String getTransactionId() {
        return transactionId_;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId_ = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo_;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo_ = outTradeNo;
    }

    public String getBankType() {
        return bankType_;
    }

    public void setBankType(String bankType) {
        this.bankType_ = bankType;
    }

    public int getTotalFee() {
        return totalFee_;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee_ = totalFee;
    }

    public String getTimeEnd() {
        return timeEnd_;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd_ = timeEnd;
    }

    public long getCreateUser() {
        return createUser_;
    }

    public void setCreateUser(long createUser) {
        this.createUser_ = createUser;
    }

    public String getOpenId() {
        return openId_;
    }

    public void setOpenId(String openId) {
        this.openId_ = openId;
    }

    private long id_;
    private String appid_;
    private String mchId_;
    private String subMchId_;
    private String body_;
    private String transactionId_;
    private String outTradeNo_;
    private String bankType_;
    private int totalFee_;
    private String timeEnd_;
    private long createUser_;
    private String openId_;
}
