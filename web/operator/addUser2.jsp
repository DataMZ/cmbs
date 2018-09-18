<%--
  Created by IntelliJ IDEA.
  User: zwcpc
  Date: 2018/9/9
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/x-admin.css" media="all">
    <link rel="stylesheet" href="../css/layui.css" media="all">
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../js/utils.js"></script>
</head>
<body>
<div class="x-body" style="padding-top: 10px">
    <span style="font-size: 15px;padding-left: 10px">您现在的位置：新增用户>>第三步</span><br/>
    <hr>
</div>

<form id="userInfo" class="layui-form" action="">
    <div class="layui-form-item" style="padding-left: 25px" >
        <label for="telephone" class="layui-form-label">手机号码:</label>
        <div class="layui-input-inline" style="width: 18%;">
            <input type="text" id="telephone" name="username" required lay-verify="required" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>必须为11位数字
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 25px">
        <label class="layui-form-label">漫游状态:</label>
        <div class="layui-input-block">
            <input type="radio" name="roam" value="0" title="省内漫游" checked>
            <input type="radio" name="roam" value="1" title="国内漫游" >
            <input type="radio" name="roam" value="2" title="国际漫游" >
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 25px">
        <label class="layui-form-label">通话级别:</label>
        <div class="layui-input-block">
            <input type="radio" name="telLevel" value="0" title="本地通话" checked>
            <input type="radio" name="telLevel" value="1" title="国内长途" >
            <input type="radio" name="telLevel" value="2" title="国际长途" >
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 25px" >
        <label class="layui-form-label">客户ID:</label>
        <div class="layui-input-inline" style="width: 18%;">
            <input type="text" id="customerId" name="username" required lay-verify="required"
                   autocomplete="off" value="${customer.customerId}" disabled="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 25px" >
        <label for="account" class="layui-form-label">账号:</label>
        <div class="layui-input-inline" style="width: 18%;">
            <input type="text" id="account" name="username" required lay-verify="required" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>必须为小于等于8位的正整数
        </div>
    </div>
    <div class="layui-form-item" style="padding-left: 5%">
        <button id="nextStep" type="button" class="layui-btn  layui-btn-radius layui-btn-lg" style="width: 120px;height: 30px;background-color: #2a6496">
            下一步>>
        </button>
        <button id="clean" type="button" class="layui-btn layui-btn-radius  layui-btn-lg" style="width: 120px;height: 30px;margin-left: 50px;background-color: #2a6496">
            全部重写
        </button>
    </div>
    <div class="layui-form-item" style="padding-left: 5%">
        <button  id="viewMoreTelNum"  type="button"  class="layui-btn  layui-btn-radius layui-btn-lg" style="width: 140px;height: 40px;background-color: #2a6496">
            查看可用号码
        </button>
    </div>
</form>
</body>
<script src="../js/layui/src/layui.js"></script>
<script src="../js/x-layui.js" charset="utf-8"></script>
<script  >
    layui.use(['form','layer','upload'], function() {

        var form = layui.form,
            layer = layui.layer,
            $ = layui.jquery;

        $("#clean").click(function () {
            $("#telephone").val("");
            $("#account").val("");
            $("input:radio[name=roam]")[0].checked=true;
            $("input:radio[name=telLevel]")[0].checked=true;
            form.render('radio');
        });

        $("#nextStep").click(function () {
            var telNum = $("#telephone").val();
            var roam = $("input[name=roam]:checked").val();
            var telLevel = $("input[name=telLevel]:checked").val();
            var customerId = $("#customerId").val();
            var account = $("#account").val();
            var isAccount = /^\d{1,8}\$/.test(account);
            if(telNum=="" || customerId=="" || account=="" ) {
                layer.alert('输入框不能为空！', {
                    icon: 2,
                    title: "提示"
                });
            }else if(!isAccount) {
                layer.alert('账号格式不正确，应该全是数字且位数小于8！', {
                    icon: 2,
                    title: "提示"
                });
            } else {
                $.ajax({
                    url:getRootURL()+"/addUser.action",
                    type:"POST",
                    data:{
                        mobileNumber:telNum,
                        roamingStatus:roam,
                        comLevel:telLevel,
                        customerId:customerId,
                        accountId:account
                    },
                    success:function (data) {
                        var parseJSON = jQuery.parseJSON(data);
                        var infoForm = $("#userInfo");
                        if(parseJSON.status=="telErr") {
                            layer.alert('手机号码不可用！请更换。', {
                                icon: 2,
                                title: "提示"
                            });
                        }else {
                            infoForm.attr("action",getRootURL()+"/operator/addUser3.jsp");
                            infoForm.submit();
                        }
                    }
                });
            }
        });
        
        $("#viewMoreTelNum").click(function () {
            $.ajax({
                url:getRootURL()+"/viewMoreTelNum.action",
                type:"POST",
                data:{
                },
                success:function () {
                    x_admin_show("可用电话", "showTel.jsp", '700', '450');
                }
            });
        })
    });


</script>
</html>
