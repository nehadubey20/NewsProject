package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.JAddNewsDTO;
import dao.JournalistAddNewsDAO;

public final class jviewstatus_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Journalist profile</title>\n");
      out.write("\t\t<meta charset=\"utf-8\" />\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("          <div class=\"topnav\" >\n");
      out.write("\t  <a href=\"index.html\">Home</a>\n");
      out.write("\t  <a class=\"active\" href=\"jviewprofile.jsp\">View Profile</a>\n");
      out.write("\t  <a href=\"jaddnews.jsp\">Add News</a>\n");
      out.write("\t  <a href=\"jviewstatus.jsp\">View Status</a>\n");
      out.write("\t  <a href=\"jlogout.jsp\">Logout</a>\n");
      out.write("          </div>\n");
      out.write("                ");

        //String username=(String)session.getAttribute("username");
        
                    String postname=(String)session.getAttribute("postname");
        if(postname==null || postname.trim().equals(""))
        {
            response.sendRedirect("journalist.html");
        }
        
      out.write("\n");
      out.write("        <!-- Banner -->\n");
      out.write("\t\t\t<section id=\"banner\">\n");
      out.write("\t\t\t\t<div class=\"inner split\">\n");
      out.write("\t\t\t\t\t<section>\n");
      out.write("\t\t\t\t\t\t<h2>Here is what you have uploaded yet!!!</h2>\n");
      out.write("\t\t\t\t\t</section>\n");
      out.write("\t\t\t\t\t<section>\n");
      out.write("\t\t\t\t\t\t<br>                         \n");
      out.write("              ");

              JournalistAddNewsDAO jaddnewsDAO=new JournalistAddNewsDAO();
              JAddNewsDTO jaddnewsDTO=jaddnewsDAO.getSpecificUserData(postname);
              
      out.write("                 \n");
      out.write("                   <!-- Form -->\n");
      out.write("                   <div>\n");
      out.write("                   <form action=\"JournalistAddNews\" method=\"post\">\n");
      out.write("                   <table class=\"table-wrapper\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>Category:</B></td>\n");
      out.write("                    <td>\n");
      out.write("                    <INPUT TYPE=\"text\" disabled name=\"category\" value=\"");
      out.print(jaddnewsDTO.getCategory());
      out.write("\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                 <tr>\n");
      out.write("                <td><B>Post Name:</B></td>\n");
      out.write("                <td><B><INPUT TYPE=\"text\" name=\"postname\" value=\"");
      out.print(jaddnewsDTO.getPostname());
      out.write("\" /></B></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><B>Description:</B></td>\n");
      out.write("                <td><B><INPUT TYPE=\"text\" name=\"desc\" value=\"");
      out.print(jaddnewsDTO.getDesc());
      out.write("\" /></B></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><B>Location:</B></td>\n");
      out.write("                <td><B><INPUT TYPE=\"text\" name=\"location\" value=\"");
      out.print(jaddnewsDTO.getLocation());
      out.write("\" /></B></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><B>Key Word:</B></td>\n");
      out.write("                <td><B><INPUT TYPE=\"text\" name=\"keyword\" value=\"");
      out.print(jaddnewsDTO.getKeyword());
      out.write("\" /></B></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td><B>Image Associated:</B></td>\n");
      out.write("                <td><B><INPUT TYPE=\"img\" name=\"image\" value=\"");
      out.print(jaddnewsDTO.getImage());
      out.write("\" /></B></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            </table>\n");
      out.write("            </form>\n");
      out.write("            </div>     \n");
      out.write("            </section>\n");
      out.write("            </div>\n");
      out.write("            </section>\n");
      out.write("        </body>\n");
      out.write("</html>\n");
      out.write("                 \n");
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
