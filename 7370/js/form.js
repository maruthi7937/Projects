$(document).ready(function() {
  var form = $('#form'); // contact form
  var submit = $('#submit');  // submit button
  var alert = $('.alert'); // alert div for show alert message

  // form submit event
  form.on('submit', function(e) {
    e.preventDefault(); // prevent default form submit

    $.ajax({
      //url: '', // form action url
      type: 'POST', // form submit method get/post
      dataType: 'html', // request type html/json/xml
      data: form.serialize(), // serialize form data 
      beforeSend: function() {  //While the form data is being sent,
        alert.fadeOut();		
        submit.html('Sending....'); // change submit button text
      },
      success: function(data) {    //If form submit is successful,
        alert.html(data).fadeIn(); // fade in response data
		form.load("AjaxTest.html #ajaxTest"); //Load content of AjaxTestResult for div ajaxTest
      },
      error: function(e) { //If error exists,
        console.log(e)     //Report errors.
      }
    });
  });
});