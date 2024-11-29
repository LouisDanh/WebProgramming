function toggleSubCategory(category) {
    const subCategories = document.querySelectorAll('.sub-category');

    subCategories.forEach(function(subCategory) {
        // Hide all sub-categories
        subCategory.style.display = 'none';
    });

    // Get the selected category
    const selectedCategory = document.getElementById(category);

    // Show or hide the selected category based on its current state
    if (selectedCategory.style.display === 'block') {
        selectedCategory.style.display = 'none';
    } else {
        selectedCategory.style.display = 'block';
    }
}

function closeAllSubCategories() {
    const subCategories = document.querySelectorAll('.sub-category');
    subCategories.forEach(function(subCategory) {
        subCategory.style.display = 'none';
    });
}

// Close the sub-categories when mouse leaves the menu
document.querySelector('.danhMuc').addEventListener('mouseleave', closeAllSubCategories);
