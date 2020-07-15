<%--
  Created by IntelliJ IDEA.
  User: dianit
  Date: 2020/6/29
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/test/upLoad" method="post" enctype="multipart/form-data">
    <input type="file" name="img"/>
    <button type="submit">upload</button>
</form>
</body>
</html>
