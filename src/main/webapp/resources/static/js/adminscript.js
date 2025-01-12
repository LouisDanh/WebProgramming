$(function () {
    $('.tool').on('click', function () {
        $('.main').addClass("d-none")
        var target = $(this).data('target');
		$('#' + target).removeClass('d-none');
    });
})