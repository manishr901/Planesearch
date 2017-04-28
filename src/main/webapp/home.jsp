<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<%  session =request.getSession(false);
 if(session.getAttribute("userName")==null)
{

	 response.sendRedirect("Login.jsp");	
}
%>
<script src="./js/lib/jQuery/jquery.min.js"></script>
<script src="./js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="home.js"></script>
<script src="./js/lib/jQuery/jquery.color-2.1.2.js"></script>
<script src="./js/lib/jQuery/jquery.validate.min.js"></script>
<link rel="stylesheet" href="./css/lib/bootstrap.min.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome ${name }</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">

<!-- Theme CSS -->
<link href="css/grayscale.min.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

	<!-- Navigation -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-main-collapse">
					Menu <i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand page-scroll" href="#page-top"> <i
					class="fa fa-play-circle"></i> <span class="light">Welcome</span>
					${name}
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div
				class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">
					<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a class="page-scroll" href="#about">About You</a></li>
					<li><a class="page-scroll" href="#download">Search FLights</a></li>
					<li><a class="page-scroll" href="#contact">Contact</a></li>
					<li><a class="page-scroll" href="logout?name=${name}">Logout</a>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Intro Header -->
	<header class="intro">
		<div class="intro-body">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<h1 class="brand-heading">Search for Flights</h1>
						<p class="intro-text">
							Faster <br>Because Time is Money
						</p>

						<input style="color: black" id="from" type="text" name="from"
							placeholder="FROM"> <input style="color: black" id="to"
							type="text" name="to" placeholder="TO"> <input id="go"
							style="color: black" type="button" name="button" value="GO!!">
						<table border=1 id="details" align="center">
							<tr>
								<td>Plane NAME</td>
								<td>From</td>
								<td>TO</td>
							</tr>



						</table>



						<!-- <a href="#about" class="btn btn-circle page-scroll">
                      <i class="fa fa-angle-double-down animated"></i>
                        </a> -->
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- About Section -->
	<section id="about" class="container content-section text-center">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<h2>About ${name }</h2>
				<p></p>
				<p>Contact:${contact }</p>
				<p>
				email:${email }	</p>
				<p> city:${city }</p>
	`		<h5>Change password</h5>
		Current	 password<input  style="color: black"  type="password" text="Enter your Current password " placeholder="enter your current password">
		<br>New password	<input style="color: black"  type="password" text="Enter New password" placeholder="enter your new password"><br>
	<input  style="color: black" type="button" value="Change" /><br>
		For Full Details <a href="pdfgenerator"	>Generateapdf</a> With password same as your account password
		
			</div>
		</div>
	</section>

	<!-- Download Section -->
	<section id="download" class="content-section text-center">
		<div class="download-section">
			<div class="container">
				<div class="col-lg-8 col-lg-offset-2">
					<input id="plane_search" type="text" style="color: black"
						name="plane" value="Enter a plane to search" />
					<button id="plane_search_button" type="button" style="color: black">Search
					</button>


					<table id="schedule" align="center" border="1">
						<tr>
							<td>City</td>
							<td>Time</td>
						</tr>

					</table>


				</div>
			</div>
		</div>
	</section>

	<!-- Contact Section -->
	<section id="contact" class="container content-section text-center">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<h2>Contact Start Bootstrap</h2>
				<p>Feel free to email us to provide some feedback on our
					templates, give us suggestions for new templates and themes, or to
					just say hello!</p>
				<p>
					<a href="mailto:manishr901@gmail.com">manishr901@gmail.com</a>
				</p>
				<ul class="list-inline banner-social-buttons">
					<li><a href="https://twitter.com/SBootstrap"
						class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i>
							<span class="network-name">Twitter</span></a></li>
					<li><a
						href="https://github.com/IronSummitMedia/startbootstrap"
						class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i>
							<span class="network-name">Github</span></a></li>
					<li><a href="https://plus.google.com/+Startbootstrap/posts"
						class="btn btn-default btn-lg"><i
							class="fa fa-google-plus fa-fw"></i> <span class="network-name">Google+</span></a>
					</li>
				</ul>
			</div>
		</div>
	</section>

	<!-- Map Section -->
	<div id="map"></div>

	<!-- Footer -->
	<footer>
		<div class="container text-center">
			<p>Copyright &copy; Manish_dev 2017</p>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="vendor/jquery/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
	<!-- <script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script> -->



</body>

</html>
