<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Voucher</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Create New Voucher</h1>
        <form action="${pageContext.request.contextPath}/admin/voucher" method="post" class="p-4 shadow rounded">
            <div class="form-group mb-3">
                <label for="name">Voucher Name</label>
                <input type="text" class="form-control" id="name" name="name" required placeholder="Enter voucher name">
            </div>
            <div class="form-group mb-3">
                <label for="percentage">Discount Percentage</label>
                <input type="number" class="form-control" id="percentage" name="percentage" required step="0.01" min="0" max="100" placeholder="Enter discount percentage">
            </div>
            <div class="form-group mb-3">
                <label for="maxDiscount">Max Discount</label>
                <input type="number" class="form-control" id="maxDiscount" name="maxDiscount" required step="0.01" min="0" placeholder="Enter max discount">
            </div>
            <div class="form-group mb-3">
                <label for="expiredDate">Expiration Date</label>
                <input type="datetime-local" class="form-control" id="expiredDate" name="expiredDate" required placeholder="Enter expiration date">
            </div>
            <div class="form-group mb-3">
                <label for="quantity">Quantity</label>
                <input type="number" class="form-control" id="quantity" name="quantity" required min="1" placeholder="Enter quantity">
            </div>
            <div class="form-group mb-3">
                <label for="code">Voucher Code</label>
                <input type="text" class="form-control" id="code" name="code" required placeholder="Enter voucher code">
            </div>
            <button type="submit" class="btn btn-primary w-100">Create Voucher</button>
        </form>
    </div>
</body>
</html>
