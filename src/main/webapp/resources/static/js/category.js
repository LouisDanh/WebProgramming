$(document).ready(function() {
    function toggleSubCategory(category) {
        // Hide all sub-categories
        $('.sub-category').hide();

        // Show or hide the selected category based on its current state
        const selectedCategory = $('#' + category);
        if (selectedCategory.css('display') === 'block') {
            selectedCategory.hide();
        } else {
            selectedCategory.show();
        }
    }

    function closeAllSubCategories() {
        $('.sub-category').hide();
    }

    // Close the sub-categories when mouse leaves the menu
    $('.danhMuc').on('mouseleave', closeAllSubCategories);
});
