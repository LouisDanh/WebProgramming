<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/search_list_product.css">
</head>

<body>
    <header>
        <jsp:include page="/views/shares/header.jsp"></jsp:include>
    </header>
    <main>
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
            <div class="border-bottom py-3 container">
                <h2 class="fw-bold h1">
                    (Content search)
                </h2>
            </div>
            <div class="row p-4">
                <div class="col-3 hover-dark btn-link mb-1" data-href="${pageContext.request.contextPath}/views/home/descript.jsp">
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
    </main>
    <footer>
        <jsp:include page="/views/shares/footer.jsp"></jsp:include>
    </footer>
    <script type="text/javascript"
    src="${pageContext.request.contextPath}/resources/static/js/filter_category.js"></script>
</body>

</html>