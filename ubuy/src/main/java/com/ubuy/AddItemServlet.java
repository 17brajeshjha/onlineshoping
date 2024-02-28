package com.ubuy;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddItemServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String itemname = request.getParameter(Constants.GetInstance().itemname);
		Double rate = Double.parseDouble(request.getParameter(Constants.GetInstance().rate));
		String unit = request.getParameter(Constants.GetInstance().unit);
		Item.ITEM_UNIT itunit = Item.ITEM_UNIT.PACKET;;
		if(unit.matches(Constants.GetInstance().kg))
		{
			itunit = Item.ITEM_UNIT.KG;
		}
		else if(unit.matches(Constants.GetInstance().litters))
		{
			itunit = Item.ITEM_UNIT.LITTER;
		}
		//response.getWriter().append("Served at: "+itemname+" "+rate+" "+unit+" ").append(request.getContextPath());
		
		if(Items.GetInstance().add(itemname, rate, itunit, 0.0))
		{
			request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_success_message);
			request.getRequestDispatcher("AddItem.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_duplicate_entry_message);
			request.getRequestDispatcher("AddItem.jsp").forward(request, response);
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
