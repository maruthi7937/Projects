<?php
    	
	session_cache_limiter('private,must-revalidate');
	session_start();

	$uname=$_POST["uname"];
	$password=$_POST["password"];
  
	
	require_once("secure.inc");

	$pwd_md5 = md5($password);

	$dblink = mysql_connect(HOSTNAME,USERNAME,PASSWORD) or die("connect failed");
	
	mysql_select_db(DBNAME) or die("Error: cannot select db");

	$query ="select * from users where username='$uname' and password='$pwd_md5'";
	
	
	

	$result = mysql_query($query) or die("Problem with table name");
	
	
	$check = mysql_num_rows($result);


	if ($check>=1)
	{
	    
	    if($uname=="" && $password=="")
	    {
		header("Location: login_invalid.html");
	        die();
	    }
	    else
	    {	
			if ($uname=="admin")
                    {
                        $_SESSION['logged_in'] = $uname;
						header("Location: home.php");
                    }
                    else
                    {
                       $_SESSION['logged_in'] = $uname;
						header("Location: home_user.php");
                    }
	        die();
	    }
	    
	}
	else
	{
	  
	    header("Location: login_invalid.html");
	    die();	
	    
	}
	
?>
