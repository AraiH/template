<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<%@page import="com.joytec.src.beans.GWork"%>
<%@page import="java.io.*,java.util.*,java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	request.setCharacterEncoding("Windows-31J");
	String employeeNm = (String) request.getAttribute("employeeNm");
	ArrayList<GWork> list = new ArrayList<GWork>();

	// 現在の時刻を取得
	java.util.Date nowTime = new java.util.Date();
%>
<%
	request.setCharacterEncoding("Windows-31J");
	String Msg = (String) request.getAttribute("Msg");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>JSP SAMPLE</title>

<!-- スタイルシート設定 -->
<link rel="stylesheet" type="text/css" href="/JoytecWorkKnr/css/common.css">
<link rel="stylesheet" type="text/css" href="/JoytecWorkKnr/css/input.css">

</head>
<body>


 <!-- コンテンツここから -->
 <div id="contents">
  ※入力画面： <br>
  <p>
   <strong><%=nowTime%></strong>
  </p>
  <%=employeeNm%>さん<br>

  <form method="post" action="./input">
   <input type="hidden" name="employeeCd" value="${ employeeCd }" /> <input type="hidden" name="employeeNm" value="${ employeeNm }" />
   <table class="type01" border=0>
    <tr>
     <td><label for="label1">年月日</label></td>
     <td><input type="date" name="businessDay"></td>
    </tr>
    <tr>
     <td><label for="label1">開始</label></td>
     <td><input type="time" name="workStart"></td>
    </tr>
    <tr>
     <td><label for="label1">終了</label></td>
     <td><input type="time" name="workEnd"></td>
    </tr>
    <tr>
     <td></td>
     <td><input value="送信" type="submit"></td>
    </tr>
   </table>
  </form>

  <%=Msg%>
  ※勤怠票：
  <form method="post" action="./csvExport">
   <input type="hidden" name="employeeCd" value="${ employeeCd }" /> <input type="hidden" name="employeeNm" value="${ employeeNm }" /> <input value="CSV出力" type="submit">
  </form>
  <div style="height: 260px; width: 400px; overflow-y: scroll;">
   <table class="type01" border=0>
    <tr>
     <th>年月日</th>
     <th>開始時間</th>
     <th>終了時間</th>
    </tr>
    <c:forEach var="kintaiList" items="${kintaiList}">
     <tr class="sample3-li">
      <td>${kintaiList.businessDay}</td>
      <td>${kintaiList.workStart}</td>
      <td>${kintaiList.workEnd }</td>
     </tr>
    </c:forEach>
   </table>
  </div>
 </div>
 <!-- コンテンツここまで -->
</body>
</html>