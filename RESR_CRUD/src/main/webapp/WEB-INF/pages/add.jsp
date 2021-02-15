<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>

<h1>员工添加页面</h1>
<form:form action="emp" modelAttribute="employee" method="post">
    <%--path两个作用：1.原本的name属性；2.自动回显隐含模型中某个对象对应的这个属性的值--%>
    lastName:<form:input path="lastName"/><form:errors path="lastName" cssStyle="color: red"/>--->${errorsMap.lastName}<br/>
    email:<form:input path="email"/><form:errors path="email" cssStyle="color: red"/>--->${errorsMap.email}<br/>
    gender:male<form:radiobutton path="gender" value="1" checked="true"/>
    &nbsp;female<form:radiobutton path="gender" value="0"/><br/>
    <%--items会自动遍历，这里遍历出的每一个元素都是一个Department对象
        itemLabel="属性名"：指定遍历出的这个对象的哪个属性是作为option标签体中的值，就是要显示出来的内容
        itemValue="属性名"：指定遍历出的这个对象的哪个属性是作为option标签体value属性的值，就是要提交的值
    --%>
    department:<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"/><br/>
    <%--提交写原生的--%>
    <input type="submit" value="提交">
</form:form>

<%--<form action="" method="">
    LastName:<input type="text" name="lastName"/><br/>
    Email:<input type="text" name="email"/><br/>
    Gender:male<input type="radio" name="gender" checked="checked" value="1">&nbsp;female:<input type="radio" name="gender" value="0"><br/>
    Department：<select name="department.id">
        <c:forEach items="${requestScope.depts}" var="dept">
            <option value="${dept.id}">${dept.departmentName}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="提交">
</form>--%>
</body>
</html>
