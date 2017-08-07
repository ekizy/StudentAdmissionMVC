<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">

<html>

<body style="background-color: #DDDDDD">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a  href="/StudentAdmissionMVC"><spring:message code="label.home" /></a></li>
					<li><a href="/StudentAdmissionMVC/students"><spring:message code="label.students" /></a></li>
					<li><a href="/StudentAdmissionMVC/instructors"><spring:message code="label.teachers" /></a></li>
					<li><a href="/StudentAdmissionMVC/lectures"><spring:message code="label.lectures" /> </a></li>
					<li><a href="/StudentAdmissionMVC/courses"><spring:message code="label.courses" /> </a> </li>
					<li> <a href="/StudentAdmissionMVC/enrollStudent"><spring:message code="label.enrollStudent" /> </a></li>
					<li><a href="/StudentAdmissionMVC/contact"><spring:message code="label.contact" /></a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">

					<li><a
						href="?siteLanguage=en"
						style="text-decoration: none;"> English</a></li>
					<li><a
						href="?siteLanguage=de"
						style="text-decoration: none;">Deutsch</a></li>
					<li><a
						href="?siteLanguage=tr"
						style="text-decoration: none;">Türkçe</a></li>
				</ul>

			</div>


		</div>
	</div>
	<div id="pageheader">

		<jsp:invoke fragment="header" />
	</div>

	<div id="body">
		<jsp:doBody />
	</div>
	<div id="pagefooter">
		<jsp:invoke fragment="footer" />
	</div>
</body>
</html>