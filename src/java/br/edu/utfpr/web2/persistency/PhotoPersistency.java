package br.edu.utfpr.web2.persistency;

import br.edu.utfpr.web2.db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.utfpr.web2.model.Photo;

public class PhotoPersistency {

    private Connection conn;

    public ArrayList<Photo> index() {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select * from photos");
            return this.processResultSet(st.executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(PhotoPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void store(Photo a) {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("insert into albums (title, path, albums_id) values (?, ?, ?)");
            st.setString(1, a.getTitle());
            st.setString(2, a.getPath());
            st.setInt(3, a.getAlbumsId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhotoPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<Photo> processResultSet(ResultSet rs) {
        ArrayList<Photo> photos = new ArrayList<>();
        try {
            while (rs.next()) {
                photos.add(new Photo(rs.getInt("id"), rs.getString("title"), rs.getString("path"), rs.getInt("albums_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhotoPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return photos;
    }
}
