<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	 <td width="1200" valign="top">
    	<div id="welcome" style="border-right:#666666 1px dotted;"><h1>OPEN NEW ACCOUNT</h1><br>
    	    <table  align="center" bgcolor="white">
		<tr>
			
		</tr>
		<tr>
			<td>
				<form method="post" action="register" >
				  <table cellspacing="5" cellpadding="3">
					
					GENDER: 
					<input type="radio" ng-model="myVar" value="female" name ="gender">FEMALE
					<input type="radio" ng-model="myVar" value="male" name ="gender">MALE				
					<tr><td>NAME:</td><td> <input type="text" name="firstName"/></td></tr>
					<tr><td>SURNAME:</td><td> <input type="text" name="lastName"/></td></tr>
					<tr><td>ID NUMBER:</td><td> <input type="text" name="idNum"/></td></tr>
					<tr><td>EMAIL:</td><td> <input type="text" name="email"/></td></tr>
					<tr><td>PASSWORD:</td><td> <input type="password" name="password"/></td></tr>
					<tr><td>RE-PASSWORD:</td><td> <input type="password" name="repassword"/></td></tr>
					<tr><td>ADDRESS:</td><td> <input type="text" name="address"/></td></tr>
					<tr><td>PHONE:</td><td> <input type="text" name="phone"/></td></tr>					
					<tr><td></td><td><input type="submit" value="Submit"/>
					
					<INPUT TYPE=RESET VALUE="Clear"></td></tr>
					</table>
               		</form>
			</td>
		</tr>
	
	</table>
    	   </div>      
    </td>


</body>
</html>