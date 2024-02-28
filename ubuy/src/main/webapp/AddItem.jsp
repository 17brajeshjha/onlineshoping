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
function validateForm() {
	let itemname = document.forms["AddItemsForm"]["<%=Constants.GetInstance().itemname%>"].value;
	let rate = document.forms["AddItemsForm"]["<%=Constants.GetInstance().rate%>"].value;
	let unit = document.forms["AddItemsForm"]["<%=Constants.GetInstance().unit%>"].value;
	
	if (itemname == "") {
		alert("<%=Constants.GetInstance().additem_itemname_required_msg%>");
		return false;
	}
	if (rate == "") {
		alert("<%=Constants.GetInstance().additem_rate_required_msg%>");
		return false;
	}

	<%-- if (!(rate === ""+parseInt(rate, 10)) && unit == "<%=Constants.GetInstance().packet%>")
	{
		alert("<%=Constants.GetInstance().additem_packet_msg%>") ;
		return false;	
	} --%>
	return true;
}
function viewItems() {
	location.assign("ViewItems.jsp");
}
</script>
<body background="images/indexpage.jpg" align="center">
<%
    if(session.getAttribute(Constants.GetInstance().mobileno)==null)
	{
		response.sendRedirect("login.jsp"); 
	}
%>
<br>
<h1 align="left"><%=Constants.GetInstance().company_name%></h1>
<h1 align="center"><%=Constants.GetInstance().additem_caption_title%></h1>
<h3>${servletResult}</h3>
</br>
<form name="AddItemsForm" action="AddItemServlet" method = "POST" onsubmit="return validateForm()">
<table style="with: 80%" align="center">
   <tr><td><%=Constants.GetInstance().additem_caption_itemname%></td><td><input type="text" name="<%=Constants.GetInstance().itemname%>"></td></tr>  
   <tr>
   <td><%=Constants.GetInstance().additem_caption_unit%></td>
   <td>
   <select name="<%=Constants.GetInstance().unit%>" id="<%=Constants.GetInstance().unit%>" style="background-color: #F7EEEB;
  border: solid;
  color: gray;
  padding: 10px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 12px;">
	  <option value="<%=Constants.GetInstance().packet%>">Packet</option>
	  <option value="<%=Constants.GetInstance().kg%>">Kg</option>
	  <option value="<%=Constants.GetInstance().litters%>">Litter</option>
	</select>
	</td>
   </tr>
   <tr><td><%=Constants.GetInstance().additem_caption_rate%></td><td><input type="number" min="0.1" name="<%=Constants.GetInstance().rate%>" step=".01" placeholder="0.0" ></td></tr>
</table>
<input type="submit" value="<%=Constants.GetInstance().additem_caption_save%>">
<input type="button" class="vieitembtn" onclick="viewItems()" value="<%=Constants.GetInstance().additem_caption_viewitems%>">
</form>
</body>
</html>