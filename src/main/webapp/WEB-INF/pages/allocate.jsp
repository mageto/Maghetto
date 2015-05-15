<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: obiero
  Date: 5/7/2015
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drug Details</title>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
</head>
<body>
<c:if test="${empty msg}">
    <div class="main" style="margin-left: 80px; margin-top: 50px;padding: 20px; width: 600px; border:3px solid #F0F0F0; box-shadow: 0px 0px 47px -3px rgba(0,0,0,0.58); border-radius: 5px;">
  <p>Name: ${patient.fname} ${patient.lname} </p>
    <p>Date Of Birth: ${patient.dob} </p>
    <p>Allocate Drug</p>
    <form class="pure-form" action="<c:url value='/save' />" method="post">
        <input type="hidden" name="patient_id" value="${patient.pid}">
        <label for="dname">*Drug Name:</label>
        <input type="text" name="dname" id="dname" required>
        <button class="pure-button pure-button-primary">Allocate</button>
    </form>
</div>
</c:if>
<br/>
<c:if test="${!empty listDrug}">
    <p>List of Drugs</p>
    <table class="pure-table">
        <tr>
            <th width="80">Drug ID</th>
            <th width="150">Drug Name</th>
            <th width="80">Patient ID</th>
            <th width="250">View Patients Taking this Drug</th>
        </tr>
        <c:forEach items="${listDrug}" var="drug">
            <tr>
                <td>${drug.did}</td>
                <td>${drug.drug_name} </td>
                <td>${drug.pid}</td>
                <td><a href="<c:url value='/drug' />" >View Patients</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
