<%--
  Created by IntelliJ IDEA.
  User: zwcpc
  Date: 2018/9/14
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
    <table class="layui-table" style="text-align: center; margin:0 auto;width: 60%; height: 70%" >
        <colgroup>
            <col width="60" >
            <col width="60">
        </colgroup>
        <tr>
            <th style="text-align: center">序号</th>
            <th style="text-align: center">电话号码</th>
        </tr>

        <c:forEach var="mobile" items="${mobiles}" varStatus="mobileIdx" >
            <tr>
                <td>${mobileIdx.count} </td>
                <td>${mobile.mobileNumber}</td>
            </tr>
        </c:forEach><br/>
    </table>
</div>
</body>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script src="../js/x-admin.js"></script>
</html>
