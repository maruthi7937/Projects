<?php   
 /* CAT:Bar Chart */

 /* pChart library inclusions */
 include("../class/pData.class.php");
 include("../class/pDraw.class.php");
 include("../class/pImage.class.php");
							/* database connection*/
							require_once("secure.inc");   
							$percentage_removed = array();
							$sample_id = array();
							$count=1;
							$con = mysqli_connect(HOSTNAME, USERNAME, PASSWORD, DBNAME) or die("connect failed");			                
							if($stmt = mysqli_prepare($con, "Select percentage_removed from fastq_trimmer")){
							mysqli_stmt_execute($stmt);
							mysqli_stmt_bind_result($stmt, $percentage);
							while(mysqli_stmt_fetch($stmt)){
								$percentage_removed[] = $percentage;
								$sample_id[] = $count;
								$count = $count+1;
								}
								mysqli_stmt_close($stmt);
							}else{
							echo "error:\n";
							echo $mysqli->errno."\n";
							echo $mysqli->error."\n";
								}						       		
				  		       mysqli_close($con);
 /* Create and populate the pData object */
 $MyData = new pData();  
 $MyData->addPoints($percentage_removed,"percentage");
 $MyData->setAxisName(0,"percentage_removal");
 $MyData->addPoints($sample_id,"sample_id");
 $MyData->setAxisName(1,"sample_id");
 $MyData->setSerieDescription("sample_id","sample");
 $MyData->setAbscissa("sample_id");
 $MyData->setAbscissaName("sample_id");

 /* Create the pChart object */
 $myPicture = new pImage(1000,530,$MyData);

 /* Turn of Antialiasing */
 $myPicture->Antialias = FALSE;

 /* Add a border to the picture */
 $myPicture->drawRectangle(200,200,999,529,array("R"=>100,"G"=>50,"B"=>50));

 /* Set the default font */
 $myPicture->setFontProperties(array("FontName"=>"../fonts/verdana.ttf","FontSize"=>12));

 /* Define the chart area */
 $myPicture->setGraphArea(250,230,970,490);

 /* Draw the scale */
 $scaleSettings = array("GridR"=>200,"GridG"=>200,"GridB"=>200,"DrawSubTicks"=>TRUE,"CycleBackground"=>TRUE);
 $myPicture->drawScale($scaleSettings);

 /* Write the chart legend */
 $myPicture->drawLegend(800,210,array("Style"=>LEGEND_NOBORDER,"Mode"=>LEGEND_HORIZONTAL));

 /* Turn on shadow computing */ 
 $myPicture->setShadow(TRUE,array("X"=>1,"Y"=>1,"R"=>10,"G"=>50,"B"=>60,"Alpha"=>10));

 /* Draw the chart */
 $myPicture->setShadow(TRUE,array("X"=>1,"Y"=>1,"R"=>10,"G"=>50,"B"=>60,"Alpha"=>10));
 $settings = array("Gradient"=>TRUE,"GradientMode"=>GRADIENT_EFFECT_CAN,"DisplayPos"=>LABEL_POS_INSIDE,"DisplayValues"=>TRUE,"DisplayR"=>255,"DisplayG"=>255,"DisplayB"=>255,"DisplayShadow"=>TRUE,"Surrounding"=>10);
 $myPicture->drawBarChart();

 /* Render the picture (choose the best way) */
 $myPicture->autoOutput("pictures/example.drawBarChart.simple.png");
?>