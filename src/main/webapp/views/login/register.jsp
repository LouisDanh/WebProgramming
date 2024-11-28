<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create an AP Account</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/register.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/hiddenEye.css">

</head>

<body>
	<jsp:include page="/views/shares/header.jsp"></jsp:include>

	<main>
		<div class="container container-f mt-5">
			<h2 class="text-center mb-4">Create an AP Account</h2>
			<p class="text-center mb-4">Create an account to access exclusive
				features and check your watches in.</p>

			<!-- choose solution -->
			<form id="registerForm">
				<div class="mb-3">
					<label for="salutation" class="form-label">Salutation</label> <select
						class="form-select" id="salutation" required>
						<option selected disabled value="">Choose...</option>
						<option value="Mr">Mr</option>
						<option value="Mrs">Mrs</option>
						<option value="Ms">Ms</option>
					</select>
				</div>

				<div class="mb-3">
					<label for="fullName" class="form-label">Full Name</label> <input
						type="text" class="form-control" id="fullName"
						placeholder="Enter your full name" required>
				</div>

				<div class="mb-3">
					<label for="email" class="form-label">Email</label> <input
						type="email" class="form-control" id="email"
						placeholder="Enter your email address" required>
				</div>

				<!-- Date of Birth -->
				<div class="mb-3">
					<label for="dob" class="form-label">Date of Birth</label> <input
						type="date" class="form-control" id="dob" required>
				</div>

				<!-- Choose your countries -->
				<div class="form-group">
					<label for="location" class="form-label"></label> <select
						class="form-select" id="location" name="location" required>
						<option selected disabled value="">Loading countries...
							<!-- Äang táº£i cÃ¡c quá»c gia... -->
						</option>
					</select>
				</div>

				<div class="row mb-3">
					<div class="col-md-6">
						<label for="password" class="form-label">Create a Password</label>
						<div class="input-group">
							<input type="password" class="form-control" id="password"
								placeholder="Enter your password" required>
							<button type="button" id="toggle-password"
								class="btn position-absolute top-50 end-7 translate-middle-y p-0">
								<i class="bi-eye-slash"></i>
							</button>
						</div>
					</div>
					<div class="col-md-6">
						<label for="confirmPassword" class="form-label">Confirm
							Password</label>
						<div class="input-group">
							<input type="password" class="form-control" id="confirmPassword"
								placeholder="Confirm your password" required>
							<button type="button" id="toggle-password"
								class="btn position-absolute top-50 end-7 translate-middle-y p-0">
								<i class="bi-eye-slash"></i>
							</button>
						</div>
					</div>
				</div>
				<div class="form-check mb-3">
					<input class="form-check-input" type="checkbox" id="privacyCheck"
						required> <label class="form-check-label"
						for="privacyCheck"> I acknowledge that my personal data
						will be processed in accordance with Audemars Piguet Privacy
						Notice. </label>
				</div>

				<button type="submit" class="btn btn-dark w-100">Create an
					Account</button>
			</form>

			<p class="text-center mt-3">
				Already have an account? <a
					href="${pageContext.request.contextPath}/views/login/login.jsp">Log
					in</a>

			</p>
		</div>
	</main>
	<script>document.addEventListener('DOMContentLoaded', function () {
		    const locationSelect = document.getElementById('location');

		    // Function to fetch countries and populate the select dropdown
		    async function fetchCountries() {
		        try {
		            // Fetch countries from the API
		            const response = await fetch('https://restcountries.com/v3.1/all');
		            const countries = await response.json();

		            // Clear any existing options (in case the page is reloaded)
		            locationSelect.innerHTML = '<option selected disabled value="">Choose a country...</option>';

		            // Loop through the countries and create option elements
		            countries.forEach(country => {
		                const option = document.createElement('option');
		                option.value = country.name.common;  // Set the country name as the value
		                option.textContent = country.name.common;  // Set the country name as the displayed text
		                locationSelect.appendChild(option);
		            });
		        } catch (error) {
		            console.error('Error fetching countries:', error);
		            locationSelect.innerHTML = '<option selected disabled value="">Failed to load countries</option>';
		        }
		    }

		    // Call the function to fetch countries when the page is loaded
		    fetchCountries();
		});
	</script>

	<script
		src="${pageContext.request.contextPath}/resources/static/js/hiddenEye.js"
		type="text/javascript">
	</script>

	<footer><jsp:include page="/views/shares/footer.jsp"></jsp:include></footer>

</body>

</html>