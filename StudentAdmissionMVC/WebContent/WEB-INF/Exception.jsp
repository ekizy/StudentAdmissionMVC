<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.error"/></title>
</jsp:attribute>

<jsp:body>

<h1>Student Admission MVC</h1>

<h3>
There is an error in application. In order to get help please contact me with this e-mail ekizy@itu.edu.tr
</h3>
</jsp:body>

</t:genericpage>