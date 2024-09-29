package simple_session_crud_assignment.controller;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import simple_session_crud_assignment.dao.CustomerDao;

public class CustomerDeleteController extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		new CustomerDao().deleteCustomerByIdDao(id);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("Display.jsp");
		dispatcher.forward(req, res);
		
		
	}

}
