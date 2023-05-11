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
import model.AccountRegisterDAO;

@WebServlet("/accountregister")
public class AccountRegister extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		AccountBean ab = new AccountBean();
		ab.setName(name);
		ab.setPassword(password);
		ab.setEmail(email);
		
		AccountRegisterDAO adao = new AccountRegisterDAO();
		int cnt = adao.select(ab);
		
		if(cnt == 1) {
			HttpSession session = req.getSession(true);
			session.setAttribute("ab", ab);
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/users/registersuccess.jsp");
		rd.forward(req, res);
	}
}
