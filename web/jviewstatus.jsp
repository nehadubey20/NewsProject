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
        
                    
        String postname=(String)session.getAttribute("postname");
        if(postname==null || postname.trim().equals(""))
        {
            response.sendRedirect("jaddnews.jsp");
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
              JAddNewsDTO jaddnewsDTO=jaddnewsDAO.getSpecificUserData(postname);
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
                -->
                
                <tr>
                    <td><B>Category:</B></td>
                    <td>
                    <%=jaddnewsDTO.getCategory()%>
                    </td>
                </tr>
                 <tr>
                <td><B>Post Name:</B></td>
                <td><%=jaddnewsDTO.getPostname()%>" </td>
            </tr>
            <tr>
                <td><B>Description:</B></td>
                <td><%=jaddnewsDTO.getDesc()%></td>
            </tr>
            <tr>
                <td><B>Location:</B></td>
                <td><%=jaddnewsDTO.getLocation()%></td>
            </tr>
            <tr>
                <td><B>Key Word:</B></td>
                <td><B><%=jaddnewsDTO.getKeyword()%></td>
            </tr>
            
            <tr>
                <td><B>Image Associated:</B></td>
                <td><%=jaddnewsDTO.getImage()%></td>
            </tr>
            
            </table>
            </form> 
            </div>     
            </section>
            </div>
            </section>
        </body>
</html>
                 
