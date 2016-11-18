<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><meta name="viewport" content="initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/bootstrap-table.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/layer.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/layer.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap-table.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap-table-zh-CN.js"></script>
</head>
<body >
<div>
        <div id="contactlist"   >
            <div id="toolbar"><button class="btn btn-primary" title="审核通过" onclick="sendok(1)">审核通过
            </button><button class="btn btn-danger" title="审核不过" onclick="sendok(2)">审核不过
            </button></div>
            <table  id="ctable"  class="table table-striped table-hover table-bordered"> <thead><tr>
            <th  data-checkbox="true" ><th  data-field="index" data-formatter="indexFormatter" >序号</th>
                <th  data-field="rname" data-sortable="true">姓名</th><th  data-field="phone"  data-sortable="true" >手机号</th>
            <th  data-field="cid">身份证</th><th  data-field="lefuno">乐富序列号</th>
            <th  data-field="posno">POS机流水</th>
                <th  data-field="lefuhandno" data-formatter="urlFormatter">乐富手刷序列号</th>
                <th  data-field="hefuhandno" data-formatter="urlFormatter">和付手刷序列号</th>
                <th  data-field="qimhandno" data-formatter="urlFormatter">企盟手刷序列号</th>
                <th  data-field="zhhhandno" data-formatter="urlFormatter">中汇掌富宝序列号</th>
                <th  data-field="ccregphone" data-formatter="urlFormatter">CC卡注册手机号</th>
                <th  data-field="ryxposno" data-formatter="urlFormatter">瑞银信POS序列号</th>
                <th  data-field="wxmch">微信商户号</th><th  data-field="sesame">芝麻分</th>
            <th data-field="cartype">汽车类型</th><th data-field="highpay">额度</th><th data-field="ok"  data-formatter="format_ok">是否审核</th></tr></thead>
        </table>
        </div>

        <div class="directory-info-row" style="display: none">
            <div class="row">
            </div>
        </div>
    </div>
</body>
<script>
    function indexFormatter(value, row, index) {
        return index+1+"<a href='#'>[查看图片]</a>";
    }
    function urlFormatter(value, row, index) {
        if (value!=undefined)
        return "<a href='http://www.baidu.com'>"+value+"</a>";
        else return "";
    }

    function format_ok(value, row, index) {
        return value==1?"已审核":( value==2?"不通过":"未审核");
    }

    function sendok(v){
        editc(v);
    }

    function myinitTable() {
        $.get('<%=request.getContextPath()%>/G!goodstList', function(data) {
            data=JSON.parse(data);
            //先销毁表格
            $('#ctable').bootstrapTable('destroy');
            //初始化表格,动态从服务器加载数据
            $("#ctable").bootstrapTable({
                //method: "get",  //使用get请求到服务器获取数据
                //url: "< %=request.getContextPath()%>/u!contactList", //获取数据的Servlet地址
                toolbar: '#toolbar',                //工具按钮用哪个容器
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                sortOrder: "asc",
                showToggle:true,
                striped: true,  //表格显示条纹
                pagination: true, //启动分页
                pageSize:5,  //每页显示的记录数
                pageNumber:1, //当前第几页
                pageList: [5, 10, 15, 20, 25],  //记录数可选列表
                search: true,  //是否启用查询
                showColumns: true,  //显示下拉框勾选要显示的列
                //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
                //设置为limit可以获取limit, offset, search, sort, order
                queryParamsType : "queryParams",
                sidePagination: "client",
                onClickCell: function(field, value, row, $element){  //加载成功时执行
                    //alert(field+value+row.id);
                    if (field=="index"){
                        $.ajax({
                            type: 'post',
                            url: '<%=request.getContextPath()%>/G!getGoodsPaypic',
                            dataType: "json",
                            data: {gid: row.id},
                            success: function (data) {
                                var json = eval("(" + data + ")");
                                layer.open({
                                    type: 1,
                                    title:"身份证",
                                    skin: 'layui-layer-rim', //加上边框
                                    area: ['80%', '90%'], //宽高
                                    content: "<img style='width:100%' src='data:image/png;base64," + json.pic1 + "'><br>" +
                                    "<img style='width:100%' src='data:image/png;base64," + json.pic2 + "'><br>"+
                                    "<img style='width:100%' src='data:image/png;base64," + json.pic3 + "'><br>"
                                });
                            }
                        });
                        return;
                    }
                    if (field!="highpay") return;
                    var v=prompt("请输入金额",value)
                    if (v!=null && v!="")
                    {
                                $.ajax({
                                    type: 'post',
                                    url: '<%=request.getContextPath()%>/G!updateGoodsok',
                                    dataType: "json",
                                    data:{highpay:v,gid: row.id},
                                    success: function (data) {
                                        var json = eval("(" + data + ")");
                                        alert(json.resultCode);
                                        if (json.resultCode=="Succeed"){
                                            myinitTable();
                                        }
                                    }
                                });
                    }
                },
                onLoadError: function(){  //加载失败时执行
                    alert("加载数据失败");
                },
                data: data
            });
        });
    }
    function editc(v){
        var t = ""+getIdSelections();
        $.ajax({
            type: 'post',
            url: '<%=request.getContextPath()%>/G!updateGoodslistok',
            dataType: "json",
            data:{gid:t,ok:v},
            success: function (data) {
                var json = eval("(" + data + ")");
                alert(json.resultCode);
                if (json.resultCode=="Succeed"){
                    myinitTable();
                }
            }
        });
    }

    function getIdSelections() {
        return $.map($('#ctable').bootstrapTable('getSelections'), function(row) {
            return row.id
        });
    }
    $().ready(function () {myinitTable();
    });
</script>
</html>
