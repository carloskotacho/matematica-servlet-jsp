$(document).ready(function () {	
	$('.collapsible').collapsible();
        $('#year').html(getCurrentYear());
        $('select').material_select();
        $(".button-collapse").sideNav();
        $('input#username').characterCounter();
        $('.fixed-action-btn').openFAB();
        $('.fixed-action-btn').closeFAB();
        $('.fixed-action-btn.toolbar').openToolbar();
        $('.fixed-action-btn.toolbar').closeToolbar();
        
});

function getCurrentYear(){
    return new Date().getFullYear();    
}




