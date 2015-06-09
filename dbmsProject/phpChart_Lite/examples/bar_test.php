<?php
require_once("conf.php");
?>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>phpChart - Bar Test</title>
</head>
    <body>
        <div><span> </span><span id="info1b"></span></div>

<?php
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Bar 1 Example
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    $s1 = array(2, 6, 7, 10);
    $ticks = array('a', 'b', 'c', 'd');
    
    $pc = new C_PhpChartX(array($s1),'chart1');
    $pc->add_plugins(array('highlighter','pointLabels'));
	$pc->set_animate(true);
	$pc->set_series_default(array(
		'renderer'=>'plugin::BarRenderer',
		'pointLabels'=> array('show'=>true)));
    $pc->set_axes(array(
         'xaxis'=>array(
			'renderer'=>'plugin::CategoryAxisRenderer',
			'ticks'=>$ticks)
    ));
    $pc->set_highlighter(array('show'=>false));
    $pc->bind_js('jqplotDataClick',array(
		'series'=>'seriesIndex',
		'point'=>'pointIndex',
		'data'=>'data'));
    $pc->draw(400,300);
?>

    </body>
</html>