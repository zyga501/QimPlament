package com.qimpay.database;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsPay {

    public static List<GoodsPay>  getAllGoodsPay() {
        String statement = "com.qimpay.database.mapping.goodspay.getAllGoodsPay";
        return Database.Instance().selectList(statement);
    }

    public static GoodsPay getGoodsPayById(String id) {
        String statement = "com.qimpay.database.mapping.goodspay.getGoodsPayById";
        return Database.Instance().selectOne(statement, id);
    }

    public static GoodsPay getGoodsPayBymap(GoodsPay param) {
        String statement = "com.qimpay.database.mapping.goodspay.getGoodsPayBymap";
        return Database.Instance().selectOne(statement,param);
    }

    public static GoodsPay getGoodsPaypic(Long id) {
        String statement = "com.qimpay.database.mapping.goodspay.getGoodsPaypic";
        return Database.Instance().selectOne(statement,id);
    }
    public static List<GoodsPay> getAllUserInfo(GoodsPay  param) {
        String statement = "com.qimpay.database.mapping.goodspay.getAllUserInfo";
        return Database.Instance().selectList(statement,param);
    }

    public static boolean insertGoodsPay(GoodsPay goodsPay) {
        String statement = "com.qimpay.database.mapping.goodspay.insertGoodsPay";
        return Database.Instance().update(statement, goodsPay) == 1;
    }

    public static boolean updateGoodsPayPic1(GoodsPay param) {
        String statement = "com.qimpay.database.mapping.goodspay.updateGoodsPayPic1";
        return Database.Instance().update(statement, param) == 1;
    }
    public static boolean updateGoodsPayPic3(GoodsPay param) {
        String statement = "com.qimpay.database.mapping.goodspay.updateGoodsPayPic3";
        return Database.Instance().update(statement, param) == 1;
    }
    public static boolean updateGoodsok(GoodsPay param) {
        String statement = "com.qimpay.database.mapping.goodspay.updateGoodsok";
        return Database.Instance().update(statement, param) == 1;
    }
    public static boolean updateGoodslistok(Map param) {
        String statement = "com.qimpay.database.mapping.goodspay.updateGoodslistok";
        return Database.Instance().update(statement, param) > 0;
    }
    public static boolean updateGoodsPayPic2(GoodsPay param) {
        String statement = "com.qimpay.database.mapping.goodspay.updateGoodsPayPic2";
        return Database.Instance().update(statement, param) == 1;
    }
    public static boolean updateGoodsPay(GoodsPay param) {
        String statement = "com.qimpay.database.mapping.goodspay.updateGoodsPay";
        return Database.Instance().update(statement, param) == 1;
    }

    public int getId() {
        return id_;
    }

    public void setId(int id_) {
        this.id_ = id_;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLefuno() {
        return lefuno;
    }

    public void setLefuno(String lefuno) {
        this.lefuno = lefuno;
    }

    public String getPosno() {
        return posno;
    }

    public void setPosno(String posno) {
        this.posno = posno;
    }

    public String getSesame() {
        return sesame;
    }

    public void setSesame(String sesame) {
        this.sesame = sesame;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getHighpay() {
        return highpay;
    }

    public void setHighpay(String highpay) {
        this.highpay = highpay;
    }

    public byte[] getPic1() {
        return pic1;
    }

    public void setPic1(byte[] pic1) {
        this.pic1 = pic1;
    }

    public byte[] getPic2() {
        return pic2;
    }

    public void setPic2(byte[] pic2) {
        this.pic2 = pic2;
    }

    public int getOk() {
        return ok;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public String getLefuhandno() {
        return lefuhandno;
    }

    public void setLefuhandno(String lefuhandno) {
        this.lefuhandno = lefuhandno;
    }

    public String getWxmch() {
        return wxmch;
    }

    public void setWxmch(String wxmch) {
        this.wxmch = wxmch;
    }

    public String getRyxposno() {
        return ryxposno;
    }

    public void setRyxposno(String ryxposno) {
        this.ryxposno = ryxposno;
    }

    public String getCcregphone() {
        return ccregphone;
    }

    public void setCcregphone(String ccregphone) {
        this.ccregphone = ccregphone;
    }

    public String getZhhhandno() {
        return zhhhandno;
    }

    public void setZhhhandno(String zhhhandno) {
        this.zhhhandno = zhhhandno;
    }

    public String getQimhandno() {
        return qimhandno;
    }

    public void setQimhandno(String qimhandno) {
        this.qimhandno = qimhandno;
    }

    public String getHefuhandno() {
        return hefuhandno;
    }

    public void setHefuhandno(String hefuhandno) {
        this.hefuhandno = hefuhandno;
    }

    public byte[] getPic3() {
        return pic3;
    }

    public void setPic3(byte[] pic3) {
        this.pic3 = pic3;
    }

    private int id_;
    private String rname;
    private String  cid;
    private String   phone;
    private String lefuno;
    private String  posno;
    private String  sesame;
    private String  lefuhandno;
    private String  wxmch;
    private String  ryxposno;
    private String  ccregphone;
    private String  zhhhandno;
    private String  qimhandno;
    private String  hefuhandno;
    private String cartype;
    private String  highpay;
    private byte[] pic1;
    private byte[] pic2;
    private byte[] pic3;
    private int ok;

}
