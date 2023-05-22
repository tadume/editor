package controller;

import java.io.IOException;

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

@WebServlet("/mypage")
public class Mypage extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
		HttpSession session = req.getSession(true);
		ArticleDAO adao = new ArticleDAO();
		IndexDTO idto = new IndexDTO();
		AccountBean returnAb = (AccountBean)session.getAttribute("returnAb");
		
		//ログインしている時、ユーザの情報を送り、ユーザが作成した記事を取得する。
		if(returnAb != null) {
			idto = adao.mypage(returnAb.getUser_id());
			req.setAttribute("idto", idto);
			String name = returnAb.getName();
			req.setAttribute("name", name);
			RequestDispatcher rd = req.getRequestDispatcher("/mypage.jsp");
			rd.forward(req, res);

		}
	}
}
