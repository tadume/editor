package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.articles.IndexDTO;
import model.ArticleDAO;

@WebServlet("/article")
public class Article extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		String btn = req.getParameter("btn");
		String msg = "記事一覧を表示します";
		ArticleDAO adao = new ArticleDAO();
		IndexDTO idto = new IndexDTO();
		if(btn.equals("記事一覧表示")) {
			idto = adao.select();
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("idto", idto);
		RequestDispatcher rd = req.getRequestDispatcher("/articles/index.jsp");
		rd.forward(req, res);
	}
}
