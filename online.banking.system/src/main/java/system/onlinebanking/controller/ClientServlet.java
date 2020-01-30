package system.onlinebanking.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import system.onlinebanking.bean.ClientDetailBean;
import system.onlinebanking.dao.ClientDAO;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClientDAO clientDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	clientDao = new ClientDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		switch(action) {
		
		case "/insert":
			showNewForm(request, response);
			break;
		
		case "/register":
			insertClient(request, response);
			break;
			
		case "/delete":
			deleteClient(request, response);
			break;
			
		case "/edit":
			showEditForm(request, response);
			break;
			
		case "/update":
			updateClient(request, response);
			break;
			
		default:
			homepg(request,response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}
	
	private void insertClient(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String name = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String idNum = request.getParameter("idNum");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		ClientDetailBean newClient = new ClientDetailBean();
		
		clientDao.saveClient(newClient);
		
		response.sendRedirect("homepg");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String idNum = request.getParameter("clientIndex");
		ClientDetailBean clientUpdate = clientDao.getIdNum(idNum);
		
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		request.setAttribute("client", clientUpdate);
		rd.forward(request, response);
	}
	
	public void deleteClient(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("clientIndex"));
		clientDao.deleteClient(id);
		response.sendRedirect("homepg");
	}
	
	private void updateClient(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("clientIndex"));
		
		String name = request.getParameter("firstName");
		String lastName = request.getParameter("lastNeme");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		
		ClientDetailBean client = new ClientDetailBean(id, name, lastName, phone, email, address, password, repassword);
		clientDao.updateClient(client);
		response.sendRedirect("homepg");
	}
	
	private void homepg(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
