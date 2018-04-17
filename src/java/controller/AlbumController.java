package controller;

import java.util.ArrayList;
import model.Album;
import persistency.AlbumPersistency;

public class AlbumController {

    private final AlbumPersistency persistency = new AlbumPersistency();

    public ArrayList<Album> index() {
        return this.persistency.index();
    }
}
