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
<form:form method="post" action="/webstore/propertys/add" modelAttribute="propDict">
    <table>
        <form:hidden path="idPropDict" />
        <tr>
            <td>
                <form:label path="name">
                    <spring:message code="propdict.name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dataType">
                    <spring:message code="propdict.type"/>
                </form:label>
            </td>
            <td>
                <!--form:input path="dataType"/-->
                <form:select path="dataType.idDataType">

                    <c:forEach items="${dataTypeList}" var="dataTypeSelect">
                        <form:option value="${dataTypeSelect.idDataType}" label="${dataTypeSelect.type}"/>
                    </c:forEach>

                    <!--form:options items="${dataTypeList}" itemValue="idDataType" itemLabel="type"/-->
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="descr">
                    <spring:message code="propdict.descr"/>
                </form:label>
            </td>
            <td>
                <form:input path="descr"/>
            </td>
        </tr>
        <tr>
            <td>
                <a href="/${mainUrl}/propertys">
                    <spring:message code="propdict.erase"/>
                </a>
            </td>
            <td>
                <input type="submit" value="<spring:message code="propdict.add"/>" />
            </td>
        </tr>
    </table>

</form:form>

<c:if test="${!empty propDictList}">
    <table>
        <tr>
            <th><spring:message code="propdict.id"/></th>
            <th><spring:message code="propdict.name"/></th>
            <th><spring:message code="propdict.type"/></th>
            <th><spring:message code="propdict.descr"/></th>
        </tr>

        <c:forEach items="${propDictList}" var="propDict">
            <tr>
                <td><a href="/${mainUrl}/propertys/view&id=${propDict.idPropDict}">${propDict.idPropDict}</a></td>
                <td>${propDict.name}</td>
                <td>${propDict.dataType.type}:${propDict.dataType.length}</td>
                <td>${propDict.descr}</td>

                <td><a href="/${mainUrl}/propertys/delete&id=${propDict.idPropDict}"><spring:message code="propdict.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
