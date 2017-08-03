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
			<td><spring:message code="label.courseCode" /></td>
			<td>${courseCode}</td>
		</tr>

		<tr>
			<td><spring:message code="label.instructorName" /></td>
			<td>${instructorName} ${instructorSurname}</td>
		</tr>

				<tr>
			<td><spring:message code="label.instructionLanguage" /></td>
			<td>${lecture.instructionLanguage}</td>
		</tr>

				<tr>
			<td><spring:message code="label.classroom" /></td>
			<td>${lecture.classRoom}</td>
		</tr>


				<tr>
			<td><spring:message code="label.daytime" /></td>
			<td>${lecture.dayTime}</td>
		</tr>


	</table>

	</jsp:body>

</t:genericpage>
