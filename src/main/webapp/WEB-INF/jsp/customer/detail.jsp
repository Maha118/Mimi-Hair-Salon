<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/global-style.css">
<%@ include file="../include/header.jsp" %>

 <h1>Customer Detail</h1>

    <h2>Customer Information:</h2>
    <table>
        <tr>
            <th>ID:</th>
            <td>${customer.id}</td>
        </tr>
        <tr>
            <th>First Name:</th>
            <td>${customer.firstName}</td>
        </tr>
        <tr>
            <th>Last Name:</th>
            <td>${customer.lastName}</td>
        </tr>
        <tr>
            <th>Phone:</th>
            <td>${customer.phone}</td>
        </tr>
        <tr>
            <th>City:</th>
            <td>${customer.city}</td>
        </tr>
    </table>

    <h2>Booking Information:</h2>
    <table>
        <tr>
            <th>Booking ID:</th>
            <td>${booking.id}</td>
        </tr>
        <tr>
            <th>Customer Name:</th>
            <td>${booking.customerName}</td>
        </tr>
        <tr>
            <th>Service:</th>
            <td>${booking.service}</td>
        </tr>
        <tr>
            <th>Date:</th>
            <td>${booking.date}</td>
        </tr>
        <tr>
            <th>Status:</th>
            <td>${booking.status}</td>
        </tr>
    </table>
<%@ include file="../include/footer.jsp" %>