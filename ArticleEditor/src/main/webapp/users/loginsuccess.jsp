<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.users.*" %>
<jsp:useBean id="returnAb" class="bean.users.AccountBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功画面</title>
</head>
<body>
	<h2>ログインに成功しました！</h2>
		ユーザ名：<strong><%= returnAb.getName() %></strong>
	<button type="button" onclick="location.href='/ArticleEditor/top.html'">トップ画面</button>
</body>
</html>