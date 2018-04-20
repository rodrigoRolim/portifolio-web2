<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Showing album ${album.title}</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/style.css" type="text/css">
    </head>

    <body>
        <div class="container">
            <h1>${album.title}</h1>
            <p>${album.description}</p>
            <div class="galeria">
                <c:forEach items="${photos}" var="photo">
                    <div class="item-galeria">
                        <div class="capa-galeria">
                            <img src="${pageContext.request.contextPath}/uploads/${photo.path}">
                        </div>
                    </div>    
                </c:forEach>
            </div>
            <div class="comments">
                <h3>Comments</h3>
                <div class="album-comment">
                    <div class="comment-author">João Paulo Paes</div>
                    <div class="comment-content">Olá!</div>
                </div>
                <div class="album-comment">
                    <div class="comment-author">João Paulo Paes</div>
                    <div class="comment-content">Hello!</div>
                </div>

                <h3>Comment</h3>
                <form action="/album/${album.id}/comment" method="post" class="form">
                    <div class="form-group">
                        <label for="author-name">Your name</label>
                        <input type="text" name="author-name" id="author-name" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="comment-content">Message</label>
                        <textarea name="comment-content" id="comment-content" cols="30" rows="10" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary">Send</button>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>