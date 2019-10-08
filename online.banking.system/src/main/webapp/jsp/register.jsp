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
				<form method="post" action="Register" >
				  <table cellspacing="5" cellpadding="3">	
					
					GENDER: 
					<input type="radio" ng-model="myVar" value="female">FEMALE
					<input type="radio" ng-model="myVar" value="male">MALE				
					<tr><td>NAME:</td><td> <input type="text" name="name" placeholder="Name(s)"/></td></tr>
					<tr><td>SURNAME:</td><td> <input type="text" name="surname" placeholder="Surname"/></td></tr>
					<tr><td>ID NUMBER:</td><td> <input type="text" name="idNum" placeholder="ID Number"/></td></tr>
					<tr><td>EMAIL:</td><td> <input type="text" name="email" placeholder="Email"/></td></tr>
					<tr><td>PASSWORD:</td><td> <input type="password" name="password" placeholder="Password"/></td></tr>
					<tr><td>RE-PASSWORD:</td><td> <input type="password" name="repassword" placeholder="Password"/></td></tr>
					<tr><td>ADDRESS:</td><td> <input type="text" name="address" placeholder="Address"/></td></tr>
					<tr><td>PHONE:</td><td> <input type="text" name="phone" placeholder="Phone"/></td></tr>
					<tr><td>AMOUNT:</td><td> <input type="text" name="amount" placeholder="Ammount"/></td></tr>
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