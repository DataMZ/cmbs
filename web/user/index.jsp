<%--
  Created by IntelliJ IDEA.
  User: zwcpc
  Date: 2018/9/6
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        index
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/x-admin.css" media="all">
    <script type="text/javascript" src="../js/utils.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <a class="logo" href="./index.html">
                <img src="../images/banner2.jpg" />
            </a>
            <ul class="layui-nav" lay-filter="">
                <li class="layui-nav-item"><img src="../images/0.jpg" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
                <li class="layui-nav-item">
                    <a href="javascript:;">${account.accountId}</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-side layui-bg-black x-side">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
                <!--数据管理-->
                <!--onclick="personalInfo()"-->
                <li class="layui-nav-item">
                    <a id="personalInfo" style="top:18%;background-color: rgba(0,0,0,0);" class="javascript:;" href="javascript:;" _href="main.jsp"  >
                        <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>个人信息</cite>
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a  class="javascript:;" href="javascript:;" _href="../common/blank.html" onclick="exit()" >
                        <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>退出系统</cite>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true">
        <div class="x-slide_left"></div>
        <ul class="layui-tab-title">
            <li class="layui-this">
                登录成功
                <i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
            </li>
        </ul>
        <div class="layui-tab-content site-demo site-demo-body">
            <div class="layui-tab-item layui-show">
                <iframe frameborder="0" src="welcome.jsp" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
    <div class="site-mobile-shade">
    </div>
</div>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script src="../js/x-admin.js"></script>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<script>
    function exit() {
        doFormRequest(getRootURL()+"/exit/exit.jsp","get",{})
    }
</script>
</body>
</html>
