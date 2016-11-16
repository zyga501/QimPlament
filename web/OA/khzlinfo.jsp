<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>信息添加</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=request.getContextPath()%>/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/animate.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style.min.css?v=4.1.0" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/laypage.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/laydate.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/layer.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/danlanlaydate.css" rel="stylesheet" type="text/css"/>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="full-height-scroll">
        <div class="ibox-content">
            <form class="form-horizontal">
                <div class="form-group">
                    <div class="form-group">
                    <label class="col-sm-3 control-label">法人姓名：</label>
                    <div class="col-sm-8">
                        <input type="text" name="frxm" placeholder="法人姓名" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">身份证号码：</label>
                    <div class="col-sm-8">
                        <input type="text" name="zjhm" placeholder="身份证号码" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">身份证有效期：</label>
                    <div class="col-sm-8">
                        <input type="text" placeholder="身份证有效期" name="expirydate" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">发证机关：</label>
                    <div class="col-sm-8">
                        <input type="text" name="fzjg" placeholder="发证机关" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">住 址：</label>
                    <div class="col-sm-8">
                        <input type="text" name="address" placeholder="住 址" class="form-control">
                    </div>
                </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">手机号码：</label>
                        <div class="col-sm-8">
                            <input type="text" name="mobilenum" placeholder="手机号码" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">银行卡：</label>
                        <div class="col-sm-8">
                            <input type="text" name="cardno" placeholder="银行卡" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">发卡行：</label>
                        <div class="col-sm-8">
                            <input type="text" name="cardbank" placeholder="发卡行" class="form-control">
                        </div>
                    </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">行业1~行业n：</label>
                    <div class="col-sm-8">
                        <input type="text" name="hy" placeholder="行业1~行业n" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">商户个数：</label>
                    <div class="col-sm-8">
                        <input type="text" name="storenum" placeholder="商户个数（与行业个数对应）" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">费率：</label>
                    <div class="col-sm-8">
                        <input type="text" name="rate" placeholder="费率" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">地域：</label>
                    <div class="col-sm-8">
                        <input type="text" name="area" placeholder="地域" class="form-control">
                    </div>
                </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="fsfzz">身份证正面</label>
                        <div class="col-sm-8">
                            <input class="huodong-msg" type="file" id="fsfzz" name="fsfzz" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="fsfzf">身份证反面</label>
                        <div class="col-sm-8">
                            <input type="file" id="fsfzf"   onchange="checksize(this.files)">
                            <input type="hidden" id="hfsfzf" name="hfsfzf">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="fyhkz">银行卡正面</label>
                        <div class="col-sm-8">
                            <input type="file" id="fyhkz" name="fyhkz">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="fyhkf">银行卡反面</label>
                        <div class="col-sm-8">
                            <input type="file" id="fyhkf" name="fyhkf">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="fscsfz">手持身份证</label>
                        <div class="col-sm-8">
                            <input type="file" id="fscsfz" name="fscsfz">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="fdphy">店铺合影</label>
                        <div class="col-sm-8">
                            <input type="file" id="fdphy" name="fdphy" capture="camera">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" id="slectimg">机具类型：</label>
                        <div class="col-sm-8">
                            <textarea id="rt" name="postype" placeholder="机具类型" class="form-control"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-8">
                            <button class="btn btn-lg btn-primary btn-block" type="button" onclick="uploadinfo()">确 认</button>
                        </div>
                    </div>
                    <img id="fg" src=""style="width:100px;height:100px;"/>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/ajaxfileupload.js"></script>
<script>
    jQuery.prototype.serializeObject=function(){
        var obj=new Object();
        $.each(this.serializeArray(),function(index,param){
            if(!(param.name in obj)){
                obj[param.name]=param.value;
            }
        });
        return obj;
    };

    function checksize(obj) {
        var file = obj[0];
        if (file.size>1024*1024) {
            var rate =(1000*1000)/(file.size);
            var imageUrl = getObjectURL(file);//$(this)[0].files[0]
            convertImgToBase64(imageUrl,rate, function(base64Img){
                alert(base64Img);
                $("#hfsfzf").val(base64Img);
            });
            return;
        }
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function(e){
            alert(e.target.result);
            $("#hfsfzf").val(e.target.result);
        }
    }

    function convertImgToBase64(url,rate, callback, outputFormat){
        var canvas = document.createElement('CANVAS');
        var ctx = canvas.getContext('2d');
        var img = new Image;
        img.crossOrigin = 'Anonymous';
        img.onload = function(){
            var width = img.width;
            var height = img.height;
           // var rate =(width<height ? width/height : height/width);
            alert(rate);
            canvas.width = width*rate;
            canvas.height = height*rate;
            ctx.drawImage(img,0,0,width,height,0,0,width*rate,height*rate);
            var dataURL = canvas.toDataURL(outputFormat || 'image/jpg');
            callback.call(this, dataURL);
            canvas = null;
        };
        img.src = url;
    }

    function getObjectURL(file) {
        var url = null ;
        if (window.createObjectURL!=undefined) {  // basic
            url = window.createObjectURL(file) ;
        } else if (window.URL!=undefined) {       // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // web_kit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    }

    $('.huodong-msg').bind('change',function(event){
        var imageUrl = getObjectURL($(this)[0].files[0]);
        convertImgToBase64(imageUrl, function(base64Img){
            alert(base64Img.split(",")[1]);
            $("#rt").text(base64Img);
        });
        event.preventDefault();
    });

    function uploadinfo(){
        $.ajax({
            type: 'post',
            url: 'Khzlgl!uploadkhzlinfo',
            dataType:"json",
            data:$("form").serialize(),
            success: function (data) {
                var json =  eval("(" + data + ")");
                if ( json.resultCode =="Failed")
                    alert ("码");
                else if (json.resultCode =="Succeed"){
                    alert(json.resultCode);

                }
            }
        });
//      alert($("form").serializeObject());
//      $.ajaxFileUpload({
//          url: "Khzlgl!uploadkhzlinfo",
//          secureuri: false,
//          fileElementId: ['fdphy','fyhkf','fyhkz','fsfzwf','fsfzz'],
//          dataType: 'multipart/form-data',
//          data: $("form").serializeObject(),
//          type: 'POST',
//          success: function (data,status) {
//              alert(data);
//          },
//          error:function(data,status,e){
//              alert(e);
//          }
//      });
        $().ready(function () {
            var images = {
                localId: [],
                serverId: []
            };
            document.querySelector('#fg').onclick = function () {
                wx.chooseImage({
                    success: function (res) {
                        images.localId = res.localIds;
                        alert('已选择 ' + res.localIds.length + ' 张图片');
                    }
                });
            };
        });
  }
</script>
</body>

</html>

