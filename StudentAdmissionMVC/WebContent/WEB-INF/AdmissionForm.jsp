<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.admission" /></title>
</jsp:attribute>


<jsp:body>


	<link rel="stylesheet" href="<spring:theme code='styleSheet'/>"
		type="text/css" />

	<p>
		<a href="/StudentAdmissionMVC/getAdmission.html?siteTheme=green"><spring:message code="label.green" /></a>|
		<a href="/StudentAdmissionMVC/getAdmission.html?siteTheme=red"><spring:message code="label.red" /></a>
	</p>

	<a href="/StudentAdmissionMVC/getAdmission.html?siteLanguage=en"
			style="text-decoration: none;">
		<button>English</button>
		</a>
	<a href="/StudentAdmissionMVC/getAdmission.html?siteLanguage=de"
			style="text-decoration: none;">
	<button>Deutsch</button>
		</a>

	<a href="/StudentAdmissionMVC/getAdmission.html?siteLanguage=tr"
			style="text-decoration: none;"><button>Türkçe</button></a>


	<h1>
		<spring:message code="label.admissionHeader" />
	</h1>

	<form:errors path="student1.*" />
	<!-- Student inputlarında hata varsa göstermek icin -->

	<form action="/StudentAdmissionMVC/submitAdmission.html"
		method="post">
		<!-- These name tags have to be consistent with java class variables. -->
		<table>
			<tr>
				<td><spring:message code="label.studentName" /></td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentHobby" /></td>
				<td><input type="text" name="studentHobby" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentMobile" /></td>
				<td><input type="text" name="studentMobile" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentBirthday" /></td>
				<td><input type="text" name="studentBirthday" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentSkills" /></td>
				<td><select name="studentSkills" multiple>
						<option value="Java">Java</option>
						<option value="C++">C++</option>
						<option value=".NET">.NET</option>
						<option value="C#">C#</option>
				</select></td>
			</tr>
		</table>

<p> <spring:message code="label.address" /></p>
		<table>

			<tr>
				<td><spring:message code="label.studentAddress.country" /> <input
					type="text" name="studentAddress.country"></td>
				<td><spring:message code="label.studentAddress.city" /> <input
					type="text" name="studentAddress.city"></td>
				<td><spring:message code="label.studentAddress.street" /> <input
					type="text" name="studentAddress.street"></td>
				<td><spring:message code="label.studentAddress.pincode" /> <input
					type="text" name="studentAddress.pincode"></td>
			</tr>
		</table>

<p> <spring:message code="label.submitMessage" /> </p>
		<input type="submit" value=<spring:message code="label.submit"/> />
	</form>

</jsp:body>
</t:genericpage>
