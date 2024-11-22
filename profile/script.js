$(document).ready(function () {
    // Hiển thị ảnh xem trước khi người dùng tải ảnh lên
    $('#imageUpload').on('change', function () {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (e) {
                $('#previewImage').attr('src', e.target.result);
            };
            reader.readAsDataURL(file);
        }
    });
        $('#submitButton').on('click', function () {
            let isValid = true;
    
            // Kiểm tra từng trường
            if ($('#name').val().trim() === '') {
                $('#nameError').removeClass('d-none'); // Hiển thị lỗi
                isValid = false;
            } else {
                $('#nameError').addClass('d-none'); // Ẩn lỗi
            }
    
            if ($('#email').val().trim() === '' || !validateEmail($('#email').val().trim())) {
                $('#emailError').removeClass('d-none');
                isValid = false;
            } else {
                $('#emailError').addClass('d-none');
            }
    
            if ($('#phone').val().trim() === '') {
                $('#phoneError').removeClass('d-none');
                isValid = false;
            } else {
                $('#phoneError').addClass('d-none');
            }
    
            if ($('#birthday').val().trim() === '') {
                $('#birthdayError').removeClass('d-none');
                isValid = false;
            } else {
                $('#birthdayError').addClass('d-none');
            }
    
            // Nếu hợp lệ, submit form
            if (isValid) {
                $('#userForm').submit();
            }
        });
    
        // Hàm kiểm tra email hợp lệ
        function validateEmail(email) {
            const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return re.test(email);
        }
    
});
