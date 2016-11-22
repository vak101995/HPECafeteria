<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order details</title>
</head>
<body>
<h3>Your order will be delivered in 45 minutes</h3>
<h3>Employee Id: <%=request.getAttribute("empId") %></h3>

<h3>Employee Name: <%=request.getAttribute("eName") %></h3>
<h3>Food Item: <%=request.getAttribute("food") %></h3>
<h3>Quantity: <%=request.getAttribute("quantity") %></h3>
<h3>Order number: <%=request.getAttribute("orderNo") %></h3>
<h3>Status: <%=request.getAttribute("status") %></h3>
</body>
</html>