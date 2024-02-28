<%@page import="com.ubuy.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
   <head>
      <title>Profile</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" type="text/css" href="ubuy.css">
</head>
<body background="images/indexpage.jpg" align="center">
   <br>
	<h1 align="left"><%=Constants.GetInstance().company_name%></h1>
	<h1 align="center"><%=Constants.GetInstance().customer_caption_profile%></h1>
	</br>
      <center>
         <!-- table width = "70%" border = "1" align = "center" -->
         <table width = "90%">
            <!--  tr bgcolor = "#949494">
               <th>Header Name</th>
               <th>Header Value(s)</th>
            </tr -->
            <%
	            if(session.getAttribute(Constants.GetInstance().mobileno)==null)
	        	{
	        		response.sendRedirect("login.jsp"); 
	        	} 
               
               Customer cust = Customers.GetInstance().getByMobileNo((String)session.getAttribute(Constants.GetInstance().mobileno));
               if(cust!=null)
               {
	            out.print("<tr><td>" + "Name" + "</td>\n");
	            out.println("<td> " + cust.getCustName() + "</td></tr>\n");
	            
	            out.print("<tr><td>" + "Mobile No" + "</td>\n");
	            out.println("<td> " + cust.getMobileNo() + "</td></tr>\n");
	            
	            out.print("<tr><td>" + "Email" + "</td>\n");
	            out.println("<td> " + cust.getEmailid() + "</td></tr>\n");
	            
	            out.print("<tr><td>" + "Male or Female" + "</td>\n");
	            out.println("<td> " + cust.getMaleFemale().toString() + "</td></tr>\n");
	            	            
	            out.print("<tr><td>" + "Address" + "</td>\n");
	            String address = cust.getStreetName()+" "+cust.getColonyName()+" "+cust.getCity()+" "+cust.getState()+" "+cust.getCountry();
	            out.println("<td> " + address + "</td></tr>\n");
	            
	            out.print("<tr><td>" + "Pin" + "</td>\n");
	            out.println("<td> " + cust.getPin() + "</td></tr>\n");
	            
	            out.print("<tr><td>" + "Customer Type" + "</td>\n");
	            if(cust.getCustType() == Customer.CUSTOMER_TYPE.ADMIN)
	            {
	            	out.println("<td> " + "Adminstrator" + "</td></tr>\n");
	            }
	            else if(cust.getCustType() == Customer.CUSTOMER_TYPE.PURCHASER)
	            {
	            	out.println("<td> " + "Purchaser" + "</td></tr>\n");
	            }
	            else if(cust.getCustType() == Customer.CUSTOMER_TYPE.GOODS_DELIVERY_PERSON)
	            {
	            	out.println("<td> " + "Delivery Person" + "</td></tr>\n");
	            }
               }
            %>
         </table>
</center>
   </body>
</html>