package br.edu.utfpr.web2.persistency;

import br.edu.utfpr.web2.db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.utfpr.web2.model.User;

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
            st.setString(1, email);
            st.setString(2, password);
            return this.processResultSet(st.executeQuery()).size() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void store(User u) {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("insert into users (name, email, password) values (?, ?, ?)");
            st.setString(1, u.getName());
            st.setString(2, u.getEmail());
            st.setString(3, u.getPassword());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User findByCredentials(String email, String password) {
        this.conn = Conexao.getInstance();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select * from users where email = ? and password = ?");
            st.setString(1, email);
            st.setString(2, password);
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
