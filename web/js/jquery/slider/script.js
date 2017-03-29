$(document).ready(function()
{
	//Add Inactive Class To All Accordion Headers
	$('.accordion-header').toggleClass('inactive-header');
	
	//Set The Accordion Content Width
	var contentwidth = $('.accordion-header').width();
	$('.accordion-content').css({'width' : contentwidth });
	
	//Open The First Accordion Section When Page Loads
//	$('.accordion-header').first().toggleClass('active-header').toggleClass('inactive-header');
//	$('.accordion-content').first().slideDown().toggleClass('open-content');
	
	// The Accordion Effect
	$('.accordion-header').click(function () {
		if($(this).is('.inactive-header')) {
			$('.active-header').toggleClass('active-header').toggleClass('inactive-header').next().slideToggle().toggleClass('open-content');
			$(this).toggleClass('active-header').toggleClass('inactive-header');
			$(this).next().slideToggle().toggleClass('open-content');
		}
		
		else {
			$(this).toggleClass('active-header').toggleClass('inactive-header');
			$(this).next().slideToggle().toggleClass('open-content');
		}
	});
	
	return false;
});

$(document).ready(function(){
		$('#login-trigger').click(function(){
			$(this).next('#login-content').slideToggle();
			$(this).toggleClass('active');					
			
			//if ($(this).hasClass('active')) $(this).find('span').html('&#x25B2;')
			//	else $(this).find('span').html('&#x25BC;')
			})
	});
	
function validate(evt) {
	  var theEvent = evt || window.event;
	  var key = theEvent.keyCode || theEvent.which;
	  key = String.fromCharCode( key );
	  var regex = /[0-9]|\./;
	  if( !regex.test(key) ) {
		theEvent.returnValue = false;
		if(theEvent.preventDefault) theEvent.preventDefault();
	  }
	}
        
function openShadowbox(content){
window.parent.Shadowbox.open({
  content: content,//
  player: 'iframe',
  width: '960',
  height: '600'
  
});
}