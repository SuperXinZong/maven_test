<%--
  Created by IntelliJ IDEA.
  User: dianit
  Date: 2020/6/27
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/test/res/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        function test() {
            $.get("/test/test1", {
                "student.name":"qwer"
            }, function (result) {
                console.log(result);
            } );
            // var result = [{"id":"zs","hobby":["篮球","足球"]},{"id":"ls","hobby":["篮球","排球"]}];
            // console.log(result[1].hobby[1]);
        }
    </script>
</head>
<body>
<button type="button" onclick="test()">test</button>
<form action="/test/test1">
    <input type="text" name="userIds" value="1"/>
    <input type="text" name="userIds" value="2"/>
    <input type="text" name="userIds" value="3"/>
    <input type="text" name="student.name" value="qwer"/>
    <button type="submit">submit</button>

</form>
</body>
</html>
