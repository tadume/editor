package controller.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.users.AccountDTO;
import model.UserDAO;

@WebServlet("/accountindex")
public class AccountIndex extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		UserDAO udao = new UserDAO();
		AccountDTO adto = udao.select();
		
		req.setAttribute("adto", adto);
		RequestDispatcher rd = req.getRequestDispatcher("/users/user_index.jsp");
		rd.forward(req, res);
	}
}
