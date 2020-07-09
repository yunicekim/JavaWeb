<%-- 
    Document   : AOYKAddBook
    Created on : 8-Feb-2020, 9:20:06 AM
    Author     : yunice & Abdel
--%>

<jsp:include page="/includes/AOYKBanner.jsp" />
  
<!-- start the middle column -->

<section>
    <h1>List of Books </h1> 
    <form action="AOYKAddBook.jsp" method="post">
        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Quantity</th>
            </tr>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="book" items="${bookList}">        
            <tr>
                <td>${book.code}</td>
                <td>${book.description}</td>
                <td>${book.quantity}</td>
            </tr>
    </c:forEach>            
        </table>
        <div style="width: 400px">
            &nbsp;<button type="submit">Add Book</button>
        </div>
    </form>
</section>
       
<!-- end the middle column -->

<jsp:include page="/includes/AOYKFooter.jsp" />