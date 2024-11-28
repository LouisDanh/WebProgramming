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