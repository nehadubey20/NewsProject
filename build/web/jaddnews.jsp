<%@page import="dto.JournalistDTO"%>
<%@page import="dao.JournalistDAO"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Journalist profile</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>
          <div class="topnav" >
	  <a href="jprofile.jsp">Home</a>
	  <a href="jviewprofile.jsp">View Profile</a>
	  <a class="active" href="jaddnews.jsp">Add News</a>
	  <a href="jviewstatus.jsp">View Status</a>
	  <a href="jlogout.jsp">Logout</a>
          </div>
                <%
        String username=(String)session.getAttribute("username");
        if(username==null || username.trim().equals(""))
        {
            response.sendRedirect("journalist.html");
        }
        %>
		<!-- Banner -->
			<section id="banner">
				<!--<div class="inner split">-->
					<section>
						<h2>Here you can add your news!</h2>
					</section>
                                <br/>
					<section>	
              <%
              JournalistDAO journalistDAO=new JournalistDAO();
              JournalistDTO journalistDTO=journalistDAO.getSpecificUserData(username);
              %>                 
                   <!-- Form -->
                   <div>
                   <form action="JournalistAddNews" method="post">
                   <table class="table-wrapper">
                        <tr>
                <td><B>Username:</B></td>
                <td><B><%=journalistDTO.getUsername()%></b>
                    <INPUT TYPE="hidden" name="empid" value="<%=journalistDTO.getUsername()%>" />
                </td>
            </tr>
                       <tr>
                       
                    <td><B>Category:</B></td>
                    <td>
                        <select name="category">
                <option value="Select">---SELECT---</option>            
                <option value="National">National</option>
                <option value="Sports">Sports</option>
                <option value="Fashion">Fashion</option>
                <option value="International">International</option>
                  </select>
                 </td>
                </tr>
                       <tr >
                    <td><B>Post Name:</B></td>
                    <td>
                    <INPUT TYPE="text" name="postname" />
                    </td>
                </tr>
                 <tr>
                <td><B>Description:</B></td>
                <td><B><input type="text" name="description" /></B></td>
            </tr>
            <tr>
                <td><B>Location:</B></td>
                <td><B><input type="text" name="location" /></B></td>
            </tr>
            <tr>
                <td><B>Key Word:</B></td>
                <td><B><input type="text" name="keyword" /></B></td>
            </tr>
            <tr>
                <td><B>Pic an image:</B></td>
                <td><B><input type="file" name="image" accept="image/*"/></B></td>
            </tr>
            
            <tr>
                <td class="actions">
                <input type="submit" value="Submit" />
                </td>
                <td class="actions">
                <input type="reset" value="Reset" />
                </td>
            
            </tr>
            </table>
            </form>
            </div>     
            </section>
            
            </section>
        </body>
</html>
                 
