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
<form:form method="post" action="/webstore/propertys/add" commandName="propDictAdd">
    <table>
        <tr>
            <td>
                <form:label path="idPropDict">
                    <spring:message code="propdict.id"/>
                </form:label>
            </td>
            <td>
                <form:input path="idPropDict" readonly="true"/>
            </td>
        </tr>
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
                <form:select path="dataType">
                    <form:option value="NONE" label="--- Select ---" />
                    <c:forEach items="${dataTypeList}" var="dataTypeSelect">
                        <form:option value="${dataTypeSelect.idDataType}" label="${dataTypeSelect.type}"/>
                    </c:forEach>
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
                <a href="/${mainUrl}/datatypes">
                    <spring:message code="datatype.erase"/>
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
                <td>${propDict.idPropDict}</td>
                <td>${propDict.name}</td>
                <td>${propDict.dataType.type}:${propDict.dataType.length}</td>
                <td>${propDict.descr}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
