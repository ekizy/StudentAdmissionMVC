<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:genericpage>
<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.teachers" /></title>



</jsp:attribute>


<jsp:body>
  	 <div style="height:80px;">
  	 </div>

<div class="main">
<a  href="/StudentAdmissionMVC/addInstructor" class="btn btn-success" role="button">

<spring:message code="label.addTeacher" />

</a>
</div>




<div class="container">
  <h1 class="studentHeader"><spring:message code="label.teacherHeader1" /></h1>

  <h3 class="studentHeader"> <spring:message code="label.teacherHeader2" /></h3>

  <div class="main">


<table class="table">
    <thead>
      <tr>
        <th><spring:message code="label.courseName" /></th>
        <th><spring:message code="label.courseCode" /></th>

      </tr>
    </thead>
    <tbody>
		  	 <c:forEach items="${courses}" var="course">
		  	 <tr>
		  	 <td>${course.courseName } </td>
		  	 <td> ${course.course }</td>

		  	 </tr>
</c:forEach>
    </tbody>
  </table>

  </div>
</div>








</jsp:body>
</t:genericpage>