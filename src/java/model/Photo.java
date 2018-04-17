package model;

public class Photo {

    private int id;
    private String title;
    private String path;
    private int albumsId;

    public Photo() {
    }

    public Photo(int id, String title, String path, int albumsId) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.albumsId = albumsId;
    }

    public Photo(String title, String path, int albumsId) {
        this.title = title;
        this.path = path;
        this.albumsId = albumsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getAlbumsId() {
        return albumsId;
    }

    public void setAlbumsId(int albumsId) {
        this.albumsId = albumsId;
    }

}
