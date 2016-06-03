<%-- 
    Document   : FiltratoJson
    Created on : 2-giu-2016, 12.29.23
    Author     : Riccardo Balia 65106
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.atg.com/taglibs/json" prefix="json" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<json:array>
    <c:forEach var="objectSale" items="${filterResult}">
        <json:object>
            <json:property name="ID" value="${objectSale.ID}"/> 
            <json:property name="name" value="${objectSale.name}"/> 
            <json:property name="imageURL" value="${objectSale.imageURL}"/> 
            <json:property name="description" value="${objectSale.description}"/> 
            <json:property name="price" value="${objectSale.price}"/> 
            <json:property name="availability" value="${objectSale.availability}"/> 
            <json:property name="category" value="${objectSale.category}"/> 
        </json:object>
    </c:forEach>>
</json:array>

