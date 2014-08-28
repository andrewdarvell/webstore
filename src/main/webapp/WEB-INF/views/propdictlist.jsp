<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="propdict.title" /></title>
    <spring:url value="webstore" var="mainUrl"/>
</head>
<body>

<c:if test="${!propDistList}">
    <table>
        <tr>
            <th><spring:message code="propdict.id"/></th>
            <th><spring:message code="propdict.name"/></th>
            <th><spring:message code="propdict.type"/></th>
            <th><spring:message code="propdict.descr"/></th>
        </tr>
        <c:forEach items="${propDistList}" var="propDict">
            <td>${propDict.idPropDict}</td>
            <td>${propDict.name}</td>
            <td>${propDict.dataType.type}:${propDict.dataType.length}</td>
            <td>${propDict.descr}</td>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
