
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
