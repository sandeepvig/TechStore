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
							<tr><td><b>Products</b>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
						</table>						
					</td>
				</tr>
				<tr>
					<td>
						<table style="border: 0; border-spacing: 0">
							<tr style="background-color: #D2D1D0"><td>Item&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Price&nbsp;&nbsp;&nbsp;&nbsp;</td><td style="background-color: #FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
							<c:set var="counter" value="0" scope="page"></c:set>
							<c:forEach items="${Products}" var="product">
								
								<tr>
									<td>${product.name}&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td>${product.price} (${product.ccy})&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td>
										<form action="addToCart" name="frmAddToCart_${counter}" method="post">
											<input type="hidden" name="product_id" value="${product.productID}"/>
											<input type="submit" value="Add To Cart" style="font-size: x-small;"/>
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
</table>		


