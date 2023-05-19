<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.articles.*" %>
<jsp:useBean id="idto" class="bean.articles.IndexDTO" scope="request" ></jsp:useBean>
<jsp:useBean id="msg" class="java.lang.String" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記事一覧画面</title>
</head>
<body>
	<h1>記事一覧画面</h1>
	<h2><%= msg %></h2>
	<form action="<%= request.getContextPath() %>/logout" method="get">
		<% Object returnAb = session.getAttribute("returnAb"); %>
		<% if(returnAb != null){ %>
			<input type="submit" value="ログアウト">
	</form>
			<button type="button" onclick="location.href='/ArticleEditor/accountindex'">ユーザ一覧</button>
		<% }else{ %>
			<button type="button" onclick="location.href='/ArticleEditor/users/register.html'">サインアップ</button>
			<button type="button" onclick="location.href='/ArticleEditor/users/login.html'">ログイン</button>
		<% } %>
	
	<table>
		<thead>
			<tr>
				<th>タイトル</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 0; i < idto.size(); i++){
					IndexBean ib = idto.get(i);
			%>
			<tr>
				<td><%= ib.getTitle() %></td>
				<td>
					<button type="button" onclick="location.href='/ArticleEditor/articles/show.jsp'">詳細</button>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>