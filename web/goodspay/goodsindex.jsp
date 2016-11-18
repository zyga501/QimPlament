<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <br><br><br><br><br>
    <div class="row">
            <div class="col-sm-12  ">
            <button class="btn btn-primary form-control" onclick="javascript:window.location.href='<%=request.getContextPath()%>/goodspay/goodssign.jsp'">查贷款额度</button>
        </div>
        <div class="col-sm-12">
            <button class="btn btn-success form-control" onclick="javascript:window.location.href='<%=request.getContextPath()%>/goodspay/goodspay.jsp'">申请贷款</button>
        </div>
    </div>
</div>
</body>
<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
</html>