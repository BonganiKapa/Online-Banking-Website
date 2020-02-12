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
				<form action="ClientServlet" method="post" >
				  <table cellspacing="5" cellpadding="3">
					
					GENDER: 
					<input type="radio" ng-model="myVar" value="female" name ="gender">FEMALE
					<input type="radio" ng-model="myVar" value="male" name ="gender">MALE				
					NAME: <input type="text" name="firstName" required = "required"/>
					SURNAME: <input type="text" name="lastName" required = "required"/>
					ID NUMBER: <input type="text" name="idNum" required = "required"/>
					EMAIL: <input type="text" name="email" required = "required"/>
					ADDRESS: <input type="text" name="address" required = "required"/>
					PHONE: <input type="text" name="phone"/ required = "required">
					PASSWORD: <input type="password" name="password" required = "required"/>
					RE-PASSWORD: <input type="password" name="repassword"/></td></tr>
										
					<input type="submit" value="REGISTER"/>
					
					<input TYPE=RESET  VALUE="Clear"></td></tr>
					</table>
               		</form>
			</td>
		</tr>
	
	</table>
    	   </div>      
    </td>


</body>
</html>