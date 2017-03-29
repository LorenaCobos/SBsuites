function is_touch_device() {
  return !!('ontouchstart' in window);
}

/***************************************************
	    PORTFOLIO ITEM IMAGE HOVER
***************************************************/
$(window).load(function(){
						   
	$(".grid ul li .item-info-overlay").hide();
	
	if( is_touch_device() ){
		$(".grid ul li").click(function(){
												  
			var count_before = $(this).closest("li").prevAll("li").length;
			
			var this_opacity = $(this).find(".item-info-overlay").css("opacity");
			var this_display = $(this).find(".item-info-overlay").css("display");
			
			
			if ((this_opacity == 0) || (this_display == "none")) {
				$(this).find(".item-info-overlay").fadeTo(250, 0.9);
			} else {
				$(this).find(".item-info-overlay").fadeTo(250, 0);
			}
			
			$(this).closest("ul").find("li:lt(" + count_before + ") .item-info-overlay").fadeTo(250, 0);
			$(this).closest("ul").find("li:gt(" + count_before + ") .item-info-overlay").fadeTo(250, 0);	

		});	

	}
	else{	
			$(".grid ul li").hover(function(){
				$(this).find(".item-info-overlay").fadeTo(250, 0.9);
				}, function() {
					$(this).find(".item-info-overlay").fadeTo(250, 0);		
			});
		
		}

	
	
	
});