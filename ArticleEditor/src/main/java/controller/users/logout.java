package controller.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		HttpSession session = req.getSession();
		if(session.getAttribute("returnAb") != null) {
			session.invalidate();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/users/logout.jsp");
		rd.forward(req, res);
	}
}
