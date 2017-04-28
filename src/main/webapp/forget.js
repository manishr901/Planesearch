$(document).ready(function() {
	$('#sendmail').hide();

	$('#forget').keyup(function() {
		$.ajax({
			url : "forgetpassword",
			data : {
				email : $('#forget').val()
			},
			success : function(data) {
				if (data == 10)
					$('#sendmail').show();
			}
		})
	});

});
function message(){
	
window.location="Login.jsp";
}
$(document).ready(function(){
$('#sendmail').click(function(){
	$.ajax({
		url:"forgetpasswordemail",
		data:{
			email:$('#forget').val()
		},
	
	})
});	
});

