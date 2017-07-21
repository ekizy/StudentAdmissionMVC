<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.admission" /></title>


</jsp:attribute>


	<jsp:body>
  	 <div style="height: 52px;">
  	 </div>

<div class="container" >
	<h1 class="admissionHeader1">
		<spring:message code="label.admissionHeader" />
	</h1>

	<form:errors path="student1.*" />
	<!-- Student inputlarında hata varsa göstermek icin -->

<div class="main">
	<form action="/StudentAdmissionMVC/submitAdmission" method="post">

		<!-- These name tags have to be consistent with java class variables. -->

		<table>
			<tr>
				<td><spring:message code="label.studentName" /></td>
				<td><input class="form-control" type="text" name="studentName" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.studentSurname" /></td>
				<td><input class="form-control" type="text" name="studentSurname" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.studentNumber" /></td>
				<td><input class="form-control" type="text" name="studentNumber" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.studentFaculty" /></td>
				<td><input class="form-control" type="text" name="studentFaculty" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentHobby" /></td>
				<td><input class="form-control" type="text" name="studentHobby" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentBirthday" /></td>
				<td><input class="form-control" type="text" name="studentBirthday" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentSkills" /></td>
				<td><select class="form-control" name="studentSkills" multiple>
						<option value="Java">Java</option>
						<option value="C++">C++</option>
						<option value=".NET">.NET</option>
						<option value="C#">C#</option>
						<option value="Python">Python</option>
				</select></td>
			</tr>
<tr> <td> <spring:message code="label.address" />
			</td>
			</tr>
			<tr>
				<td><spring:message code="label.studentAddress.country" /> </td><td><input
				class="form-control" type="text" name="studentAddress.country"></td>
							</tr>
							<tr>
				<td><spring:message code="label.studentAddress.city" /></td><td> <input
				class="form-control" type="text" name="studentAddress.city"></td>
							</tr>
							<tr>
				<td><spring:message code="label.studentAddress.street" /> </td><td><input
				class="form-control" type="text" name="studentAddress.street"></td>
							</tr>
							<tr>
				<td><spring:message code="label.studentAddress.pincode" /> </td><td><input
			class="form-control"	type="text" name="studentAddress.pincode"></td>

			</tr>
		</table>


<p style="text-align:center;"> <spring:message code="label.submitMessage" /> </p>
		<button class="btn btn-success" style="margin:0 auto; display:block;">
					<spring:message code="label.submit" />  </button>


	</form>

</div>
	</div>

</jsp:body>
</t:genericpage>
