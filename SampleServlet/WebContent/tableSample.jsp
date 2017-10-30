<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<%@ page import="java.io.*,java.util.*,java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>JSP SAMPLE</title>
</head>
<body>
 <%
 	// ���X�g��錾
 	List<String[]> tableList = new ArrayList<String[]>();

 	for (int i = 0; i < 10; i++) {
 		// �z����`
 		String[] stArray = new String[4];

 		// �z��ɒl���Z�b�g
 		for (int j = 0; j < 4; j++) {

 			if (i == 9 && j == 3) {
 				stArray[j] = "";
 			} else {
 				stArray[j] = i + " - " + j;
 			}

 		}
 		// ���X�g�ɔz����Z�b�g
 		tableList.add(stArray);
 	}
 	//���o
 	request.setAttribute("tableList", tableList);
 %>


 <%
 	//Java8�T���v��
 	List<String> cities = new ArrayList<String>();
 	cities.add("���s");
 	cities.add("���");
 	cities.add("�_��");
 	cities.forEach(System.out::println);

 	int i[] = { 1 };
 	java.util.stream.Stream.of("a", "b", "c", "d").forEach(s -> {
 		System.out.println(i[0] + ": " + s);
 		i[0]++;
 	});
 %>

 <div>

  <table border="1" width="700" cellspacing="0" cellpadding="5" bordercolor="#333333">
   <tr>
    <th bgcolor="#eeeeee"><font color="#000000">�v�f�P</font></th>
    <th bgcolor="#eeeeee"><font color="#000000">�v�f�Q</font></th>
    <th bgcolor="#eeeeee"><font color="#000000">�v�f�R</font></th>
    <th bgcolor="#eeeeee"><font color="#000000">�v�f�S</font></th>
   </tr>

   <c:forEach var="obj" items="${tableList}" varStatus="status">
    <tr>
     <td><input type="checkbox" name="checkbox" value="${status.index}0" checked="checked">�F<c:out value="${obj[0]}" /></td>
     <td><input type="checkbox" name="checkbox" value="${status.index}1" checked="checked">�F<c:out value="${obj[1]}" /></td>
     <td><input type="checkbox" name="checkbox" value="${status.index}2" checked="checked">�F<c:out value="${obj[2]}" /></td>
     <td><input type="checkbox" name="checkbox" value="${status.index}3" checked="checked">�F<c:out value="${obj[3]}" /></td>
    </tr>
   </c:forEach>
  </Table>
 </div>
</body>
</html>