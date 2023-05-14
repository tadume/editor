<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.users.*" %>
<jsp:useBean id="adto" class="bean.users.AccountDTO" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ一覧画面</title>
</head>
<body>
	<h1>ユーザ一覧</h1>
	<button type="button" onclick="location.href='/ArticleEditor/top.html'">トップ画面</button>
	<table>
		<thead>
			<tr>
				<th>ユーザ名</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 0; i < adto.size(); i++){
					AccountBean ab = adto.get(i);
			%>
			<tr>
				<td><%= ab.getName() %>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>