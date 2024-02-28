<%@page import="com.ubuy.Customer"%>
<%@page import="com.ubuy.Item"%>
<%@page import="com.ubuy.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="ubuy.css">
</head>
<script>
function load()
{
	
}
function profile() {
	location.assign("profile.jsp");
}
function additems() {
	location.assign("AddItem.jsp");
}
function viewitems() {
	location.assign("ViewItems.jsp");
}
function viewCustomers() {
	location.assign("ViewCustomers.jsp");
}
function managepwd() {
  
}
function viewCustomerOrders() {
  
}

function addDeliveryPerson()
{
	location.assign("signup.jsp?<%=Constants.GetInstance().customertype%>=<%=Constants.GetInstance().delivery_person%>");
}

</script>
<body onload="load()" background="images/indexpage.jpg" align="center">
<br><h1 align="left"><%=Constants.GetInstance().company_name%></h1>
<h1 align="center"><%out.println("Hi " + ((Customer)request.getAttribute(Constants.GetInstance().customer)).getCustName());%></h1>
<button type="button" class="profilebtn" onclick="profile()"><%=Constants.GetInstance().admin_caption_profile%></button>
<button type="button" class="additemsbtn" onclick="additems()"><%=Constants.GetInstance().additem_caption_title%></button>
<button type="button" class="viewitemsbtn" onclick="viewitems()"><%=Constants.GetInstance().admin_caption_viewitems%></button>
<button type="button" class="viewCustomersbtn" onclick="viewCustomers()"><%=Constants.GetInstance().admin_caption_viewcustomers%></button>
<button type="button" class="managepwdbtn" onclick="managepwd()"><%=Constants.GetInstance().admin_caption_managecustomerpwd%></button>
<button type="button" class="viewCustomerOrdersbtn" onclick="viewCustomerOrders()"><%=Constants.GetInstance().admin_caption_viewcustomerorders%></button>
<button type="button" class="addDeliveryPersonbtn" onclick="addDeliveryPerson()"><%=Constants.GetInstance().admin_caption_addDeliveryPerson%></button></br>
<form action="LogoutServlet" method="get">
<input type="hidden" name="mobileno" value="<%=((Customer)request.getAttribute(Constants.GetInstance().customer)).getMobileNo()%>" />
<input type="submit" value="<%=Constants.GetInstance().caption_logout%>"/>
</form>
</body>
</html>