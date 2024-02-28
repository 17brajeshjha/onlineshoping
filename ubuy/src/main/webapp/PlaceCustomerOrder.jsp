<%@page import="com.ubuy.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
   <head>
      <title>Place customer order</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" type="text/css" href="ubuy.css">
</head>
<script type="text/javascript">
</script>
<body background="images/indexpage.jpg" align="center">
   <h1 align="left"><%=Constants.GetInstance().company_name%></h1>
    <h1 align="center"><%=Constants.GetInstance().placecustomerorder_caption_title%></h1>
    <form action="PlaceCustomerOrderServlet" method="get">
    <input type=hidden name=PlaceCustomerOrderMsg value=Search>
	<h2>Search item by name:</h2><input type="text" name="<%=Constants.GetInstance().itemname%>">
	<input type="submit" value="<%=Constants.GetInstance().viewcustomer_caption_search%>"/>
	</form>
	<h3>${servletResult}</h3>
      <center>
         <!-- table width = "70%" border = "1" align = "center" -->
         <%
            if(session.getAttribute(Constants.GetInstance().mobileno)==null)
        	{
        		response.sendRedirect("login.jsp"); 
        	}  
         %>
         ${servletResultListOfItems}
	</center>
</body>
</html>