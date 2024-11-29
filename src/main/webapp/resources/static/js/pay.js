// Lắng nghe sự kiện khi người dùng chọn phương thức thanh toán
 document.querySelectorAll('.payment-method').forEach(function(button) {
   button.addEventListener('click', function() {
     // Lấy tên phương thức thanh toán người dùng chọn
     var paymentMethod = this.innerText;

     // Tìm nút "Tiến hành thanh toán" và cập nhật nội dung
     var proceedButton = document.querySelector('.collapse-btn');
     proceedButton.innerHTML = '<i class="bi bi-caret-down-fill"></i> ' + paymentMethod;

     // Đóng các button và nội dung khác (nếu có)
     var collapseContent = document.querySelector('.collapse-content');
     
     // Nếu có các nội dung mở (collapse), đóng chúng
     if (collapseContent) {
       collapseContent.style.display = 'none';  // Đóng nội dung
     }
     
     // Nếu cần, đóng tất cả các nút có class collapse-btn (các button điều khiển)
     var collapseBtns = document.querySelectorAll('.collapse-btn');
     collapseBtns.forEach(function(collapseBtn) {
       collapseBtn.classList.remove('active');  // Loại bỏ class active nếu có
     });
   });
 });