<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:genericpage>
<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.lectures" /></title>



</jsp:attribute>


<jsp:body>
  	 <div style="height:80px;">
  	 </div>

<div class="main">
<a  href="/StudentAdmissionMVC/addLecture" class="btn btn-success" role="button">

<spring:message code="label.addLecture" />

</a>
</div>




<div class="container">
  <h1 class="studentHeader"><spring:message code="label.lectureHeader1" /></h1>


  <div class="main">


<table class="table">
    <thead>
      <tr>
        <th><spring:message code="label.courseCode" /></th>
        <th><spring:message code="label.instructor" /> </th>
        <th><spring:message code="label.instructionLanguage" /> </th>
        <th><spring:message code="label.classroom" /> </th>
        <th><spring:message code="label.daytime" /> </th>


      </tr>
    </thead>
    <tbody>
		  	 <c:forEach items="${lectures}" var="lecture">
		  	 <tr>
		  	 <td>${lecture.course.courseCode} </td>
		  	 <td> ${lecture.instructor.instructorName} ${lecture.instructor.instructorSurname}</td>
			<td> ${lecture.instructionLanguage}</td>
			<td> ${lecture.classRoom}</td>
			<td> ${lecture.dayTime}</td>
		  	 </tr>
</c:forEach>
    </tbody>
  </table>

  </div>
</div>








</jsp:body>
</t:genericpage>