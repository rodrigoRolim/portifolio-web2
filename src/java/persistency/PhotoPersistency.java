package persistency;

import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Photo;

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
