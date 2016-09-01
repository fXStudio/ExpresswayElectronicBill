// System Login Controller
$(document).ready(function(){
	$('a.btn').click(function(){
		var username = $('#login-name').val();
		var password = $('#login-pass').val();
		
		alert(username + " " + password);
	});
});