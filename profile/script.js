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
    $('.primary-color-hover').on('click', function () {
        $(this).addClass('primary-color-active');
        var index = $(this).index();
        var tag = $('.infor-tag').eq(index)
        tag.removeClass('d-none');
        $('.infor-tag').not(tag).addClass('d-none');
        $('.primary-color-hover').not(this).removeClass('primary-color-active');
    });

    // Hàm kiểm tra email hợp lệ
    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    }

});

// Hàm sửa địa chỉ
$(document).ready(function() {
    // Khi nhấn nút Lưu địa chỉ
    $('#addressSubmitButton').click(function() {
        var fullName = $('#fullName').val();
        var phoneNumber = $('#phoneNumber').val();
        var address = $('#address').val();

        // Kiểm tra nếu tất cả các trường đều có giá trị
        if (fullName && phoneNumber && address) {
            // Hiển thị thông tin đã nhập vào thẻ hiển thị
            $('#displayFullName').text(fullName);
            $('#displayPhoneNumber').text(phoneNumber);
            $('#displayAddress').text(address);

            // Hiển thị thẻ thông tin địa chỉ
            $('#addressDisplay').show();

            // Ẩn form nhập địa chỉ
            $('#addressForm').hide();
        } else {
            // Hiển thị thông báo lỗi nếu một trong các trường bị thiếu
            if (!fullName) $('#fullNameError').removeClass('d-none');
            if (!phoneNumber) $('#phoneNumberError').removeClass('d-none');
            if (!address) $('#addressError').removeClass('d-none');
        }
    });

    // Tắt lỗi khi người dùng bắt đầu nhập lại
    $('#fullName, #phoneNumber, #address').on('input', function() {
        $(this).siblings('small').addClass('d-none');
    });

    // Khi nhấn nút "Sửa địa chỉ"
    $('#editAddressButton').click(function() {
        // Hiển thị lại form nhập địa chỉ
        $('#addressForm').show();
        $('#addressDisplay').hide();

        // Điền lại các giá trị vào form để chỉnh sửa
        $('#fullName').val($('#displayFullName').text());
        $('#phoneNumber').val($('#displayPhoneNumber').text());
        $('#address').val($('#displayAddress').text());
    });
});
