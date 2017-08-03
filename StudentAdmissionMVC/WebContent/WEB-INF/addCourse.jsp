<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.addCourseTitle" /></title>


</jsp:attribute>


	<jsp:body>
  	 <div style="height: 52px;">
  	 </div>

<div class="container">
	<h1 class="admissionHeader1">
		<spring:message code="label.addCourseHeader" />
	</h1>

	<form:errors path="course.*" />
	<!-- Lecture inputlarında hata varsa göstermek icin -->

<div class="main">
	<form action="/StudentAdmissionMVC/submitCourse" method="post">

		<!-- Inputlarla classların eşleşebilmesi için name taglerine classlardaki değişkenlerin adı verilmiştir. -->

		<table>
			<tr>
				<td><spring:message code="label.courseCode" /></td>
				<td><input class="form-control" type="text" name="courseCode" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.courseName" /></td>
				<td><input class="form-control" type="text"
								name="courseName" /></td>
			</tr>


		</table>


<p style="text-align: center;"> <spring:message
							code="label.submitMessage" /> </p>
		<button class="btn btn-primary"
						style="margin: 0 auto; display: block;">
					<spring:message code="label.submit" />  </button>


	</form>

</div>
	</div>

</jsp:body>
</t:genericpage>