<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Description</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/styles.css">
</head>

<body>
    <div class="container mt-5">
        <div class="row">
            <!-- Pháº§n hiá»n thá» áº£nh sáº£n pháº©m, chiáº¿m 2 cá»t -->
            <div class="col-2 d-flex justify-content-start align-items-center flex-column px-2 gap-3">
                <img src="/product1.png" alt="Image 1" class="img-60px " data-large-image="/product1.png">
                <img src="/el_sku_G1VH01_308x424_0.avif" alt="Image 2" class="img-60px " data-large-image="/el_sku_G1VH01_308x424_0.avif">
                <img src="/el_sku_PG5201_226x311_0.avif" alt="Image 3" class="img-60px " data-large-image="/el_sku_PG5201_226x311_0.avif">
                <img src="/el_sku_G1VH01_308x424_0.avif" alt="Image 4" class="img-60px " data-large-image="/el_sku_G1VH01_308x424_0.avif">
                <!-- CÃ³ thá» thÃªm nhiá»u áº£nh sáº£n pháº©m khÃ¡c á» ÄÃ¢y -->
            </div>
        
            <!-- Pháº§n chi tiáº¿t sáº£n pháº©m, chiáº¿m pháº§n cÃ²n láº¡i -->
            <div class="col">
                <div class="row">
                    <!-- Chi tiáº¿t thÃ nh pháº§n sáº£n pháº©m -->
                    <div class="col">
                        <div class="container d-flex justify-content-center align-items-center">
                            <div class="image-container d-flex justify-content-center align-items-center" style="width: 526px; height: 526px;">
                                <img id="mainImage" src="/product1.png" alt="Product Detail" class="img-fluid">
                            </div>
                        </div>                                    
                        <!-- Pháº§n thÃ nh pháº§n sáº£n pháº©m -->
                        <div class="border-bottom">
                            <div class="d-flex justify-content-between align-items-center">
                                <h2 class="fw-bold">ThÃ nh pháº§n</h2> <!-- Sá»­ dá»¥ng fw-bold Äá» lÃ m Äáº­m tiÃªu Äá» -->
                                <div class="tang-kich-thuoc-plus">
                                    <i class="bi bi-plus" id="toggleIcon"></i>
                                </div>
                            </div>
                            <!-- ThÃ´ng tin chi tiáº¿t thÃ nh pháº§n sáº£n pháº©m, máº·c Äá»nh áº©n -->
                            <div id="ingredientsContent" class="d-none">
                                <p class="text-muted">Hydrolyzed Rice Extract, Yeast Extract\Faex\Extrait De Levure,
                                    Hordeum Vulgare Extract\Extrait D'Orge, Anthemis Nobilis (Chamomile) Flower Extract,
                                    Cucumis Sativus (Cucumber) Fruit Extract, Helianthus Annuus (Sunflower) Seed
                                    Extract, Sorbitol, Potassium Palmitoyl Hydrolyzed Wheat Protein, Propylene Glycol
                                    Dicaprate, Maltodextrin, Steareth-21, Dimethicone Crosspolymer-3, Steareth-2,
                                    Hexylene Glycol, Xanthan Gum, Caprylyl Glycol, Ethylhexylglycerin, Glucose, Bht,
                                    Disodium Edta, Phenoxyethanol, Sodium Dehydroacetate, Potassium Sorbate, Yellow 5
                                    (Ci 19140), Red 4 (Ci 14700)</p>
                                <p class="text-muted">Xin lÆ°u Ã½ ráº±ng danh sÃ¡ch thÃ nh pháº§n cÃ³ thá» thay Äá»i hoáº·c thay Äá»i
                                    theo thá»i gian. Vui lÃ²ng tham kháº£o danh sÃ¡ch thÃ nh pháº§n trÃªn gÃ³i sáº£n pháº©m báº¡n nháº­n
                                    ÄÆ°á»£c Äá» biáº¿t danh sÃ¡ch thÃ nh pháº§n cáº­p nháº­t nháº¥t.</p>
                            </div>
                        </div>
                    </div>
                    <!-- Pháº§n thÃ´ng tin vÃ  mua sáº£n pháº©m -->
                    <div class="col">
                        <div class="text-center mt-5">
                            <!-- TÃªn sáº£n pháº©m (sá»­ dá»¥ng h1 cho tiÃªu Äá» chÃ­nh) -->
                            <h3>ANR ECLIPSE-WN</h3> <!-- Sá»­ dá»¥ng display-4 Äá» tÄng cá»¡ chá»¯ cho tÃªn sáº£n pháº©m -->
                            <h4 class="text-center fw-bold" id="prices"> 4.200.000 â«</h4>
                            <div class="d-flex justify-content-center align-items-center gap-3 mb-3">
                                <p class="mb-0 fw-bold">SLG</p> <!-- Sá»­ dá»¥ng fw-bold Äá» lÃ m Äáº­m tá»« SLG -->
                                <!-- Container for quantity controls (minus, quantity, plus) -->
                                <div class="d-flex align-items-center gap-0">
                                    <!-- Ã vuÃ´ng chá»©a dáº¥u trá»« (giáº£m sá» lÆ°á»£ng) -->
                                    <div class="border p-0" style="width: 40px; height: 40px;">
                                        <i id="decrease"
                                            class="bi bi-dash w-100 h-100 d-flex justify-content-center align-items-center"></i>
                                    </div>
                                    <!-- Ã vuÃ´ng chá»©a sá» lÆ°á»£ng -->
                                    <div class="border p-0" style="width: 40px; height: 40px;">
                                        <span
                                            class="text-center w-100 h-100 d-flex justify-content-center align-items-center"
                                            id="quantity">1</span>
                                    </div>
                                    <!-- Ã vuÃ´ng chá»©a dáº¥u cá»ng (tÄng sá» lÆ°á»£ng) -->
                                    <div class="border p-0" style="width: 40px; height: 40px;">
                                        <i id="increase"
                                            class="bi bi-plus w-100 h-100 d-flex justify-content-center align-items-center"></i>
                                    </div>
                                </div>
                                <!-- NÃºt thÃªm vÃ o giá» hÃ ng vá»i khoáº£ng cÃ¡ch -->
                                <button class="btn btn-dark ms-3">ThÃªm vÃ o giá» hÃ ng</button>
                            </div>
                        </div>
                        <!-- ThÃ´ng tin giao hÃ ng miá»n phÃ­ -->
                        <div class="text-center">
                            <p class="mb-0 text-muted">Giao hÃ ng tiÃªu chuáº©n miá»n phÃ­ vÃ  tráº£ láº¡i</p>
                            <!-- Sá»­ dá»¥ng text-muted Äá» lÃ m nháº¡t mÃ u chá»¯ cho thÃ´ng tin phá»¥ -->
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