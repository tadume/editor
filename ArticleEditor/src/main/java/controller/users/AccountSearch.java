package controller.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.users.AccountBean;
import model.AccountDAO;

@WebServlet("/accountsearch")
public class AccountSearch extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		AccountBean ab = new AccountBean();    //フォームから取得した情報を格納してSQL文を完成させる
		ab.setPassword(password);
		ab.setEmail(email);
		
		AccountDAO adao = new AccountDAO();

		AccountBean returnAb = adao.findAccount(ab);    //DBから取得した情報を returnAb に格納
		
		if(returnAb != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("returnAb", returnAb);
			
			RequestDispatcher rd = req.getRequestDispatcher("/users/loginsuccess.jsp");
			rd.forward(req, res);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/users/error.jsp");
			rd.forward(req, res);
		}
	}

}
