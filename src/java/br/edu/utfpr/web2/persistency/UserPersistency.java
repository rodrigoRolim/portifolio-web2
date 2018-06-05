package br.edu.utfpr.web2.persistency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.utfpr.web2.model.User;

public class UserPersistency {
  
    public void createUser(User user) throws Exception {
       
        try {
            System.out.println("aqui entro");
            String sql = "INSERT INTO user(name_user, password) VALUES(?,?)";
            PreparedStatement statement = DBConnectionSingleton.getInstance().prepareStatement(sql);
            System.out.println("aqui tambem entrou");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            
            int rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted);
            if(rowsInserted == 0) {
                throw new RuntimeException("User could not be persisted!");
            }
        } catch(SQLException ex) {
            System.out.println("não, entrou foi aqui");
            ex.printStackTrace();
           // throw new Exception(ex);
        }
    }
    public void updateUser(User user) throws Exception {
        try{
            String sql = "UPDATE user SET name_user = ?, password = ? WHERE name_user like ?";
            PreparedStatement statement = DBConnectionSingleton.getInstance().prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            int rowsInserted = statement.executeUpdate();
        
            if(rowsInserted == 0) {
                throw new RuntimeException("User could not be updated!");
            }
        } catch(SQLException ex) {
            throw new Exception(ex);
        }
    }
}
