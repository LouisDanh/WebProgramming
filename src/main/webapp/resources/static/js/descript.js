/**
 * Update shopping Cart
 */
$(document).ready(function() {
    // Toggle ingredients visibility with icon change
    $("#toggleIcon").click(function() {
        const ingredientsContent = $("#ingredientsContent");
        const isHidden = ingredientsContent.hasClass("d-none");

        // Toggle visibility
        ingredientsContent.toggleClass("d-none", !isHidden);

        // Change the icon
        if (isHidden) {
            $(this).removeClass("bi-plus").addClass("bi-dash");
        } else {
            $(this).removeClass("bi-dash").addClass("bi-plus");
        }
    });

    // Update price based on quantity
    const updatePrice = (quantity) => {
        const basePrice = 4200000;  // Set base price for your product (you can get it from HTML)
        const totalPrice = basePrice * quantity;
        $("#prices").text(totalPrice.toLocaleString('vi-VN') + '₫');
    };

    // Handle quantity changes
    let quantity = 1;  // Default quantity

    // When decrease button is clicked
    $("#decrease").click(function() {
        if (quantity > 1) {
            quantity--;  // Decrease the quantity
            $("#quantity").text(quantity);  // Update the quantity display
            updatePrice(quantity);  // Update price
        }
    });

    // When increase button is clicked
    $("#increase").click(function() {
        quantity++;  // Increase the quantity
        $("#quantity").text(quantity);  // Update the quantity display
        updatePrice(quantity);  // Update price
    });

    // Change main image when thumbnail is clicked
    const thumbnails = document.querySelectorAll('.img-60px');
    const mainImage = document.getElementById('mainImage');

    thumbnails.forEach(thumbnail => {
        thumbnail.addEventListener('click', (e) => {
            mainImage.src = e.target.getAttribute('data-large-image');
        });
    });

    // Initially update price when page loads
    updatePrice(quantity);
});
