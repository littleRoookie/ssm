<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<html>
<body>
<h2>Hello World!</h2>
<%--a标签里面的href如果不加/  解析出来就是 http://localhost:8080/项目名/
    如果加上了/就表示绝对路径了，就是浏览器解析到的 http://localhost:8080/
    是没有项目的名字的哦--%>
<a href="hello?username=gzx">Hello</a>
<form method="post" action="testPojo">
    <input type="text" name="username" /><br/>
    <input type="text" name="password"/><br/>
    <input type="submit" value="提交"><br/>
</form><br/>
<a href="testCode">测试doDispatch源码</a><br/>
<a href="testVC">测试XML配置View-Controller进行转发</a><br/>
<a href="testView">测试自定义的视图解析器</a><br/>
</body>
</html>
