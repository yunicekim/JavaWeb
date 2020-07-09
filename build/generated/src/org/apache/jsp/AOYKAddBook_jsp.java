package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AOYKAddBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/includes/AOYKBanner.jsp", out, false);
      out.write("\n");
      out.write("  \n");
      out.write("<!-- start the middle column -->\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function Save(){\n");
      out.write("        action = \"AOYKAddBook\";\n");
      out.write("        var formName = document.addBook;\n");
      out.write("        formName.action = action;\n");
      out.write("        formName.method=\"post\";\n");
      out.write("        formName.submit();\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function Cancel(){\n");
      out.write("        action = \"AOYKDisplayBooks\";\n");
      out.write("        var formName = document.addBook;\n");
      out.write("        formName.action = action;\n");
      out.write("        formName.method=\"post\";\n");
      out.write("        formName.submit();\n");
      out.write("    }    \n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<section>\n");
      out.write("    <h1>Add a Book</h1> \n");
      out.write("    <p><i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i></p>\n");
      out.write("    <form name=\"addBook\" method=\"post\">\n");
      out.write("        <label>Code: </label><input type=\"text\" style=\"width: 100px\" name=\"code\" id=\"code\"><br>\n");
      out.write("        <label>Description: </label><input type=\"text\" style=\"width: 300px\" name=\"description\" id=\"description\"><br>\n");
      out.write("        <label>Quantity: </label><input type=\"text\" style=\"width: 50px\" name=\"quantity\" id=\"quantity\"><br>\n");
      out.write("\n");
      out.write("        <div style=\"text-align: center; width: 360px\">\n");
      out.write("            <button type=\"button\" onClick=\"Save();\">Save</button>\n");
      out.write("            <button type=\"button\" onClick=\"Cancel();\">Cancel</button>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("</section>\n");
      out.write("       \n");
      out.write("<!-- end the middle column -->\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/includes/AOYKFooter.jsp", out, false);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
