<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<form action="login" name="frmLogin" method="post">
		<table columns="2" rows="3" border="0" align="center">
			<tr><td>UserID</td><td><input name="userid" type="text"/></td></tr>
			<tr><td>Password</td><td><input name="password" type="password"/></td></tr>
			<tr><td></td><td><table><tr><td><input type="submit" value="Submit"/></td><td><input type="reset" value="Reset"/></td></tr></table></td></tr>		
		</table>
	</form>
</body>

</html>
