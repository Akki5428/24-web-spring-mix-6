<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-6">
			<form action="esignup" method="post" enctype="multipart/form-data">
				<h1>Ecom Signup</h1>
				<div class="form-group">
					Firstname : <input type="text" name="firstName" class="form-control">
				</div>
				<div class="form-group">
					Email : <input type="email" name="email" class="form-control">
				</div>
				<div class="form-group">
					Password : <input type="password" name="password" class="form-control">
				</div>
				<div class="form-group">
				Profilepic : <input type="file" name="profilepic" >
				</div>
	
			<input type="submit" value="Submit" class="btn btn-primary">
		</form>
		</div>
	</div>
	
</body>
</html>