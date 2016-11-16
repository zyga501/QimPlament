<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/layer.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="cid" class="col-sm-2 control-label">身份证号</label>

                    <div class="col-sm-8">
                        <input type="number" class="form-control" id="cid" name="cid" placeholder="身份证号">
                    </div>
                </div>
                <%--<div class="form-group">--%>
                    <%--<label for="phone" class="col-sm-2 control-label">手机号</label>--%>

                    <%--<div class="col-sm-8">--%>
                        <%--<input type="number" class="form-control" id="phone" name="phone" placeholder="手机号">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="form-group">
                    <div class="col-sm-12">
                        <button type="button" class="btn btn-sm btn-primary form-control" onclick="nt()">查询</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/fileinput.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/fileinput_locale_zh.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/layer.min.js"></script>
<script>
    function nt() {
        $.ajax({
            type: 'post',
            url: '<%=request.getContextPath()%>/G!fetchgoodsinfo',
            async: false,
            dataType: "json",
            data: $("form").serialize(),
            success: function (data) {
                var json = eval("(" + data + ")");
                layer.confirm(json.msg, {
                    skin: 'layui-layer-molv',
                    btn: ['确定'] //按钮
                    , area: ['auto', 'auto'],
                    title: "审核结果"
                }, function () {
                    if (json.resultCode == "Failed")
                        window.location.href = "<%=request.getContextPath()%>/goodspay/goodspay.jsp?phone=" + $("#phone").val() + "&cid=" + $('#cid').val();
                    else
                        layer.closeAll();
                })
            }
        });
    }

</script>
</html>