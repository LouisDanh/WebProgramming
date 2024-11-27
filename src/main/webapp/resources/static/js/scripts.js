// Đảm bảo mật khẩu ẩn và biểu tượng là mắt đóng khi trang được tải
$('#toggle-password').on('click', function () {
    var passwordField = $('#password');
    var icon = $(this).find('i');
    
    if (passwordField.attr('type') === 'password') {
        passwordField.attr('type', 'text'); // Hiện mật khẩu
        icon.removeClass('bi-eye-slash').addClass('bi-eye'); // Đổi biểu tượng mắt đóng thành mắt mở
    } else {
        passwordField.attr('type', 'password'); // Ẩn mật khẩu
        icon.removeClass('bi-eye').addClass('bi-eye-slash'); // Đổi biểu tượng mắt mở thành mắt đóng
    }
});

$('#toggle-confirm-password').on('click', function () {
    var confirmPasswordField = $('#confirmPassword');
    var icon = $(this).find('i');
    
    if (confirmPasswordField.attr('type') === 'password') {
        confirmPasswordField.attr('type', 'text'); // Hiện mật khẩu xác nhận
        icon.removeClass('bi-eye-slash').addClass('bi-eye'); // Đổi biểu tượng mắt đóng thành mắt mở
    } else {
        confirmPasswordField.attr('type', 'password'); // Ẩn mật khẩu xác nhận
        icon.removeClass('bi-eye').addClass('bi-eye-slash'); // Đổi biểu tượng mắt mở thành mắt đóng
    }
});

// Hàm để toggle hiển thị danh mục con khi nhấn
function toggleSubCategory(category) {
    var subCategories = $('.sub-category');
    
    subCategories.each(function() {
        $(this).hide(); // Ẩn tất cả danh mục con
    });

    // Lấy danh mục con được chọn
    var selectedCategory = $('#' + category);

    // Kiểm tra xem danh mục con đã hiển thị hay chưa, nếu có thì ẩn, nếu không thì hiển thị
    if (selectedCategory.css('display') === 'block') {
        selectedCategory.hide();
    } else {
        selectedCategory.show();
    }
}

// Hàm đóng danh mục con khi chuột di chuyển ra ngoài
function closeAllSubCategories() {
    $('.sub-category').hide(); // Ẩn tất cả danh mục con
}

// Thêm sự kiện `mouseleave` vào phần tử menu để đóng danh mục con khi di chuột ra ngoài
$('.navbar-nav').on('mouseleave', closeAllSubCategories);
