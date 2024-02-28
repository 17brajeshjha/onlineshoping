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
function validateForm() {	   
	var country = document.forms["PurchaseCustomerOrderForm"]["<%=Constants.GetInstance().country%>"].value;
	var state = document.forms["PurchaseCustomerOrderForm"]["<%=Constants.GetInstance().state%>"].value;
	var city = document.forms["PurchaseCustomerOrderForm"]["<%=Constants.GetInstance().city%>"].value;
	var colonyname = document.forms["PurchaseCustomerOrderForm"]["<%=Constants.GetInstance().colonyname%>"].value;
	var streetname = document.forms["PurchaseCustomerOrderForm"]["<%=Constants.GetInstance().streetname%>"].value;
	var pin = document.forms["PurchaseCustomerOrderForm"]["<%=Constants.GetInstance().pin%>"].value;
	var phone = document.forms["PurchaseCustomerOrderForm"]["<%=Constants.GetInstance().phone%>"].value;
	
	//alert(country+" "+state+" "+city+" "+colonyname+" "+streetname+" "+pin);
	
	if (country == "") {
		alert("<%=Constants.GetInstance().purchase_customerorder_country_required_message%>");
		return false;
	}
	if (state == "") {
		alert("<%=Constants.GetInstance().purchase_customerorder_state_required_message%>");
		return false;
	}

	if (city == "") {
		alert("<%=Constants.GetInstance().purchase_customerorder_city_required_message%>");
		return false;
	}
	
	if (colonyname == "") {
		alert("<%=Constants.GetInstance().purchase_customerorder_colonyname_required_message%>");
		return false;
	} 
	else if(streetname == "")
	{
		alert("<%=Constants.GetInstance().purchase_customerorder_streetname_required_message%>");
		return false;
	}
	else if(pin == "")
	{
		alert("<%=Constants.GetInstance().purchase_customerorder_pin_required_message%>");
		return false;
	}
	else if(phone == "")
	{
		alert("<%=Constants.GetInstance().purchase_customerorder_phone_required_message%>");
		return false;
	}
	else {
		
		return true;
	}
}
</script>
<body background="images/indexpage.jpg" align="center">
   <h1 align="left"><%=Constants.GetInstance().company_name%></h1>
    <h1 align="center"><%=Constants.GetInstance().placecustomerorder_caption_title%></h1>
	<h3>${servletResult}</h3>
      <center>
         <!-- table width = "70%" border = "1" align = "center" -->
         <%
            if(session.getAttribute(Constants.GetInstance().mobileno)==null)
        	{
        		response.sendRedirect("login.jsp"); 
        	}  
         %>
	</center>   
	<form name="PurchaseCustomerOrderForm" action="PurchaseCustomerOrderServlet" method = "POST" onsubmit="return validateForm()">
	<table style="with: 80%" align="center">
    
   <tr><td><h2><%=Constants.GetInstance().purchase_customerorder_caption_destinationAddress%></h2></td></tr>
   <tr>
   <td>*<%=Constants.GetInstance().signup_caption_country%></td>
   <td>
   <select name="<%=Constants.GetInstance().country%>" id="<%=Constants.GetInstance().country%>" style="background-color: #F7EEEB;
  border: solid;
  color: gray;
  padding: 10px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 12px;">
	  <option value="<%=Constants.GetInstance().india%>"><%=Constants.GetInstance().signup_caption_india%></option>
	  <option value="<%=Constants.GetInstance().nepal%>"><%=Constants.GetInstance().signup_caption_nepal%></option>
	  <option value="<%=Constants.GetInstance().srilanka%>"><%=Constants.GetInstance().signup_caption_srilanka%></option>
	  <option value="<%=Constants.GetInstance().bangladesh%>"><%=Constants.GetInstance().signup_caption_bangladesh%></option>
	</select>
	</td>
   </tr>
   <tr><td>*<%=Constants.GetInstance().signup_caption_state%></td><td><input type="text" name="<%=Constants.GetInstance().state%>"></td></tr>
   <tr><td>*<%=Constants.GetInstance().signup_caption_city%></td><td><input type="text" name="<%=Constants.GetInstance().city%>"></td></tr>
   <tr><td>*<%=Constants.GetInstance().signup_caption_colony%></td><td><input type="text" name="<%=Constants.GetInstance().colonyname%>"></td></tr>
   <tr><td>*<%=Constants.GetInstance().signup_caption_street%></td><td><input type="text" name="<%=Constants.GetInstance().streetname%>"></td></tr>
   <tr><td>*<%=Constants.GetInstance().signup_caption_pincode%></td><td><input type="text" name="<%=Constants.GetInstance().pin%>" pattern="[0-9]{6}" placeholder="110042"></td></tr>
   <tr><td><%=Constants.GetInstance().signup_caption_mobileno%></td><td><input type="tel" name="<%=Constants.GetInstance().phone%>" pattern="[0-9]{10}" placeholder="<%=Constants.GetInstance().admin_mobileno%>"></td></tr>
</table>
<input type="submit" value="<%=Constants.GetInstance().placecustomerorder_caption_title%>">
</form>
</body>
</html>