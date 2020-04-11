$(document).ready(function()
{
    $('#navTogglePanel').css('display','none');
    $("#tableButton").click(function()
    {
        $('#navTogglePanel').slideDown("slow");
    });
});