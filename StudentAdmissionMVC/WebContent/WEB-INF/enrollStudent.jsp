<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:genericpage>
	<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.enrollTitle" /></title>


</jsp:attribute>


	<jsp:body>
  	 <div style="height: 52px;">
  	 </div>

<div class="container">
	<h1 class="admissionHeader1">
		<spring:message code="label.enrollHeader" />
	</h1>


<div class="main">
	<form action="/StudentAdmissionMVC/submitEnrollment" method="post">

		<!-- Inputlarla classların eşleşebilmesi için name taglerine classlardaki değişkenlerin adı verilmiştir. -->

		<table>
			<tr>
				<td><spring:message code="label.studentName" /></td>
				<td><select class="form-control" name="studentFullName">

								  	 <c:forEach items="${students}" var="student">
								  	 <option value="${student.studentName}-${student.studentSurname} ">
										${student.studentName} ${student.studentSurname}
										</option>
							</c:forEach>
							</select></td>
			</tr>

						<tr>
				<td><spring:message code="label.lecture" /></td>
				<td><select class="form-control" name="lecture">

								  	 <c:forEach items="${lectures}" var="lecture">
								  	 <option value="${lecture.course.courseCode}/${lecture.dayTime} ">
										${lecture.course.courseCode} ${lecture.dayTime}
										</option>
							</c:forEach>
							</select></td>
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