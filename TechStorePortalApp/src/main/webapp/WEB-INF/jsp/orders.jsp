<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="0" title="Orders">
	<thead><tr><td><b>Orders</b></td></tr></thead>
	<tr><td>
		<c:forEach items="${Orders}" var="order">
			<table border="1" style="border:thin; border-color: #699BFF">
				<tr>
					<td>
						<table style="border: 0; border-spacing: 0" title="Order-${order.orderID}">
							<tr style="background-color: #699BFF"><td>Order-${order.orderID}&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${order.orderDate}&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Currency&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${order.status}&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
						</table>						
					</td>
				</tr>

				<tr>
					<!-- <td>&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
					<td>
						<table style="border: 0" title="Order-${order.orderID}">
							<tr style="background-color: #D2D1D0"><td>Item&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Quantity&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Price Per Unit&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Net Price&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
							<c:forEach items="${order.orderItems}" var="orderItem">
								<tr><td>${orderItem.product.name}&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${orderItem.quantity}&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${orderItem.pricePerItem}&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${orderItem.quantity*orderItem.pricePerItem}&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				
			</table>
			<br><br>
		</c:forEach>	
	</td></tr>

</table>
