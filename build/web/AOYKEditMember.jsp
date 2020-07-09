<%-- 
    Document   : AOYKEditMember.jsp
    Created on : 31-Jan-2020, 3:40:29 PM
    Author     : Abdel & Yunice
--%>

<jsp:include page="/includes/AOYKBanner.jsp" />

<!-- start the middle column -->
  
<section>
    <h1>Edit an Existing Member</h1>
    <p><i>${errors}</i></p>
    <form method="post">
        <label>Email</label><input type="text" style="width: 300px; background-color: lightgray" name="email"  value="${member.emailAddress}" readonly><br>
        <label>Full Name:</label><input type="text" style="width: 200px" name="fullName" value="${member.fullName}"><br>
        <label>Phone:</label><input type="text" style="width: 100px" name="phone" value="${member.phoneNumber}"><br>
        <label>IT Program:</label>
            <select name="dropProgram">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:if test = "${member.programName.equals('CAS')}">
                <option value="CAS" selected>CAS</option>
            </c:if>
            <c:if test = "${!member.programName.equals('CAS')}">
                <option value="CAS">CAS</option>
            </c:if>
            <c:if test = "${member.programName.equals('SQATE')}">
                <option value="SQATE" selected>SQATE</option>
            </c:if>
            <c:if test = "${!member.programName.equals('SQATE')}">
                <option value="SQATE">SQATE</option>
            </c:if>
            <c:if test = "${member.programName.equals('CPA')}">
                <option value="CPA" selected>CPA</option>
            </c:if>
            <c:if test = "${!member.programName.equals('CPA')}">
                <option value="CPA">CPA</option>
            </c:if>
            <c:if test = "${member.programName.equals('CP')}">
                <option value="CP" selected>CP</option>
            </c:if>
            <c:if test = "${!member.programName.equals('CP')}">
                <option value="CP">CP</option>
            </c:if>
            <c:if test = "${member.programName.equals('ITID')}">
                <option value="ITID" selected>ITID</option>
            </c:if>
            <c:if test = "${!member.programName.equals('ITID')}">
                <option value="ITID">ITID</option>
            </c:if>
            <c:if test = "${member.programName.equals('CAD')}">
                <option value="CAD" selected>CAD</option>
            </c:if>
            <c:if test = "${!member.programName.equals('CAD')}">
                <option value="CAD">CAD</option>
            </c:if>
            <c:if test = "${member.programName.equals('ITSS')}">
                <option value="ITSS" selected>ITSS</option>
            </c:if>
            <c:if test = "${!member.programName.equals('ITSS')}">
                <option value="ITSS">ITSS</option>
            </c:if>
            </select><br>
        <label>Year Level</label>
            <select name="dropYearLevel">
            <c:if test = "${member.yearLevel == 1}">
                <option value="1" selected>1</option>
            </c:if>
            <c:if test = "${member.yearLevel != 1}">
                <option value="1">1</option>
            </c:if>
            <c:if test = "${member.yearLevel == 2}">
                <option value="2" selected>2</option>
            </c:if>
            <c:if test = "${member.yearLevel != 2}">
                <option value="2">2</option>
            </c:if>
            <c:if test = "${member.yearLevel == 3}">
                <option value="3" selected>3</option>
            </c:if>
            <c:if test = "${member.yearLevel != 3}">
                <option value="3">3</option>
            </c:if>
            <c:if test = "${member.yearLevel == 4}">
                <option value="4" selected>4</option>
            </c:if>
            <c:if test = "${member.yearLevel != 4}">
                <option value="4">4</option>
            </c:if>
            </select><br>
        <div style="text-align: center; width: 150px">
            <input type="hidden" name="action" value="saveMember">
            <button type="submit" formaction="/AOYKClub/AOYKMemberAdmin">Save</button>
            <button type="reset">Reset</button>
        </div>
    </form>
</section>
       
<!-- end the middle column -->

<jsp:include page="/includes/AOYKFooter.jsp" />



