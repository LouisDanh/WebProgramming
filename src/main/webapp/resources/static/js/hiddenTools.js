$(document).ready(function() {
    // Toggle menu khi nhấn vào hamburger icon
    $('#hamburgerIcon').click(function(event) {
        $('#extraIcons').toggleClass('show'); // Toggle class 'show' để hiển thị/ẩn menu
        
        // Ngừng sự kiện click lan tỏa ra ngoài (ngăn không đóng khi nhấn vào menu)
        event.stopPropagation();
    });

    // Đóng menu nếu nhấn ra ngoài hamburger icon và menu
    $(document).click(function(event) {
        // Kiểm tra nếu click ra ngoài hamburger icon và menu
        if (!$('#hamburgerIcon').is(event.target) && !$('#extraIcons').is(event.target) && $('#extraIcons').has(event.target).length === 0) {
            $('#extraIcons').removeClass('show'); // Ẩn dropdown menu
        }
    });
});
