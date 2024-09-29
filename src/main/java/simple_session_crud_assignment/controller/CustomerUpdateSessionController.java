package simple_session_crud_assignment.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value="")
public class CustomerUpdateSessionController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("userSession") != null) {
			req.getRequestDispatcher("Update.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "you are not logged in");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}

}
