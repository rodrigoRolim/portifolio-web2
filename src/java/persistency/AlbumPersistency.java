package persistency;

import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Album;

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
