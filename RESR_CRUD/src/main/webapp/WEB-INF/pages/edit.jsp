<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<h1>员工修改信息页面</h1>
<form:form action="${ctp}/emp/${employee.id}" modelAttribute="employee" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="hidden" name="id" value="${employee.id}">
    email:<form:input path="email"/><br/>
    gender:male<form:radiobutton path="gender" value="1" checked="true"/>
    &nbsp;&nbsp;&nbsp;female<form:radiobutton path="gender" value="0"/><br/>
    <%--items会自动遍历，这里遍历出的每一个元素都是一个Department对象
        itemLabel="属性名"：指定遍历出的这个对象的哪个属性是作为option标签体中的值，就是要显示出来的内容
        itemValue="属性名"：指定遍历出的这个对象的哪个属性是作为option标签体value属性的值，就是要提交的值
    --%>
    department:<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"/><br/>
    <%--提交写原生的--%>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
