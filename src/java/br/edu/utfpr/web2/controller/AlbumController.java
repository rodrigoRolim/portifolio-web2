package br.edu.utfpr.web2.controller;

import java.util.ArrayList;
import br.edu.utfpr.web2.model.Album;
import br.edu.utfpr.web2.persistency.AlbumPersistency;

public class AlbumController {

    private final AlbumPersistency persistency = new AlbumPersistency();

    public ArrayList<Album> index() {
        return this.persistency.index();
    }
    
    public ArrayList<Album> search(String q) {
        return this.persistency.search(q);
    }
    
    public void store(Album a) {
        this.persistency.store(a);
    }
    
    public void update(Album a) {
        this.persistency.update(a);
    }
    
    public int lastId() {
        return this.persistency.lastId();
    }
}
