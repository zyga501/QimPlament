<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><meta name="viewport" content="initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/layer.css" rel="stylesheet">
</head>
<body>
<div class="row">
    <span id="btnstep1" class="center-block btn btn-warning col-sm-6" onclick="pre()">第一步<br>基础信息</span>
    <span id="btnstep2" class="center-block btn btn-default col-sm-6" disabled onclick="ntt()"> 第二步<br>上传证件</span>
</div>
<form>
    <input type="hidden" id="gid" name="gid" value="">
    <div class="form-horizontal" id="step1">
        <div class="form-group">
            <label for="rname" class="col-sm-3 control-label">姓名</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="rname" name="rname" placeholder="请输入姓名" data-bv-notempty data-bv-notempty-message="验证码不能为空">
            </div>
        </div>
        <div class="form-group">
            <label for="cid" class="col-sm-3 control-label">身份证号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="cid" name ="cid" placeholder="身份证号" value='<%=request.getParameter("cid")!=null?request.getParameter("cid"):""%>'>
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-3 control-label">手机号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="phone" name ="phone" placeholder="手机号" value='<%=request.getParameter("phone")!=null?request.getParameter("phone"):""%>'>
            </div>
        </div>
        <div class="form-group">
            <label for="lefuno" class="col-sm-3 control-label">乐富序列号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="lefuno" name ="lefuno" placeholder="乐富序列号">
            </div>
        </div>
        <div class="form-group">
            <label for="posno" class="col-sm-3 control-label">POS机流水</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="posno" name="posno" placeholder="POS机流水">
            </div>
        </div>
        <div class="form-group">
            <label for="lefuhandno" class="col-sm-3 control-label">乐富手刷序列号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="lefuhandno" name="lefuhandno" placeholder="乐富手刷序列号">
            </div>
        </div>
        <div class="form-group">
            <label for="hefuhandno" class="col-sm-3 control-label">和付手刷序列号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="hefuhandno" name="hefuhandno" placeholder="和付手刷序列号">
            </div>
        </div>
        <div class="form-group">
            <label for="qimhandno" class="col-sm-3 control-label">企盟手刷序列号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="qimhandno" name="qimhandno" placeholder="企盟手刷序列号">
            </div>
        </div>
        <div class="form-group">
            <label for="zhhhandno" class="col-sm-3 control-label">中汇掌富宝序列号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="zhhhandno" name="zhhhandno" placeholder="中汇掌富宝序列号">
            </div>
        </div>
        <div class="form-group">
            <label for="ccregphone" class="col-sm-3 control-label">CC卡注册手机号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="ccregphone" name="ccregphone" placeholder="CC卡注册手机号">
            </div>
        </div>
        <div class="form-group">
            <label for="ryxposno" class="col-sm-3 control-label">瑞银信POS序列号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="ryxposno" name="ryxposno" placeholder="瑞银信POS序列号">
            </div>
        </div>
        <div class="form-group">
            <label for="wxmch" class="col-sm-3 control-label">微信商户号</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="wxmch" name="wxmch" placeholder="微信商户号">
            </div>
        </div>
        <div class="form-group">
            <label for="sesame" class="col-sm-3 control-label">芝麻分</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="sesame" name="sesame" placeholder="芝麻分">
            </div>
        </div>
        <div class="form-group">
            <label for="cartype" class="col-sm-3 control-label">汽车类型</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="cartype" name="cartype" placeholder="汽车类型">
            </div>
        </div>
        <div class="form-group">
            <label for="highpay" class="col-sm-3 control-label">申请额度</label>

            <div class="col-sm-6">
                <input type="number" class="form-control" id="highpay" name="highpay" placeholder="申请额度">
            </div>
        </div>
        <div class="form-group">
            <label for="highpay" class="col-sm-7 control-label"></label>

            <div class="col-sm-1">
                <button type="button" class="btn btn-sm btn-primary" onclick="nt()">下一步</button>
            </div>
        </div>
    </div>
    <div class="form-horizontal" id="step2" style="display:none">
        <div class="form-group">
            <span class="control-label">请上传【身份证正面】【身份证反面】【手持身份证】共3张！！上传成功后请等待审核结果</span>
        </div>
        <div>
            <input style="width:100px;" id="file1" class="file-loading" type="file" name="f" multiple="true"
                   data-overwrite-initial="true" data-min-file-count="3">
        </div>
    </div>
</form>
</body>
<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/fileinput.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/fileinput_locale_zh.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/layer.min.js"></script>
<script>
    <%--$().ready(function(){--%>
     <%--<% if (request.getParameter("gid")!=null) {%> --%>
        <%--$("#gid").val('<%=request.getParameter("gid").toString()%>');--%>
        <%--$.ajax({--%>
            <%--type: 'post',--%>
            <%--url: '<%=request.getContextPath()%>/G!fetchgoodsinfo',--%>
            <%--dataType: "json",--%>
            <%--data: {gid:$("#gid").val()},--%>
            <%--success: function (data) {--%>
                <%--var json = eval("(" + data + ")");--%>
            <%--}--%>
        <%--})--%>
    <%--<% } %>    --%>
    <%--});--%>
    function nt() {
        if ($("#rname").val().trim()==""){
            alert("姓名不能为空");return;
        }
        if ($("#cid").val().trim()==""){
            alert("身份证不能为空");return;
        }
        if ($("#phone").val().trim()==""){
            alert("手机不能为空");return;
        }
        if ($("#highpay").val().trim()==""){
            alert("申请额度不能为空");return;
        }
        $.ajax({
            type: 'post',
            url: '<%=request.getContextPath()%>/G!goodsInfo',
            dataType: "json",
            data: $("form").serialize(),
            success:function(data){
                var json = eval("(" + data + ")");
                if (json.resultCode=="Failed"){
                    alert("提交出错，请检查各项");
                }
                else{
                    if (json.rt!=undefined){
                        $("#gid").val(json.rt.id);
                    }
                    $("#btnstep2").attr("disabled", false);
                    $("#step1").css("display", "none");
                    $("#step2").css("display", "block");
                    $("#btnstep1").attr("class", "center-block btn btn-default col-sm-6");
                    $("#btnstep2").attr("class", "center-block btn btn-warning col-sm-6");
                }
            }
        });
    }

    function ntt() {
        if ($("#btnstep2").attr("disabled") != "disabled") {
            nt();
        }
    }
    function pre() {
        $("#step1").css("display", "block");
        $("#step2").css("display", "none");
        $("#btnstep2").attr("class", "center-block btn btn-default col-sm-6");
        $("#btnstep1").attr("class", "center-block btn btn-warning col-sm-6");
    }

    $("#file1").fileinput({
        language: 'zh',
        uploadUrl: '<%=request.getContextPath()%>/G!goodsPaypic', // you must set a valid URL here else you will get an error
        allowedFileExtensions: ['jpg', 'png', 'gif'],
        overwriteInitial: false,
        maxFileSize: 20000,
        maxFilesNum:3,
        dropZoneEnabled: false,
        showCaption: false,
        uploadAsync:true,
        enctype: 'multipart/form-data',
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        slugCallback: function (filename) {
            return filename.replace('(', '_').replace(']', '_');
        },
        uploadExtraData: function() {
            return {"gid":  $("#gid").val() };
        }
    });
    $("#file1").on("fileuploaded", function(event, data, previewId, index) {
        //if (index==3)
        {
            layer.confirm( "材料提交成功。请耐心等待",{
                        title: "提示",
                btn:["确定"]
                    },function() {
                        window.close();
                        WeixinJSBridge.call('closeWindow');
                    }
            );
        }
    })
</script>
</html>