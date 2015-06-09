<?php
    header('Expires: Sun, 01 Jan 2014 00:00:00 GMT');
    header('Cache-Control: no-store, no-cache, must-revalidate');
    header('Cache-Control: post-check=0, pre-check=0', FALSE);
    header('Pragma: no-cache');
    
    require_once ("secure.inc");
    session_start();
    unset($_SESSION['logged_in']);
    session_destroy();

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
   <li class='active'><a href='index.html'>Home</a></li>
 
</ul>
</div>
 
 <div id="content"> 

    <div id="insidecontent"> <br>
      <h1>Acute Lymphoblastic Leukemia (ALL) Database</h1>
	  <br><br>
	  <h3 align="center">User successfully logged out</h3>
	  <div>
</div>	  
    </div>
	

		
	<div id="sidebar"> 
	
	
	
	</div>
    

    <div style="clear: both;"></div>

  </div>



  <div id="footer"> <p>Copyright 2014 | All Rights Reserved | ALL DATABASE Group  </p>
  </div>

</div>
</body>
</html>
