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
/* function sendRequest(var strURL)
{
	var xmlHttpReq = false;
	if (window.XMLHttpRequest) {
	   xmlHttpReq = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
	    xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlHttpReq.open('POST', strURL, true);
	xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	 xmlHttpReq.onreadystatechange = function() {
	    if (xmlHttpReq.readyState == 4) {
	        alert(xmlHttpReq.responseText)
	    }
	}
	xmlHttpReq.send();
	return true;
} */
function load()
{
	<%
	System.out.println("Index page");
	System.out.println("Session on Index page load: "+ request.getSession(false));
	System.out.println("Session attribute on Index page load: "+ request.getSession(false).getAttribute(Constants.GetInstance().mobileno));
	if(request.getSession(false)!=null && request.getSession(false).getAttribute(Constants.GetInstance().mobileno)!=null)
	{
		String mobileno = (String)request.getSession(false).getAttribute(Constants.GetInstance().mobileno);
		Customer cust = Customers.GetInstance().getByMobileNo(mobileno);
		if(cust!=null)
		{
			request.setAttribute(Constants.GetInstance().customer, cust);
			if(cust.getCustType() == Customer.CUSTOMER_TYPE.ADMIN)
			{
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("customer.jsp").forward(request, response);
			}
		}
	}
	else
	{
		System.out.println("Loading Index page");
	}
	%>
}
function login() {
  location.assign("login.jsp");
}
function signup() {
  location.assign("signup.jsp");
}
</script>
<body onload="load()" background="images/indexpage.jpg" align="center">
<br>
<h1 align="left"><%=Constants.GetInstance().company_name%></h1>
<h1 align="center"><%=Constants.GetInstance().ip_title_message%></h1>
</br>
<br><button type="button" class="loginbtn" onclick="login()"><%=Constants.GetInstance().ip_caption_loginbutton%></button></br>
<br><button type="submit" class="signupbtn" onclick="signup()"><%=Constants.GetInstance().ip_caption_signup%></button></br>
<p style="padding:5px 15px"><%=Constants.GetInstance().company_message%></p>
<!-- p style="padding:5px 15px">This example creates a full page background image. Try to resize the browser window to see how it always will cover the full screen (when scrolled to top), and that it scales nicely on all screen sizes.</p -->
</body>
</html>