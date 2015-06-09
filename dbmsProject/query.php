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
		   <?php
			
					
		   		echo "<li class='last'><a href='admin.php'>ADMIN</a>";
	   	        	echo "</li>";
			
		  ?>
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
		<h1 align="center">Query Page:</h3><br /><br />


		
		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query01.php">
		
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
		<form method="POST" action="query02.php">
		
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
		<form method="POST" action="query03.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>3. Select expression for gene <input type="text" style="width:30px;" name="name3"> 
			for
			<select name="category03">
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
			</select>. (Enter single or list of gene symbols to test for expression)

			<br />

			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />




		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query04.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>4. Within <input type="text" style="width:30px;" name="name41"> distance of the location: chromosome 
			<select name="category41">
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
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option>
			<option value="22">22</option>
			</select>, start <input type="text" style="width:30px;" name="name42">, end <input type="text" style="width:30px;" name="name43">
			what 
			<select name="category42">
			<option value="gene">gene</option>
			<option value="isoform">isoform</option></select> expressing > <input type="text" style="width:30px;" name="name43">
			for particular sample <select name="category41">
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
			</sample>



			<br />

			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />




		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query05.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>5. What is the expression of the isoforms of gene <input type="text" style="width:30px;" name="name5"> 
			for
			<select name="category05">
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
			</select>. 

			<br />

			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />


		

		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query06.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>6. What <select name="category06"> 
			<option value="gene">Gene</option>
			<option value="tss">Tss</option>
			<option value="isoform">Isoform</option>
			</select> expressed for a particular sample <select name="category061">
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
				
			</select> but NOT in the rest</b>
			<br />

			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />



	
		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query08.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>8. Within <input type="text" style="width:30px;" name="name8"> distance of multiple locations
			<input type="text" style="width:30px;" name="name81"> what 
			<select name="category08"> 
			<option value="gene">Gene</option>
			<option value="isoform">Isoform</option>
			</select> expressing > <input type="text" style="width:30px;" name="name82">
			for particular sample <select name="category081">
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
				
			</select>
			<br />

			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />



		
		
		<table style = "border: 1px solid black;" align="center">
	
		<form method="POST" action="query09.php">
		
		<tr valign="middle">
			<td style="width:550px;" >
			<b>9. Select the top <input type="text" style="width:30px;" name="percentage9">% expression of <select name="category9">
			<option value="gene_fpkm">Gene</option>
			<option value="tss_fpkm">Tss</option>
			<option value="isoform_fpkm">Isoform</option>
			</select>
		
		
		
			<br />
			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>		
		<br /><br />

		
		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query10.php">
		
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
		<form method="POST" action="query11.php">
		
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
		<form method="POST" action="query12.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>12. Count number of gene expressed on particular chromosome for <select name="category12">
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
				
			</select> sample
			</b>
			
			<br />
		
			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />



		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query13.php">
		
		<tr valign="middle">
			<td style="width:550px;">
			<b>13. Total number of genes NOT expressed in <select name="category13">
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
				
			</select> patient.
			</b>
			
			<br />
		
			<p align="center"><input type="submit" name="submit"></p>
			</td>
		</tr>
		</form>
		</table>
		<br /><br />


		
		<table style = "border: 1px solid black;" align="center">
		<form method="POST" action="query14.php">
		
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
		<form method="POST" action="query15.php">
		
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
		<form method="POST" action="query16.php">
		
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
		<form method="POST" action="query17.php">
		
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
		<form method="POST" action="query18.php">
		
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
		<form method="POST" action="query19.php">
		
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
		<form method="POST" action="query20.php">
		
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
		<form method="POST" action="query21.php">
		
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
		<form method="POST" action="query_results.php">
		
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

