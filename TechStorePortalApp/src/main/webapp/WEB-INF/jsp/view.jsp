<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body style="font-family: Calibri; size: 10">

	<c:choose>
		<c:when test="${CurrentUser!=null && (Action=='Orders' || Action=='SubmitOrder')}">
			<table align="center">
				<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td><c:import url="header.jsp"></c:import></td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td><c:import url="orders.jsp"></c:import></td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
			</table>
		</c:when>
		<c:when test="${CurrentUser!=null}">
			<table align="center">
				<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td><c:import url="header.jsp"></c:import></td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td><c:import url="cart.jsp"></c:import></td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td><c:import url="products.jsp"></c:import></td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
			</table>
		</c:when>
		<c:otherwise>
			<c:import url="login.jsp"/>
		</c:otherwise>
	</c:choose>


</body>

</html>
