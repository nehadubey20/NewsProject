package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.JournalistDTO;
import dao.JournalistDAO;

public final class jaddnews_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<title>Journalist add news</title>\n");
      out.write("\t\t<meta charset=\"utf-8\" />\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("          <div class=\"topnav\" >\n");
      out.write("\t  <a href=\"jprofile.jsp\">Home</a>\n");
      out.write("\t  <a href=\"jviewprofile.jsp\">View Profile</a>\n");
      out.write("\t  <a class=\"active\" href=\"jaddnews.jsp\">Add News</a>\n");
      out.write("\t  <a href=\"jviewstatus.jsp\">View Status</a>\n");
      out.write("\t  <a href=\"jlogout.jsp\">Logout</a>\n");
      out.write("          </div>\n");
      out.write("                ");

        String username=(String)session.getAttribute("username");
        if(username==null || username.trim().equals(""))
        {
            response.sendRedirect("journalist.html");
        }
        
      out.write("\n");
      out.write("\t\t<!-- Banner -->\n");
      out.write("\t\t\t<section id=\"banner\">\n");
      out.write("\t\t\t\t<!--<div class=\"inner split\">-->\n");
      out.write("\t\t\t\t\t<section>\n");
      out.write("\t\t\t\t\t\t<h2>Here you can add your news!</h2>\n");
      out.write("\t\t\t\t\t</section>\n");
      out.write("                                <br/>\n");
      out.write("\t\t\t\t\t<section>\t\n");
      out.write("              ");

              JournalistDAO journalistDAO=new JournalistDAO();
              JournalistDTO journalistDTO=journalistDAO.getSpecificUserData(username);
              
      out.write("                 \n");
      out.write("                   <!-- Form -->\n");
      out.write("                   <div>\n");
      out.write("                   <form action=\"JournalistAddNews\" method=\"post\">\n");
      out.write("                   <table class=\"table-wrapper\">\n");
      out.write("                        <tr>\n");
      out.write("                <td><B>Username:</B></td>\n");
      out.write("                <td><B>");
      out.print(journalistDTO.getUsername());
      out.write("</b>\n");
      out.write("                    <INPUT TYPE=\"hidden\" name=\"username\" value=\"");
      out.print(journalistDTO.getUsername());
      out.write("\" />\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("                       <tr>\n");
      out.write("                       \n");
      out.write("                    <td><B>Category:</B></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"category\">\n");
      out.write("                <option value=\"Select\">---SELECT---</option>            \n");
      out.write("                <option value=\"National\">National</option>\n");
      out.write("                <option value=\"Sports\">Sports</option>\n");
      out.write("                <option value=\"Fashion\">Fashion</option>\n");
      out.write("                <option value=\"International\">International</option>\n");
      out.write("                  </select>\n");
      out.write("                 </td>\n");
      out.write("                </tr>\n");
      out.write("                       <tr >\n");
      out.write("                    <td><B>Post Name:</B></td>\n");
      out.write("                    <td>\n");
      out.write("                    <INPUT TYPE=\"text\" name=\"postname\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                 <tr>\n");
      out.write("                <td><B>Description:</B></td>\n");
      out.write("                <td><B><input type=\"text\" name=\"description\" /></B></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><B>Location:</B></td>\n");
      out.write("                <td><B><input type=\"text\" name=\"location\" /></B></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><B>Key Word:</B></td>\n");
      out.write("                <td><B><input type=\"text\" name=\"keyword\" /></B></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><B>Pic an image:</B></td>\n");
      out.write("                <td><B><input type=\"file\" name=\"image\" accept=\"image/*\"/></B></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td class=\"actions\">\n");
      out.write("                <input type=\"submit\" value=\"Submit\" />\n");
      out.write("                </td>\n");
      out.write("                <td class=\"actions\">\n");
      out.write("                <input type=\"reset\" value=\"Reset\" />\n");
      out.write("                </td>\n");
      out.write("            \n");
      out.write("            </tr>\n");
      out.write("            </table>\n");
      out.write("            </form>\n");
      out.write("            </div>     \n");
      out.write("            </section>\n");
      out.write("            \n");
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
