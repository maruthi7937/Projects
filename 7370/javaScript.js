
//java script for the two functions in the webpage
//Displaying Date in Top Corner of every page 
var now = new Date();
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var today = now.getFullYear() + "-" + (month) + "-" + (day);
document.write("<small><font color='000000' face='Arial'><b>"+today+"</b></font></small>")

//script for for vertical drop menu

var TimeOut         = 300;
var currentLayer    = null;
var currentitem     = null;
var currentLayerNum = 0;
var noClose         = 0;
var closeTimer      = null;

function mopen(n) {
  var l  = document.getElementById("menu"+n);
  var mm = document.getElementById("mmenu"+n);
  if(l) {
    mcancelclosetime();
    l.style.visibility='visible';
	
    if(currentLayer && (currentLayerNum != n))
      currentLayer.style.visibility='hidden';
    currentLayer = l;
    currentitem = mm;
    currentLayerNum = n;			
  } else if(currentLayer) {
    currentLayer.style.visibility='hidden';
    currentLayerNum = 0;
    currentitem = null;
    currentLayer = null;
 	}
}
 
function mclosetime() {
  closeTimer = window.setTimeout(mclose, TimeOut);
}

function mcancelclosetime() {
  if(closeTimer) {
    window.clearTimeout(closeTimer);
    closeTimer = null;
  }
}

function mclose() {
  if(currentLayer && noClose!=1)   {
    currentLayer.style.visibility='hidden';//
    currentLayerNum = 0;//setting the values to 0 
    currentLayer = null;//setting the values to null
    currentitem = null;
  } else {
    noClose = 0;
  }
  currentLayer = null;
  currentitem = null;
}

document.onclick = mclose; 
//alert box for form application submit button
function myFunction() {
    alert("Your Application Has Received");
}