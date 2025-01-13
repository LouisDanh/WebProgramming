<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="baseLayout">
	<!-- TITLE -->
	<tiles:putAttribute name="titlePage" value="pFrofilePage" />

	<!-- CSS -->
	<tiles:putListAttribute name="pageCss">
		<tiles:addAttribute value="profile" />
		<tiles:addAttribute value="imageProfiles" />

	</tiles:putListAttribute>

	<!--SCRIPTS-->
	<tiles:putListAttribute name="pageJs">
		<tiles:addAttribute value="profiles" />
		<tiles:addAttribute value="review" />
		<tiles:addAttribute value="changeImageProfiles" />
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
								<li data-target="change-password"><i class="bi bi-key"></i><span>
										Change Password</span></li>
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
								<div class="container mt-5">
									<c:if test="${not empty account }">
										<div class="d-flex align-items-start">
											<!-- Account Details (Left Side) -->
											<div class="account-details">
												<div class="service-item">
													<div class="icon-circle">
														<i class="bi bi-person"></i>
													</div>
													<div>
														<h5>Name Customer</h5>
														<p class="service-text">${account.customer.fullName}</p>
													</div>
												</div>
												<div class="service-item">
													<div class="icon-circle">
														<i class="bi bi-telephone"></i>
													</div>
													<div>
														<h5>Phone Customer</h5>
														<p class="service-text">${account.customer.phone}</p>
													</div>
												</div>
												<div class="service-item">
													<div class="icon-circle">
														<i class="bi bi-envelope"></i>
													</div>
													<div>
														<h5>Email Customer</h5>
														<p class="service-text">${account.email}</p>
													</div>
												</div>
												<div class="service-item">
													<div class="icon-circle">
														<i class="bi bi-geo-alt"></i>
													</div>
													<div>
														<h5>Registered Address</h5>
														<p class="service-text">${account.customer.placeReceive}</p>
													</div>
												</div>
											</div>
										</div>
									</c:if>
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
							<div class="col-6">
								<h3 class="font-weight-bold h3-color text-center">UPDATE MY
									DETAILS</h3>

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
										<div id="update-info-success" class="alert alert-success mt-3"
											style="display: none;">Account info updated
											successfully!</div>
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
						<div id="order-history" class="detail-form d-none">
							<h3 class="font-weight-bold h3-color text-center">ORDER
								HISTORY</h3>
							<div class="mt-4">
								<c:forEach var="order" items="${orders}">
									<div class="border p-3 mb-4">
										<div class="collapse-btn">
											<h5 class="font-weight-bold">Invoice</h5>
											<c:forEach var="orderDate"
												items="${order.orderDetails.orderDates}">
												<p>
													<strong>Date:</strong>
													<fmt:formatDate value="${orderDate.date}"
														pattern="yyyy-MM-dd HH:mm:ss" />
													AM
												</p>
												<p>
													<strong>Status:</strong>
													${orderDate.orderState.description}
												</p>
											</c:forEach>
											<p>
												<strong>Total Amount:</strong>$${order.totalAmount}
											</p>
											<c:if test="${not empty account }">
												<ul class="timeline">
													<li><strong>Order Placed: </strong>
														${account.customer.placeReceive}</li>
													<li><strong>Payment Confirmed:</strong>
														${order.orderDetails.paymentMethod.name }</li>
													<c:forEach var="orderDate"
														items="${order.orderDetails.orderDates}">
														<li><strong>Shipped:</strong> <fmt:formatDate
																value="${orderDate.date}" pattern="yyyy-MM-dd HH:mm:ss" />
															PM</li>
														<li><strong>Delivered:</strong> <fmt:formatDate
																value="${orderDate.date}" pattern="yyyy-MM-dd HH:mm:ss" />
															PM</li>
													</c:forEach>
												</ul>
											</c:if>
											<hr>
										</div>
										<!-- Collapse content for invoice details -->
										<div class="collapse-content">
											<p>
												<strong>Products:</strong>
											</p>
											<div class="mb-3" id="product-list">
												<c:forEach var="orderItem"
													items="${order.orderDetails.orderItems }">
													<div class="d-flex align-items-center mb-3">
														<img src="${orderItem.product.galleries[0].link }"
															alt="Product A" class="img-thumbnail"
															style="width: 160px; height: auto;">
														<div class="ml-3">
															<p>
																<strong>${orderItem.product.name } </strong>
															</p>
															<p>${orderItem.quantity}x${orderItem.product.price }$</p>
															<p>
																<strong>Price:</strong> $${orderItem.quantity *
																orderItem.product.price}
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
												</c:forEach>
											</div>
											<hr>
										</div>
										<p>
											<strong>Total Price:</strong> $<span id="total-price">${order.totalAmount}</span>
										</p>
										<p>
											<strong>Discount:</strong> % <span id="discount">${order.orderDetails.voucher.percentage}</span>
										</p>
										<p>
											<strong>Total Amount:</strong> $<span id="total-amount">${order.totalAmount}</span>
										</p>
									</div>
								</c:forEach>
							</div>
						</div>
						<!-- ORDER HISTORY -->
					</div>
				</div>
			</div>
		</main>
	</tiles:putAttribute>
</tiles:insertDefinition>
