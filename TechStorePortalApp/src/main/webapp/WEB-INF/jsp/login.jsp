<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<form action="login" name="frmLogin" method="post">
		<table border="0" style="margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom: auto">
			<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
			<tr><td></td><td>
				<table border="0" style="margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom: auto">
					<tr><td>UserID</td><td><input name="email" type="text"/></td></tr>
					<tr><td>Password</td><td><input name="password" type="password"/></td></tr>
					<tr><td></td><td><table><tr><td><input type="submit" value="Submit"/></td><td><input type="reset" value="Reset"/></td></tr></table></td></tr>		
					<tr><td>&nbsp;</td><td>&nbsp;</td></tr>		
					<tr><td>&nbsp;</td><td>&nbsp;</td></tr>		
					<tr><td colspan="2" align="center"><a href="signup">Signup</a>&nbsp;</td></tr>		
				</table>
			</td><td></td></tr>
			<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
		</table>
	</form>
</body>

</html>
