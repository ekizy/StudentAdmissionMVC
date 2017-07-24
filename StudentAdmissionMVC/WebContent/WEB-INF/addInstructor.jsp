<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.addTeacherTitle" /></title>


</jsp:attribute>


	<jsp:body>
  	 <div style="height: 52px;">
  	 </div>

<div class="container">
	<h1 class="admissionHeader1">
		<spring:message code="label.addTeacherHeader" />
	</h1>

	<form:errors path="student1.*" />
	<!-- Student inputlarında hata varsa göstermek icin -->

<div class="main">
	<form action="/StudentAdmissionMVC/submitInstructor" method="post">

		<!-- Inputlarla classların eşleşebilmesi için name taglerine classlardaki değişkenlerin adı verilmiştir. -->

		<table>
			<tr>
				<td><spring:message code="label.instructorName" /></td>
				<td><input class="form-control" type="text" name="instructorName" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.instructorSurname" /></td>
				<td><input class="form-control" type="text"
								name="instructorSurname" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.instructorMobile" /></td>
				<td><input class="form-control" type="text"
								name="instructorMobile" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.title" /></td>
				<td><input class="form-control" type="text" name="instructorTitle" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.office" /></td>
				<td><input class="form-control" type="text"
								name="instructorOffice" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.email" /></td>
				<td><input class="form-control" type="text"
								name="instructorEmail" /></td>
			</tr>
		</table>


<p style="text-align: center;"> <spring:message
							code="label.submitMessage" /> </p>
		<button class="btn btn-success"
						style="margin: 0 auto; display: block;">
					<spring:message code="label.submit" />  </button>


	</form>

</div>
	</div>

</jsp:body>
</t:genericpage>
