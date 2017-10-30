<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<link rel="stylesheet" type="text/css" href="/JoytecWorkKnr/css/common.css">
<link rel="stylesheet" type="text/css" href="/JoytecWorkKnr/css/login.css">
<title>勤怠管理 ログイン画面</title>
</head>
<body>
 <!-- コンテンツここから -->
 <div id="contents">
  ※ログイン画面：
  <form method="post" action="./login">
   <table class="type01" border=0>
    <tr>
     <td><label for="label1">社員番号</label></td>
     <td><input type="text" name="employeeCd"></td>
    </tr>
    <tr>
     <td><label for="label1">パスワード</label></td>
     <td><INPUT TYPE="password" name="pass"></td>
    </tr>
    <tr>
     <td></td>
     <td><input type="submit" value="ログイン"></td>
    </tr>
   </table>
  </form>
 </div>
 <!-- コンテンツここまで -->
</body>
</html>