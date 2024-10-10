package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onllinebookstore.dto.Admin;

import dao.AdminDao;

@WebServlet("/AdminSignUp")
public class AdminSignUp extends HttpServlet{
	int id;
	String adminName;
	String eMail;
	String adminPass;
	String confmPass;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		adminName = req.getParameter("adminName");
		 eMail= req.getParameter("eMail");
		 adminPass= req.getParameter("adminPass");
		confmPass = req.getParameter("cpassword");
		Admin admin= new Admin(id,adminName,adminPass,eMail);
		AdminDao adDao= new AdminDao();
	if(adminPass.equals(confmPass))	{
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookstore","root","root");
//			PreparedStatement ps = con.prepareStatement("insert into admin values(?,?,?,?)");
//			ps.setInt(1, admin.getId());
//			ps.setString(2, admin.getAdminName());
//			ps.setString(3, admin.getAdminPass());
//			ps.setString(4, admin.getEmail());
//			int count = ps.executeUpdate();
//			con.close();
			adDao.saveAdmin(admin);
			resp.sendRedirect("login.html");
			
		} catch (Exception e) {
			System.out.println("Enter valid details..");
		} 
	}
		
	}
}
