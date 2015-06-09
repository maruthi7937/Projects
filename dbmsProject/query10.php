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
			if( isset($_SESSION['admin']) )
			{
					
		   		echo "<li class='last'><a href='admin.php'>ADMIN</a>";
	   	        	echo "</li>";
			}
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
			 	   	                $category = $_POST["category10"];
							
							
							if($category == "gene_fpkm")
							{
								$line1 = "SET @rownum := -1;";
								$line2 = "SELECT gene_short_name,  AVG(t.id) as Median FROM(SELECT @rownum := @rownum + 1 AS rownum, gene_fpkm.gene_fpkm_id AS id, gene_short_name  FROM gene_fpkm, gene_info where gene_info.id=gene_fpkm.gene_id AND sample_id=1 ORDER BY gene_fpkm.gene_fpkm_id) AS t WHERE   t.rownum IN (CEIL(@rownum/2), FLOOR(@rownum/2));";
									
							}

							else if($category == "tss_fpkm")
							{
								$line1 = "SET @rownum := -1;";
								$line2 = "SELECT actual_tss_id,   AVG(t.id) as Median FROM ( SELECT@rownum := @rownum + 1 AS rownum, tss_info.actual_tss_id AS actual_tss_id, tss_fpkm.tss_fpkm_id AS id FROM tss_fpkm, tss_info  where	 tss_info.id=tss_fpkm.tss_id AND sample_id=1 ORDER BY tss_fpkm.tss_fpkm_id) AS t WHERE t.rownum IN ( CEIL(@rownum/2),FLOOR(@rownum/2) );";
								
							}
							else if($category == "isoform_fpkm")
							{
								$line1 = "SET @rownum := -1;";
								$line2 = "SELECT iso_id, AVG(t.id) as Median FROM ( SELECT @rownum := @rownum + 1 AS rownum,  isoform_info.iso_id AS iso_id,  isoform_fpkm.iso_fpkm_id AS id FROM isoform_info,isoform_fpkm where isoform_info.id=isoform_fpkm.isoform_id AND sample_id=1   ORDER BY isoform_fpkm.iso_fpkm_id) AS t WHERE t.rownum IN (CEIL(@rownum/2), FLOOR(@rownum/2) );";
								
							}
							

												
							$con = mysqli_connect(HOSTNAME, USERNAME, PASSWORD, DBNAME) or die("connect failed");
		
				                        if(mysqli_connect_errno())
		     					{
								echo "Failed to connect to MySQL: ".mysqli_connect_error();
					                }
		
					                mysqli_query($con, $line1) or die('Query failed line1');
							$sql_result = mysqli_query($con, $line2) or die('Query failed line2');
							
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
						       echo '<a href="results_download2.php?line1='.$line1.'&line2='.$line2.'">Results</a>';
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
