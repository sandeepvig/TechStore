<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table border="0">
	<tr>
		<td>
			<table border="1" style="border:thin; border-color: #699BFF">
				<tr style="background-color: #699BFF">
					<td>
						<table style="border: 0; border-spacing: 0">
							<tr><td><b>Cart</b>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
						</table>						
					</td>
				</tr>
				<tr>
					<td>
						<table style="border: 0; border-spacing: 0">
							<tr style="background-color: #D2D1D0"><td>Item&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Quantity&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Price&nbsp;&nbsp;&nbsp;&nbsp;</td><td style="background-color: #FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
							<c:set var="counter" value="0" scope="page"></c:set>
							<c:forEach items="${Cart}" var="cartItem">
								<tr>
									<td>${cartItem.product.name}&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td>${cartItem.quantity}&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td>${cartItem.product.price}&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td>
										<form action="removeFromCart" name="frmRemoveFromCart_${counter}" method="post">
											<input type="hidden" name="product_id" value="${cartItem.product.productID}"/>
											<input type="submit" value="Remove" style="font-size: x-small;"/>
										</form>
									</td>
								</tr>
								<c:set var="counter" value="${counter+1}" scope="page"></c:set>
							</c:forEach>
						</table>						
					</td>
				</tr>
			</table>	
		</td>
	</tr>

	<tfoot align="right">
		<tr><td>
			<form action="submitOrder" name="frmCheckout" method="post">
				<input type="submit" value="   Submit Order   ">
			</form>
		</td></tr>
	</tfoot>
	
</table>


