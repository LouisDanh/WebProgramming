/**
 * 
 */
//show tabled product
           const tabledProducts = document.getElementsByClassName("tabled-products");
           const containerTabled = document.getElementsByClassName("tabled-product-detail");

           //event tabled
           {

               // Hàm để cập nhật lớp "fw-bold" cho tab được chọn
               function updateTabHighlight(selectedElement) {
                   for (const element of tabledProducts) {
                       element.classList.remove("fw-bold");
                   }
                   selectedElement.classList.add("fw-bold");
               }

               // Hàm để hiển thị danh sách sản phẩm  tương ứng với tab được chọn
               function showContainerTabled(index) {
                   for (let i = 0; i < containerTabled.length; i++) {
                       containerTabled[i].classList.toggle("d-none", i !== index);
                   }
               }

           }
           // Gán sự kiện click cho từng tab
           for (let i = 0; i < tabledProducts.length; i++) {
               tabledProducts[i].addEventListener("click", () => {
                   updateTabHighlight(tabledProducts[i]); // Cập nhật tab được chọn
                   showContainerTabled(i); // Hiển thị container tương ứng
               });
           }