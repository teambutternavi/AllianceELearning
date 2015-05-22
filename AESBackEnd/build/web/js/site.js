$(document).ready(function(){
    $('.slider-menu').click(function(){
        var hidden = $('.log-slider');
        if (hidden.hasClass('visible')){
            hidden.animate({"right":"-1000px"}, "slow").removeClass('visible');
        } else {
            hidden.animate({"right":"0px"}, "slow").addClass('visible');
        }
    });
});