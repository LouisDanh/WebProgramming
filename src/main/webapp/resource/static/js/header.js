/**
 * Ẩn hiện danh mục
 */
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
document.querySelector('body').addEventListener('mouseleave', closeAllSubCategories);
/**
 * Ẩn hiện thanh tìm kiếm
 */
function toggleSearchBar() {
	const searchBar = document.getElementById("search-bar");
	searchBar.classList.toggle("d-none"); // Thêm/loại bỏ class 'd-none' để hiển thị/ẩn thanh tìm kiếm
}

// Đóng thanh tìm kiếm nếu nhấn ra ngoài nó
document.addEventListener("click", function(event) {
	const searchBar = document.getElementById("search-bar");
	const searchIcon = document.querySelector(".fas.fa-search");

	// Kiểm tra xem người dùng có nhấn ngoài thanh tìm kiếm và biểu tượng tìm kiếm không
	if (!searchBar.contains(event.target) && !searchIcon.contains(event.target)) {
		searchBar.classList.add("d-none"); // Ẩn thanh tìm kiếm nếu nhấn ra ngoài
	}
});

// Gắn sự kiện click vào biểu tượng tìm kiếm, đảm bảo rằng biểu tượng tồn tại
const searchIcon = document.querySelector(".fas.fa-search");
if (searchIcon) {
	searchIcon.addEventListener("click", function(event) {
		event.stopPropagation();  // Ngừng sự kiện click để không bị lan truyền ra ngoài
		toggleSearchBar();        // Toggle (hiển thị/ẩn) thanh tìm kiếm khi nhấn vào biểu tượng
	});
}
// Icon đăng xuất
const logoutIcon = document.getElementById('logoutIcon');

// Thêm sự kiện click cho biểu tượng logout
logoutIcon.addEventListener('click', function() {
	// Khi nhấn vào biểu tượng, trang sẽ chuyển hướng đến trang đăng nhập (có thể thay đổi URL theo nhu cầu)
	window.location.href = 'login.html';  // Thay đổi URL này nếu muốn chuyển đến trang khác
});/**
 * 
 */// Gắn sự kiện click vào biểu tượng logout
document.getElementById('logoutIcon').addEventListener('click', function () {
    // Điều hướng tới đường dẫn logout
    window.location.href = "${pageContext.request.contextPath}/views/login/login.jsp"; // Thay '#' bằng đường dẫn logout thực tế
});/**
 * 
 */