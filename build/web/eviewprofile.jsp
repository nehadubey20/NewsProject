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
	  <a class="active" href="jviewprofile.jsp">View Profile</a>
	  <a href="jaddnews.jsp">Add News</a>
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
				<div class="inner split">
					<section>
						<h2>Welcome to News Report, a free platform for sharing,viewing and adding news...</h2>
					</section>
					<section>
						<h2>Hello <%=username%>!</h2>
                                                <br>                         
              <%
              JournalistDAO journalistDAO=new JournalistDAO();
              JournalistDTO journalistDTO=journalistDAO.getSpecificUserData(username);
              %>                 
                   <!-- Form -->
                   <div>
                   <form action="JournalistUpdate" method="post">
                   <table class="table-wrapper">
                <tr>
                    <td><B>Username:</B></td>
                    <td>
                    <INPUT TYPE="text" disabled name="username" value="<%=journalistDTO.getUsername()%>" />
                    </td>
                </tr>
                 <tr>
                <td><B>Full Name:</B></td>
                <td><B><input type="text" name="fullname" value="<%=journalistDTO.getFullname()%>"/></B></td>
            </tr>
            <tr>
                <td><B>E-mail:</B></td>
                <td><B><input type="text" name="email" value="<%=journalistDTO.getEmail()%>"/></B></td>
            </tr>
            <tr>
                <td><B>Contact No:</B></td>
                <td><B><input type="text" name="phoneno" value="<%=journalistDTO.getPhoneno()%>"/></B></td>
            </tr>
            <tr>
                <td class="actions">
                <input type="submit" value="update profile" />
                </td>
            </tr>
            </table>
            </form>
            </div>     
            </section>
            </div>
            </section>
        </body>
</html>
                 
