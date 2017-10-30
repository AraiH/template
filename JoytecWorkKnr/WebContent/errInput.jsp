<%@ page contentType="text/html;charset=Windows-31J"
    pageEncoding="Windows-31J" %>
    <%
        request.setCharacterEncoding("Windows-31J");
        String errMsg = (String)request.getAttribute("ErrMsg");
    %>

<html>
<title>
エラーページ
</title>
<head>
</head>
<body>
    <font color = "#ff0000"><b>システムエラーです。</b></font><br>
    【<%= errMsg %>】
    <form action = "input.jsp" method="POST">
        <input type = "submit" value="戻る" />
    </form>
</body>
</html>