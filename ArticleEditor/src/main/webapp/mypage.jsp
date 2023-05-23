<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.articles.*" %>
<jsp:useBean id="idto" class="bean.articles.IndexDTO" scope="request"></jsp:useBean>
<jsp:useBean id="name" class="java.lang.String" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ画面</title>
</head>
<body>
	<h2>ようこそ<%= name %>さん</h2>
	<form action="/ArticleEditor/articles/create.jsp" method="post">
		<input type="submit" name="btn" value="記事作成">
	</form>
	<h3>記事数：<%= idto.size() %></h3>
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
					<form action="/ArticleEditor/article" method="post">
						<input type="hidden" name="article_id" value="<%= Integer.toString(ib.getArticle_id()) %>">
						<input type="submit" name="btn" value="詳細">
					</form>
				</td>
				<td>
					<button type="button">編集</button>
				</td>
				<td>
					<form action="/ArticleEditor/article" method="post">
						<input type="hidden" name="article_id" value="<%= Integer.toString(ib.getArticle_id()) %>">
						<input type="submit" name="btn" value="削除" >
					</form>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>