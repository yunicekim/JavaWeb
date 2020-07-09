<%-- 
    Document   : AOYKELoan.jsp
    Created on : 13-Mar-2020, 2:39:57 PM
    Author     : Abdel & Yunice
--%>

<jsp:include page="/includes/AOYKBanner.jsp" />

<!-- start the middle column -->

<section>
    <table>
        <tr>
            <th style="width: 50px;">Code</th>
            <th style="width: 230px;">Description</th>
            <th style="width: 50px; text-align: right;">QOH</th>
            <th style="width: 50px;">Action</th>
        </tr>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="item" items="${applicationScope.loanitems}">        
        <tr>
            <td>${item.code}</td>
            <td>${item.description}</td>
            <td style="text-align: right;">${item.quantity}</td>
    <c:if test="${item.quantity > 0}">
            <td><a href="AOYKCart?action=reserve&code=${item.code}">Reserve</a></td>
    </c:if>
    <c:if test="${item.quantity == 0}">
            <td style="text-align: right;">N/A</td>
    </c:if>     
        </tr>
</c:forEach>            
    </table>

</section>

<!-- end the middle column -->

<jsp:include page="/includes/AOYKFooter.jsp" />
