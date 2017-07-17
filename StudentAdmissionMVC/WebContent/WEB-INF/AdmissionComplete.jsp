<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.successfulAdmission"/></title>
</jsp:attribute>

<jsp:body>

	<h1>${headerMessage}</h1>

	<h2><spring:message code="label.details"/></h2>

	<table>
		<tr>
			<td><spring:message code="label.studentName" /></td>
			<td>${student1.studentName}</td>
		</tr>

		<tr>
			<td><spring:message code="label.studentNumber" /></td>
			<td>${student1.studentNumber}</td>
		</tr>
		<tr>
			<td><spring:message code="label.studentHobby" /></td>
			<td>${student1.studentHobby}</td>
		</tr>

		<tr>
			<td><spring:message code="label.studentMobile" /></td>
			<td>${student1.studentMobile}</td>
		</tr>
		<tr>
			<td><spring:message code="label.studentBirthday" /></td>
			<td>${student1.studentBirthday}</td>
		</tr>
		<tr>
			<td><spring:message code="label.studentSkills" /></td>
			<td>${student1.studentSkills}</td>
		</tr>

		<tr>
			<td><spring:message code="label.address" /></td>
			<td><spring:message code="label.studentAddress.country" />:
				${student1.studentAddress.country} <spring:message
					code="label.studentAddress.city" />:
				${student1.studentAddress.city} <spring:message
					code="label.studentAddress.street" />:
				${student1.studentAddress.street} <spring:message
					code="label.studentAddress.pincode" />:
				${student1.studentAddress.pincode}</td>
		</tr>
	</table>

	</jsp:body>

	</t:genericpage>
