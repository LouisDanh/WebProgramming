<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giá» HÃ ng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="styles.css"> <!-- LiÃªn káº¿t Äáº¿n file CSS -->
</head>

<body>
    <div class="container mt-5">
        <div class="row align-items-start px-5 d-flex">
            <div class="container mt-5">
                <div class="row">
                    <!-- Cá»t bÃªn trÃ¡i: Danh sÃ¡ch sáº£n pháº©m trong giá» hÃ ng -->
                    <div class="col-8 d-flex flex-column align-items-center">
                        <div class="text-center">
                            <h2 id="cart-count" class="text-center">Giá» hÃ ng cá»§a báº¡n [1]</h2>
                        </div>
                        <div class="cart-items d-flex flex-column align-items-center border p-2">
                            <!-- sp1                   -->
                            <div class="cart-item border-bottom p-2" data-price="4200000">
                                <div class="cart-item-details d-flex gap-5 p-3">
                                    <div class="product-image-wrapper">
                                        <img src="/el_sku_PGJG46_TH_226x311_0.avif" class="product-image">
                                    </div>
                                    <div class="product-info-wrapper d-flex flex-column justify-content-between h-100">
                                        <div class="product-info d-flex justify-content-between mb-3">
                                            <div>
                                                <h6 class="mb-1">Synchronized Multi-Recovery Complex</h6>
                                                <p class="text-muted mb-0">KÃ­ch thÆ°á»c: 75ml</p>
                                            </div>
                                        </div>
                                        <div class="quantity-controls d-flex align-items-center gap-0">
                                            <!-- Giáº£m sá» lÆ°á»£ng -->
                                            <div class="quantity-btn">
                                                <i class="bi bi-dash decrease"></i>
                                            </div>
                                            <!-- Hiá»n thá» sá» lÆ°á»£ng -->
                                            <div class="quantity-btn">
                                                <span class="quantity-display">1</span>
                                            </div>
                                            <!-- TÄng sá» lÆ°á»£ng -->
                                            <div class="quantity-btn">
                                                <i class="bi bi-plus increase"></i>
                                            </div>
                                            <div class="ms-auto">
                                                <h5 class="text-danger total-price" data-price="4200000" id="price-1">
                                                    4.200.000â«
                                                </h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- sp2                   -->
                            <div class="cart-item border-bottom p-2" data-price="4200000">
                                <div class="cart-item-details d-flex gap-5 p-3">
                                    <div class="product-image-wrapper">
                                        <img src="/el_sku_GXGP01_640x640_0.avif" class="product-image">
                                    </div>
                                    <div class="product-info-wrapper d-flex flex-column justify-content-between h-100">
                                        <div class="product-info d-flex justify-content-between mb-3">
                                            <div>
                                                <h6 class="mb-1">Synchronized Multi-Recovery Complex</h6>
                                                <p class="text-muted mb-0">KÃ­ch thÆ°á»c: 75ml</p>
                                            </div>
                                        </div>
                                        <div class="quantity-controls d-flex align-items-center gap-0">
                                            <!-- Giáº£m sá» lÆ°á»£ng -->
                                            <div class="quantity-btn">
                                                <i class="bi bi-dash decrease"></i>
                                            </div>
                                            <!-- Hiá»n thá» sá» lÆ°á»£ng -->
                                            <div class="quantity-btn">
                                                <span class="quantity-display">1</span>
                                            </div>
                                            <!-- TÄng sá» lÆ°á»£ng -->
                                            <div class="quantity-btn">
                                                <i class="bi bi-plus increase"></i>
                                            </div>
                                            <div class="ms-auto">
                                                <h5 class="text-danger total-price" data-price="3600000" id="price-2">
                                                    3.600.000â«
                                                </h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Cá»t bÃªn pháº£i: ThÃ´ng tin thanh toÃ¡n -->
                    <div class="col">
                        <div class="container mb-4">
                            <!-- Tháº» thanh toÃ¡n -->
                            <div class="card align-items-center p-2 mb-3">
                                <button class="btn btn-dark w-100"><i class="bi bi-lock-fill"></i> Tiáº¿n hÃ nh thanh
                                    toÃ¡n</button>
                                <div>
                                    <i class="bi bi-credit-card card-icon"></i>
                                    <span class="visa">Visa</span>
                                    <i class="bi bi-bank bank-icon"></i>
                                </div>
                            </div>
                            <!-- TÃ³m táº¯t ÄÆ¡n hÃ ng -->
                            <div class="card shadow-sm mb-3">
                                <div class="card-body">
                                    <h3 class="card-title text-center mb-4">TÃ³m táº¯t ÄÆ¡n hÃ ng</h3>
                                    <div
                                        class="d-flex justify-content-between align-items-center border-bottom pb-3 mb-3">
                                        <span class="font-weight-bold">Táº¡m tÃ­nh:</span>
                                        <span id="total-amount" class="font-weight-bold text-success">4.950.000â«</span>
                                    </div>
                                    <div
                                        class="d-flex justify-content-between align-items-center border-bottom pb-3 mb-3">
                                        <span class="font-weight-bold">Giao hÃ ng:</span>
                                        <span class="text-muted">Giao hÃ ng tiÃªu chuáº©n (Miá»n phÃ­)</span>
                                    </div>
                                    <div class="d-flex justify-content-between align-items-center border-top pt-3">
                                        <span class="font-weight-bold">Tá»ng giÃ¡ trá» ÄÆ¡n hÃ ng:</span>
                                        <span class="font-weight-bold text-danger" id="final-total">4.950.000â«</span>
                                    </div>
                                </div>
                            </div>
                            <!-- MÃ£ Æ°u ÄÃ£i -->
                            <div class="card p-3 mb-3 shadow-sm rounded">
                                <div class="row g-2 align-items-center">
                                    <div class="col-8">
                                        <div class="form-floating">
                                            <input type="text" id="voucher" class="form-control" placeholder=" " />
                                            <label for="voucher">NHáº¬P MÃ Æ¯U ÄÃI</label>
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <button type="button" class="btn btn-dark primary-color-hover">Ãp dá»¥ng</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/scripts.js"></script>

</body>

</html>