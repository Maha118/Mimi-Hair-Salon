<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<br>
	<c:url var="delete" value="/home/Delete" />
	<c:url var="update" value="/home/update"/>

	<h2 align="center">User List</h2>
	<br>
	<div class="container mt-4"
		style="position: relative; min-height: 72vh">

		<sf:form method="post"
			action="${pageContext.request.contextPath}/userList"
			modelAttribute="form">


			<table width="100%">
				<tr>
					<td align="center"><s:bind path="email">
							<sf:input path="${status.expression}" type="text" name="name"
								placeholder="Search By Email" value="" />
						</s:bind> &emsp;&emsp; <input type="submit" name="operation" value="Search">&nbsp;&nbsp;&nbsp;<input
						type="submit" name="operation" value="Reset"></td>
				</tr>
			</table>
			<br>
<b class="text-center"><%@ include file="businessMessage.jsp"%></b>
			<table class="table table-striped table table-dark">
				<tr>

					<th scope="col">Name</th>
					<th scope="col">Email</th>
                    <th scope="col">RoleName</th>
					<th scope="col">Action</th>
                </tr>





				<c:forEach items="${list}" var="userlist">

					<tr>

					<th scope="col">Name</th>
                    					<th scope="col">Email</th>
                                        <th scope="col">RoleName</th>
                    					<th scope="col">Action</th>

						<c:choose>
							<c:when test="${userlist.userid == 2 }">
								<td>---------</td>
							</c:when>
							<c:otherwise>
								<td><%-- <a class="btn btn-info" href="${update}?id=${userlist.id}"><i
										class='fas fa-edit' style='font-size: 15px;'></i></a> --%>&nbsp;&nbsp;&nbsp;

									<a class="btn btn-danger" href="${delete}?id=${userlist.id}"><i
										class='	far fa-trash-alt' style='font-size: 15px;'></i></a></td>

							</c:otherwise>
						</c:choose>

					</tr>
				</c:forEach>
				</tbody>
			</table>


		</sf:form>


	</div>
</body>
</html>