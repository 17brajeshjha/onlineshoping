<%@page import="com.ubuy.Customer.CUSTOMER_TYPE"%>
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
	let uname = document.forms["signupForm"]["<%=Constants.GetInstance().uname%>"].value;
	let mobileno = document.forms["signupForm"]["<%=Constants.GetInstance().mobileno%>"].value;
	let malefemale = document.forms["signupForm"]["<%=Constants.GetInstance().malefemale%>"].value;
	var pass = document.forms["signupForm"]["<%=Constants.GetInstance().pass%>"].value;
	var pass_confirm = document.forms["signupForm"]["pass_confirm"].value;
	var hide = document.forms["signupForm"]["hide"].value;
	var ctypeChecked = document
			.querySelector('input[name="customertype"]:checked');
	if (uname == "") {
		alert("<%=Constants.GetInstance().name_required_message%>");
		return false;
	}
	if (mobileno == "") {
		alert("<%=Constants.GetInstance().mobileno_required_message%>");
		return false;
	}

	if (malefemale == "") {
		alert("<%=Constants.GetInstance().malefemale_required_message%>");
		return false;
	}
	
	if (pass == "") {
		alert("<%=Constants.GetInstance().password_required_message%>");
		return false;
	} 
	else if(pass_confirm == "")
	{
		alert("<%=Constants.GetInstance().confirm_password_required_message%>");
		return false;
	}
	else if(pass_confirm != pass)
	{
		alert("<%=Constants.GetInstance().confirm_password_wrong_message%>");
		return false;
	}
	else {
		document.forms["signupForm"]["hide"].value = document.forms["signupForm"]["<%=Constants.GetInstance().pass%>"].value;
		var hash = CryptoJS.MD5(pass);
		//alert(hash);
		document.forms["signupForm"]["<%=Constants.GetInstance().pass%>"].value = hash;
		return true;
	}
}
</script>
<body background="images/indexpage.jpg" align="center">
<br>
<h1 align="left">UBUY</h1>

<%
if(session.getAttribute(Constants.GetInstance().mobileno)==null)
{%>
<h1 align="center"><%=Constants.GetInstance().signup_caption_title%></h1>
<%
}
else
{
	String customertype = request.getParameter(Constants.GetInstance().customertype);
	if(customertype!=null && customertype.matches(Constants.GetInstance().delivery_person))
	{
		%>
		<h1 align="center"><%=Constants.GetInstance().signup_caption_title_goods_delivery_person%></h1>
		<%
	}
}
%>
<h3>${servletResult}</h3>
</br>
<form name="signupForm" action="SignupServlet" method = "POST" onsubmit="return validateForm()">
<table style="with: 80%" align="center">
   <tr><td><%=Constants.GetInstance().signup_caption_name%></td><td><input type="text" name="<%=Constants.GetInstance().uname%>"></td></tr> 
   <tr><td><%=Constants.GetInstance().signup_caption_mobileno%></td><td><input type="tel" name="<%=Constants.GetInstance().mobileno%>" pattern="[0-9]{10}" placeholder="<%=Constants.GetInstance().admin_mobileno%>"></td></tr> 
   <tr><td><%=Constants.GetInstance().signup_caption_password%></td><td><input type="password" name="<%=Constants.GetInstance().pass%>"><input type="hidden" name="hide" /></td></tr>
   <tr><td><%=Constants.GetInstance().signup_caption_confirm_password%></td><td><input type="password" name="pass_confirm"><input type="hidden" name="hide" /></td></tr>
   
<%
if(session.getAttribute(Constants.GetInstance().mobileno)==null)
{
%>
<tr><td><input type="hidden" name="<%=Constants.GetInstance().customertype%>" value="<%=Constants.GetInstance().purchaser%>" /></td></tr>
<%	
}
else
{
	Customer cust = Customers.GetInstance().getByMobileNo((String)session.getAttribute(Constants.GetInstance().mobileno));
    if(cust==null || (cust!=null && cust.getCustType() != Customer.CUSTOMER_TYPE.ADMIN))
    {
    	request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
	<tr><td><input type="hidden" name="<%=Constants.GetInstance().customertype%>" value="<%=request.getParameter(Constants.GetInstance().customertype)%>" /></td></tr>
<%
}
%>   
   <tr><td><%=Constants.GetInstance().signup_caption_email%></td><td><input type="<%=Constants.GetInstance().email%>" id="<%=Constants.GetInstance().email%>" name="<%=Constants.GetInstance().email%>" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"></td></tr> 
   <tr>
   <td><%=Constants.GetInstance().signup_caption_malefemale%></td>
   <td>
   <%=Constants.GetInstance().signup_caption_male%><input type="radio" name="<%=Constants.GetInstance().malefemale%>" value="<%=Constants.GetInstance().male%>">
   <%=Constants.GetInstance().signup_caption_female%><input type="radio" name="<%=Constants.GetInstance().malefemale%>" value="<%=Constants.GetInstance().female%>">
   </td>
   </tr>
   <tr><td><%=Constants.GetInstance().signup_caption_address%></td></tr>
   <tr>
   <td><%=Constants.GetInstance().signup_caption_country%></td>
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
   <tr><td><%=Constants.GetInstance().signup_caption_state%></td><td><input type="text" name="<%=Constants.GetInstance().state%>"></td></tr>
   <tr><td><%=Constants.GetInstance().signup_caption_city%></td><td><input type="text" name="<%=Constants.GetInstance().city%>"></td></tr>
   <tr><td><%=Constants.GetInstance().signup_caption_colony%></td><td><input type="text" name="<%=Constants.GetInstance().colonyname%>"></td></tr>
   <tr><td><%=Constants.GetInstance().signup_caption_street%></td><td><input type="text" name="<%=Constants.GetInstance().streetname%>"></td></tr>
   <tr><td><%=Constants.GetInstance().signup_caption_pincode%></td><td><input type="text" name="<%=Constants.GetInstance().pin%>" pattern="[0-9]{6}" placeholder="110042"></td></tr>
</table>
<input type="submit" value="<%=Constants.GetInstance().signup_caption_submit_button%>">
</form>
</body>
</html>