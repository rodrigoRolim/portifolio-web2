package br.edu.utfpr.web2.model;

public class Album {

    private int id;
    private String title;
    private String description;
    private String coverPath;

    public Album(int id, String title, String description, String coverPath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverPath = coverPath;
    }

    public Album(String title, String description, String coverPath) {
        this.title = title;
        this.description = description;
        this.coverPath = coverPath;
    }

    public Album() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

}
