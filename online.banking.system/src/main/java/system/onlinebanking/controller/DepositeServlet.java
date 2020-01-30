package system.onlinebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepositeServlet
 */
public class DepositeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositeServlet() {
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
		
		int i = Integer.parseInt(request.getParameter("dpst"));
		
		int j = Integer.parseInt(request.getParameter("blnc"));
		
		j = 0;
		
		j = j + i;
		
//		PrintWriter pw = response.getWriter();
//		pw.println("Your Current Balance is: " + j);
		
		request.setAttribute("j", j);
		request.setAttribute("i", i);
		
		RequestDispatcher rd = request.getRequestDispatcher("bln");
		rd.forward(request, response);
		doGet(request, response);
	}

}
