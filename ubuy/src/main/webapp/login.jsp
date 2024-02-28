<%@page import="com.ubuy.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="ubuy.css">
</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/md5.js"></script>
<script>
function validateForm() {
	let mobileno = document.forms["loginForm"]["<%=Constants.GetInstance().mobileno%>"].value;
	var pass = document.forms["loginForm"]["<%=Constants.GetInstance().pass%>"].value;
	if (mobileno == "") {
		alert("<%=Constants.GetInstance().mobileno_required_message%>");
		return false;
	}

	if (pass == "") {
		alert("<%=Constants.GetInstance().password_required_message%>");
		return false;
	} else {
		document.forms["loginForm"]["hide"].value = document.forms["loginForm"]["<%=Constants.GetInstance().pass%>"].value;
		var hash = CryptoJS.MD5(pass);
		//alert(hash);
		document.forms["loginForm"]["<%=Constants.GetInstance().pass%>"].value = hash;
		return true;
	}
}
</script>
<body background="images/indexpage.jpg" align="center">
<br>
<h1 align="left"><%=Constants.GetInstance().company_name%></h1>
<h1 align="center"><%=Constants.GetInstance().login_caption_title%></h1>
<h3>${servletResult}</h3>
</br>
<form name="loginForm" action="LoginServlet" method = "POST" onsubmit="return validateForm()">
<table style="with: 80%" align="center">
   <tr><td><%=Constants.GetInstance().login_caption_enter_mobileno%></td></tr> 
   <tr><td><input type="tel" name="<%=Constants.GetInstance().mobileno%>" pattern="[0-9]{10}" placeholder="<%=Constants.GetInstance().admin_mobileno%>"></td></tr> 
   <tr><td><%=Constants.GetInstance().signup_caption_password%></td></tr>
   <tr><td><input type="password" name="<%=Constants.GetInstance().pass%>"><input type="hidden" name="hide"/></td></tr>
</table>
<h4><%=Constants.GetInstance().login_caption_know_password%></h4>
<input type="submit" value="<%=Constants.GetInstance().login_caption_loginbtn%>">
</form>
</body>
</html>