package persistency;

import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserPersistency {

    private Connection conn;

    public ArrayList<User> index() {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select * from users");
            return this.processResultSet(st.executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean auth(String email, String password) {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select * from users where email = ? and password = ?");
            st.setString(0, email);
            st.setString(1, password);
            return this.processResultSet(st.executeQuery()).size() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public User findByCredentials(String email, String password) {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select * from users where email = ? and password = ?");
            st.setString(0, email);
            st.setString(1, password);
            return this.processResultSet(st.executeQuery()).get(0);
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private ArrayList<User> processResultSet(ResultSet rs) {
        ArrayList<User> users = new ArrayList<>();
        try {
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhotoPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
