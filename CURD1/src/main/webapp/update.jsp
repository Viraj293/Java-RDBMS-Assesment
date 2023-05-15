<%@page import="com.bin.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student1</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<%
      Employee s=(Employee)request.getAttribute("s");
%>
<b style="color:red;">
<%
    if(request.getAttribute("msg")!=null){
    	out.println(request.getAttribute("msg"));
    }
%>
</b>
 <form  name="insert"  method="post" action="EmployeeController">
 <table>
     <tr>
        <td><input type="hidden" name="id" value="<%=s.getId() %>"></td>
     </tr>
    
    <tr>
    <td>First Name</td>
    <td><input type="text" name="fname"  value="<%=s.getFname() %>"></td>
    </tr> 
    
    <tr>
    <td>Last Name</td>
    <td><input type="text" name="lname"  value="<%=s.getLname() %>"></td>
    </tr> 
    
    <tr>
    <td>Email</td>
    <td><input type="text" name="email"   value="<%=s.getEmail() %>"></td>
    </tr> 
    
      <tr>
    <td>Mobile</td>
    <td><input type="text" name="mobile"  value="<%=s.getMobile() %>"></td>
    </tr> 
    
    <tr>
    <td>Address</td>
    <td><textarea cols="21" rows="5"  name="address"><%=s.getAddress() %></textarea></td>
    </tr> 
    
    
    <tr>
    <td>Gender</td>
    <td>
    
    <%
       if(s.getGender().equalsIgnoreCase("male")){
    %>
            <input type="radio" name="gender" value="male" checked="checked">Male
        <input type="radio" name="gender" value="female">Female              
    <%
       }
    else if(s.getGender().equalsIgnoreCase("female")){
    %>
         <input type="radio" name="gender" value="male">Male
        <input type="radio" name="gender" value="female" checked="checked">Female        
    
    <% 	   
       }
    else{
   	%>
    	  <input type="radio" name="gender" value="male">Male
        <input type="radio" name="gender" value="female">Female        
    <% 
    }
    %>
      
    </td>  
    </tr> 
    
    <tr>
    <td  colspan="2"  align="center">
    <input type="submit" name="action" value="update"></td>
    </tr> 
    
     
      
 </table>
 <a href="Show.jsp">Show ALL Student</a>
 </form>
</body>
</html>