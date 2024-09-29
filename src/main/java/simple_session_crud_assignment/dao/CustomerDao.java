package simple_session_crud_assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import simple_session_crud_assignment.connection.CustomerConnection;
import simple_session_crud_assignment.dto.Customer;

public class CustomerDao {
	
	Connection connection = CustomerConnection.getCustomerConnection();
	
	PreparedStatement ps;
	
	private final String CUSTOMERINSERTQUERY = "insert into CustomerAssign(id,name,email,password,phone,dob) values(?,?,?,?,?,?)";
	
	final String DISPLAY_STUDENT_QUERY = "Select * from CustomerAssign";
	
	private final String DISPLAY_SINGLE_PRODUCT = "select * from CustomerAssign where id=?";
	
	private final String UPDATE_QUERY = "update CustomerAssign set name=?, email=?, password=?, phone=?, dob=? where id=?";
	
	private final String delete_Product_By_Id = "delete from CustomerAssign where id=?";
	
	
	//Insert
	public Customer saveCustomerDao(Customer customer) {
		
		try {
			ps = connection.prepareStatement(CUSTOMERINSERTQUERY);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPassword());
			ps.setLong(5, customer.getPhone());
			ps.setObject(6, customer.getDob());
			ps.execute();
			return customer;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	//Display all
	public List<Customer> getAllCustomerDataDao(){
		
		try {
			ps = connection.prepareStatement(DISPLAY_STUDENT_QUERY);
			
			ResultSet set = ps.executeQuery();
			
			List<Customer> list = new ArrayList<Customer>();
			
			while(set.next()) {list.add(new Customer(
					set.getInt("id"),
					set.getString("name"),
					set.getString("email"),
					set.getString("password"),
					set.getLong("phone"),
					set.getDate("dob").toLocalDate()
					));
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
//	display single customer by id
	public Customer getCustomerByIdDao(int id) {
		
		Customer customer = null;
		
		try {
			ps=connection.prepareStatement(DISPLAY_SINGLE_PRODUCT);
			ps.setInt(1, id);
			
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				int ids = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				Long mob = resultSet.getLong("phone");
				LocalDate dob = resultSet.getDate("dob").toLocalDate();
				
				customer = new Customer(id,name,email,password,mob,dob);
			}
			
			return customer;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
//	Update
	public int updateCustomerDetailsDao(Customer customer) {
		
		try {
			ps=connection.prepareStatement(UPDATE_QUERY);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPassword());
			ps.setLong(4, customer.getPhone());
			ps.setObject(5, customer.getDob());
			ps.setInt(6, customer.getId()); // Ensure this is being set correctly

			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
//	Delete
	
	public int deleteCustomerByIdDao(int id) {
		try {
			ps=connection.prepareStatement(delete_Product_By_Id);
			ps.setInt(1, id);
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	

}
