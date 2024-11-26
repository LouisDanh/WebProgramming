// Đảm bảo mật khẩu ẩn và biểu tượng là mắt đóng khi trang được tải
document.getElementById('toggle-password').addEventListener('click', function () {
    var passwordField = document.getElementById('password');
    var icon = this.querySelector('i');
    if (passwordField.type === 'password') {
        passwordField.type = 'text'; // Hiện mật khẩu
        icon.classList.remove('bi-eye-slash'); // Đổi biểu tượng mắt đóng
        icon.classList.add('bi-eye'); // Đổi biểu tượng mắt mở
    } else {
        passwordField.type = 'password'; // Ẩn mật khẩu
        icon.classList.remove('bi-eye'); // Đổi biểu tượng mắt mở
        icon.classList.add('bi-eye-slash'); // Đổi biểu tượng mắt đóng
    }
});

document.getElementById('toggle-confirm-password').addEventListener('click', function () {
    var confirmPasswordField = document.getElementById('confirmPassword');
    var icon = this.querySelector('i');
    if (confirmPasswordField.type === 'password') {
        confirmPasswordField.type = 'text'; // Hiện mật khẩu xác nhận
        icon.classList.remove('bi-eye-slash'); // Đổi biểu tượng mắt đóng
        icon.classList.add('bi-eye'); // Đổi biểu tượng mắt mở
    } else {
        confirmPasswordField.type = 'password'; // Ẩn mật khẩu xác nhận
        icon.classList.remove('bi-eye'); // Đổi biểu tượng mắt mở
        icon.classList.add('bi-eye-slash'); // Đổi biểu tượng mắt đóng
    }
});

// Hàm để toggle hiển thị danh mục con khi nhấn
function toggleSubCategory(category) {
    const subCategories = document.querySelectorAll('.sub-category');
    
    subCategories.forEach(function (subCategory) {
        // Ẩn tất cả danh mục con
        subCategory.style.display = 'none';
    });

    // Lấy danh mục con được chọn
    const selectedCategory = document.getElementById(category);

    // Kiểm tra xem danh mục con đã hiển thị hay chưa, nếu có thì ẩn, nếu không thì hiển thị
    if (selectedCategory.style.display === 'block') {
        selectedCategory.style.display = 'none';
    } else {
        selectedCategory.style.display = 'block';
    }
}

// Hàm đóng danh mục con khi chuột di chuyển ra ngoài
function closeAllSubCategories() {
    const subCategories = document.querySelectorAll('.sub-category');
    subCategories.forEach(function (subCategory) {
        subCategory.style.display = 'none';
    });
}

// Thêm sự kiện `mouseleave` vào phần tử menu để đóng danh mục con khi di chuột ra ngoài
document.querySelector('.navbar-nav').addEventListener('mouseleave', closeAllSubCategories);

