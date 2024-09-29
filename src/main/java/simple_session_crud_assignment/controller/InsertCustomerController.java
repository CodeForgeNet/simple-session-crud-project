package simple_session_crud_assignment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import simple_session_crud_assignment.dao.CustomerDao;
import simple_session_crud_assignment.dto.Customer;

@WebServlet(value="/registerForm")
public class InsertCustomerController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerDao dao = new CustomerDao();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		
		Customer customer = new Customer(id,name,email,password,phone,dob);
		
		Customer customer2 = dao.saveCustomerDao(customer);
		if(customer2!=null) {
			System.out.println("Data Stored");
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("Register.jsp");
		dispatcher.include(req, resp);
	}

}
