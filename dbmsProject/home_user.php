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
      		   

		   <li class='last'><a href='home_user.php'>Home</a>
		   </li>	
		   <li class='last'><a href='query_user.php'>QUERY</a>
		
		   </li>
		   <li class='last'><a href='reset_user.php'>Password Reset</a>
		   </li>
				
		   <li class='last'><a href='logout.php'>Logout</a>
		   </li>
   		</ul>
	</div>

	<div id="content"> 
	    <div id="insidecontent"> <br>
      		<h1>Acute Lymphoblastic Leukemia (ALL) Database</h1>
		<br />
		<p style="font-family:Arial;font-weight:normal;color:#000000;"><font size="3"><b>Current Data in Database</b></font></p>
		<p style="font-family:Arial;font-weight:normal;color:#000000;"><font size="3">RNA-Seq analysis for 16 ALL samples at Diagnosis conducted on 1/1/2014</font></p>
	<br /><br />
		<p style="font-family:Arial;font-weight:normal;color:#000000;"><font size="3"><b>Future Plans</b></font></p>
		<p style="font-family:Times;font-weight:normal;color:#000000;"><font size="3">
		<ul>
			
			<li>Integrate normal sample data RNA-Seq data</li>
			<li>Integrate MIRA-Seq data</li>
			<li>Integrate additional RNA-Seq data analysis</li>
			
		</ul>
		</font>
	
		</p>
		
		<p style="font-family:Arial;font-weight:normal;color:#000000;"><font size="3"><b>Known Issues</b></font></p>
		<p style="font-family:Arial;font-weight:normal;color:#000000;"><font size="3">If an issue arises that is not listed here, please contact Nathan T. Johnson at <a href="ntjxv7@mail.missouri.edu">ntjxv7@mail.missouri.edu</a></font></p>
		

				  
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
