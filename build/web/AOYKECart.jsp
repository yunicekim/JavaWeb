<%-- 
    Document   : AOYKECart.jsp
    Created on : 13-Mar-2020, 2:44:25 PM
    Author     : Abdel & Yunice
--%>

<jsp:include page="/includes/AOYKBanner.jsp" />

<!-- start the middle column -->

<section>
    <div style="width: 350px; text-align: center;"><h4>Your Loan Cart</h4></div>
    <table>
        <tr>
            <th style="width: 50px;">Code</th>
            <th style="width: 250px;">Description</th>
            <th style="width: 50px;">Quantity</th>
        </tr>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="total" scope="page" value="0"/>  

<c:forEach var="item" items="${sessionScope.cart.items}">        
        <tr>
            <td>${item.code}</td>
            <td>${item.description}</td>
            <td style="text-align: right;">${item.quantity}</td>
        </tr>
<c:set var="total" value="${total +  item.quantity}"/>  
</c:forEach>    
        <tr><td colspan="3"></td></tr>
        <tr><td colspan="2" style="text-align: right;">Total:</td><td style="text-align: right;"><c:out value="${total}"/>  </td></tr>
    </table>
<br/>
<h3><a href="AOYKClearCart">Clear the cart</a></h3>
<h3><a href="AOYKLoan">Return to eLoan</a></h3>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/AOYKFooter.jsp" />