<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Show album #title</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/style.css" type="text/css">
    </head>

    <body>
        <div class="container">
            <h1>Albums</h1>
            <p>Manage albums</p>

            <c:if test="${message}">
                <div class="alert alert-danger">${message}</div>
            </c:if>

            <div class="offset-md-8 col-md-4">
                <form action="/Albums" method="get">
                    <div class="col-auto">
                        <label class="sr-only" for="q">Search</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">Search</div>
                            </div>
                            <input type="text" name="q" class="form-control" id="q" placeholder="What you are locking for?" value="${param.q}">
                        </div>
                    </div>
                </form>
            </div>

            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Cover</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${albums}" var="album">
                        <tr>
                            <td>${album.id}</td>
                            <td>${album.title}</td>
                            <td>${album.description}</td>
                            <td>
                                <img src="/assets/img/${album.coverPath}" height="45px">
                            </td>
                            <td>
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <button type="button" class="btn btn-primary">
                                        <a href="/Albums?id=${album.id}">Show</a>
                                    </button>
                                    <button type="button" class="btn btn-warning">
                                        <a href="/Albums=?id=${album.id}&edit">Edit</a>
                                    </button>
                                    <button type="button" class="btn btn-danger">
                                        <a href="/Albums?id=${album.id}&delete">Edit</a>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>

</html>