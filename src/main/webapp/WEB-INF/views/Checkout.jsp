<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Float price = (Float)session.getAttribute("price");%>
	<h2>Pay</h2>

	Final Amount : <%=price %>
	<br> CreditCard :
	<input type="text" name="creditCardNum" />
	<br>
	<br> ExpiredDate :
	<input type="text" name="expiredDate" />
	<br>
	<Br> Cvv:
	<input type="text" name="cvv" />
	<br>
	<Br>
	<input type="submit" value="Pay" />
</body>
</html>