<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="playerdetail" method="post">
		Player Name : <input type="text" name="pname" value="${pnameValue}"/><span style="color:red"> ${pnameError}</span><br><br>
		Player Type : <input type="radio" name="ptype" value="Batsman" ${ptypeValue == "Batsman" ? "Checked" : ''}/>Batsman
					  <input type="radio" name="ptype" value="Bowler" ${ptypeValue == "Bowler" ? "Checked" : ''}/>Bowler
					  <input type="radio" name="ptype" value="All Rounder" ${ptypeValue == "All Rounder" ? "Checked" : ''}/>All Rounder
					  <span style="color:red"> ${ptypeError}</span><br><br>			
		Food Preference : <select name="ftype">
						  <option value="-1" >Select Food Preference</option>
						  <option value="Regular" ${ftypeValue == "Regular" ? "Selected" : ''}>Regular</option>
						  <option value="Jain" ${ftypeValue == "Jain" ? "Selected" : ''}>Jain</option>
						  </select>
						  <span style="color:red"> ${ftypeError}</span><br><br>
		Drink : <input type="checkbox" name="drink" value="RB" ${drinkValue.contains("RB") ? "Checked" : ''}/>RB
				<input type="checkbox" name="drink" value="MD" ${drinkValue.contains("MD") ? "Checked" : ''}/>MD
				<input type="checkbox" name="drink" value="TH" ${drinkValue.contains("TH") ? "Checked" : ''}/>TH
				<input type="checkbox" name="drink" value="LJ" ${drinkValue.contains("LJ") ? "Checked" : ''}/>LJ
				<input type="checkbox" name="drink" value="CO" ${drinkValue.contains("CO") ? "Checked" : ''}/>CO
				<span style="color:red"> ${drinkError}</span>
				<br><br>	
				
		<input type="submit" value="Register"/>
	</form>
	
</body>
</html>