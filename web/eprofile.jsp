<!DOCTYPE HTML>
<!--
	Prism by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Journalist profile</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>
          <div class="topnav" >
	  <a href="eprofile.jsp">Home</a>
	  <a href="jviewprofile.jsp">View Profile</a>
	  <a href="jaddnews.jsp">----</a>
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
        <!--<a href="home1.jsp" style="font-size: 20px;color: black">Update Profile</a>-->

    
		<!-- Banner -->
			<section id="banner">
				<div class="inner split">
					<section>
						<h2>Welcome to News Report, a free platform for sharing,viewing and adding news...</h2>
					</section>
					<section>
						<h2>Hello <%=username%>!...</h2>
                                                <br>
                                                <ul class="actions">
							<li><a href="#" class="button special">Edit profile</a></li>
						</ul>
					</section>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper">
				<div class="inner split">
					<section>
						<h2>Magna feugiat adipiscing</h2>
						<p>Lorem ipsum nisl sed cursus magna et amet veroeros. Sed phasellus aliquam et tempus lorem feugiat adipiscing lorem. Morbi pharetra vitae felis placerat pharetra. Nulla risus orci, dapibus id malesuada et nec, malesuada quis orci. Pellentesque eget consequat.</p>
						<ul class="actions">
							<li><a href="#" class="button alt">Learn more</a></li>
						</ul>
					</section>
					<section>
						<ul class="checklist">
							<li>Ipsum nisl sed cursus magna</li>
							<li>Amet veroeros sed aliquam consequat</li>
							<li>Tempus lorem adipiscing et lorem</li>
							<li>Morbi pharetra vitae felis placerat</li>
							<li>Pharetra nulla risus orci dapibus</li>
						</ul>
					</section>
				</div>
			</section>

	</body>
</html>