<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <div class="container-fluid mt-4">
        <div class="container">
            <div class="row">
                <div class="col-2 fs-5">
                    <!-- áº¢nh Äáº¡i diá»n -->
                    <div class="d-flex py-3 align-items-center">
                        <img src="https://www.esteelauder.com/media/export/cms/special-offers/110224-promo-elements/glo_hol001_110224_hp_3up_holiday_bestsellers_fragrance_1366x1366.jpg"
                            alt="" class="avatar-img rounded-circle w-25">
                        <p class="m-0 fw-bold lh-1">TÃªn ngÆ°á»i dÃ¹ng</p>
                    </div>

                    <div class="mt-2">
                        <div class="accordion border-0" id="userMenuAccordion">
                            <!-- TÃ i khoáº£n cá»§a tÃ´i -->
                            <div class="accordion-item border-0">
                                <p class="accordion-header primary-text-color" id="headingAccount">
                                    <button class="collapsed border-0 shadow-none bg-transparent primary-text-color"
                                        type="button" data-bs-toggle="collapse" data-bs-target="#collapseAccount"
                                        aria-expanded="false" aria-controls="collapseAccount">
                                        TÃ i khoáº£n cá»§a tÃ´i
                                    </button>
                                </p>
                                <div id="collapseAccount" class="accordion-collapse collapse"
                                    aria-labelledby="headingAccount" data-bs-parent="#userMenuAccordion">
                                    <div class="accordion-body">
                                        <ul class="list-group list-group-flush fs-6">
                                            <li
                                                class="list-group-item border-0 ps-4 primary-color-hover primary-color-active">
                                                Há» sÆ¡</li>
                                            <li class="list-group-item border-0 ps-4 primary-color-hover ">NgÃ¢n hÃ ng
                                            </li>
                                            <li class="list-group-item border-0 ps-4 primary-color-hover">Äá»a chá»</li>
                                            <li class="list-group-item border-0 ps-4 primary-color-hover">Äá»i máº­t kháº©u
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Lá»ch sá»­ ÄÆ¡n hÃ ng -->
                            <div class="accordion-item border-0">
                                <p class="accordion-header" id="headingOrders">
                                    <button class=" collapsed border-0 shadow-none bg-transparent primary-text-color"
                                        type="button" data-bs-toggle="collapse" data-bs-target="#collapseOrders"
                                        aria-expanded="false" aria-controls="collapseOrders">
                                        Lá»ch sá»­ ÄÆ¡n hÃ ng
                                    </button>
                                </p>
                                <div id="collapseOrders" aria-labelledby="headingOrders"
                                    data-bs-parent="#userMenuAccordion">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col border-1 shadow ms-5">
                    <div class="p-3">
                        <div class="infor-tag">
                            <!-- Header -->
                            <div class="pb-2 border-bottom">
                                <h2 class="text-capitalize">Há» sÆ¡ cá»§a tÃ´i</h2>
                                <p>Quáº£n lÃ½ thÃ´ng tin há» sÆ¡</p>
                            </div>
                            <!-- Form -->
                            <form action="" class="p-3" id="userForm">
                                <div class="d-flex align-items-start gap-5">
                                    <!-- ThÃ´ng tin cÃ¡ nhÃ¢n -->
                                    <table class="table table-borderless align-middle">
                                        <tr>
                                            <td>
                                                <label for="name" class="form-label">TÃªn</label>
                                            </td>
                                            <td>
                                                <input type="text" class="form-control" name="name" id="name"
                                                    placeholder="Nháº­p tÃªn">
                                                <small class="text-danger d-none" id="nameError">Vui lÃ²ng nháº­p
                                                    tÃªn!</small>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="email" class="form-label">Email</label>
                                            </td>
                                            <td>
                                                <input type="email" class="form-control" name="email" id="email"
                                                    placeholder="Nháº­p email">
                                                <small class="text-danger d-none" id="emailError">Vui lÃ²ng nháº­p email
                                                    há»£p lá»!</small>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="phone" class="form-label">Sá» Äiá»n thoáº¡i</label>
                                            </td>
                                            <td>
                                                <input type="text" class="form-control" name="phone" id="phone"
                                                    placeholder="Nháº­p sá» Äiá»n thoáº¡i">
                                                <small class="text-danger d-none" id="phoneError">Vui lÃ²ng nháº­p sá» Äiá»n
                                                    thoáº¡i!</small>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="birthday" class="form-label">NgÃ y sinh</label>
                                            </td>
                                            <td>
                                                <input type="date" class="form-control" name="birthday" id="birthday">
                                                <small class="text-danger d-none" id="birthdayError">Vui lÃ²ng chá»n ngÃ y
                                                    sinh!</small>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td>
                                                <button type="button" id="submitButton"
                                                    class="primary-color-btn page-infor-btn">LÆ°u</button>
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- Äá»i áº£nh -->
                                    <div class="card border-0 w-50 text-center">
                                        <img src="https://via.placeholder.com/150" id="previewImage" alt=""
                                            class="avatar-img rounded-circle w-50 mx-auto">
                                        <div class="card-body">
                                            <label for="imageUpload" class="primary-color-btn page-infor-btn mb-3">Chá»n
                                                áº£nh</label>
                                            <input type="file" id="imageUpload" accept="image/jpeg, image/png"
                                                class="d-none">
                                            <p class="card-text">
                                                <span>Dung lÆ°á»£ng file tá»i Äa: 1 MB</span>
                                                <br>
                                                <span>Äá»nh dáº¡ng: .JPEG, .PNG</span>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="infor-tag d-none">
                            <!-- header -->
                            <div class="pb-3 border-bottom d-flex justify-content-between">
                                <h2 class="text-capitalize">TÃ i khoáº£n NgÃ¢n hÃ ng cá»§a tÃ´i</h2>
                                <button class="primary-color-btn page-infor-btn" data-bs-toggle="modal"
                                    data-bs-target="#addBankModal">
                                    <i class="fa fa-plus me-1"></i>
                                    ThÃªm ngÃ¢n hÃ ng liÃªn káº¿t
                                </button>
                            </div>
                            <!-- body -->
                            <div>
                                <div class="my-2 d-flex justify-content-between border-bottom">
                                    <div>
                                        <h5 class="fs-4">TÃªn ngÃ¢n hÃ ng: <span class="fw-normal">Vietcombank</span></h5>
                                        <p class="m-0 fs-5"><strong>Sá» tÃ i khoáº£n:</strong> 1234 5678 9012
                                            <br> <strong>Chi nhÃ¡nh:</strong> HÃ  Ná»i
                                        </p>
                                    </div>
                                    <button class="remove-bank-btn">
                                        <i class="fa fa-trash fs-5"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="modal fade" id="addBankModal" tabindex="-1" aria-labelledby="addBankModalLabel"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h3 class="modal-title" id="addBankModalLabel">ThÃªm ngÃ¢n hÃ ng</h3>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body fs-4 ">
                                            <form id="add-bank-form">
                                                <div class="mb-3">
                                                    <label for="bank-name" class="form-label">TÃªn ngÃ¢n hÃ ng</label>
                                                    <select class="form-control" id="bank-name" required>
                                                        <option value="">Chá»n ngÃ¢n hÃ ng</option>
                                                        <!-- CÃ¡c tÃ¹y chá»n ngÃ¢n hÃ ng sáº½ ÄÆ°á»£c Äiá»n tá»« API hoáº·c dá»¯ liá»u cá»§a báº¡n -->
                                                        <option value="vietcombank">Vietcombank</option>
                                                        <option value="techcombank">Techcombank</option>
                                                        <option value="acb">ACB</option>
                                                        <!-- ThÃªm cÃ¡c ngÃ¢n hÃ ng khÃ¡c vÃ o ÄÃ¢y -->
                                                    </select>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="bank-account" class="form-label">Sá» tÃ i khoáº£n</label>
                                                    <input type="text" class="form-control" id="bank-account"
                                                        placeholder="Nháº­p sá» tÃ i khoáº£n" required>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="branch" class="form-label">Chi nhÃ¡nh</label>
                                                    <select class="form-control" id="branch" required>
                                                        <option value="">Chá»n chi nhÃ¡nh</option>
                                                        <!-- CÃ¡c tÃ¹y chá»n chi nhÃ¡nh sáº½ ÄÆ°á»£c Äiá»n tá»« API hoáº·c dá»¯ liá»u cá»§a báº¡n -->
                                                        <option value="hanoi">HÃ  Ná»i</option>
                                                        <option value="hochiminh">TP. Há» ChÃ­ Minh</option>
                                                        <option value="danang">ÄÃ  Náºµng</option>
                                                        <!-- ThÃªm cÃ¡c chi nhÃ¡nh khÃ¡c vÃ o ÄÃ¢y -->
                                                    </select>
                                                </div>
                                                <button type="submit" class="primary-color-hoverfs-5">ThÃªm</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="infor-tag d-none">
                            <div class="pb-3 border-bottom">
                                <h2 class="text-capitalize">Äá»a chá» cá»§a tÃ´i</h2>
                                <p>Cáº­p nháº­t vÃ  quáº£n lÃ½ thÃ´ng tin Äá»a chá» giao hÃ ng cá»§a báº¡n.</p>
                            </div>

                            <!-- Form nháº­p Äá»a chá» -->
                            <form action="" class="p-3" id="addressForm">
                                <div class="form-group mb-3">
                                    <label for="fullName" class="form-label">Há» vÃ  tÃªn</label>
                                    <input type="text" class="form-control" name="fullName" id="fullName"
                                        placeholder="Nháº­p há» vÃ  tÃªn">
                                    <small class="text-danger d-none" id="fullNameError">Vui lÃ²ng nháº­p há» vÃ 
                                        tÃªn!</small>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="phoneNumber" class="form-label">Sá» Äiá»n thoáº¡i</label>
                                    <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"
                                        placeholder="Nháº­p sá» Äiá»n thoáº¡i">
                                    <small class="text-danger d-none" id="phoneNumberError">Vui lÃ²ng nháº­p sá» Äiá»n
                                        thoáº¡i!</small>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="address" class="form-label">Äá»a chá»</label>
                                    <input type="text" class="form-control" name="address" id="address"
                                        placeholder="Nháº­p Äá»a chá»">
                                    <small class="text-danger d-none" id="addressError">Vui lÃ²ng nháº­p Äá»a chá»!</small>
                                </div>
                                <div class="d-flex justify-content-end">
                                    <button type="button" id="addressSubmitButton" class="primary-color-btn page-infor-btn">LÆ°u Äá»a
                                        chá»</button>
                                </div>
                            </form>

                            <!-- Tháº» hiá»n thá» Äá»a chá» ÄÃ£ nháº­p -->
                            <div class="pb-3 mt-4" id="addressDisplay" style="display: none;">
                                <h3 class="text-capitalize">ThÃ´ng tin Äá»a chá» ÄÃ£ nháº­p</h3>
                                <p><strong>Há» vÃ  tÃªn:</strong> <span id="displayFullName"></span></p>
                                <p><strong>Sá» Äiá»n thoáº¡i:</strong> <span id="displayPhoneNumber"></span></p>
                                <p><strong>Äá»a chá»:</strong> <span id="displayAddress"></span></p>
                                <!-- NÃºt sá»­a Äá»a chá» -->
                                <button type="button" id="editAddressButton" class="mt-3 primary-color-btn page-infor-btn">Sá»­a Äá»a
                                    chá»</button>
                            </div>
                        </div>

                        <div class="infor-tag d-none">
                            <div class="pb-3 border-bottom">
                                <h2 class="text-capitalize">Äá»i máº­t kháº©u</h2>
                                <p>Cáº­p nháº­t vÃ  thay Äá»i máº­t kháº©u cá»§a báº¡n Äá» báº£o máº­t tÃ i khoáº£n.</p>
                            </div>
                            <form action="" class="p-3" id="passwordForm">
                                <div class="form-group mb-3">
                                    <label for="currentPassword" class="form-label">Máº­t kháº©u hiá»n táº¡i</label>
                                    <input type="password" class="form-control" name="currentPassword"
                                        id="currentPassword" placeholder="Nháº­p máº­t kháº©u hiá»n táº¡i">
                                    <small class="text-danger d-none" id="currentPasswordError">Vui lÃ²ng nháº­p máº­t kháº©u
                                        hiá»n táº¡i!</small>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="newPassword" class="form-label">Máº­t kháº©u má»i</label>
                                    <input type="password" class="form-control" name="newPassword" id="newPassword"
                                        placeholder="Nháº­p máº­t kháº©u má»i">
                                    <small class="text-danger d-none" id="newPasswordError">Vui lÃ²ng nháº­p máº­t kháº©u
                                        má»i!</small>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="confirmPassword" class="form-label">XÃ¡c nháº­n máº­t kháº©u má»i</label>
                                    <input type="password" class="form-control" name="confirmPassword"
                                        id="confirmPassword" placeholder="XÃ¡c nháº­n máº­t kháº©u má»i">
                                    <small class="text-danger d-none" id="confirmPasswordError">Máº­t kháº©u xÃ¡c nháº­n khÃ´ng
                                        khá»p!</small>
                                </div>
                                <div class="d-flex justify-content-end">
                                    <button type="button" id="passwordSubmitButton" class="primary-color-btn page-infor-btn">Äá»i máº­t
                                        kháº©u</button>
                                </div>
                            </form>
                        </div>
                        <div class="infor-tag d-none ">
                            <div class="d-flex flex-column gap-4">
                                <div class="border-bottom pb-3">
                                    <div class="d-flex align-items-center justify-content-between">
                                        <div class="d-flex">
                                            <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lvcrqvyu9pxp3f_tn"
                                                alt="" class="img-80px border p-1">
                                            <div class="ms-3">
                                                <p class="fs-4">TÃªn sáº£n pháº©m</p>
                                                <p>Sá» lÆ°á»£ng</p>
                                            </div>
                                        </div>
                                        <p class="fs-5"><strong>GiÃ¡:</strong> <span>
                                                100000
                                            </span></p>
                                    </div>
                                    <div class="d-flex justify-content-end gap-4">
                                        <!-- Náº¿u ÄÃ£ ÄÃ¡nh giÃ¡ rá»i thÃ¬ biáº¿n thÃ nh mua láº¡i -->
                                        <div class="d-flex align-items-center gap-4 rating-container d-none">
                                            <!-- Sao ÄÃ¡nh giÃ¡ -->
                                            <div class="btn-group" role="group">
                                                <button type="button" class="star" data-value="1">
                                                    <i class="fa fa-star"></i>
                                                </button>
                                                <button type="button" class="star" data-value="2">
                                                    <i class="fa fa-star"></i>
                                                </button>
                                                <button type="button" class="star star-active" data-value="3">
                                                    <i class="fa fa-star"></i>
                                                </button>
                                                <button type="button" class="star" data-value="4">
                                                    <i class="fa fa-star"></i>
                                                </button>
                                                <button type="button" class="star" data-value="5">
                                                    <i class="fa fa-star"></i>
                                                </button>
                                            </div>
                                            <!-- NÃºt há»§y -->
                                            <button class="cancelRating page-infor-btn">Há»§y</button>
                                            <button class="comfirmRating page-infor-btn">XÃ¡c nháº­n</button>
                                        </div>
                                        <button class="primary-color-btn open-rating-container page-infor-btn">ÄÃ¡nh
                                            giÃ¡</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="script.js"></script>
</body>

</html>