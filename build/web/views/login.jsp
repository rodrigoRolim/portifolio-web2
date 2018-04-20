<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="/style.css" type="text/css">
    </head>

    <body>
        <div class="container">
            <h1>Photo Management</h1>
            <div class="row">
                <div class="col-md-6">
                    <form action="/Auth" method="post" class="form-horizontal">
                        <fieldset>
                            <legend>Sign in</legend>
                            <c:if test="${cookie.containsKey('message')}">
                                <div class="alert alert-default">${cookie.message.value}</div>
                            </c:if>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" name="email" id="email" class="form-control" value="${hasErrorEmail}">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="text" name="password" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary">Login</button>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="col-md-6">
                    <div class="logo">
                        <img src="/assets/img/logo.png" height="200px">
                    </div>
                </div>
            </div>
        </div>
    </body>

    </html>