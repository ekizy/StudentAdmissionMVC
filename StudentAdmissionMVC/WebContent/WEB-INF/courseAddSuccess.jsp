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
			<td><spring:message code="label.courseName" /></td>
			<td>${course.courseName}</td>
		</tr>

		<tr>
			<td><spring:message code="label.courseCode" /></td>
			<td>${course.courseCode}</td>
		</tr>


	</table>

	</jsp:body>

</t:genericpage>
