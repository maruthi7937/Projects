<?php
/*MARUTHI KUMAR DONTHI, ST ID #14176105*/
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
    <h3 align="center">Deleting User:</h3>
		<form method="POST" action="del_user.php">
		<table align="center">
		<tr>
			<td>Username:</td><td> <input type="text" name="username"></td>
		</tr>
		<tr>
			<td><input type="submit" name="Delete"></td>
			<td><input type="reset" value="Reset"></td></tr>
		</tr>
        </table>
		</form>
		</div>

  </div>
<div style="margin: 0px auto 0px auto; width: 400px; border: 1px solid Gray">
  <div id="footer"> <p>Copyright 2014 | All Rights Reserved | ALL DATABASE Group  </p>
  </div>

</div>
</body>
</html>
