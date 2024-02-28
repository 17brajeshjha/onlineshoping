package com.ubuy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogoutServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Get the print writer object to write into the response
        PrintWriter out = response.getWriter();
        // Set the content type of response to "text/html"
        response.setContentType("text/html");
        String mobileno = request.getParameter(Constants.GetInstance().mobileno);
        System.out.println("LogoutServlet:doGet:mobileno: "+ mobileno);
        // For understanding purpose, print the session object in the console before
        if(request.getSession(false)!=null && request.getSession(false).getAttribute(Constants.GetInstance().mobileno)!=null)
        {
        	System.out.println("Session before invalidate: "+ request.getSession(false));
            System.out.println("Session attribute before invalidate: "+ request.getSession(false).getAttribute(Constants.GetInstance().mobileno));
            
	        // Invalidate the session.
	        request.getSession(false).invalidate();
	  
	        // Print the session object in the console after invalidating the session.
	        System.out.println("Session after invalidate: "+ request.getSession(false));
	  
	        // Print success message to the user and close the print writer object.
	        System.out.println("Thank you! You are successfully logged out.");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else
        {
        	System.out.println("Session not invalidated: "+ request.getSession(false));
        }
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
