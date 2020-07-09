<%-- 
    Document   : AOYKError
    Created on : 17-Feb-2020, 5:04:39 PM
    Author     : yunice & Abdel
--%>

<jsp:include page="/includes/AOYKBanner.jsp" />

<!-- start the middle column -->
<section>
    <h1>Java Error</h1>
    <p>Sorry, Java has thrown an exception.</p>
    <p>To continue, click the Back button.</p>

    <h2>Details</h2>
    <p>Type: ${pageContext.exception["class"]}</p>
    <p>Message: ${pageContext.exception.message}</p>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/AOYKFooter.jsp" />
