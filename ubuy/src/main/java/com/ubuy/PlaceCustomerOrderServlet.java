package com.ubuy;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlaceCustomerOrderServlet
 */
@WebServlet("/PlaceCustomerOrderServlet")
public class PlaceCustomerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PlaceCustomerOrderServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
		/*
		 * PrintWriter out = response.getWriter(); String greetings =
		 * "Place Customer Order Servlet"; response.setContentType("text/plain");
		 * response.getWriter().write(greetings);
		 */
		String message = request.getParameter("PlaceCustomerOrderMsg");
		if(message==null)
		{
			request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_message);
			request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
		}
		else if(message.matches("Search"))
		{
			System.out.println("Search"); 
			       
           String mobileno = (String)request.getSession(false).getAttribute(Constants.GetInstance().mobileno);
           String itemname = request.getParameter(Constants.GetInstance().itemname);
           System.out.println("itemname = "+itemname); 
           List<Item> itemList = (itemname==null || itemname.isEmpty())?Items.GetInstance().getAll():Items.GetInstance().getItemsByName(itemname);
           if(itemList!=null && itemList.size()>0)
           {
        	   String strFinal="<table class=tb>";
        	   strFinal+="<tr style=background-color:red;color:white;>";
        	   strFinal+="<th>";
        	   strFinal+=Constants.GetInstance().placecustomerorder_caption_itemname;
        	   strFinal+="</th></tr>";
        	   
        	   System.out.println("item list count = "+itemList.size()); 
        	   for(int i=0; i<itemList.size();i++)
        	   {
        		    Item item = itemList.get(i);
		         	String str = "<tr><td>";
		         	str += item.getItemName()+" "+Constants.GetInstance().currency_name+" "+item.getRate()+"/"+item.getUnit().toString();
		         	str += "<form action=PlaceCustomerOrderServlet method=get>";
		         	str += "<input type=hidden name=PlaceCustomerOrderMsg value=Select>";
		         	str += "<input type=hidden name="+Constants.GetInstance().mobileno+" value="+mobileno+">";
		         	str += "<input type=hidden name="+Constants.GetInstance().itemno+" value="+item.getItemNo()+">";
		         	str += "Enter Quantity <input type=number name="+Constants.GetInstance().quantity+" step=0.01 min=1 max=100>";
		         	str += "<input type=submit value=Select>";
		         	str += "</form></td></tr>";
		         	//out.print(str);
		         	System.out.println(str); 
		         	strFinal += str;
		         	System.out.println("//////////////////////////////////////////////////////////////"); 
        	   }
        	   strFinal+="</table>";
        	         	          	   
        	   List<CustomerSelectedItem> custSelected = CustomerSelectedItems.GetInstance().getByCustomer(Customers.GetInstance().getByMobileNo(mobileno));
               if(custSelected!=null && custSelected.size()>0)
               {
            	   strFinal+="<table class=tb>";
            	   strFinal+="<tr style=background-color:red;color:white;>";
            	   strFinal+="<th>";
            	   strFinal+=Constants.GetInstance().placecustomerorder_caption_selecteditems;
            	   strFinal+="</th></tr>";
            	   
	               	double totalPrice = 0;
	               	for(int i=0;i<custSelected.size();i++)
	               	{
	               		CustomerSelectedItem csi = custSelected.get(i);
	               		if(csi!=null)
	               		{
	   			         	String str = "<tr><td>";
	   			         	str += csi.getItem().getItemName()+" "+Constants.GetInstance().currency_name+" "+csi.getItem().getRate()+"/"+csi.getItem().getUnit().toString();
	   			         	str += " Quantity = "+csi.getQuantity();
	   			         	str += " Price = "+Constants.GetInstance().currency_name+" "+csi.getItem().getRate()*csi.getQuantity();
	   			         	str += "<form action=PlaceCustomerOrderServlet method=get>";
	   			         	str += "<input type=hidden name=PlaceCustomerOrderMsg value=Delete>";
	   			         	str += "<input type=hidden name="+Constants.GetInstance().mobileno+" value="+mobileno+">";
	   			         	str += "<input type=hidden name="+Constants.GetInstance().itemno+" value="+csi.getItem().getItemNo()+">";
	   			         	str += "<input type=submit value=Delete>";
	   			         	str += "</form></td></tr>";
	   			         	strFinal += str;
	   			         	//out.print(str);
	   			         	totalPrice+=csi.getItem().getRate()*csi.getQuantity();	   			         	
	               		}
	               	}
	               	String str = "<tr><td>";
	   	         	str += "Total Price = "+Constants.GetInstance().currency_name+" "+totalPrice;
	   	         	str += "</td></tr>";
	   	         	strFinal += str;
	   	         	strFinal+="</table>";
	   	         	
	   	         strFinal+="<form action=PlaceCustomerOrderServlet method=get>";
	   	         strFinal+="<input type=hidden name=PlaceCustomerOrderMsg value=PurchaseCustomerOrder>";
	   	         strFinal+="<input type=submit value=Buy>";
	   	         strFinal+="</form>";
               }
               else
               {
            	   System.out.println("No items selected to purchase");
               }
               System.out.println(strFinal); 
        	   request.setAttribute(Constants.GetInstance().servletResultListOfItems, strFinal);
			   request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
           }
           else
           {
        	   request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_item_not_found_message);
        	   request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
           }
			 
		}
		else if(message.matches("PurchaseCustomerOrder"))
		{
			System.out.println("PurchaseCustomerOrder");
			//request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_success_message);
			request.getRequestDispatcher("PurchaseCustomerOrder.jsp").forward(request, response);
		}
		else if(message.matches("Select"))
		{
			System.out.println("Select");
			String custmobileno = request.getParameter(Constants.GetInstance().mobileno);
			if(custmobileno!=null)
			{
				int itemno = Integer.parseInt(request.getParameter(Constants.GetInstance().itemno));
				String strQuantity = request.getParameter(Constants.GetInstance().quantity);
				if(strQuantity!=null && !strQuantity.isEmpty())
				{
					double quantity =Double.parseDouble(strQuantity);
					System.out.println(custmobileno+" "+itemno+" "+quantity);
					Customer customer = Customers.GetInstance().getByMobileNo(custmobileno);
					Item item = Items.GetInstance().getByItemNo(itemno);
					if(customer!=null && item!=null)
					{
						if(Utility.isDouble(strQuantity) && item.getUnit()==Item.ITEM_UNIT.PACKET)
						{
							request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_packet_not_numeric_message);
							request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
						}
						else
						{
							CustomerSelectedItem csi = new CustomerSelectedItem(customer, item, quantity);
							if(csi.add())
							{
								request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_success_message);
								request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
							}
							else
							{
								request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_duplicate_entry_message);
								request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
							}
						}
					}
					else
					{
						request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_message);
						request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
					}
				}
				else
				{
					request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_empty_quantity_message);
					request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_customer_not_found_message);
				request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
			}
		}
		else if(message.matches("Delete"))
		{
			System.out.println("Delete");
			request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_success_message);
			request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
		}
		else
		{
			System.out.println("else");
			request.setAttribute(Constants.GetInstance().servletResult, Constants.GetInstance().server_error_message);
			request.getRequestDispatcher("PlaceCustomerOrder.jsp").forward(request, response);
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
