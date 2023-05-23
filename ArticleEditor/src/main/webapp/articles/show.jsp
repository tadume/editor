<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.articles.*" %>
<jsp:useBean id="idto" class="bean.articles.IndexDTO" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記事詳細画面</title>
</head>
<body>
	<% for(int i = 0; i < idto.size(); i++){ %>
	<% IndexBean ib = idto.get(i); %>
	<h1><%= ib.getTitle() %></h1>
	<h2><%= ib.getText() %></h2>
	<% } %>
</body>
</html>