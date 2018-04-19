package br.edu.utfpr.web2.persistency;

import br.edu.utfpr.web2.db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.utfpr.web2.model.Comment;

public class CommentPersistency {

    private Connection conn;

    public ArrayList<Comment> index() {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select * from comments");
            return this.processResultSet(st.executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(CommentPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private ArrayList<Comment> processResultSet(ResultSet rs) {
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            while (rs.next()) {
                comments.add(new Comment(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getString("author_name"), rs.getInt("albums_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhotoPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }
}
