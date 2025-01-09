<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="baseLayout">
	<!-- TITLE -->
	<tiles:putAttribute name="titlePage" value="profilePage" />

	<!-- CSS -->
	<tiles:putListAttribute name="pageCss">
		<tiles:addAttribute value="profile" />
	</tiles:putListAttribute>

	<!--SCRIPTS-->
	<tiles:putListAttribute name="pageJs">
		<tiles:addAttribute value="profiles" />
		<tiles:addAttribute value="collapse" />
		<tiles:addAttribute value="user_infor_validate" />
		<tiles:addAttribute value="review" />
	</tiles:putListAttribute>

	<!--AJAX-->
	<tiles:putListAttribute name="pageAjax">
		<tiles:addAttribute value="profiles" />
	</tiles:putListAttribute>

	<!-- BODY -->
	<tiles:putAttribute name="body">
		<main class="my-4">
			<div class="container-fluid">
				<div class="row mt-5">
					<!-- TOOLS PART -->
					<div class="col-3">
						<div class="new-container mt-5">
							<ul class="new-list cursor-pointer">
								<div class="mb-5">
									<c:if test="${not empty account}">
										<i class="bi bi-person"></i>
										<span><strong>Hi! <span>${account.customer.fullName}</span></strong></span>
									</c:if>
								</div>
								<li class="border-top" data-target="account-overview"><i
									class="bi bi-house-door"></i><span> Account Overview</span></li>
								<li data-target="my-details"><i
									class="bi bi-person-lines-fill"></i><span> My Details</span></li>
								<li data-target="order-history"><i class="bi bi-cart-check"></i><span>
										Order History</span></li>
								<li data-target="customer-service"><i class="bi bi-headset"></i><span>
										Customer Service</span></li>
								<li data-target="change-password"><i class="bi bi-key"></i><span>
										Change Password</span></li>
								<li data-target="sign-out"><i class="bi bi-box-arrow-right"></i><span>
										Sign Out</span></li>
							</ul>
						</div>
					</div>
					<!-- INFORMATION PART -->
					<div class="col-9">
						<div class="container mt-5">
							<!-- ACCOUNT OVERVIEW -->
							<div id="account-overview" class="detail-form d-none">
								<h3 class="font-weight-bold h3-color text-center">ACCOUNT
									OVERVIEW</h3>
								<div
									class="border-bottom d-flex justify-content-between align-items-center pb-3">
									<span><strong>Default Address</strong></span>
								</div>
								<div class="mt-4">
									<c:if test="${not empty account}">
										<p>
											<strong>Name:</strong> <span>${account.customer.fullName}</span>
										</p>
										<p>
											<strong>Phone:</strong> <span>${account.customer.phone}</span>
										</p>
										<p>
											<strong>Address:</strong> <span>${account.customer.placeReceive}</span>
										</p>
									</c:if>
									<c:if test="${empty account}">
										<p>No account data found!</p>
									</c:if>
								</div>

							</div>
						</div>
						<!-- CUSTOMER SERVICE -->
						<div id="customer-service" class="detail-form d-none">
							<h3 class="font-weight-bold h3-color">CUSTOMER SERVICE</h3>
							<!-- Add the Bootstrap Icons stylesheet -->
							<div class="container mt-5">
								<div class="service-item">
									<div class="icon-circle">
										<i class="bi bi-telephone"></i>
									</div>
									<div>
										<h5>Phone Customer Services</h5>
										<p class="service-text">020 3805 6666</p>
									</div>
								</div>
								<div class="service-item">
									<div class="icon-circle">
										<i class="bi bi-envelope"></i>
									</div>
									<div>
										<p>Email Customer Services</p>
										<p class="service-text">sales@thewhiskyworld.com</p>
									</div>
								</div>
								<div class="service-item">
									<div class="icon-circle">
										<i class="bi bi-geo-alt"></i>
									</div>
									<div>
										<h5>Registered Address</h5>
										<p class="service-text">90 Oldhill Street, London N16 6NA
											UK</p>
									</div>
								</div>
							</div>
						</div>
						<!-- CHANGE PASSWORD -->
						<div id="change-password" class="detail-form d-none">
							<div class="row">
								<div class="col-8">
									<h3 class="font-weight-bold h3-color text-center">UPDATE
										MY PASSWORD</h3>
									<!-- Current Password -->
									<form id="change-pass-form">
										<div class="form-group mt-5">
											<label for="email">Current password:</label> <input
												type="password" id="current-password"
												name="current-password" class="form-control"
												placeholder="Enter your current password" required>
										</div>
										<!-- New Password -->
										<div class="form-group">
											<label for="email">New password:</label> <input
												type="password" id="new-password" name="new-password"
												class="form-control" placeholder="Enter your new password"
												required>
										</div>
										<!-- Confirm Password -->
										<div class="form-group">
											<label for="email">Confirm password:</label> <input
												type="password" id="confirm-password"
												name="confirm-password" class="form-control"
												placeholder="Enter your new password" required>
										</div>
										<!-- Save Change Button -->
										<button type="submit" class="btn btn-dark w-100 mt-3 ">Save
											Changes</button>
										<!-- NOTIFICATION -->
										<div id="change-pass-success" class="alert alert-success mt-3"
											style="display: none;">Password updated successfully!</div>
										<!-- ERROR -->
										<div id="change-pass-error" class="alert alert-danger mt-3"
											style="display: none;">Error occurred while updating
											password.</div>
									</form>
								</div>
							</div>
						</div>
						<!-- MY DETAILS -->
						<div id="my-details" class="detail-form d-none">
							<div class="row">
								<div class="col-6">
									<h3 class="font-weight-bold h3-color text-center">UPDATE
										MY DETAILS</h3>

									<!-- Full Name Input -->
									<c:if test="${not empty account}">
										<form id="update-info-form">
											<div class="form-group mt-5">
												<label for="full-name">Full Name:</label> <input type="text"
													id="full-name" name="fullName" class="form-control"
													placeholder="Enter your full name"
													value="${account.customer.fullName}" required>
											</div>
											<!-- Email Input -->
											<div class="form-group mt-3">
												<label for="email">Email:</label> <input type="email"
													id="email" name="email" class="form-control"
													placeholder="Enter your email" value="${account.email}"
													required>
											</div>
											<!-- Phone Input -->
											<div class="form-group mt-3">
												<label for="phone">Phone Number:</label> <input type="tel"
													id="phone" name="phone" class="form-control"
													placeholder="Enter your phone number"
													value="${account.customer.phone}" required>
											</div>
											<!-- Address Input -->
											<div class="form-group mt-3">
												<label for="address">Address:</label> <input type="text"
													id="address" name="address" class="form-control"
													placeholder="Enter your address"
													value="${account.customer.placeReceive}" required>
											</div>
											<!-- Save Change Button -->
											<div class="text-center">
												<button type="submit" class="btn btn-dark w-100 mt-3">Save</button>
											</div>
											<!-- NOTIFICATION -->
											<div id="update-info-success"
												class="alert alert-success mt-3" style="display: none;">Account
												info updated successfully!</div>
											<!-- ERROR -->
											<div id="update-info-error" class="alert alert-danger mt-3"
												style="display: none;">Error occurred while updating
												account info.</div>
										</form>
									</c:if>
									<c:if test="${empty account}">
										<p>No account data found!</p>
									</c:if>

								</div>
								<div class="col"></div>
							</div>
						</div>
						<!-- ORDER HISTORY -->
						<div id="order-history" class="detail-form d-none">
							<h3 class="font-weight-bold h3-color text-center">ORDER
								HISTORY</h3>
							<div class="mt-4">
								<!-- Invoice 1 -->
								<div class="border p-3 mb-4">
									<div class="collapse-btn">
										<h5 class="font-weight-bold">Invoice #123456</h5>
										<p>
											<strong>Date:</strong> 2024-12-05
										</p>
										<p>
											<strong>Total Amount:</strong> $150.00
										</p>
										<p>
											<strong>Status:</strong> Completed
										</p>
										<ul class="timeline">
											<li><strong>Order Placed:</strong> 2024-12-01, 09:00 AM</li>
											<li><strong>Payment Confirmed:</strong> 2024-12-01,
												10:00 AM</li>
											<li><strong>Shipped:</strong> 2024-12-02, 03:00 PM</li>
											<li><strong>Delivered:</strong> 2024-12-03, 11:00 AM</li>
										</ul>
										<hr>
									</div>

									<!-- Collapse content for invoice details -->
									<div class="collapse-content">
										<p>
											<strong>Products:</strong>
										</p>
										<div class="mb-3" id="product-list">
											<div class="d-flex align-items-center mb-3">
												<img
													src="https://whisky.vn/wp-content/uploads/2023/10/Glenallachie-15-nhan-moi-300x450.jpg"
													alt="Product A" class="img-thumbnail"
													style="width: 160px; height: auto;">
												<div class="ml-3">
													<p>
														<strong>Product A</strong>
													</p>
													<p>1 x $50.00</p>
													<p>
														<strong>Price:</strong> $50.00
													</p>
													<div class="d-flex flex-column">
														<div class="d-flex align-items-center mb-3">
															<strong>Review:</strong>
															<div class="stars ml-2 stars-selected" data-value="3">
																<span class="star" data-value="1">&#9734;</span> <span
																	class="star" data-value="2">&#9734;</span> <span
																	class="star" data-value="3">&#9734;</span> <span
																	class="star" data-value="4">&#9734;</span> <span
																	class="star" data-value="5">&#9734;</span>
															</div>
														</div>
														<div class="d-flex">
															<button
																class="btn btn-profile mr-2 buy_again-btn disabled-btn">Buy
																again</button>
															<button class="btn btn-profile recieved_order-btn">Recieved</button>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="d-flex align-items-center mb-3">
											<img
												src="https://whisky.vn/wp-content/uploads/2023/10/Glenallachie-12-nhan-moi-300x450.jpg"
												alt="Product B" class="img-thumbnail"
												style="width: 160px; height: auto;">
											<div class="ml-3">
												<p>
													<strong>Product B</strong>
												</p>
												<p>1 x $50.00</p>
												<p>
													<strong>Price:</strong> $50.00
												</p>
												<div class="d-flex flex-column">
													<div class="d-flex align-items-center mb-3">
														<strong>Review:</strong>
														<div class="stars ml-2" data-value="0">
															<span class="star" data-value="1">&#9734;</span> <span
																class="star" data-value="2">&#9734;</span> <span
																class="star" data-value="3">&#9734;</span> <span
																class="star" data-value="4">&#9734;</span> <span
																class="star" data-value="5">&#9734;</span>
														</div>
													</div>
													<div class="d-flex">
														<button
															class="btn btn-profile mr-2 buy_again-btn disabled-btn">Buy
															again</button>
														<button class="btn btn-profile recieved_order-btn">Recieved</button>
													</div>
												</div>
											</div>
										</div>
										<hr>
									</div>
									<p>
										<strong>Total Price:</strong> $<span id="total-price">75.00</span>
									</p>
									<p>
										<strong>Discount:</strong> $<span id="discount">10.00</span>
									</p>
									<p>
										<strong>Total Amount:</strong> $<span id="total-amount">90.00</span>
									</p>
								</div>
							</div>
						</div>
					</div>
					<!-- SIGN OUT -->
					<div id="sign-out" class="detail-form d-none">
						<h3 class="font-weight-bold h3-color">SIGN OUT</h3>
						<p>You have been logged out successfully.</p>
					</div>
				</div>
			</div>
		</main>
	</tiles:putAttribute>
</tiles:insertDefinition>
