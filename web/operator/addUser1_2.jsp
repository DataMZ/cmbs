<%--
  Created by IntelliJ IDEA.
  User: zwcpc
  Date: 2018/9/8
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增用户1_2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/x-admin.css" media="all">
    <link rel="stylesheet" href="../js/layui/src/css/layui.css" media="all">
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../js/utils.js"></script>
</head>
<body>
<div class="x-body" style="padding-top: 10px">
    <span style="font-size: 15px;padding-left: 10px">您现在的位置：新增用户>>第二步</span><br/>
    <hr>
</div>
<form id="customerInfo" class="layui-form" action="" method="post">
    <div class="layui-form-item" style="padding-left: 25px" >
        <label class="layui-form-label">证件类型:</label>
        <div class="layui-input-inline" style="width: 10%;">
            <input type="text" id="cardType" name="username" required lay-verify="required"
                   autocomplete="off" value="${customer.idTypeStr}" disabled="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 25px" >
        <label class="layui-form-label">证件号码:</label>
        <div class="layui-input-inline" style="width: 18%;">
            <input type="text" id="cardNum" name="username" required lay-verify="required"
                   autocomplete="off" value="${customer.idNumber}" disabled="" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item" style="padding-left: 25px" >
        <label for="username" class="layui-form-label">姓名:</label>
        <div class="layui-input-inline">
            <input type="text" id="username" name="username" value="${customer.customerName}" required lay-verify="required" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 25px">
        <label class="layui-form-label">性别:</label>
        <div id="sex" class="layui-input-block">
            <input id="man" type="radio" name="sex" value="男" title="男" checked>
            <input id="woman" type="radio" name="sex" value="女" title="女" >
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 25px">
        <label class="layui-form-label">生日:</label>
        <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
            <input type="text" class="layui-input" id="birthday" value="${customer.customerBirthdayFormat}" readonly="">
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 25px" >
        <label for="username" class="layui-form-label">联系地址:</label>
        <div class="layui-input-inline">
            <input type="text" id="address" name="username" value="${customer.customerAddress}" required lay-verify="required" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 5%">
        <button type="button" id="nextStep" class="layui-btn layui-btn-radius layui-btn-lg" style="width: 110px;height: 40px;padding-top: -20px ;background-color: #2a6496"  >
            下一步>>
        </button>
        <button type="button" id="clean" class="layui-btn layui-btn-radius  layui-btn-lg" style="width: 110px;height: 40px;margin-left: 50px;padding-top: -20px;background-color: #2a6496">
            全部重写
        </button>
    </div>
</form>
</body>
<script src="../js/x-layui.js" charset="utf-8"></script>
<script src="../js/layui/src/layui.js"></script>
<script  >
    layui.use(['form','layer','upload','laydate'], function() {

        var form = layui.form;
        $ = layui.jquery;
        layer = layui.layer;
        laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#birthday' //指定元素
        });
        // 初始化基础信息
        $(function () {
            var sex = "${customer.customerSex}";
            if(sex=="女"){
                $("input:radio[name=sex]")[1].checked=true;
                form.render('radio');
            }
        });

        $("#clean").click(function () {
            $("input:radio[name=sex]")[0].checked=true;
            form.render('radio');
            $("#username").val("");
            $("#birthday").val("");
            $("#address").val("");
        });

        $("#nextStep").click(function () {
            var idType = "${customer.idType}";
            var idNum = "${customer.idNumber}";
            var username = $("#username").val();
            var sex = $("input[name=sex]:checked").val();
            var birthday = new Date($("#birthday").val()) ;
            var address = $("#address").val();
            if(username=="" || sex=="" || birthday=="" || address=="" ) {
                layer.alert('输入框不能为空！', {
                    icon: 2,
                    title: "提示"
                });
            }else {
                $.ajax({
                    url:getRootURL()+"/addCustomer.action",
                    type:"POST",
                    data:{
                        idType:idType,
                        idNumber:idNum,
                        customerName:username,
                        customerBirthday:birthday,
                        customerSex:sex,
                        customerAddress:address
                    },
                    success:function (data) {
                        var parseJSON = jQuery.parseJSON(data);
                        var infoForm = $("#customerInfo");
                        if(parseJSON.status=="customerErr") {
                            layer.alert('入库异常，请输入正确格式', {
                                icon: 2,
                                title: "提示"
                            });
                        }else {
                            infoForm.attr("action",getRootURL()+"/operator/addUser2.jsp");
                            infoForm.submit();
                        }

                    }
                });
            }
        });




    });

</script>
</html>
