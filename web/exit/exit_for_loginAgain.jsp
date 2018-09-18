<%--
  Created by IntelliJ IDEA.
  User: zwcpc
  Date: 2018/9/7
  Time: 10:42
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
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/x-admin.css" media="all">
</head>
<body style="margin: 0">
<div style="text-align: center">
    <img src="../images/banner3.jpg" style="width: 100%;height: 250px" />
    <b style="font-size: 30px">您的账户已经登录，请退出后重新登录</b><br/><br/>
    <a href=${indexPage} class="layui-btn">返回操作</a>
    <a style="margin-left: 100px" href="/cmbs/exit.action" class="layui-btn layui-btn-danger">安全退出</a>
</div>
</body>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script src="../js/x-admin.js"></script>
</html>
