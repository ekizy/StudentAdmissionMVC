<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:genericpage>
<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.teachers" /></title>


</jsp:attribute>


<jsp:body>
  	 <div style="height:52px;">
  	 </div>

  	 <div class="container">

<h1 class="studentHeader"> <spring:message code="label.choosenInstructor" /></h1>


<div class="main">

<table class="table">
		<tr>
			<td><spring:message code="label.instructorName" /></td>
			<td>${instructor.instructorName}</td>
		</tr>
		<tr>
			<td><spring:message code="label.instructorSurname" /></td>
			<td>${instructor.instructorSurname}</td>
		</tr>
		<tr>
			<td><spring:message code="label.instructorMobile" /></td>
			<td>${instructor.instructorMobile}</td>
		</tr>

		<tr>
			<td><spring:message code="label.title" /></td>
			<td>${instructor.instructorTitle}</td>
		</tr>

				<tr>
			<td><spring:message code="label.email" /></td>
			<td>${instructor.instructorEmail}</td>
		</tr>
		<tr>
			<td><spring:message code="label.office" /></td>
			<td>${instructor.instructorOffice}</td>
		</tr>


	</table>

</div>

	<form action="/StudentAdmissionMVC/deleteInstructor" method="post">

	<p> </p>
		<button class="btn btn-danger"
						style="margin: 0 auto; display: block;">
					<spring:message code="label.deleteInstructor" />  </button>

</form>



</div>



</jsp:body>
</t:genericpage>