<%-- 
    Document   : AOYKRegister
    Created on : 31-Jan-2020, 3:40:29 PM
    Author     : Abdel & Yunice
--%>

<jsp:include page="/includes/AOYKBanner.jsp" />

<!-- start the middle column -->
  
<section>
    <h1>New Member Registration Form </h1>
    <form action="AOYKDisplayMemeber.jsp" method="post">
        <label>Full Name:</label><input type="text" style="width: 200px" name="fullName" required><br>
        <label>Email</label><input type="text" style="width: 300px" name="email" required><br>
        <label>Phone:</label><input type="text" style="width: 100px" name="phone"><br>
        <label>IT Program:</label>
            <select name="dropProgram">
                <option value="CAS">CAS</option>
                <option value="SQAT">SQATE</option>
                <option value="CPA">CPA</option>
                <option value="CP">CP</option>
                <option value="ITID">ITID</option>
                <option value="CAD">CAD</option>
                <option value="ITSS">ITSS</option>
            </select><br>
        <label>Year Level</label>
            <select name="dropYearLevel">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select><br>
        <div style="text-align: center; width: 400px">
            <button type="submit">Register Now</button>
            <button type="reset">Reset</button>
        </div>
    </form>
</section>
       
<!-- end the middle column -->

<jsp:include page="/includes/AOYKFooter.jsp" />



