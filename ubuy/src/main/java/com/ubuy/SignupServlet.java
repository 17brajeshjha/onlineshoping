package com.ubuy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignupServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		System.out.println("-----------------------SignupServlet::doGet-------------------------");
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter(Constants.GetInstance().uname);
		String mobileno = request.getParameter(Constants.GetInstance().mobileno);
		String password = request.getParameter(Constants.GetInstance().pass);
		String customertype = request.getParameter(Constants.GetInstance().customertype);
		String emailid = request.getParameter(Constants.GetInstance().email);
		String malefemale = request.getParameter(Constants.GetInstance().malefemale);
		String country = request.getParameter(Constants.GetInstance().country);
		String state = request.getParameter(Constants.GetInstance().state);
		String city = request.getParameter(Constants.GetInstance().city);
		String colonyname = request.getParameter(Constants.GetInstance().colonyname);
		String streetname = request.getParameter(Constants.GetInstance().streetname);
		String pin = request.getParameter(Constants.GetInstance().pin);

		System.out.println("Password: "+password);
		if(name!=null && !name.isEmpty() && mobileno!=null && !mobileno.isEmpty() && password!=null && !password.isEmpty() && customertype!=null && !customertype.isEmpty())
		{
			if(mobileno.matches(Constants.GetInstance().admin_mobileno))
			{
				customertype = Constants.GetInstance().admin;
			}
			Customer addedBy=null;
			if(request.getSession(false)!=null)
			{
				String mobno = (String)request.getSession(false).getAttribute(Constants.GetInstance().mobileno);
				if(mobno!=null && !mobno.isEmpty())
				{
					addedBy = Customers.GetInstance().getByMobileNo(mobno);
				}
			}
			if (Customers.GetInstance().add(name, customertype, malefemale, mobileno, password, emailid, streetname,
					colonyname, city, state, pin, country,addedBy)) {
				if(customertype.matches(Constants.GetInstance().delivery_person))
				{
					request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_success_message);
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_youcan_login_message);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_message);
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}	
		}
		else {
			//request.setAttribute("servletResult", Constants.GetInstance().server_error_message);
			//request.getRequestDispatcher("signup.jsp").forward(request, response);
		}	
		
		//pw.write("<h2> Following data received successfully.. <h2> <br>");			 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
