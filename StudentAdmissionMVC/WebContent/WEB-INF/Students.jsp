<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:genericpage>
<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.students" /></title>



</jsp:attribute>


<jsp:body>
  	 <div style="height:80px;">
  	 </div>

<div class="main">
<a  href="/StudentAdmissionMVC/addStudent" class="btn btn-success" role="button">

<spring:message code="label.addStudent" />

</a>
</div>




<div class="container">
  <h1 class="studentHeader">All of the students can be seen below</h1>

  <h3 class="studentHeader"> You can click the student name for more details</h3>

  <div class="main">


  <table class="table">
    <thead>
      <tr>
        <th><spring:message code="label.studentName" /></th>
        <th><spring:message code="label.studentSurname" /></th>
        <th><spring:message code="label.studentNumber" /></th>
        <th><spring:message code="label.studentFaculty" /></th>
      </tr>
    </thead>
    <tbody>
		  	 <c:forEach items="${students}" var="student">
		  	 <tr>
		  	 <td><a href="/StudentAdmissionMVC/${student.studentNumber }" style="color:black;">${student.studentName }</a> </td>
		  	 <td> ${student.studentSurname }</td>
		  	 <td> ${student.studentNumber }</td>
		  	 <td> ${student.studentFaculty }</td>

		  	 </tr>
</c:forEach>
    </tbody>
  </table>

  </div>
</div>








</jsp:body>
</t:genericpage>