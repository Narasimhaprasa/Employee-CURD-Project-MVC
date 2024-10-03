 <%@page isELIgnored="false" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"/> -->
 <noscript>
   <h1 style="color:red;text-align:center">Please enable java script machine</h1>
 </noscript>
 
 <script language="JavaScript" src="js/validations.js">
    
 </script>
 <!-- <div class="container">  -->
 
 <h1 style="color:red;text-align:center">Register Employee</h1>
 
 <form:form modelAttribute="emp"  onsubmit="return validation(this)" name="frm">
  <%-- <p style="color:red;text-align:center">
     <form:errors path="*"/>
  </p> --%>
 <table border="1" bgcolor="cyan" align="center">
 <!-- <table border="1" class="table table-striped" width="300px" height="250px"> -->
 <tr>
 <td>Employee Name::</td>
 <td><form:input path="ename"/> <form:errors cssStyle="color:red" path="ename"/>  <span id ="enameErr"></span></td>
 </tr>
 
 <tr>
 <td>Employee desg::</td>
 <td><form:input path="job"/> <form:errors cssStyle="color:red" path="job"/>  <span id ="jobErr"></span></td>
 </tr>
 
 <tr>
 <td>Employee salary::</td>
 <td><form:input path="sal"/> <form:errors cssStyle="color:red" path="sal"/>  <span id ="salErr"></span></td>
 </tr>
 <tr>
 <td colspan="2" align="center"><input type="submit" value="register Employee"/></td>
 </tr>
 </table>
 <form:hidden path="vflag"/>
 </form:form>
<!--  </div> -->