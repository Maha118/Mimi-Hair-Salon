<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/global-style.css">
<%@ include file="../include/header.jsp" %>

<h1>Service Detail</h1>
<div class="container mt-5">
    <h2>Service Information</h2>
    <table class="table table-bordered">
        <tr>
            <th>Service ID</th>
            <td>${service.id}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${service.name}</td>
        </tr>
        <tr>
            <th>Description</th>
            <td>${service.description}</td>
        </tr>
        <tr>
            <th>Price</th>
            <td>${service.price}</td>
        </tr>
    </table>
</div>

<!-- Display Booking Information -->
<h2>Booking Information</h2>
<div class="container mt-3">
    <table class="table table-bordered">
        <tr>
            <th>Customer Name</th>
            <td>${booking.customerName}</td>
        </tr>
        <tr>
            <th>Booking Date</th>
            <td>${booking.date}</td>
        </tr>
        <tr>
            <th>Price</th>
            <td>${booking.price}</td>
        </tr>
        <!-- Add more booking details as needed -->
    </table>
</div>

<%@ include file="../include/footer.jsp" %>