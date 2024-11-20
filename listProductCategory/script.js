$(document).ready(function () {
    $('.dropdown-brand-item').on('click', function () {
        $('.dropdown-brand-item').removeClass('drop-brand-item__active');
        $(this).addClass('drop-brand-item__active');
        var selectedText = $(this).text();
        $('#dropdown-text-brand').text(selectedText);
    });
    $('.filter-item').on('click', function () {
        $(this).addClass('filter-item__active');
    });
    $('#filter-remove-button').on('click', function () {
        $('.filter-item').removeClass('filter-item__active');
        $('#dropdown-text-brand').text('');
        $('.dropdown-brand-item').removeClass('drop-brand-item__active');
    });
});
