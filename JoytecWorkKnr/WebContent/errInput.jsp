<%@ page contentType="text/html;charset=Windows-31J"
    pageEncoding="Windows-31J" %>
    <%
        request.setCharacterEncoding("Windows-31J");
        String errMsg = (String)request.getAttribute("ErrMsg");
    %>

<html>
<title>
�G���[�y�[�W
</title>
<head>
</head>
<body>
    <font color = "#ff0000"><b>�V�X�e���G���[�ł��B</b></font><br>
    �y<%= errMsg %>�z
    <form action = "input.jsp" method="POST">
        <input type = "submit" value="�߂�" />
    </form>
</body>
</html>