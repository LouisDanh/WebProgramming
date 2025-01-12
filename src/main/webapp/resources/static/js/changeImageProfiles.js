// Hàm xem trước ảnh khi người dùng chọn ảnh mới
    function previewImage(event) {
        const reader = new FileReader();
        
        reader.onload = function() {
            const output = document.getElementById('profileImagePreview');
            output.src = reader.result;  // Đặt nguồn của ảnh thành ảnh đã chọn
        }
        
        // Đọc ảnh đã chọn dưới dạng URL dữ liệu (base64)
        reader.readAsDataURL(event.target.files[0]);
    }