<%@page import="com.ubuy.Customer"%>
<%@page import="com.ubuy.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
function changepwd() {
	location.assign("signup.jsp");
}
function ordergoods() {
 
	location.assign("PlaceCustomerOrder.jsp");
}
function goodsordered() {
	location.assign("ViewCustomerPurchasedOrder.jsp");
}
function validateForm() {
	return true;
}
</script>
<body onload="load()" background="images/indexpage.jpg" align="center">
<br>
<h1 align="left"><%=Constants.GetInstance().company_name%></h1>
<h1 align="center"><%out.println("Hi " + ((Customer)request.getAttribute(Constants.GetInstance().customer)).getCustName());%></h1>
<button type="button" class="profilebtn" onclick="profile()"><%=Constants.GetInstance().customer_caption_profile%></button>
<button type="button" class="changepwdbtn" onclick="changepwd()"><%=Constants.GetInstance().customer_caption_changepwd%></button>
<button type="button" class="ordergoodsbtn" onclick="ordergoods()"><%=Constants.GetInstance().customer_caption_ordergoods%></button>
<button type="button" class="goodsorderedbtn" onclick="goodsordered()"><%=Constants.GetInstance().customer_caption_vieworder%></button></br>
<form action="LogoutServlet" method="get" onsubmit="return validateForm()">
<input type="hidden" name="<%=Constants.GetInstance().mobileno%>" value="<%=((Customer)request.getAttribute(Constants.GetInstance().customer)).getMobileNo()%>" />
<input type="submit" value="<%=Constants.GetInstance().caption_logout%>"/>
</form>
</body>
</html>