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
    } $(document).ready(function () {
        // Khi nhấn nút Lưu địa chỉ
        $('#addressSubmitButton').click(function () {
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
        $('#fullName, #phoneNumber, #address').on('input', function () {
            $(this).siblings('small').addClass('d-none');
        });

        // Khi nhấn nút "Sửa địa chỉ"
        $('#editAddressButton').click(function () {
            // Hiển thị lại form nhập địa chỉ
            $('#addressForm').show();
            $('#addressDisplay').hide();

            // Điền lại các giá trị vào form để chỉnh sửa
            $('#fullName').val($('#displayFullName').text());
            $('#phoneNumber').val($('#displayPhoneNumber').text());
            $('#address').val($('#displayAddress').text());
        });
        // Sự kiện cho các mục nhỏ
        $('.primary-color-hover').on('click', function (event) {
            event.stopPropagation();  // Ngừng sự kiện lan truyền lên phần tử cha
            var index = $('.primary-color-hover').index(this);
            setActiveSmallTag(index);
        });

        // Sự kiện cho các mục lớn
        $('#userMenuAccordion .accordion-item').on('click', function (event) {
            event.stopPropagation();  // Ngừng sự kiện lan truyền lên phần tử cha
            var index = $('#userMenuAccordion .accordion-item').index(this);
            var smallIndex = index === 0 ? 0 : $('.infor-tag').length - 1;
            setActiveSmallTag(smallIndex);
        });

        // Sự kiện cho phần tử đánh giá
        $('.open-rating-container').on('click', function () {
            var index = $('.open-rating-container').index(this);
            openRatingContainer(index);
        });

        // Hàm mở phần đánh giá
        function openRatingContainer(index) {
            $('.rating-container').eq(index).removeClass('d-none');
            $('.open-rating-container').eq(index).addClass('d-none');
        }

        // Hàm set active cho các mục nhỏ
        function setActiveSmallTag(index) {
            $('.primary-color-hover').removeClass('primary-color-active'); // Xóa active cũ
            $('.primary-color-hover').eq(index).addClass('primary-color-active'); // Đặt active mới
            var tag = $('.infor-tag').eq(index); // Lấy nội dung theo index
            tag.removeClass('d-none'); // Hiển thị nội dung
            $('.infor-tag').not(tag).addClass('d-none'); // Ẩn các nội dung còn lại
        }

        $('.cancelRating').on('click', function () {
            var index = $('.cancelRating').index(this);
            closeRatingContainer(index);
        });
        $('.submitRating').on('click', function () {
            var index = $('.submitRating').index(this);
            closeRatingContainer(index);
            var btn = $('.open-rating-container').eq(index);
            btn.addClass('btn-link');
            btn.text('Mua lại');
        });
        $('.rating-star').on('click', function () {
            var index = $('.start').index(this);
            var rating = index + 1;
            var stars = $('.rating-star');
            for (var i = 0; i < stars.length; i++) {
                if (i <= index) {
                    stars.eq(i).addClass('text-warning');
                } else {
                    stars.eq(i).removeClass('text-warning');
                }
            }
            $('#ratingValue').val(rating);
        });
        function closeRatingContainer(index) {
            $('.rating-container').eq(index).addClass('d-none');
            $('.open-rating-container').eq(index).removeClass('d-none');
        }
    });
});
