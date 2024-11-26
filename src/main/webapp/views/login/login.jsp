<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- ThÃªm Bootstrap CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- ThÃªm Bootstrap Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.min.css"
        rel="stylesheet">
</head>

<body>
    <!-- Login and Create Account Section -->
    <div class="container my-5 pt-5">
        <div class="row justify-content-center">
            <!-- Pháº§n Log in -->
            <div class="col-md-5">
                <h1 class="text-center">Log in</h1>
                <p class="text-center">Don't have an account yet? <a href="/register.html">Sign up</a></p>
                <form id="loginForm" method="post" enctype="multipart/form-data">
                    <!-- TrÆ°á»ng nháº­p email -->
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="email" name="email" placeholder="EMAIL" required>
                        <label for="email">Email</label>
                    </div>
                    <div class="form-floating mb-3 position-relative">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                        <label for="password">Password</label>
                        <!-- NÃºt toggle hiá»n/áº©n máº­t kháº©u -->
                        <button type="button" id="toggle-password" class="btn position-absolute top-50 end-7 translate-middle-y p-0" style="right: 12px; background: none; border: none;">
                            <i class="bi-eye-slash"></i>
                        </button>
                    </div>                    
                    <!-- NÃºt submit -->
                    <div class="text-center"><a href="/forgotPass.html">Forgot password</a></div>
                    <div class="text-center"><button type="submit" class="btn btn-dark btn-block mt-3 w-100"
                            id="submitLoginForm">Log in</button></div>
                </form>
            </div>

            <!-- Pháº§n Create Account -->
            <div class="col-md-5 text-center">
                <h1>Create an AP account</h1>
                <p>Your personal account enables you to check your watches in and benefit from additional exclusive
                    features.</p>
                <a href="/register.html" class="btn btn-dark btn-block mt-3">Create an account</a>
            </div>
        </div>
    </div>


    <!-- Bootstrap JS vÃ  mÃ£ JavaScript tÃ¹y chá»nh -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/js/bootstrap.bundle.min.js"></script>
    <script src="/scripts.js"></script>
</body>

</html>