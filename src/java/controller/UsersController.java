package controller;

import java.util.ArrayList;
import model.User;
import persistency.UserPersistency;

public class UsersController {
    private final UserPersistency persistency = new UserPersistency();

    public ArrayList<User> index() {
        return this.persistency.index();
    }
    
    public boolean auth(String email, String password){
        return this.persistency.auth(email, password);
    }
    
    public User findUserByCredentials(String email, String password){
        return this.persistency.findByCredentials(email, password);
    }
}
