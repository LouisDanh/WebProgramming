$(document).ready(function() {
    // Chức năng ẩn/hiện phần nguyên liệu khi nhấn vào biểu tượng
    $("#toggleIcon").click(function() {
        const ingredientsContent = $("#ingredientsContent");
        const isHidden = ingredientsContent.hasClass("d-none");

        // Thực hiện ẩn/hiện phần nguyên liệu
        ingredientsContent.toggleClass("d-none", !isHidden);

        // Thay đổi biểu tượng (+ <-> -)
        if (isHidden) {
            $(this).removeClass("bi-plus").addClass("bi-dash");
        } else {
            $(this).removeClass("bi-dash").addClass("bi-plus");
        }
    });

    // Hàm cập nhật giá tiền dựa trên số lượng
    const updatePrice = (quantity) => {
        const basePrice = parseInt($("#basePrice").text());  // Lấy giá gốc từ HTML (có thể lấy từ phần tử trên trang)
        const totalPrice = basePrice * quantity;  // Tính tổng giá
        $("#prices").text(totalPrice.toLocaleString('vi-VN') + '₫');  // Hiển thị tổng giá theo định dạng tiền Việt
    };

    // Xử lý thay đổi số lượng
    let quantity = 1;  // Số lượng mặc định

    // Khi nhấn nút giảm số lượng
    $("#decrease").click(function() {
        if (quantity > 1) {
            quantity--;  // Giảm số lượng
            $("#quantity").text(quantity);  // Cập nhật hiển thị số lượng
            updatePrice(quantity);  // Cập nhật giá
        }
    });

    // Khi nhấn nút tăng số lượng
    $("#increase").click(function() {
        quantity++;  // Tăng số lượng
        $("#quantity").text(quantity);  // Cập nhật hiển thị số lượng
        updatePrice(quantity);  // Cập nhật giá
    });

    // Thay đổi ảnh chính khi nhấn vào hình thu nhỏ (sử dụng jQuery)
    $(".img-60px").click(function() {
        const newImage = $(this).data('large-image');  // Lấy URL của ảnh lớn từ thuộc tính data-large-image
        $('#mainImage').attr('src', newImage);  // Cập nhật ảnh chính
    });

    // Cập nhật giá ngay khi trang được tải
    updatePrice(quantity);
});
