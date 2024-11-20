$(document).ready(function() {
    // Toggling ingredients visibility with icon change
    $("#toggleIcon").click(function() {
        const ingredientsContent = $("#ingredientsContent");
        const isHidden = ingredientsContent.hasClass("d-none");

        ingredientsContent.toggleClass("d-none", !isHidden);
        $(this).toggleClass("bi-plus bi-dash", isHidden);
    });

    // Function to update the price for a given product
    const updatePrice = (productElement, quantity) => {
        const priceElement = productElement.find('.total-price');
        const basePrice = parseInt(priceElement.data('price'));
        const totalPrice = basePrice * quantity;
        priceElement.text(totalPrice.toLocaleString('vi-VN') + '₫');
    };

    // Handle Quantity Change for all products
    $('.product-details').each(function() {
        const productElement = $(this);
        let quantity = 1;

        // Event delegation for decrease and increase buttons
        productElement.on('click', '.decrease', function() {
            if (quantity > 1) {
                quantity--;
                productElement.find('.quantity-display').text(quantity);
                updatePrice(productElement, quantity);
            }
        });

        productElement.on('click', '.increase', function() {
            quantity++;
            productElement.find('.quantity-display').text(quantity);
            updatePrice(productElement, quantity);
        });

        // Initial price update on page load
        updatePrice(productElement, quantity);
    });

    // Image change functionality
    const thumbnails = document.querySelectorAll('.img-60px');
    const mainImage = document.getElementById('mainImage');

    thumbnails.forEach(thumbnail => {
        thumbnail.addEventListener('click', (e) => {
            mainImage.src = e.target.getAttribute('data-large-image');
        });
    });
    
    // Price adjustment logic for single product
    let quantity = 1;
    const priceElement = $('#prices');
    const basePrice = parseInt(priceElement.data('price'));

    const updateSingleProductPrice = () => {
        const totalPrice = basePrice * quantity;
        priceElement.text(totalPrice.toLocaleString('vi-VN') + '₫');
    };

    // Decrease quantity for the single product
    $('#decrease').click(function() {
        if (quantity > 1) {
            quantity--;
            $('#quantity').text(quantity);
            updateSingleProductPrice();
        }
    });

    // Increase quantity for the single product
    $('#increase').click(function() {
        quantity++;
        $('#quantity').text(quantity);
        updateSingleProductPrice();
    });

    // Initial price update for the single product
    updateSingleProductPrice();
});

$(document).ready(function() {
    // Function to update the cart count dynamically
    const updateCartCount = () => {
        let totalQuantity = 0;
        
        // Loop through each product and get the quantity value
        $('.product-item').each(function() {
            const quantity = parseInt($(this).find('.quantity-display').text());
            totalQuantity += quantity;
        });
        
        // Update the cart count displayed in the h2
        $('#cart-count').text(`Giỏ hàng của bạn [${totalQuantity}]`);
    };

    // Handle Quantity Change for each product
    $('.product-details').each(function() {
        const productElement = $(this); // Get the current product
        let quantity = 1; // Default quantity

        // Event listener for decrease button
        productElement.find('.decrease').click(function() {
            if (quantity > 1) {
                quantity--;
                productElement.find('.quantity-display').text(quantity); // Update quantity display
                updateCartCount(); // Update the cart count
            }
        });

        // Event listener for increase button
        productElement.find('.increase').click(function() {
            quantity++;
            productElement.find('.quantity-display').text(quantity); // Update quantity display
            updateCartCount(); // Update the cart count
        });

        // Initial cart count update on page load
        updateCartCount();
    });
});
