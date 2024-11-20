// Ẩn thành phần sản phẩm
$(document).ready(function(){
    $("#toggleIcon").click(function(){
        // Kiểm tra xem phần tử #ingredientsContent có đang ẩn không
        if ($("#ingredientsContent").hasClass("d-none")) {
            // Hiện phần thành phần và đổi icon thành dấu trừ
            $("#ingredientsContent").removeClass("d-none");
            $(this).removeClass("bi-plus").addClass("bi-dash");
        } else {
            // Ẩn phần thành phần và đổi icon thành dấu cộng
            $("#ingredientsContent").addClass("d-none");
            $(this).removeClass("bi-dash").addClass("bi-plus");
        }
    });
});
let quantity = 1;
document.getElementById('decrease').onclick = () => {
    if (quantity > 1) {
        quantity--;
        document.getElementById('quantity').textContent = quantity;
    }
};
document.getElementById('increase').onclick = () => {
    quantity++;
    document.getElementById('quantity').textContent = quantity;
};
// đổi ảnh khi nhấp 
const thumbnails = document.querySelectorAll('.img-60px');

// Get the main image element where the larger image will be displayed
const mainImage = document.getElementById('mainImage');

// Attach click event to each thumbnail
thumbnails.forEach((thumbnail) => {
    thumbnail.addEventListener('click', (e) => {
        // Change the source of the main image to the clicked thumbnail's data-large-image value
        mainImage.src = e.target.getAttribute('data-large-image');
    });
});

