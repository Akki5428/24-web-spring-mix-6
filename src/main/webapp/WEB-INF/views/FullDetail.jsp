<%@page import="com.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Product ID : ${pbean.getProductId()}<br><br>
	Product Name : ${pbean.getProductName()}<br><br> 
	Price : ${pbean.getPrice()}<br><br>
	Quantity : ${pbean.getQty()}<br><br>
</body>
</html>