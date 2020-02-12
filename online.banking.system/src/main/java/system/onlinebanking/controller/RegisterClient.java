package system.onlinebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import system.onlinebanking.dao.ClientDAO;

/**
 * Servlet implementation class RegisterClient
 */

@WebServlet("/RegisterClient")
public class RegisterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDAO clientDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public RegisterClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			String idNum = request.getParameter("idNum");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");
			
			String sql = "insert into CLIENT_DETAILS(name, surname, gender, address, id_number,  email, phone, password) values (?,?,?,?,?,?,?,?)";
			
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test/client_details", "sa", "");
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, lastName);
			ps.setString(3, gender);
			ps.setString(4, idNum);
			ps.setString(5, address);
			ps.setString(6, email);
			ps.setString(7, phone);
			ps.setString(8, password);
			
			ps.executeUpdate();
			
			PrintWriter out = response.getWriter();
			out.println("You Are Now A Successfully Registered Client. Welcome!!!");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
