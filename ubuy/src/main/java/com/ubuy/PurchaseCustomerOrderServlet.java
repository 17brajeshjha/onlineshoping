package com.ubuy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PurchaseCustomerOrderServlet
 */
@WebServlet("/PurchaseCustomerOrderServlet")
public class PurchaseCustomerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PurchaseCustomerOrderServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
			String mobileno = (String)request.getSession(false).getAttribute(Constants.GetInstance().mobileno);
	        String country = request.getParameter(Constants.GetInstance().country);
	        String state = request.getParameter(Constants.GetInstance().state);
	        String city = request.getParameter(Constants.GetInstance().city);
	        String colonyname = request.getParameter(Constants.GetInstance().colonyname);
	        String streetname = request.getParameter(Constants.GetInstance().streetname);
	        String pin = request.getParameter(Constants.GetInstance().pin);
	        String phone = request.getParameter(Constants.GetInstance().phone);
	        System.out.println(mobileno+" "+country+" "+state+" "+city+" "+colonyname+" "+streetname+" "+pin);
	        Customer goodsPurchaser = Customers.GetInstance().getByMobileNo(mobileno);
	        List<CustomerSelectedItem> csiList = CustomerSelectedItems.GetInstance().getByCustomer(goodsPurchaser);
	        if(Orders.GetInstance().purchaseOrder(csiList, goodsPurchaser, colonyname, streetname, city, state, pin, phone))
	        {
				request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_success_customer_purchase_message);
				request.getRequestDispatcher("ViewCustomerPurchasedOrder.jsp").forward(request, response);
	        }
	        else
	        {
	        	request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_message);
				request.getRequestDispatcher("PurchaseCustomerOrder.jsp").forward(request, response);
	        }
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
			request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_message);
			request.getRequestDispatcher("PurchaseCustomerOrder.jsp").forward(request, response);
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
