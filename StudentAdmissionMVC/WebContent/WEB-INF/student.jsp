<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:genericpage>
<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> ${student.studentName} ${student.studentSurname}</title>
		<link href="./resources/bootstrap.css" rel="stylesheet"
			type="text/css">
		<link href="./resources/style.css" rel="stylesheet"
			type="text/css">


</jsp:attribute>


<jsp:body>
  	 <div style="height:52px;">
  	 </div>



<div class="container">

<h1> In this page you can see choosen student's all of information. </h1>


<div class="main">

<table class="table">
		<tr>
			<td><spring:message code="label.studentName" /></td>
			<td>${student.studentName}</td>
		</tr>

				<tr>
			<td><spring:message code="label.studentSurname" /></td>
			<td>${student.studentSurname}</td>
		</tr>

		<tr>
			<td><spring:message code="label.studentNumber" /></td>
			<td>${student.studentNumber}</td>
		</tr>

				<tr>
			<td><spring:message code="label.studentFaculty" /></td>
			<td>${student.studentFaculty}</td>
		</tr>
		<tr>
			<td><spring:message code="label.studentHobby" /></td>
			<td>${student.studentHobby}</td>
		</tr>

		<tr>
			<td><spring:message code="label.studentBirthday" /></td>
			<td>${student.studentBirthday}</td>
		</tr>
		<tr>
			<td><spring:message code="label.studentSkills" /></td>
			<td>${student.studentSkills}</td>
		</tr>

		<tr>
			<td><spring:message code="label.address" /></td>
			<td><spring:message code="label.studentAddress.country" />:
				${student.studentAddress.country} <spring:message
					code="label.studentAddress.city" />:
				${student.studentAddress.city} <spring:message
					code="label.studentAddress.street" />:
				${student.studentAddress.street} <spring:message
					code="label.studentAddress.pincode" />:
				${student.studentAddress.pincode}</td>
		</tr>
	</table>


</div>

</div>




</jsp:body>
</t:genericpage>
