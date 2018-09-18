<%--
  Created by IntelliJ IDEA.
  User: zwcpc
  Date: 2018/9/6
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户主页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/x-admin.css" media="all">
</head>
<body>
<div style="padding-top: 10%;padding-left: 15%;text-align: center;width: 60%;height: 40%">
    <table class="layui-table"style="margin:0 auto;width: 60%; height: 70%" >
        <colgroup>
            <col width="60" >
            <col width="60">
        </colgroup>
        <tr>
            <td><b>用户账号</b></td>
            <td bgcolor="white">${account.accountId}</td>
        </tr>
        <tr>
            <td><b>联系人姓名</b></td>
            <td bgcolor="white">${account.contactPerson}</td>
        </tr>
        <tr>
            <td><b>联系人地址</b></td>
            <td bgcolor="white">${account.contactAddress}</td>
        </tr>
        <tr>
            <td><b>账户余额</b></td>
            <td bgcolor="white">${account.contactBalance}</td>
        </tr>
    </table>
</div>
</body>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script src="../js/x-admin.js"></script>
</html>
