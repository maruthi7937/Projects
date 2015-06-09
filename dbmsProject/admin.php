	`<?php
	session_start();
?>
<html>
<head>
<title>ALL DATABASE</title>

<link rel="stylesheet" type="text/css" href="css.css" media="screen" />
</head>
<body>
	<?php
		echo "WELCOME ".$_SESSION['welcome'];
	?>
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
    <h1 align="left">Admin Page:</h3><br /><br />


    <table>
    <tr><td>
    1) <a href="registration.php">Register new user</a>
	</td></tr>
    <tr><td>
    2) <a href="delete.php">Delete existing user</a>
    </td></tr>
    <tr><td>
    3) <a href="view_users.php">View all users</a>
    </td></tr>
    </table>	
        	  
		
    
    </div>

  </div>



  <div id="footer"> <p>Copyright 2014 | All Rights Reserved | ALL DATABASE Group  </p>
  </div>
	
</body>
</html>