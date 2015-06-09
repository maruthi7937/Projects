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
				   <li class='last'><a href='home.php'>Home</a></li>	
				   <li class='last'><a href='query.php'>QUERY</a></li>
				   <?php
			
					
		   		echo "<li class='last'><a href='admin.php'>ADMIN</a>";
	   	        	echo "</li>";
			
		  ?>
				   <li class='last'><a href='logout.php'>Logout</a></li>
				   <li class='last'><a href='reset.php'>Password Reset</a></li>
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
			 	   	                $category = $_POST["category01"];
							$category1 = $_POST["category011"];

							
							if($category == "gene")
							{
								if($category1 == "all")
								{
									$line1 = "SELECT  gi.gene_id, gi.gene_short_name  FROM gene_info gi WHERE NOT EXISTS(SELECT s.sample_id FROM sample s WHERE NOT EXISTS(SELECT g.sample_id FROM gene_fpkm g WHERE g.sample_id=s.sample_id AND g.gene_id = gi.id));";
								}
								else
								{
									$line1 = "SELECT  gi.gene_id, gi.gene_short_name FROM gene_info gi WHERE (gi.id IN ( SELECT g.gene_id FROM gene_fpkm g, sample s WHERE (s.sample_id=g.sample_id) AND (s.sample_id = ".$category1.") ));";
								}

							}


				
							else if($category == "tss")
							{
								if($category1 == "all")
								{
									$line1 = "SELECT ti.tss_id  FROM tss_info  ti WHERE NOT EXISTS(SELECT s.sample_id FROM sample s WHERE NOT EXISTS (SELECT t.sample_id FROM tss_fpkm t WHERE t.sample_id=s.sample_id AND t.tss_id = ti.id));";
								}
								else
								{
									$line1 = "SELECT ti.tss_id FROM tss_info ti WHERE ti.id IN  (SELECT t.tss_id FROM tss_fpkm t, sample s WHERE s.sample_id = t.sample_id AND  s.sample_id = ".$category1.");";
								}
								
								
							}
							else if($category == "isoform")
							{

								if($category1 == "all")
								{
									$line1 = "";
								}
								else
								{
									$line1 = "SELECT ii.iso_id, i.nearest_ref_id FROM isoform_fpkm i, isoform_info ii WHERE (ii.id = i.isoform_id) AND (i.sample_id IN (SELECT s.sample_id FROM sample s WHERE s.sample_id = ".$category1."));";
								}
								
							}
							
							
							$con = mysqli_connect(HOSTNAME, USERNAME, PASSWORD, DBNAME) or die("connect failed");
		
				                        if(mysqli_connect_errno())
		     					{
								echo "Failed to connect to MySQL: ".mysqli_connect_error();
					                }
		
					                $sql_result = mysqli_query($con, $line1) or die('Query failed line1');
							
							
							
				  		        
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
										echo "</tr>";
									}
									else
									{
			 							$csv_output .= $data.",";
									}
								        		
									
									$csv_output .= "\n";
									$count++;
								}
								echo "</table>";
						       echo "</td></tr>";
						       echo "<tr><td></tr></tr>";
						       echo "<tr><td>Only first 10 rows from the table displayed. Please use the below Results link to download the entire result set</td>";
						       echo "<td></tr>";		
						       echo "<tr><td align='center'>";	
						       echo '<a href="results_download.php?execute='.$line1.'">Results</a>';
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

