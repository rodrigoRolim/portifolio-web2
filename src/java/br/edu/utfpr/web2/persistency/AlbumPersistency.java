package br.edu.utfpr.web2.persistency;

import br.edu.utfpr.web2.db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.utfpr.web2.model.Album;

public class AlbumPersistency {

    private Connection conn;

    public ArrayList<Album> index() {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select * from albums");
            return this.processResultSet(st.executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(AlbumPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Album> search(String s) {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select * from albums where title like ?");
            st.setString(1, "%" + s + "%");
            return this.processResultSet(st.executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(AlbumPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void store(Album a) {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("insert into albums (title, description, cover_path) values (?, ?, ?)");
            st.setString(1, a.getTitle());
            st.setString(2, a.getDescription());
            st.setString(3, a.getCoverPath());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlbumPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int lastId() {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select max(id) from albums");
            ResultSet rs = st.executeQuery();
            return Integer.parseInt(rs.getString(0));
        } catch (SQLException ex) {
            Logger.getLogger(AlbumPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    private ArrayList<Album> processResultSet(ResultSet rs) {
        ArrayList<Album> albums = new ArrayList<>();
        try {
            while (rs.next()) {
                albums.add(new Album(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getString("cover_path")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlbumPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return albums;
    }
}
