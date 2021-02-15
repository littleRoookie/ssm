<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/7
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1.新建表单enctype="multipart/form-data"最关键--%>
<form action="upload" method="post" enctype="multipart/form-data">
    用户头像：<input type="file" name="headerImg"/><br/>
    用户名：<input type="text" name="username"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
