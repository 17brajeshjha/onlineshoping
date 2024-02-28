<%@page import="com.ubuy.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
   <head>
      <title>View Customers</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" type="text/css" href="ubuy.css">
</head>
<script type="text/javascript">
function load()
{
	
}
</script>
<body onload="load()" background="images/indexpage.jpg" align="center">
    <form action="ViewCustomerServlet" method="get" onsubmit="">
    <h1 align="left"><%=Constants.GetInstance().company_name%></h1>
    <h1 align="center"><%=Constants.GetInstance().viewcustomer_caption_title%></h1>
    <a>Search by mobile no:</a><input type="tel" name="<%=Constants.GetInstance().mobileno%>" placeholder="<%=Constants.GetInstance().admin_mobileno%>">
	<a>Search by name:</a><input type="text" name="<%=Constants.GetInstance().name%>">
	<input type="submit" value="<%=Constants.GetInstance().viewcustomer_caption_search%>"/>
	</form>
      <center>
         <!-- table width = "70%" border = "1" align = "center" -->
         <table class="tb">
            <tr style=background-color:red;color:white;>
               <th><%=Constants.GetInstance().viewcustomer_caption_name%></th>
               <th><%=Constants.GetInstance().viewcustomer_caption_mobileno%></th>
               <th><%=Constants.GetInstance().viewcustomer_caption_email%></th>
               <th><%=Constants.GetInstance().viewcustomer_caption_malefemale%></th>
               <th><%=Constants.GetInstance().viewcustomer_caption_type%></th>
               <th><%=Constants.GetInstance().viewcustomer_caption_address%></th>
            </tr>
            <%
	            if(session.getAttribute(Constants.GetInstance().mobileno)==null)
	        	{
	        		response.sendRedirect("login.jsp"); 
	        	}
            
               String mobileno = request.getParameter(Constants.GetInstance().mobileno);
               String name = request.getParameter(Constants.GetInstance().name);
               List<Customer> custList = ((name==null || name.isEmpty()) &&( mobileno==null || mobileno.isEmpty()))?
            		   Customers.GetInstance().getAll():
               ((name==null || name.isEmpty())&&( mobileno!=null && !mobileno.isEmpty()))?
            	   Customers.GetInstance().getByLikeMobileNo(mobileno):
            		   ((mobileno==null || mobileno.isEmpty())&&( name!=null && !name.isEmpty()))?
            				   Customers.GetInstance().getByLikeName(name):
            					   Customers.GetInstance().getByLikeNameAndMobile(name,mobileno);
               if(custList!=null)
               {
            	   for(int i=0; i<custList.size();i++)
            	   {
            		    Customer cust = custList.get(i);
			            out.print("<tr><td>" + cust.getCustName() + "</td>\n");
			            out.println("<td> " + cust.getMobileNo() + "</td>\n");
			            out.println("<td> " + cust.getEmailid() + "</td>\n");
			            out.println("<td> " + cust.getMaleFemale().toString() + "</td>\n");
			            out.println("<td> " + cust.getCustType().toString() + "</td>\n");
			            String address = cust.getStreetName()+" "+cust.getColonyName()+" "+cust.getCity()+" "+cust.getState()+" "+cust.getPin()+", "+cust.getCountry();
			            out.println("<td> " +address + "</td></tr>\n");
            	   }
               } 	
            %>
         </table>
</center>
</body>
</html>