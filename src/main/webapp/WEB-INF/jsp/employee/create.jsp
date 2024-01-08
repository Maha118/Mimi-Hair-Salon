<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Create New Employee</h1>
            </div>
        </div>
    </div>

</section>

 <section class="pt-5 pb-5">
   <div class="container">
       <c:if test="${not empty success}">
           <div class="row justify-content-center">
               <div class="col-6 text-center">
                   <div class="alert alert-success" role="alert">
                           ${success}
                   </div>
               </div>
           </div>
           </c:if>
     <form method="get" action="/employee/createSubmit">
               <input type="hidden" name="id" value="${form.id}">
        <div class="mb-3">
            <label for="firstName" class="form-label">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" aria-describedby="firstNameHelp" value="${form.firstName}">
            <div id="firstNameHelp" class="form-text">Please let us know your first name</div>
        </div>
            <c:if test="${errors.hasFieldErrors('firstName')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('firstName')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
           </c:if>
        <div class="mb-3">
            <label for="lastName" class="form-label">Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" value="${form.lastName}">
        </div>
             <c:if test="${errors.hasFieldErrors('lastName')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('lastName')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>
            <div class="mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${form.phone}">
            </div>
            <c:if test="${errors.hasFieldErrors('phone')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('phone')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>
            <div class="mb-3">
                <label for="speciality" class="form-label">Speciality</label>
                <input type="text" class="form-control" id="speciality" name="speciality" value="${form.speciality}">
            </div>
            <c:if test="${errors.hasFieldErrors('speciality')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('city')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

                <div class="mt-3">
                    <label for="imageUrl" class="form-label">Image Url</label>
                    <input type="text" class="form-control" id="imageUrl" name="imageUrl" value="${form.imageUrl}">
                </div>
                    <c:if test="${errors.hasFieldErrors('imageUrl')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('imageUrl')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>
           <button type="submit" class="btn btn-primary">Submit</button>
     </form>
   </div>
</section>


<jsp:include page="../include/footer.jsp"/>
```