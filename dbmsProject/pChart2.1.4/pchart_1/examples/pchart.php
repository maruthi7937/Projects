<?php   
 /* CAT:Pie charts */

 /* pChart library inclusions */
 include("../class/pData.class.php");
 include("../class/pDraw.class.php");
 include("../class/pPie.class.php");
 include("../class/pImage.class.php");
 /* database connection to retrieve data*/
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
 $MyData->addPoints($percentage_removed,"ScoreA");    
 $MyData->setSerieDescription("ScoreA","Application A");

 /* Define the absissa serie */
 $MyData->addPoints($sample_id,"Labels");
 $MyData->setAbscissa("Labels");

 /* Create the pChart object */
 $myPicture = new pImage(1000,530,$MyData,TRUE);

 /* Draw a solid background */
 $Settings = array("R"=>173, "G"=>152, "B"=>217, "Dash"=>1, "DashR"=>193, "DashG"=>172, "DashB"=>237);
 $myPicture->drawFilledRectangle(200,200,999,529,$Settings);

 /* Draw a gradient overlay */
 $Settings = array("StartR"=>209, "StartG"=>150, "StartB"=>231, "EndR"=>111, "EndG"=>3, "EndB"=>138, "Alpha"=>50);
 $myPicture->drawGradientArea(200,200,1000,530,DIRECTION_VERTICAL,$Settings);
 $myPicture->drawGradientArea(200,200,1000,220,DIRECTION_VERTICAL,array("StartR"=>0,"StartG"=>0,"StartB"=>0,"EndR"=>50,"EndG"=>50,"EndB"=>50,"Alpha"=>100));

 /* Add a border to the picture */
 $myPicture->drawRectangle(199,199,998,528,array("R"=>0,"G"=>0,"B"=>0));

 /* Write the picture title */ 
 $myPicture->setFontProperties(array("FontName"=>"../fonts/verdana.ttf","FontSize"=>10));
 $myPicture->drawText(210,223,"3D pie charts",array("R"=>255,"G"=>255,"B"=>255));

 /* Set the default font properties */ 
 $myPicture->setFontProperties(array("FontName"=>"../fonts/verdana.ttf","FontSize"=>10,"R"=>80,"G"=>80,"B"=>80));

 /* Create the pPie object */ 
 $PieChart = new pPie($myPicture,$MyData);

 /* Define the slice color */
 $PieChart->setSliceColor(0,array("R"=>143,"G"=>197,"B"=>0));
 $PieChart->setSliceColor(1,array("R"=>97,"G"=>77,"B"=>63));
 $PieChart->setSliceColor(2,array("R"=>97,"G"=>113,"B"=>63));

 /* Draw a simple pie chart */ 
 $PieChart->draw3DPie(320,400,array("SecondPass"=>FALSE));

 /* Draw an AA pie chart */ 
 $PieChart->draw3DPie(580,400,array("DrawLabels"=>TRUE,"Border"=>TRUE));

 /* Enable shadow computing */ 
 $myPicture->setShadow(TRUE,array("X"=>3,"Y"=>3,"R"=>0,"G"=>0,"B"=>0,"Alpha"=>10));

 /* Draw a splitted pie chart */ 
 $PieChart->draw3DPie(810,400,array("WriteValues"=>TRUE,"DataGapAngle"=>10,"DataGapRadius"=>6,"Border"=>TRUE));

 /* Write the legend */
 $myPicture->setFontProperties(array("FontName"=>"../fonts/verdana.ttf","FontSize"=>12));
 $myPicture->setShadow(TRUE,array("X"=>1,"Y"=>1,"R"=>0,"G"=>0,"B"=>0,"Alpha"=>20));
 $myPicture->drawText(320,500,"percentage removed",array("DrawBox"=>TRUE,"BoxRounded"=>TRUE,"R"=>0,"G"=>0,"B"=>0,"Align"=>TEXT_ALIGN_TOPMIDDLE));
 $myPicture->drawText(640,500,"sample_id / percentage removed",array("DrawBox"=>TRUE,"BoxRounded"=>TRUE,"R"=>0,"G"=>0,"B"=>0,"Align"=>TEXT_ALIGN_TOPMIDDLE));

 /* Render the picture (choose the best way) */
 $myPicture->autoOutput("pictures/example.draw3DPie.png");
?>