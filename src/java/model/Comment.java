package model;

public class Comment {

    private int id;
    private String title;
    private String content;
    private String authorName;
    private int albumsId;

    public Comment(int id, String title, String content, String authorName, int albumsId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorName = authorName;
        this.albumsId = albumsId;
    }

    public Comment(String title, String content, String authorName, int albumsId) {
        this.title = title;
        this.content = content;
        this.authorName = authorName;
        this.albumsId = albumsId;
    }

    public Comment() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAlbumsId() {
        return albumsId;
    }

    public void setAlbumsId(int albumsId) {
        this.albumsId = albumsId;
    }

}
