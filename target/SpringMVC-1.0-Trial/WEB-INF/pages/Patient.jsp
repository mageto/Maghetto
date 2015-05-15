<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 5/11/15
  Time: 3:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient</title>
</head>
<body>
    <div>
      <%--<c:url value="/patients/load" var="addAction"/>--%>
      <%--<form:form commandName="">--%>

      <%--</form:form>--%>

      <form action="<c:url value='/patients/load' />" method="post">
        <label for="fname">*First Name:</label>
        <input type="text" name="fname" id="fname" required>

        <label for="lname">*Last Name:</label>
        <input type="text" name="lname" id="lname" required>

        <label for="bdate">*Date of birth:</label>
        <input type="date" name="bdate" id="bdate" required>
        <button>Save</button>

      </form>
      <br/>
      <p>List of Patients</p>
      <c:if test="${!empty listPatient}">
        <table class="tg">
          <tr>
            <th width="80">Patient ID</th>
            <th width="150">Patient Name</th>
            <th width="150">Date of Birth</th>
            <th width="150">Allocate Drug</th>
          </tr>
          <c:forEach items="${listPatient}" var="patient">
            <tr>
              <td>${patient.id}</td>
              <td>${patient.fname} ${patient.lname}</td>
              <td>${patient.dob}</td>
              <td><a href="<c:url value='/allocate?id=${patient.id}' />" >Allocate Drug</a></td>
            </tr>
          </c:forEach>
        </table>
      </c:if>
    </div>
</body>
</html>

