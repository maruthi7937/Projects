
<?php
	
	session_cache_limiter('private,must-revalidate');
	session_start();

	if(isset($_SESSION['logged_in']));
	
?>
	<html>
	<head>
		<title>ALL DATABASE</title>
	
		<link rel="stylesheet" type="text/css" href="css.css" media="screen" />
	</head>
	<body>
	<div id="container"> 
	<div id="header">
	  <div class="headtitle">ALL DATABASE</div>
	</div>

	 <div id='cssmenu'>
		<ul>
      		   

		   <li class='last'><a href='home.php'>Home</a>
		   </li>	
		   <li class='last'><a href='query.php'>QUERY</a>
		
		   </li>
		   <li class='last'><a href='admin.php'>ADMIN</a>
		   </li>
		   <li class='last'><a href='logout.php'>Logout</a>
		   </li>
		   <li class='last'><a href='reset.php'>Password Reset</a>
		   </li>
			</li>
		   <li class='email'><a href='email.php'>email</a>
		   </li>		   
   		</ul>
	</div>

	<div id="content"> 
	    <div id="insidecontent"> <br>
      		<h1>Acute Lymphoblastic Leukemia (ALL) Database</h1>
		  <br><br>
		  <?php
		$to = "maruti7937@gmail.com";
		$subject = "Hi!";
		$body = "Hi,\n\nHow are you?";
		if (mail($to, $subject, $body)) {
		echo("<p>Email successfully sent!</p>");
		} else {
		echo("<p>Email delivery failed…</p>");
		}
		?>
	    <div>     
	</div>
	</div>
    <div style="clear: both;"></div>

  </div>



  <div id="footer"> <p>Copyright 2014 | All Rights Reserved | ALL DATABASE Group  </p>
  </div>
	
</body>
</html>


































 