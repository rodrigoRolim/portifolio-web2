<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Make an album</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/style.css" type="text/css">
    </head>

    <body>
        <div class="container">
            <h1>New album</h1>
            <p>Make a new album</p>

            <form action="/portifolio-web2/albums/create" method="post" class="form" enctype="multipart/form-data">
                <fieldset>
                    <legend>Album</legend>
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input class="form-control" type="text" name="title" id="title" required>
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <input class="form-control" type="text" name="description" id="description" required>
                    </div>
                    <div class="form-group">
                        <label for="cover">Cover</label>
                        <input class="form-control" type="file" name="cover" id="cover">
                    </div>

                    <legend>Photos</legend>
                    <div class="form-group">
                        <label for="photos"></label>
                        <input class="form-control" type="file" multiple="multiple" name="photos" id="photos" required>
                    </div>
                    
                    <div class="form-group">
                        <button class="btn btn-primary">Cadastrar</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>

</html>