<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 5/11/15
  Time: 3:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>Patient</title>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
</head>
<body>
    <div class="main" style="margin-left: 80px; margin-top: 50px;padding: 20px; width: 600px; border:3px solid #F0F0F0; box-shadow: 0px 0px 47px -3px rgba(0,0,0,0.58); border-radius: 5px;">
      <%--<c:url value="/patients/load" var="addAction"/>--%>
      <%--<form:form commandName="">--%>

      <%--</form:form>--%>

      <form class="pure-form pure-form-alighned" action="<c:url value='/create' />" method="post">
        <div class="pure-control-group">
        <label for="fname">*First Name:</label>
        <input type="text" name="fname" id="fname" required>
        </div>

        <div style="margin-top: 20px;" class="pure-control-group">
        <label for="lname">*Last Name:</label>
        <input type="text" name="lname" id="lname" required>
        </div>

        <div style="margin-top: 20px;" class="pure-control-group">
        <label for="dob">*Date of birth:</label>
        <input type="date" name="dob" id="dob" required>
        </div>

        <button style="margin-top: 20px;" type="submit" class="pure-button pure-button-primary">Save</button>


      </form>
      <br/>
      <p>List of Patients</p>

        <table class="tg pure-table">
          <thead>
          <tr>
            <th width="80">Patient ID</th>
            <th width="150">Patient Name</th>
            <th width="150">Date of Birth</th>
            <th width="150">Allocate Drug</th>
          </tr>
          </thead>
        <c:if test="${!empty getPatient}">
          <c:forEach items="${getPatient}" var="patients">
            <tr>
              <td>${patients.pid}</td>
              <td>${patients.fname} ${patients.lname}</td>
              <td>${patients.dob}</td>
              <td><a href="<c:url value='/allocate?id=${patients.pid}' />" >Allocate Drug</a></td>
            </tr>
          </c:forEach>
        </table>
      </c:if>
    </div>
</body>
</html>

