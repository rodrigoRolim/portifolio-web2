package br.edu.utfpr.web2.controller;

import java.util.ArrayList;
import br.edu.utfpr.web2.model.Photo;
import br.edu.utfpr.web2.persistency.PhotoPersistency;

public class PhotoController {
    private final PhotoPersistency persistency = new PhotoPersistency();

    public ArrayList<Photo> index() {
        return this.persistency.index();
    }
    
    public void store(Photo p) {
        this.persistency.store(p);
    }
}
