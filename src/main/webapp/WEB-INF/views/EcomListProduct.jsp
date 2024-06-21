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
	<h1>List of Product</h1>
	
	<%List<ProductBean> products = (List<ProductBean>)request.getAttribute("list");%>
	
	<table border=2>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Action</th>
		</tr>
			<%
				for(ProductBean p:products)
				{
					out.print("<tr>");
					out.print("<td>"+p.getProductId()+"</td>"+"<td>"+p.getProductName()+"</td>"+"<td><a href='deleteproduct?productId="+p.getProductId()+"'>Delete</a></td>");
					out.print("</tr>");
				}
			%>	
	</table>
</body>
</html>