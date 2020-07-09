<%-- 
    Document   : AOYKAddBook
    Created on : 8-Feb-2020, 9:20:06 AM
    Author     : yunice & Abdel
--%>

<jsp:include page="/includes/AOYKBanner.jsp" />
  
<!-- start the middle column -->

<section>
    <h1>List of Members </h1> 
    <form action="AOYKAddMember.jsp" method="get">
        <table>
            <tr>
                <th>Email</th>
                <th>Full Name</th>
                <th>Program</th>
                <th>Year</th>
                <th></th>
                <th></th>
            </tr>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="member" items="${members}">        
            <tr>
                <td>${member.emailAddress}</td>
                <td>${member.fullName}</td>
                <td>${member.programName}</td>
                <td>${member.yearLevel}</td>
                <td><a href="AOYKMemberAdmin?action=editMember&amp;email=${member.emailAddress}">Edit</a></td>
                <td><a href="AOYKMemberAdmin?action=removeMember&amp;email=${member.emailAddress}">Remove</a></td>
            </tr>
    </c:forEach>            
        </table>
        <div style="width: 400px">
            <input type="hidden" name="action" value="addMember">
            &nbsp;<button type="submit">Add Member</button>
        </div>
    </form>
</section>
       
<!-- end the middle column -->

<jsp:include page="/includes/AOYKFooter.jsp" />