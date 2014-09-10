<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="UTF-8" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="datatype.title"/></title>

	<spring:url value="webstore" var="mainUrl"/>

	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="/resources/main.css"/>
	<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
	<script src="http://code.jquery.com/jquery-latest.js"><!-- --></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"><!-- --></script>

	<style>
		.error {
			color: indianred; font-weight: bold;
		}
	</style>

</head>

<body>
<a href="/${mainUrl}/main">Назад</a>

<p/>


<form:form method="post" action="/webstore/datatypes/add" commandName="dataType">
	<form:errors path="*" cssClass="alert alert-error" />
	<table>
		<tr>
			<td>
				<form:label path="idDataType">
					<spring:message code="datatype.id"/>
				</form:label>
			</td>
			<td>
				<form:input path="idDataType"/>
			</td>
			<td colspan="2">
				<form:errors path="idDataType" cssClass="alert alert-error" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="type">
					<spring:message code="datatype.type"/>
				</form:label>
			</td>
			<td>
				<form:input path="type" class="form-control"/>
			</td>
			<td>
				<form:errors path="type" cssClass="error"/>
			</td>
		</tr>

		<tr>
			<td>
				<form:label path="length">
					<spring:message code="datatype.length"/>
				</form:label>
			</td>
			<td>
				<form:input path="length"/>
			</td>
			<td>
				<form:errors path="length" cssClass="error"/>
			</td>
		</tr>
		<tr>
			<td>
				<a href="/${mainUrl}/datatypes">
					<spring:message code="datatype.erase"/>
				</a>
			</td>
			<td>
				<input type="submit" class="btn btn-success" value="<spring:message code="datatype.add"/>"/>
			</td>
		</tr>
	</table>
</form:form>


<c:if test="${!empty dataTypeList}">
	<table class="table table-striped">
		<tr>
			<th><spring:message code="datatype.id"/></th>
			<th><spring:message code="datatype.type"/></th>
			<th><spring:message code="datatype.length"/></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${dataTypeList}" var="dataType">
			<tr>

				<td><a href="/${mainUrl}/datatypes/view&id=${dataType.idDataType}">${dataType.idDataType}</a></td>
				<td>${dataType.type}</td>
				<td>${dataType.length}</td>

				<td><a href="/${mainUrl}/datatypes/delete&id=${dataType.idDataType}"><spring:message
						code="datatype.delete"/></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>