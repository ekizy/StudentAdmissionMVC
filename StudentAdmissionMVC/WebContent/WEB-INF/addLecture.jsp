<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:genericpage>
	<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.addLectureTitle" /></title>


</jsp:attribute>


	<jsp:body>
  	 <div style="height: 52px;">
  	 </div>

<div class="container">
	<h1 class="admissionHeader1">
		<spring:message code="label.addLectureHeader" />
	</h1>

	<form:errors path="lecture.*" />
	<!-- Student inputlarında hata varsa göstermek icin -->

<div class="main">
	<form action="/StudentAdmissionMVC/submitLecture" method="post">

		<!-- Inputlarla classların eşleşebilmesi için name taglerine classlardaki değişkenlerin adı verilmiştir. -->

		<table>
			<tr>
				<td><spring:message code="label.courseCode" /></td>
				<td><select class="form-control" name="courseCode">

								  	 <c:forEach items="${courses}" var="course">
								  	 <option value="${course.courseCode}">
										${course.courseCode}
										</option>
							</c:forEach>
							</select></td>
			</tr>

			<tr>
			<td><spring:message code="label.instructorName" /></td>
							<td><select class="form-control" name="instructorFullname">

								  	 <c:forEach items="${instructors}" var="instructor">
								  	 <option value="${instructor.instructorName}-${instructor.instructorSurname}">
										${instructor.instructorName} ${instructor.instructorSurname}
										</option>
							</c:forEach>
							</select></td>
			</tr>

						<tr>
			<td><spring:message code="label.instructionLanguage" /></td>
							<td><select class="form-control" name="instructionLanguage">

								<option><spring:message code="label.english" /></option>
								<option><spring:message code="label.german" /></option>
								<option> <spring:message code="label.turkish" /> </option>

							</select></td>
			</tr>

						<tr>
				<td><spring:message code="label.classroom" /></td>
				<td><input class="form-control" type="text" name="classRoom" /></td>
			</tr>

									<tr>
				<td><spring:message code="label.daytime" /></td>
				<td><input class="form-control" type="text" name="dayTime" /></td>
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