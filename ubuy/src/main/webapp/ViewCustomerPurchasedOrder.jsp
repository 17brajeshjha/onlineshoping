<%@page import="com.ubuy.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
   <head>
      <title>Purchase customer order</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" type="text/css" href="ubuy.css">
</head>
<script type="text/javascript">
</script>
<body background="images/indexpage.jpg" align="center">
   <h1 align="left"><%=Constants.GetInstance().company_name%></h1>
    <!-- h1 align="center"><%=Constants.GetInstance().purchase_customerorder_caption_title%></h1 -->
	<h3>${servletResult}</h3>
      <center>
         <!-- table width = "70%" border = "1" align = "center" -->
         <%
            if(session.getAttribute(Constants.GetInstance().mobileno)==null)
        	{
        		response.sendRedirect("login.jsp"); 
        	}  
         	String mobileno = (String)request.getSession(false).getAttribute(Constants.GetInstance().mobileno);
         	if(mobileno!=null)
         	{
         		Customer cust = Customers.GetInstance().getByMobileNo(mobileno);
         		if(cust!=null)
         		{
         			%><h1 align="center">Hi <%=cust.getCustName()%> your placed orders</h1>
         			<table class="tb">
		            <tr style=background-color:red;color:white;>
		               <th><%=Constants.GetInstance().purchase_customerorder_table_col1%></th>
		               <th><%=Constants.GetInstance().purchase_customerorder_table_col2%></th>
		               <th><%=Constants.GetInstance().purchase_customerorder_table_col3%></th>
		               <th><%=Constants.GetInstance().purchase_customerorder_table_col4%></th>
		            </tr>
         			<%
         			List<Order> orderList = Orders.GetInstance().getByCustomer(cust);
         			int i=0;
         			for(Order order:orderList)
         			{
         				out.println("<tr>");         				
         				List<OrderItem> orderItemList = OrderItems.GetInstance().getByOrder(order);
         				if(i%2==0)
         					out.println("<td style=background-color:cyan;>");
         				else
         					out.println("<td style=background-color:white;>");
         				double totalPrice = 0;
         				for(OrderItem orderItem:orderItemList)
         				{
         					out.println("<h4 style=color:red;>");
         					out.println(orderItem.getItem().getItemName());
         					out.println("</h4>");
         					String itemStr = orderItem.getQuantity()+" "+orderItem.getItem().getUnit().toString()+" Price = "+Constants.GetInstance().currency_name+" "+orderItem.getQuantity()*orderItem.getItem().getRate()+"\n";
         					out.println("<h4>");
         					out.println(itemStr);
         					out.println("</h4>");
         					totalPrice+=orderItem.getQuantity()*orderItem.getItem().getRate();
         				}
         				out.println("<h4 style=color:red;>");
     					out.println("Total Price = "+Constants.GetInstance().currency_name+totalPrice);
     					out.println("</h4>");
         				out.println("</td>");
         				
         				out.println("<td>");
         				out.println(order.getOrderDate().toLocalDate().toString());
         				out.println("</td>");
         				
         				out.println("<td>");
         				out.println(order.getOrderState().toString());
         				out.println("</td>");
         				
         				out.println("<td>");
         				out.println("<h5>");
         				out.println(order.getAddress1());
         				out.println("</h5>");
         				out.println("<h5>");
         				out.println(order.getAddress2());
         				out.println("</h5>");
         				out.println("<h5>");
         				out.println(order.getCity());
         				out.println("</h5>");
         				out.println("<h5>");
         				out.println(order.getState());
         				out.println("</h5>");
         				out.println("<h5>");
         				out.println("Ph:"+order.getPhone());
         				out.println("</h5>");
         				out.println("</td>");
         				
         				out.println("</tr>");
         				i++;
         			}
         			%>
         			</table>
         			<%
         		}
         	}
         %>
	</center>  
</body>
</html>