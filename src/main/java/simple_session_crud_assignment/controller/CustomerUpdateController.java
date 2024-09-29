package simple_session_crud_assignment.controller;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import simple_session_crud_assignment.dao.CustomerDao;
import simple_session_crud_assignment.dto.Customer;

@WebServlet(value="/customerUpdate")
public class CustomerUpdateController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerDao dao = new CustomerDao();
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Long phone = Long.parseLong(req.getParameter("phone")) ;
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		
		Customer customer = new Customer(id,name,email,password,phone,dob);
		dao.updateCustomerDetailsDao(customer);
		
		req.getRequestDispatcher("Display.jsp").forward(req,resp);
		
		
	}

}
