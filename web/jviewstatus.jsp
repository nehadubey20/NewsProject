<%@page import="dto.JAddNewsDTO"%>
<%@page import="dao.JournalistAddNewsDAO"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Journalist view status</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>
          <div class="topnav" >
	  <a href="jprofile.jsp">Home</a>
	  <a href="jviewprofile.jsp">View Profile</a>
	  <a href="jaddnews.jsp">Add News</a>
	  <a class="active" href="jviewstatus.jsp">View Status</a>
	  <a href="jlogout.jsp">Logout</a>
          </div>
                <%
        //String username=(String)session.getAttribute("username");
        
                    
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
						<h2>Here is what you have uploaded yet!!!</h2>
					</section>
					<section>
						<br>                         
              <%
              JournalistAddNewsDAO jaddnewsDAO=new JournalistAddNewsDAO();
              JAddNewsDTO jaddnewsDTO=jaddnewsDAO.getSpecificUserData(username);
              %>                 
                   <!-- Form -->
                   <div>
                   <form action="JournalistAddNews" method="post">
                   <table class="table-wrapper">
                 <tr>
                    <td><B>Username:</B></td>
                    <td>
                    <INPUT TYPE="text" disabled name="username" value="<%=jaddnewsDTO.getUsername()%>" />
                    </td>
                </tr>
                
                
                
                
                <tr>
                    <td><B>Category:</B></td>
                    <td>
                    <INPUT TYPE="text" disabled name="category" value="<%=jaddnewsDTO.getCategory()%>" />
                    </td>
                </tr>
                 <tr>
                <td><B>Post Name:</B></td>
                <td><B><INPUT TYPE="text" name="postname" value="<%=jaddnewsDTO.getPostname()%>" /></B></td>
            </tr>
            <tr>
                <td><B>Description:</B></td>
                <td><B><INPUT TYPE="text" name="desc" value="<%=jaddnewsDTO.getDesc()%>" /></B></td>
            </tr>
            <tr>
                <td><B>Location:</B></td>
                <td><B><INPUT TYPE="text" name="location" value="<%=jaddnewsDTO.getLocation()%>" /></B></td>
            </tr>
            <tr>
                <td><B>Key Word:</B></td>
                <td><B><INPUT TYPE="text" name="keyword" value="<%=jaddnewsDTO.getKeyword()%>" /></B></td>
            </tr>
            
            <tr>
                <td><B>Image Associated:</B></td>
                <td><B><INPUT TYPE="img" name="image" value="<%=jaddnewsDTO.getImage()%>" /></B></td>
            </tr>
            
            </table>
            </form>
            </div>     
            </section>
            </div>
            </section>
        </body>
</html>
                 
