package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.articles.IndexDTO;
import bean.users.AccountBean;
import model.ArticleDAO;

@WebServlet("/article")
public class Article extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html ; charset = utf-8");
		PrintWriter out = res.getWriter();
		
		String btn = req.getParameter("btn");
		String msg = "記事一覧を表示します";
		ArticleDAO adao = new ArticleDAO();
		IndexDTO idto = new IndexDTO();
		
		if(btn.equals("記事一覧表示")) {
			idto = adao.select();
			req.setAttribute("msg", msg);
			req.setAttribute("idto", idto);
			RequestDispatcher rd = req.getRequestDispatcher("/articles/index.jsp");
			rd.forward(req, res);
		}else if(btn.equals("削除")) {
			int article_id = Integer.parseInt(req.getParameter("article_id"));
			int i = adao.delete(article_id);
			if(i == 1) {
				out.println("削除しました。");
				RequestDispatcher rd = req.getRequestDispatcher("/mypage.jsp");
				rd.forward(req, res);
			}
		}else if(btn.equals("詳細")) {
			System.out.println("記事詳細を利用");
			int article_id = Integer.parseInt(req.getParameter("article_id"));
			idto = adao.show(article_id);
			req.setAttribute("idto", idto);
			RequestDispatcher rd = req.getRequestDispatcher("/articles/show.jsp");
			rd.forward(req, res);
		}else if(btn.equals("記事作成")) {
			System.out.println("記事作成を利用");
			String title = req.getParameter("title");
			String text = req.getParameter("text");
		
			HttpSession session = req.getSession(true);
			 AccountBean returnAb = (AccountBean)session.getAttribute("returnAb");
			int user_id = returnAb.getUser_id();
			
			int i = adao.create(title, text, user_id);
			if(i == 1) {
				System.out.println("記事を作成しました。");
				RequestDispatcher rd = req.getRequestDispatcher("/top.html");
				rd.forward(req, res);
			}
		}
		

	}
}
