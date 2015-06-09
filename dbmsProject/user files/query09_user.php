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
		<link rel="stylesheet" type="text/css" href="css1.css" media="screen" />
	</head>
	<body>
		<div id="container"> 
			<div id="header">
  				<div class="headtitle">ALL DATABASE</div>
			</div>
			<div id='cssmenu'>
				<ul>
				   <li class='last'><a href='home_user.php'>Home</a></li>	
				   <li class='last'><a href='query_user.php'>QUERY</a></li>
				   <li class='last'><a href='logout.php'>Logout</a></li>
				   <li class='last'><a href='reset_user.php'>Password Reset</a></li>
   				</ul>
			</div>
		</div>
			<div id="content"> 
			    <div id="insidecontent"> <br>
				    <h1>Acute Lymphoblastic Leukemia (ALL) Database</h1>
				    <br><br>
			            <div>  </div>	  
			   </div>
			   <div style="clear: both;"></div>
		           <h1 align="center">Query Results</h1>	
		           <table align="center">
 		           	<tr>
					<td>
	   				    	<?php
	  				     		echo "<table align='left' border='1'>";	     
				                        require_once("secure.inc");
			 	   	                $percentage = $_POST["percentage9"];
							$category = $_POST["category9"];

							$line1 = "set @percent = ".$percentage.";";
							$line2 = "select floor(count(1) * @percent / 100.0) into @pct from gene_fpkm where sample_id=1;";
							
							if($category == "gene_fpkm")
							{
								
								$line3 = "set @sqlstmt = concat('select gene_info.gene_short_name from gene_info,gene_fpkm where gene_info.id=gene_fpkm.gene_id order by gene_fpkm.gene_fpkm_id asc limit ',@pct);";
									
							}

							else if($category == "tss_fpkm")
							{
								$line3 = "set @sqlstmt = concat('select tss_info.actual_tss_id from tss_info,tss_fpkm where 
tss_info.id=tss_fpkm.tss_id order by tss_fpkm.tss_fpkm_id desc limit ',@pct);";
							}
							else if($category == "isoform_fpkm")
							{
								$line3 = "set @sqlstmt = concat('select isoform_info.iso_id from isoform_info,isoform_fpkm where isoform_info.id=isoform_fpkm.isoform_id order by isoform_fpkm.iso_fpkm_id desc limit ',@pct);";
							}
							
							$line4 = "prepare stmt from @sqlstmt;";
							$line5 = "execute stmt;";
							

														
							$con = mysqli_connect(HOSTNAME, USERNAME, PASSWORD, DBNAME) or die("connect failed");
		
				                        if(mysqli_connect_errno())
		     					{
								echo "Failed to connect to MySQL: ".mysqli_connect_error();
					                }
		
					                mysqli_query($con, $line1) or die('Query failed line1');
							mysqli_query($con, $line2) or die('Query failed line2');
							mysqli_query($con, $line3) or die('Query failed line3');		
							mysqli_query($con, $line4) or die('Query failed line4');
							$sql_result = mysqli_query($con, $line5) or die('Query failed line5');
							
				  		        
							$file = 'export';	
							$csv_output = 0;
							if(mysqli_num_rows($sql_result)>0)
					                {
								$i = 0;
								echo "<tr>";
								while ($field = mysqli_fetch_field($sql_result))
								{	
									echo "<th>".$field->name."</th>";
									$csv_output .= $field->name.",";
								}
								echo "</tr>";	
								
								$csv_output .= "\n";
								
								$count = 0;
								while($rows = mysqli_fetch_row($sql_result))
							        {
									if($count < 10)
									{
										echo "<tr>";
										foreach($rows as $data)
										{
											echo "<td>".$data."</td>";
											$csv_output .= $data.",";
											
										}
										$csv_output .= "\n";
										echo "</tr>";
										
									}
									else
									{
			 							$csv_output .= $data.",";
										$csv_output .= "\n";
									}
								        		
									
									
									$count++;
								}
								echo "</table>";
						       echo "</td></tr>";
						       echo "<tr><td></tr></tr>";
						       echo "<tr><td>Only first 10 rows from the table displayed. Please use the below Results link to download the entire result set</td>";
						       echo "<td></tr>";		
						       echo "<tr><td align='center'>";			
						       echo '<a href="results_download1.php?line1='.$line1.'&line2='.$line2.'&line3='.$line3.'&line4='.$line4.'&line5='.$line5.'">Results</a>';
					     	       }
					       	       else
					   	       {
			  			       		echo "<h3> No results found</h3>";
					      	       }
							
	
						       		
				  		       mysqli_close($con);

								
						?>				
		</td></tr>		      	
		   </table>

		
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

