$(document).ready(function () {
    // Hàm cập nhật tổng giá trị đơn hàng
    const updateTotalPrice = () => {
        let totalPrice = 0;
        let totalItems = 0; // Variable to keep track of the total items in the cart

        // Duyệt qua từng sản phẩm trong giỏ hàng và tính toán tổng giá trị
        $('.cart-item').each(function () {
            // Lấy số lượng sản phẩm
            const quantity = parseInt($(this).find('.quantity-display').text());
            // Lấy giá của sản phẩm
            const price = parseInt($(this).find('.total-price').data('price'));
            // Tính toán tổng giá trị đơn hàng
            totalPrice += quantity * price;
            // Cập nhật tổng số lượng sản phẩm
            totalItems += quantity;
        });

        // Cập nhật tổng giá trị tạm tính
        $('#total-amount').text(totalPrice.toLocaleString('vi-VN') + '₫');
        // Cập nhật tổng giá trị đơn hàng
        $('#final-total').text(totalPrice.toLocaleString('vi-VN') + '₫');

        // Cập nhật số lượng giỏ hàng
        $('#cart-count').text('Giỏ hàng của bạn [' + totalItems + ']');
    };

    // Gán sự kiện cho các nút tăng và giảm số lượng sản phẩm
    $('.cart-items').on('click', '.decrease, .increase', function () {
        // Lấy sản phẩm đang thay đổi số lượng
        const productItem = $(this).closest('.cart-item');
        // Lấy số lượng hiện tại của sản phẩm
        let quantity = parseInt(productItem.find('.quantity-display').text());

        // Nếu nút giảm được nhấn và số lượng lớn hơn 1, giảm số lượng đi 1
        if ($(this).hasClass('decrease') && quantity > 1) {
            quantity--;
        } 
        // Nếu nút tăng được nhấn, tăng số lượng lên 1
        else if ($(this).hasClass('increase')) {
            quantity++;
        }

        // Cập nhật lại số lượng hiển thị trên giao diện
        productItem.find('.quantity-display').text(quantity);
        // Lấy giá của sản phẩm
        const price = parseInt(productItem.find('.total-price').data('price'));
        // Cập nhật lại giá sản phẩm sau khi thay đổi số lượng
        productItem.find('.total-price').text((quantity * price).toLocaleString('vi-VN') + '₫');

        // Cập nhật lại tổng giá trị đơn hàng và số lượng giỏ hàng sau khi thay đổi số lượng
        updateTotalPrice();
    });

    // Cập nhật tổng giá trị đơn hàng và số lượng giỏ hàng ngay khi trang được tải
    updateTotalPrice();
});
