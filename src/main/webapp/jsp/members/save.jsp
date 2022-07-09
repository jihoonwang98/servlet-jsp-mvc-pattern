<%@ page import="com.example.demo.repository.MemberRepository" %>
<%@ page import="com.example.demo.domain.Member" %><%--
  Created by IntelliJ IDEA.
  User: mojo
  Date: 2022/07/09
  Time: 11:15 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age, null);
    MemberRepository.INSTANCE.save(member);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
