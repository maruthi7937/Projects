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
		   <li class='last'><a href='logout.php'>Logout</a>
		   </li>
		   <li class='last'><a href='reset_user.php'>Password Reset</a>
		   </li>
   
</ul>
</div>

  <div id="content"> 

    <div id="insidecontent"> <br>
      <h1>Acute Lymphoblastic Leukemia (ALL) Database</h1>
	  <br /><br />
		<h1 align="center">Query Page:</h3><br /><br />


		
		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query01_user.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>1. All <select name="category01"> 
			<option value="gene">Gene</option>
			<option value="tss">Tss</option>
			<option value="isoform">Isoform</option>
			</select> for <select name="category011">
			<option value="all">all</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
				
			</select> patients</b>
			<br />

			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />



		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query02_user.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>2. Select all genes for <select name="category02">
			<option value="all">all</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>	
			</select> expressing > <input type="text" style="width:30px;" name="name2">
			expression for <select name="category021">
			<option value="all">all</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
			</select> patients</b>
			<br />

			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />




		
		<table style = "border: 1px solid black;" align="center">
	
		<form method="POST" action="query09_user.php">
		
		<tr valign="middle">
			<td style="width:550px;" >
			<b>9. Select the top <input type="text" style="width:30px;" name="percentage9">% expression of <select name="category9">
			<option value="gene_fpkm">Gene</option>
			<option value="tss_fpkm">Tss</option>
			<option value="isoform_fpkm">Isoform</option>
			</select> ids for given samples</b>
		
		
		
			<br />
			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>		
		<br /><br />

		
		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query10_user.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>10. Select the <select name="category10">
			<option value="gene_fpkm">Gene</option>
			<option value="tss_fpkm">Tss</option>
			<option value="isoform_fpkm">Isoform</option>
			</select> and expression median ?</b>
			
			<br />
		
			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />


		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query11_user.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>11. Expression of <select name="category11"> 
			<option value="gene_fpkm">Gene</option>
			<option value="tss_fpkm">Tss</option>
			<option value="isoform_fpkm">Isoform</option>
			</select> on a chromosome value of <input type="text" style="width:30px;" name="value11"></b>
		
			<br />

		
			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />

		
		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query14_user.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>14. What sample are available ? </b>
			<br />
			<p align="center">
				<input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />


		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query15_user.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>15. What is the percentage of masked reads ? </b>
			<br />
			<p align="center">
				<input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />



		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query16_user.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>16. What is the percentage of reads trimmed ? </b>
			<br />
		
			<p align="center">
				<input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />


		
		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query17_user.php">
		
		<tr valign="middle">
			<td style="width:550px;"><b>17. What is the percentage of reads with adapter contamination ? </b>
		
			<br />
			<p align="center">
				<input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />
	


		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query18_user.php">
		
		<tr valign="middle">
			<td style="width:550px;"><b>18. Which genes <select name="category18">
			<option value="were">were</option>
			<option value="werenot">were not</option>
			</select> spliced ?</b>
			<br />		
					
			<p align="center">
				<input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>	
		</table>
		<br /><br />


		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query19_user.php">
		
		<tr valign="middle">
			<td style="width:550px;"><b>19. Which genes <select name="category19">
			<option value="do">do</option>
			<option value="donot">do not</option>
			</select> have a promoter ?</b>
			<br />		
			
			<p align="center">
				<input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />



		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query20_user.php">
		
		<tr valign="middle">
			<td style="width:550px;"><b>20. Which genes have isoforms ? </b>
			<br />
		
			<p align="center">
				<input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />



		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query21_user.php">
		
		<tr valign="middle">
			<td style="width:550px;"><b>21. How many genes expressed in total across all samples ? </b>
			<br />

			<p align="center">
				<input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />


		

		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query_results_user.php">
		
		<tr valign="middle">
			<td style="width:550px;"><b>Please enter MySQL query manually here</b>
			<br />	
			<textarea rows="5" cols="70" name="query1"></textarea>
			<br />
			<p align="center">
				<input type="submit" name="submit">
			</td>	
		</tr>
			
		</form>
		</table>
		
		</form>
		<br /><br />

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

