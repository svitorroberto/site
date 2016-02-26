$(document).ready( function () {
	$("#menu").hide();
	$("#show_menu").click(function() {
		$("#menu").toggle();	
		$("header").toggleClass("expanded")	
	});
	 
	var car_des = $("#carousel_destaques");
	car_des.owlCarousel({
		navigation : true,
		singleItem : true,
		transitionStyle : "fadeUp"
	});
});

