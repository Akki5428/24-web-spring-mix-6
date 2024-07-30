<%@page import="com.bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>MyCart</h2>


 

	<%
	List<ProductBean> products = (List<ProductBean>) request.getAttribute("products");
	Float price = 0.0f;
	%>

	<table border="1">
		<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Image</th>
			<th>Price</th>
			<th>Qty</th>
			<th>Action</th>
		</tr>
		<%
		for (ProductBean p : products) {
			out.print("<tr>");
			out.print("<td>" + p.getProductId() + "</td><td>" + p.getProductName() + "</td>");
			out.print("<td><img height='100px' width='100px' src='"+p.getImagepath()+"'/></td>");
			out.print("<td>"+p.getPrice()+"</td>");
			out.print("<td>"+p.getCqty()+"</td>");
			out.print("<td><a href='removecartitem?cartId="+p.getCartId()+"&qty="+p.getCqty()+"'>Remove</a></td>");
			
			out.print("</tr>");

			price = price + p.getPrice() * p.getCqty(); 
		}
		%>
		
	</table>
	
		<Br> 
		
		Total Price <%=price %>
		<%session.setAttribute("price", price); %>
	 
	 	<br><Br>
	 	<a href="checkout">Checkout</a>
</body>
</html>