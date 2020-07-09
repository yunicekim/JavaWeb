<%-- 
    Document   : AOYKDisplayBooks
    Created on : 8-Feb-2020, 9:20:06 AM
    Author     : yunice & Abdel
--%>

<jsp:include page="/includes/AOYKBanner.jsp" />
  
<!-- start the middle column -->

<section>
    <h1>Add a Book</h1> 
    <p><i>${message}</i></p>
    <form method="post">
        <label>Code: </label><input type="text" style="width: 100px" name="code" id="code" value="${book.code}"><br>
        <label>Description: </label><input type="text" style="width: 300px" name="description" id="description" value="${book.description}"><br>
        <label>Quantity: </label><input type="text" style="width: 50px" name="quantity" id="quantity" value="${book.quantity}"><br>

        <div style="text-align: center; width: 360px">
            <input type="hidden" name="action" value="save">
            <button type="submit" formaction="/AOYKClub/AOYKAddBook">Save</button>
            <input type="hidden" name="action" value="cancel">
            <button type="submit" formaction="/AOYKClub/AOYKDisplayBooks">Cancel</button>
        </div>
    </form>
</section>
       
<!-- end the middle column -->

<jsp:include page="/includes/AOYKFooter.jsp" />