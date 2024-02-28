package com.ubuy;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//https://docs.oracle.com/cd/E13224_01/wlw/docs103/guide/ormworkbench/conAddingEJB3Support.html#add_ejb3_to_existing_proj
//https://www.objectdb.com/tutorial/jpa/eclipse/web/servlet
//https://www.javawebtutor.com/articles/jpa/jpa-example-in-eclipse.php
//https://www.javawebtutor.com/articles/jpa/jpa-example-in-eclipse.php
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
        
		String mobileno = request.getParameter(Constants.GetInstance().mobileno);
		String pass = request.getParameter(Constants.GetInstance().pass);
		//System.out.println("login: mobileno "+ mobileno+" pass "+pass);
		/*
		 * response.setContentType("text/html"); PrintWriter pw = response.getWriter();
		 * pw.write("<h2> Following data received sucessfully.. <h2> <br>");
		 * pw.write("<h3> Mobile: " + mobileno + " </h3>"); pw.write("<h3> Password: " +
		 * pass + " </h3>");
		 */
		
		Customer cust = Customers.GetInstance().getByMobileNo(mobileno);
		if(cust!=null)
		{
			if(cust.getPassword().matches(pass))
			{
				System.out.println("Thank you! You are successfully logged in.");
				// Get the session object
		        HttpSession session = request.getSession(); // new session
		        System.out.println("Session on login: "+ session);
				session.setAttribute(Constants.GetInstance().mobileno, mobileno);
				request.setAttribute(Constants.GetInstance().customer, cust);
				if(cust.getCustType() == Customer.CUSTOMER_TYPE.ADMIN)
				{
					request.getRequestDispatcher("admin.jsp").forward(request, response);
				}
				else if(cust.getCustType() == Customer.CUSTOMER_TYPE.GOODS_DELIVERY_PERSON)
				{
					request.getRequestDispatcher("goodsDeliveryPerson.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("customer.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute(Constants.GetInstance().servletResult, mobileno+" "+Constants.GetInstance().server_error_message);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute(Constants.GetInstance().servletResult, mobileno+" "+Constants.GetInstance().server_error_message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
