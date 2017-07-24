<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>

	<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.successfulAdmission" /></title>
</jsp:attribute>

	<jsp:body>

  	 <div style="height: 52px;">
  	 </div>


	<h1><spring:message code="label.successfulAdmission"/></h1>

	<h2>
			<spring:message code="label.details" />
		</h2>

	<table>
		<tr>
			<td><spring:message code="label.instructorName" /></td>
			<td>${teacher.instructorName}</td>
		</tr>

		<tr>
			<td><spring:message code="label.instructorSurname" /></td>
			<td>${teacher.instructorSurname}</td>
		</tr>

				<tr>
			<td><spring:message code="label.instructorSurname" /></td>
			<td>${teacher.instructorMobile}</td>
		</tr>

				<tr>
			<td><spring:message code="label.title" /></td>
			<td>${teacher.instructorTitle}</td>
		</tr>


				<tr>
			<td><spring:message code="label.office" /></td>
			<td>${teacher.instructorOffice}</td>
		</tr>


				<tr>
			<td><spring:message code="label.email" /></td>
			<td>${teacher.instructorEmail}</td>
		</tr>



	</table>

	</jsp:body>

</t:genericpage>
