<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Employee Detail</h1>
            </div>
        </div>
    </div>
</section>

<section>
    <b class="text-center"><%@ include file="businessMessage.jsp"%></b>
    			<table class="table table-striped table table-dark">
    				<tr>

    					<th scope="col">First Name</th>
    					<th scope="col">Last Name</th>
    					<th scope="col">Phone</th>
    					<th scope="col">Speciality</th>

    				</tr>

    				<c:forEach items="${list}" var="userlist">

    					<tr>

                            <td>${userlist.FirstName}</td>
                            <td>${userlist.Last Name}</td>
                            <td>${userlist.phone}</td>
                            <td>${userlist.Speciality}</td>
    					</tr>
    				</c:forEach>

    			</table>
    </section>

<jsp:include page="../include/footer.jsp"/>