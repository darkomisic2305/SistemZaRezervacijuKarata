$(document).ready(function() {
	$('li a').on('click', function(event) {
		
		$('li').removeClass('active');
		
		$(this).closest('li').addClass('active');
	});

});