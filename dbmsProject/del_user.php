<?php
	//Cache clearance
	header('Expires: Sun, 01 Jan 2014 00:00:00 GMT');
    	header('Cache-Control: no-store, no-cache, must-revalidate');
   	header('Cache-Control: post-check=0, pre-check=0', FALSE);
   	header('Pragma: no-cache');		

	session_cache_limiter('private,must-revalidate');
	session_start();

	if( isset($_SESSION['logged_in']) )
	{
	
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
	  <br /><br />
		<?php
	
	$username = $_POST['username'];
	require_once("secure.inc");
	$con = mysqli_connect(HOSTNAME, USERNAME, PASSWORD, DBNAME) or die("connect failed");			                
							if($stmt = mysqli_prepare($con, "DELETE FROM users where username=?")){
							 mysqli_stmt_bind_param($stmt, "s", $username);
							mysqli_stmt_execute($stmt);
							echo "<br /><br /><h2 align='center'>User ".$username." deleted successfully</h2>";
							}else{
							echo "error:\n";
							echo $mysqli->errno."\n";
							echo $mysqli->error."\n";
								}						       		
				  		       mysqli_close($con);
		
	
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
<?php
}
	//If session not maintained, redirect him to the index.php
	else
	{
		header("Location: index.html");
	}
?>











