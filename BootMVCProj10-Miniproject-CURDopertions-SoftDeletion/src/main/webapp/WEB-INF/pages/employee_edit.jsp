 <%@page isELIgnored="false" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <noscript>
   <h1 style="color:red;text-align:center">Please enable java script machine</h1>
 </noscript>
 
 <h1 style="color:red;text-align:center">Employee Register</h1>
 
 <style media="all">
   body{
     background-color:pink;
   }
   span{
   color:green;
   }
 </style>
 
  <script language="JavaScript" src="js/validations.js">
    
 </script>
 <form:form modelAttribute="emp" onsubmit="return validation(this)" name="frm">
 <%--  <p style="color:red;text-align:center">
     <form:errors path="*"/>
  </p> --%>
 <table border="1" bgcolor="cyan" align="center">
 <tr>
   <td>Employee No::</td>
   <td> <form:input path="empno" readonly="true"/></td>
 </tr>
 
 <tr>
   <td>Employee Name::</td>
   <td> <form:input path="ename" /> <form:errors cssStyle="color:red" path="ename"/> <span id="enameErr"></span></td>
 </tr>
 
 <tr>
   <td>Employee desg::</td>
   <td> <form:input path="job"/> <form:errors cssStyle="color:red" path="job"/> <span id="jobErr"></span></td>
 </tr>
 <tr>
   <td>Employee salary::</td>
   <td> <form:input path="sal"/> <form:errors cssStyle="color:red" path="sal"/>  <span id="salErr"></span></td>
 </tr>
 <tr>
  <td colspan="2" align="center"><input type="submit" value="edit Employee"/></td>
 </tr>
 
 </table>
 <form:hidden path="vflag"/>
 </form:form>