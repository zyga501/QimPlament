package com.qimpay.OA.action;

import com.AjaxActionSupport;
import com.qimpay.database.GoodsPay;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.framework.utils.PublicFunc.toByteArray;

public class GoodsPayAction extends AjaxActionSupport {
    public String goodsInfo(){
        try {
            GoodsPay goodsPay = new GoodsPay();
            goodsPay.setCartype(getParameter("cartype").toString());
            goodsPay.setCid(getParameter("cid").toString());
            goodsPay.setHighpay(getParameter("highpay").toString());
            goodsPay.setLefuno(getParameter("lefuno").toString());
            goodsPay.setPhone(getParameter("phone").toString());
            goodsPay.setPosno(getParameter("posno").toString());
            goodsPay.setRname(getParameter("rname").toString());
            goodsPay.setSesame(getParameter("sesame").toString());
            goodsPay.setCcregphone(getParameter("ccregphone").toString());
            goodsPay.setHefuhandno(getParameter("hefuhandno").toString());
            goodsPay.setLefuhandno(getParameter("lefuhandno").toString());
            goodsPay.setQimhandno(getParameter("qimhandno").toString());
            goodsPay.setRyxposno(getParameter("ryxposno").toString());
            goodsPay.setWxmch(getParameter("wxmch").toString());
            goodsPay.setZhhhandno(getParameter("zhhhandno").toString());
            if (getParameter("gid")!=null && (!getParameter("gid").toString().equals(""))){
                goodsPay.setId(Integer.parseInt(getParameter("gid").toString()));
                return AjaxActionComplete( GoodsPay.updateGoodsPay(goodsPay));
            }else if (GoodsPay.insertGoodsPay(goodsPay)) {
                GoodsPay g=GoodsPay.getGoodsPayBymap(goodsPay);
                Map rm=new HashMap<>();
                rm.put("rt",g);
                return AjaxActionComplete(true,rm);
            }
        }
        catch (Exception e){
            return AjaxActionComplete(false);
        }
        return AjaxActionComplete(false);
    }

    public String goodstList(){
        List<GoodsPay> cl =GoodsPay.getAllGoodsPay();
        return AjaxActionComplete(cl);
    }

    public String fetchgoodsinfo(){//setAttribute("uid",0);
        GoodsPay g=new GoodsPay();
        g.setCid(getParameter("cid").toString());
//        g.setPhone(getParameter("phone").toString());
        GoodsPay cl =GoodsPay.getGoodsPayBymap(g);
        Map m = new HashMap<>();
        if (cl!=null ) {
            if (cl.getOk()==1)
                m.put("msg","恭喜你！您的额度是：<b>"+ cl.getHighpay()+"</b><br>联系客服:40012345567或扫扫二维码，即刻放款。<br><center><img style='height:160px;' src='../img/goodsEWM.jpg'/></center>");
            else if (cl.getOk()==2)
                m.put("msg","审核未通过");
            else
                m.put("msg","您的贷款正在审核中");
            return AjaxActionComplete(true, m);
        }else {
            m.put("msg","抱歉！您还没有获得额度，点“确定“申请贷款。");
            return AjaxActionComplete(false,m);
        }
    }

    public String updateGoodsok(){
        GoodsPay goodsPay = new GoodsPay();
        goodsPay.setHighpay(getParameter("highpay").toString());
        goodsPay.setOk(1);
        goodsPay.setId(Integer.parseInt(getParameter("gid").toString()));
        return AjaxActionComplete(GoodsPay.updateGoodsok(goodsPay));
    }

    public String updateGoodslistok(){
        GoodsPay goodsPay = new GoodsPay();
        Map m= new HashMap<>();
        m.put("ok",getParameter("ok").toString());
        m.put("id",(getParameter("gid").toString()));
        return AjaxActionComplete(GoodsPay.updateGoodslistok(m));
    }

    public String getGoodsPaypic(){
        GoodsPay goodsPay = GoodsPay.getGoodsPaypic(Long.valueOf(getParameter("gid").toString()));
        Map m= new HashMap<>();
        String pic1=  new BASE64Encoder().encode(goodsPay.getPic1());
        String pic2=  new BASE64Encoder().encode(goodsPay.getPic2());
        String pic3=  new BASE64Encoder().encode(goodsPay.getPic3());
        m.put("pic1",pic1);
        m.put("pic2",pic2);
        m.put("pic3",pic3);
        return AjaxActionComplete(m);
    }

    public String goodsPaypic() throws IOException {
        File f = new File(getParameter("f").toString());
        InputStream is = new FileInputStream(f);
        byte[] bytes = toByteArray(is);
        GoodsPay goodsPay = new GoodsPay();
        goodsPay.setId(Integer.parseInt(getParameter("gid").toString()));
        if (getParameter("file_id").toString().equals("0")){
        goodsPay.setPic1(bytes);
        GoodsPay.updateGoodsPayPic1(goodsPay);
        }else if (getParameter("file_id").toString().equals("1")){
            goodsPay.setPic2(bytes);
            GoodsPay.updateGoodsPayPic2(goodsPay);
        }else if (getParameter("file_id").toString().equals("2")){
            goodsPay.setPic2(bytes);
            GoodsPay.updateGoodsPayPic3(goodsPay);
        }
        return  AjaxActionComplete(true);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("result", "ok");
//        getResponse().setHeader("Content-Type","text/html;charset=UTF-8" );
//        getResponse().getWriter().write(jsonObject.toString());
    }
}
