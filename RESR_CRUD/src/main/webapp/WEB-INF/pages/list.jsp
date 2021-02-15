<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>员工列表页面</title>
</head>
<body>
<h1>员工列表</h1><br/>
<table BORDER="1" CELLPADDING="5" CELLSPACING="0">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>department</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${requestScope.emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.department.departmentName}</td>
            <td><a href="emp/${emp.id}">EDIT</a></td>
            <td><a href="emp/${emp.id}" class="deleteBut">DELETE</a></td>
        </tr>
    </c:forEach>
</table>

<form id="deleteForm" action="" method="post">
    <input type="hidden" name="_method" value="delete"/>
</form>

<script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".deleteBut").click(function () {
            //改变表单的提交地址
            $("#deleteForm").attr("action",this.href);
            //提交表单
            $("#deleteForm").submit();
            return false;
        });
    });
</script>
<a href="toAddPage">添加员工</a>
</body>
</html>
