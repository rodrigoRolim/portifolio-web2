<%-- 
    Document   : register
    Created on : 02/06/2018, 18:14:43
    Author     : rod_v
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/portifolio-web2/register" method="post">
            <div class="form-group">
              <label for="exampleInputEmail1">Email address</label>
              <input type="email" class="form-control" name="name" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
              <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <input type="password" class="form-control" name="password" id="exampleInputPassword" placeholder="Password" required>
            </div>  
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <img src="../resource/logo.png" alt="df"/>
            <img src="<c:url value='${pageContext.getServletContext().getRealPath("/resource/logo.png")}' />" alt="TestDisplay"/>
           <img src="${pageContext.getServletContext().getRealPath("/resource/logo.png")}" alt="f">
           <p>${pageContext.servletContext.contextPath}/web/build/resouce/logo.png</p>
           <p>${pageContext.getServletContext().getRealPath("/resource")}</p>
           
           <%
               String images_path = pageContext.getServletContext().getRealPath("/resource/logo.png");
               out.println("<img src="+images_path+">");
           %>
    </body>
</html>
