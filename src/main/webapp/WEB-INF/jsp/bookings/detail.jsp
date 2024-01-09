<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="../include/header.jsp" %>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/global-style.css">

<div class="container mt-4">
    <h2>Booking Details</h2>
    <div>
        <p><strong>ID:</strong> ${booking.id}</p>
        <p><strong>User ID:</strong> ${booking.user.id}</p>
        <p><strong>Service ID:</strong> ${booking.service.id}</p>
        <p><strong>Employee ID:</strong> ${booking.employee.id}</p>
        <p><strong>Appointment Time:</strong> ${booking.appointmentTime}</p>
    </div>
</div>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@ include file="../include/footer.jsp" %>