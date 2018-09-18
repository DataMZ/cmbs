<%--
  Created by IntelliJ IDEA.
  User: zwcpc
  Date: 2018/9/9
  Time: 16:55
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
    <span id="tip" style="font-size: 15px;padding-left: 10px">您现在的位置：合账</span><br/>
    <hr>
</div>

<form id="accountInfo" class="layui-form" action="">
    <div class="layui-form-item" style="padding-left: 25px" >
        <div class="layui-form-item" style="padding-left: 25px" >
            <label class="layui-form-label">账号:</label>
            <div class="layui-input-inline" style="width: 18%;">
                <input type="text" id="account" name="username" required lay-verify="required"
                       autocomplete="off" value="${accountTmp.accountId}" disabled="" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item" style="padding-left: 25px" >
            <label class="layui-form-label">姓名:</label>
            <div class="layui-input-inline" style="width: 18%;">
                <input type="text" id="name" name="username" required lay-verify="required"
                       autocomplete="off" value="${accountTmp.contactPerson}" disabled="" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item" style="padding-left: 25px" >
            <label class="layui-form-label">联系地址:</label>
            <div class="layui-input-inline" style="width: 18%;">
                <input type="text" id="address" name="username" required lay-verify="required"
                       autocomplete="off" value="${accountTmp.contactAddress}" disabled="" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item" style="padding-left: 25px" >
            <label class="layui-form-label">开户金额:</label>
            <div class="layui-input-inline" style="width: 18%;">
                <input type="text" id="money" name="username" required lay-verify="required"
                       autocomplete="off" value="${accountTmp.contactBalance}" disabled="" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item" style="padding-left: 5%">
            <button id="submit" type="button" class="layui-btn  layui-btn-radius layui-btn-lg" style="width: 120px;height: 30px;background-color: #2a6496">
                提交
            </button>
            <button id="clean" type="button" class="layui-btn layui-btn-radius  layui-btn-lg" style="width: 120px;height: 30px;margin-left: 50px;background-color: #2a6496">
                全部重写
            </button>
        </div>
    </div>

</form>
</body>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script src="../js/x-layui.js" charset="utf-8"></script>
<script  >
    layui.use(['form','layer','upload'], function() {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;

        $(function () {
            var accountStatus="${accountTmpStatus}";
            if(accountStatus=="inexistence") {
                $("#tip").text("您现在的位置：新增账户");
                $("#name").attr("disabled",false);
                $("#address").attr("disabled",false);
                $("#money").attr("disabled",false);
            }
        });

        $("#clean").click(function () {
            var accountStatus="${accountTmpStatus}";
            if(accountStatus=="inexistence") {
                $("#name").val("");
                $("#address").val("");
                $("#money").val("");
            }
        });


        $("#submit").click(function () {
            var account = $("#account").val();
            var name = $("#name").val();
            var address = $("#address").val();
            var money = $("#money").val();

            if(name=="" || address=="" || money=="" ) {
                layer.alert('输入框不能为空！', {
                    icon: 2,
                    title: "提示"
                });
            }else if(!/^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/.test(money)) {
                layer.alert('开户金额的格式输入异常', {
                    icon: 2,
                    title: "提示"
                });
            } else {
                $.ajax({
                    url:getRootURL()+"/submit.action",
                    type:"POST",
                    data:{
                        accountId:account,
                        contactPerson:name,
                        contactAddress:address,
                        contactBalance:money
                    },
                    success:function (data) {
                        var parseJSON = jQuery.parseJSON(data);
                        if(parseJSON.status=="teleErr") {
                            layer.alert('电话修改非可用异常！', {
                                icon: 2,
                                title: "提示"
                            });
                        }else if(parseJSON.status=="submitErr") {
                            layer.alert('入库异常，请输入正确格式！', {
                                icon: 2,
                                title: "提示"
                            });
                        }else {
                            layer.alert('恭喜你，创建成功！', {
                                icon: 1,
                                title: "提示"
                            });
                        }
                    }
                });
            }
        });
    });
</script>
</html>
