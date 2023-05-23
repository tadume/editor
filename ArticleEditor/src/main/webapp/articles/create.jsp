<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記事作成画面</title>
</head>
<body>
	<h1>記事作成画面</h1>
	<form action="/ArticleEditor/article" method="post">
		タイトル：<br>
		<input type="text" name="title" size="50" maxlength="10" required><br>
		本文：<br>
		<textarea name="text" cols="50" rows="2" maxlength="3000" required></textarea><br>
		
		<input type="submit" name="btn" value="記事作成">
		<button type="button">下書き保存</button>
	</form>
</body>
</html>