<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table>
	<tr>
		<td><c:choose><c:when test="${CurrentUser!=null}"><a href="logout">Logout</a></c:when><c:otherwise><a href="login">Login</a></c:otherwise></c:choose>&nbsp;&nbsp;</td>
		<td><a href="cart">Cart</a>&nbsp;&nbsp;</td>
		<td><a href="orders">Orders</a>&nbsp;&nbsp;</td>
	</tr>
</table>
