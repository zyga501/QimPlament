package com.qimpay.database;

import java.sql.Blob;
import java.util.Date;
import java.util.Map;

public class Khzl {

    public static Khzl getkhzlb(String cardno) {
        String statement = "com.qimpay.database.mapping.khzl.getkhzlb";
        return Database.Instance().selectOne(statement, cardno);
    }

    public static boolean insertkhzlb(Map param) {
        String statement = "com.qimpay.database.mapping.khzl.insertkhzlb";
        return Database.Instance().insert(statement,param)>0;
    }

    public static boolean insertkhzltab(Map param) {
        String statement = "com.qimpay.database.mapping.khzl.insertkhzltab";
        return Database.Instance().insert(statement,param)>0;
    }

    public static Map getkhzltab(Map param) {
        String statement = "com.qimpay.database.mapping.khzl.getkhzltab";
        return Database.Instance().selectOne(statement,param);
    }

    public int getKhid() {
        return khid;
    }

    public String getFrxm() {
        return frxm;
    }

    public String getZjhm() {
        return zjhm;
    }

    public String getAddress() {
        return address;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public String getFzjg() {
        return fzjg;
    }

    public String getCardno() {
        return cardno;
    }

    public String getCardbank() {
        return cardbank;
    }

    public int getMobilenum() {
        return mobilenum;
    }

    public String getHy() {
        return hy;
    }

    public float getStorenum() {
        return storenum;
    }

    public String getRate() {
        return rate;
    }

    public String getArea() {
        return area;
    }

    public int getTzero() {
        return tzero;
    }

    public String getPostype() {
        return postype;
    }

    public int getWyuserid() {
        return wyuserid;
    }


    private int khid ;
    private String frxm ;
    private String zjhm ;
    private String address ;
    private Date expirydate ;
    private String fzjg ;
    private String cardno ;
    private String cardbank ;
    private int mobilenum ;
    private String hy ;
    private float storenum ;
    private String rate ;
    private String area ;
    private int tzero ;
    private String postype ;
    private int wyuserid ;

}
