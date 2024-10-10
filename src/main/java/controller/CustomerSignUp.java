package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onllinebookstore.dto.Customer;

import dao.CustomerDao;

@WebServlet("/Customer")
public class CustomerSignUp extends HttpServlet{
	
	String username;
	long mobNo;
	String eMail;
	String password;
	String cpassword;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		username =req.getParameter("username");
		mobNo=Long.parseLong(req.getParameter("mobile"));
		eMail = req.getParameter("email");
		password = req.getParameter("password");
		cpassword=req.getParameter("cpassword");
		Customer custom = new Customer(username,eMail,mobNo,password);
		CustomerDao customerDao = new CustomerDao();
		if(cpassword.equals(password)) {
			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc:mysql:///onlinebookstore","root","root");
//				PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?)");
//				ps.setInt(1, custom.getId());
//				ps.setString(2, custom.getCustomerName());
//				ps.setString(3, custom.getCustomeremail());
//				ps.setString(4, custom.getCustomerpass());
//				ps.setLong(5, custom.getCustomerphn());
//				int count = ps.executeUpdate();
//				con.close();
				customerDao.saveCustomer(custom);
			}
			catch(Exception e){
				System.out.println("Give essential detials...");
			}
		}
	}
}
