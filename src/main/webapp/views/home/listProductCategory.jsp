<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <div class="container-fluid">
        <div class="p-5 w-100 h-50"></div>
        <div class="container">
            <h1 class="title-category">
                Danh má»¥c lá»n
            </h1>
            <p class="fs-15rem fw-light">
                NÃ¢ng táº§m váº» Äáº¹p tá»± nhiÃªn cho da báº¡n má»i ngÃ y vá»i cÃ¡c sáº£n pháº©m chÄm sÃ³c da máº·t cá»§a L'OrÃ©al Paris. CÃ¡c
                phÆ°Æ¡ng phÃ¡p trá» liá»u cá»§a chÃºng tÃ´i káº¿t há»£p cÃ¡c loáº¡i lotion, máº·t náº¡ vÃ  kem dÆ°á»¡ng áº©m giÃºp báº¡n táº¡o nÃªn má»t
                thÃ³i quen chÄm sÃ³c da phÃ¹ há»£p vá»i báº£n thÃ¢n vÃ  loáº¡i da cá»§a báº¡n. Chuáº©n bá» sáºµn sÃ ng Äá» ÄÃ³n nháº­n cÃ¡c loáº¡i
                dÆ°á»¡ng cháº¥t phÃ¹ há»£p nháº¥t cÅ©ng Äá»ng nghÄ©a vá»i viá»c bÆ°á»c Äáº§u tiÃªn báº¡n cáº§n lÃ m lÃ  táº©y trang. CÃ¡c loáº¡i kem,
                gel rá»­a máº·t, lotion, nÆ°á»c cÃ¢n báº±ng da: Lá»±a chá»n káº¿t cáº¥u sáº£n pháº©m phÃ¹ há»£p vá»i loáº¡i da cá»§a báº¡n vÃ  giÃºp da
                thanh lá»c vá»i cÃ¡c sáº£n pháº©m táº©y táº¿ bÃ o cháº¿t hoáº·c máº·t náº¡ tÆ°Æ¡ng ÄÆ°Æ¡ng. LÃ  má»t táº­p há»£p thá»±c cháº¥t cá»§a cÃ¡c
                thÃ nh pháº§n hoáº¡t tÃ­nh, tinh cháº¥t lÃ m giÃ u da vá»i cÃ¡c thÃ nh pháº§n hoáº¡t Äá»ng cÃ³ tÃ­nh má»¥c tiÃªu vÃ  chuáº©n bá»
                cho da sáºµn sÃ ng tiáº¿p nháº­n cÃ¡c bÆ°á»c chÄm sÃ³c tiáº¿p theo. Da khÃ´, da há»n há»£p hoáº·c da dáº§u cáº§n kem dÆ°á»¡ng da
                ban ngÃ y vÃ  kem dÆ°á»¡ng da ban ÄÃªm phÃ¹ há»£p vá»i tá»«ng loáº¡i da. Nhá»¯ng kem dÆ°á»¡ng da máº·t nÃ y ÄÃ¡p á»©ng cÃ¡c nhu
                cáº§u cá»§a da nhÆ° chá»ng lÃ£o hÃ³a, dÆ°á»¡ng áº©m hoáº·c kiá»m soÃ¡t bÃ³ng dáº§u. Kem dÆ°á»¡ng cá»§a chÃºng tÃ´i cÃ²n há» trá»£ pháº§n
                viá»n máº¯t, vÃ¹ng da má»ng manh cáº§n quy trÃ¬nh chÄm sÃ³c Äáº·c biá»t vá»i cÃ¡c tinh cháº¥t dá»u nháº¹ Äáº·c thÃ¹. LÃ n da
                cá»§a báº¡n sáº½ trá» nÃªn ráº¡ng rá»¡, tinh khiáº¿t vÃ  má»n mÃ ng hÆ¡n vá»i dÃ²ng sáº£n pháº©m chÄm sÃ³c da cá»§a L'OrÃ©al Paris
            </p>
        </div>
        <div class="py-5 w-75 m-auto h-50">
            <!-- button má» thanh filter -->
            <div class="d-flex justify-content-between align-items-center shadow fs-4 fw-bold">
                <p class="p-4 m-0"><span>(25)</span> Káº¿t quáº£</p>
                <div id="filter-product" class="px-5 py-4 bg-dark text-white cursor-pointer " data-bs-toggle="collapse"
                    data-bs-target="#filter-content" aria-expanded="false" aria-controls="filter-content">
                    <span class="me-2">Cá»¥ thá» nhu cáº§u cá»§a tÃ´i</span>
                    <i class="fa-solid fa-filter"></i>
                </div>
            </div>
            <div class="collapse bg-dark text-white p-5 no-transition shadow" id="filter-content">
                <!-- cÃ¡c  lá»±a chá»n liÃªn quan tá»i nhÃ³m sáº£n pháº©m -->
                <div class="p-4">
                    <h3 class="mb-4">Loáº¡i sáº£n pháº©m</h3>
                    <div class="d-flex flex-wrap gap-4 cursor-pointer">
                        <div class="border border-white filter-item">
                            <p class="p-3  m-0">Ná»i dung bÃªn trong <span>(Sá» lÆ°á»£ng)</span></p>
                        </div>
                    </div>
                </div>
                <div class="d-flex align-items-center p-4">
                    <p class="fs-4 m-0">DÃ²ng sáº£n pháº©m</p>
                    <!-- hiá»n thá» brand -->
                    <div class="dropdown w-50 ms-3 cursor-default ">
                        <div class="d-flex justify-content-between align-items-center border-bottom py-2 px-3 dropdown-toggle"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            <div class="fw-bold fs-5 m-0 text-wrap d-flex">
                                <span class="me-2">Brand</span>
                                <span id="dropdown-text-brand"></span>
                            </div>
                            <i class="bi bi-chevron-down"></i>
                        </div>
                        <!-- chá»n brand -->
                        <div class="dropdown-menu w-100 shadow-lg fs-5 p-0 border-radius-1">
                            <div class="dropdown-item disabled text-muted dropdown-brand-item">
                                Brand</div>
                            <div class="dropdown-item dropdown-brand-item">Glycolic Bright
                                <span>(Sá» lÆ°á»£ng)</span>
                            </div>
                            <div class="dropdown-item dropdown-brand-item">DÆ°á»¡ng tráº¯ng da Aura
                                Perfect <span>(Sá» lÆ°á»£ng)</span></div>
                            <div class="dropdown-item dropdown-brand-item">Revitalift <span>(Sá» lÆ°á»£ng)</span>
                            </div>
                            <div class="dropdown-item dropdown-brand-item">Youth Code <span>(Sá» lÆ°á»£ng)</span>
                            </div>
                            <div class="dropdown-item dropdown-brand-item pb-1 border-radius-1">Giáº£m thÃ¢m nÃ¡m Aura
                                Perfect Clinical <span>(Sá» lÆ°á»£ng)</span></div>
                        </div>
                    </div>
                </div>
                <!-- button filter -->
                <div class="p-4 d-flex align-items-center justify-content-end">
                    <button id="filter-remove-button">
                        <span class="me-2">XÃ³a toÃ n bá»</span>
                        <i class="fa-solid fa-xmark"></i>
                    </button>
                    <button id="filter-submit-button" data-bs-toggle="collapse" data-bs-target="#filter-content"
                        aria-expanded="false" aria-controls="filter-content">
                        Xong
                    </button>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row p-4">
                <div class="col-3 hover-dark div-link mb-1" data-href="https://www.w3schools.com/">
                    <div class="card border-0 text-center">
                        <img src="https://www.lorealparisusa.com/-/media/project/loreal/brand-sites/oap/americas/us/products/makeup/lip-color/lipstick/les-nus-intense-lipstick-intensely-pigmented/nu-impertinent/les-nus-impertinent-173-071249421758-primary.png?rev=b599fdaa54c046b58c6f5f54041e78c5&w=200&hash=37DCDDDD3E18F314410CE9365B2CECAF1A136492"
                            alt="" class="img-card-top img-300px">
                        <div class="card-body">
                            <h6 class="subtitle">Superior Preference</h6>
                            <h4 class="title">Cool Blonde Fade-Defying Shine Permanent Hair Color</h4>
                        </div>
                        <div class="card-footer border-0 bg-transparent">
                            <p class="card-text">
                                11.99
                            </p>
                            <div class="d-flex gap-1 justify-content-center">
                                <span class="text-dark"><i class="fa-solid fa-star"></i></span>
                                <span class="text-dark"><i class="fa-solid fa-star"></i></span>
                                <span class="text-dark"><i class="fa-solid fa-star"></i></span>
                                <span class="text-dark"><i class="fa-solid fa-star"></i></span>
                                <span class="text-secondary"><i class="fa-solid fa-star"></i></span>
                                <span class="ms-2">4/5</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

    <script src="script.js"></script>

</body>

</html>