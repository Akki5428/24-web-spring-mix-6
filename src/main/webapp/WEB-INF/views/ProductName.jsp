<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Product Name</h1>
	<form action="deleteproductbyname" method="post">
		Product Name : <input type="text" name="productName"/>  <span style="color:red">${errorName}</span><br><br>
		<input type="submit" value="Enter"/>
	</form>
</body>
</html>