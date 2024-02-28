<%@page import="com.ubuy.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
   <head>
      <title>View Items</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" type="text/css" href="ubuy.css">
	</head>
	<body background="images/indexpage.jpg" align="center">
   <br>
	<h1 align="left"><%=Constants.GetInstance().company_name%></h1>
	<h1 align="center"><%=Constants.GetInstance().viewitems_caption_title%></h1>
	</br>
      <center>
         <!-- table width = "70%" border = "1" align = "center" -->
         <table class="tb">
            <tr style=background-color:red;color:white;>
               <th><%=Constants.GetInstance().viewitems_caption_name%></th>
               <th><%=Constants.GetInstance().viewitems_caption_rate%></th>
               <th><%=Constants.GetInstance().viewitems_caption_unit%></th>
            </tr>
         
            <%
	            if(session.getAttribute(Constants.GetInstance().mobileno)==null)
	        	{
	        		response.sendRedirect("login.jsp"); 
	        	} 
            	
               List<Item> itemList = Items.GetInstance().getAll();
               if(itemList!=null)
               {
            	   for(int i=0; i<itemList.size();i++)
            	   {
            		    Item item = itemList.get(i);
			            out.print("<tr><td>" + item.getItemName() + "</td>\n");
			            out.println("<td> " + item.getRate() + "</td>\n");
			            out.println("<td> " + item.getUnit() + "</td></tr>\n");
            	   }
               }	
            %>
         </table>
</center>
   </body>
</html>