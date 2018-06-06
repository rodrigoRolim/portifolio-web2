<%-- 
    Document   : register
    Created on : 02/06/2018, 18:14:43
    Author     : rod_v
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
        <div class="container d-flex flex-column">

            <form class="align-self-center  aling-items-center"
                  action="/portifolio-web2/register" method="post"
                  style="margin: 100px 0; width: 40%">
                <div class="form-group">
                  <label for="exampleInputEmail1">
                      <fmt:message key="NAME"/>
                  </label>
                  <input type="email" class="form-control" name="name" 
                         id="exampleInputEmail1" aria-describedby="emailHelp"
                         placeholder="Enter email" required>
                  <small id="emailHelp" class="form-text text-muted">
                      <fmt:message key="MESSAGE_EMAIL"/>
                  </small>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">
                      <fmt:message key="PASSWORD"/>
                  </label>
                  <input type="password" class="form-control" name="password" 
                         id="exampleInputPassword" placeholder="Password"
                         required>
                </div>  
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
        
           
   
    </body>
</html>
