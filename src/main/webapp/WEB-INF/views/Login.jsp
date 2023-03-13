<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri ="http://www.springframework.org/tags/form"  prefix="form" %>

<br> <br>
<c:if test = "${message ne null }">

 <font color = 'red'> Reason : <c:out value = "${message}" /> </font>

</c:if>
<hr>

<form:form action = "signin"  method = "post"  modelAttribute = "loginRequest">
 <table>
   <tr>
     <td> Username </td> <td> <form:input  path="username"/> </td>
     <td> <font color='red'> <form:errors path="username"/> </font> </td>
   </tr>
   <tr>
     <td> Password </td> <td> <form:password path = "password"/> </td>
     <td> <font color='red'> <form:errors path="password"/> </font> </td>
   </tr>
 </table>
  <input type="submit"   value = "Submit">
	<input type="reset" value="Reset">
</form:form>