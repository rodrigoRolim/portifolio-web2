package controller;

import java.util.ArrayList;
import model.Photo;
import persistency.PhotoPersistency;

public class PhotoController {
    private final PhotoPersistency persistency = new PhotoPersistency();

    public ArrayList<Photo> index() {
        return this.persistency.index();
    }
}
