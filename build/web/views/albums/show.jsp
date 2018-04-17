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
            <h1>Título do álbum</h1>
            <p>Descrição do álbum. Olha que matoragem!</p>
            <div class="galeria">
                <div class="item-galeria">
                    <div class="capa-galeria">
                        <img src="/assets/img/teste2.jpg">
                    </div>
                </div>
                <div class="item-galeria">
                    <div class="capa-galeria">
                        <img src="/assets/img/teste2.jpg">
                    </div>
                </div>
                <div class="item-galeria">
                    <div class="capa-galeria">
                        <img src="/assets/img/teste2.jpg">
                    </div>
                </div>
                <div class="item-galeria">
                    <div class="capa-galeria">
                        <img src="/assets/img/teste2.jpg">
                    </div>
                </div>
            </div>
            <div class="comments">
                <h3>Comments</h3>
                <div class="album-comment">
                    <div class="comment-author">João Paulo Paes</div>
                    <div class="comment-content">Aqui vai o conteúdo vindo do banco de dados</div>
                </div>
                <div class="album-comment">
                    <div class="comment-author">João Paulo Paes</div>
                    <div class="comment-content">Aqui vai o conteúdo vindo do banco de dados</div>
                </div>

                <h3>Comment</h3>
                <form action="/album/?/comment" method="post" class="form">
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