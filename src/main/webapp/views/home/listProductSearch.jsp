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
    <div class="container-fluid position-relative h-395px p-0">
        <div class="h-50 bg-danger">
        </div>
        <div class="search-input-container">
            <form action="" class="search-form">
                <input type="text" placeholder="Search for a movie" class="search-input">
                <button type="submit" class="btn">
                    <i class="fa-solid fa-magnifying-glass search-icon"></i>
                </button>
            </form>
        </div>
        <div class="h-50">

        </div>
    </div>
    <div class="container">
        <!-- Ná»i dung tÃ¬m kiáº¿m -->
        <div class="border-bottom py-3 container">
            <h2 class="fw-bold h1">
                (Ná»i dung tÃ¬m kiáº¿m) Results
            </h2>
        </div>
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
        <!-- káº¿t quáº£ tÃ¬m kiÃ©m -->
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
    <script src="script_link.js"></script>
</body>

</html>