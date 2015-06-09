<?php

	session_start();
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
   
</ul>
</div>

  <div id="content"> 

    <div id="insidecontent"> <br>
      <h1>Acute Lymphoblastic Leukemia (ALL) Database</h1>
	  <br><br>
	  <div>
</div>	  
    </div>
    <div style="clear: both;"></div>
    <h3 align="center">User Regisration:</h3><br /><br />
	<?php
	session_cache_limiter('private,must-revalidate');
	session_start();

	$firstname = $_POST['firstname'];
	$lastname = $_POST['lastname'];
	$email = $_POST['email'];
	$username = $_POST['username'];
	$password = $_POST['password'];

	require_once("secure.inc");

	$pwd_md5 = md5($password);
	
	$con = mysqli_connect(HOSTNAME,USERNAME,PASSWORD,DBNAME);

	if(mysqli_connect_errno())
	{
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

	$sql = "INSERT INTO users(firstname,lastname,email,username,password,admin) VALUES('$firstname','$lastname','$email','$username','$pwd_md5',0)";

	if(!mysqli_query($con,$sql))
	{
		die('Error: ' . mysqli_error($con));
	}
	else
	{
		echo "<h2 align='center'>User ".$firstname." added successfully</h1>";
		
	}
	
	
	mysqli_close($con);
?>
		




		</div>

  </div>
<div style="margin: 0px auto 0px auto; width: 400px; border: 1px solid Gray">
  <div id="footer"> <p>Copyright 2014 | All Rights Reserved | ALL DATABASE Group  </p>
  </div>

</div>
</body>
</html>











