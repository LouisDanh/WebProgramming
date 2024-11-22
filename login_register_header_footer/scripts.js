// Hàm để toggle hiển thị danh mục con khi nhấn
function toggleSubCategory(category) {
    const subCategories = document.querySelectorAll('.sub-category');
    
    subCategories.forEach(function (subCategory) {
        // Ẩn tất cả danh mục con
        subCategory.style.display = 'none';
    });

    // Lấy danh mục con được chọn
    const selectedCategory = document.getElementById(category);

    // Kiểm tra xem danh mục con đã hiển thị hay chưa, nếu có thì ẩn, nếu không thì hiển thị
    if (selectedCategory.style.display === 'block') {
        selectedCategory.style.display = 'none';
    } else {
        selectedCategory.style.display = 'block';
    }
}

// Hàm đóng danh mục con khi chuột di chuyển ra ngoài
function closeAllSubCategories() {
    const subCategories = document.querySelectorAll('.sub-category');
    subCategories.forEach(function (subCategory) {
        subCategory.style.display = 'none';
    });
}

// Thêm sự kiện `mouseleave` vào phần tử menu để đóng danh mục con khi di chuột ra ngoài
document.querySelector('.navbar-nav').addEventListener('mouseleave', closeAllSubCategories);
// Function to show the search form

// Toggle the visibility of the search bar when clicking the icon
function toggleSearchBar() {
    const searchBar = document.getElementById("search-bar");
    searchBar.classList.toggle("d-none"); // Toggles the 'd-none' class to show/hide the search bar
}

// Close the search bar if clicked anywhere outside of it
document.addEventListener("click", function(event) {
    const searchBar = document.getElementById("search-bar");
    const searchIcon = document.querySelector(".fas.fa-search");

    // Check if the click was outside the search bar and the search icon
    if (!searchBar.contains(event.target) && !searchIcon.contains(event.target)) {
        searchBar.classList.add("d-none"); // Hide the search bar
    }
});

// Attach the toggleSearchBar function to the search icon
document.querySelector(".fas.fa-search").addEventListener("click", function(event) {
    event.stopPropagation();  // Prevent the click event from propagating to the document
    toggleSearchBar();
});


