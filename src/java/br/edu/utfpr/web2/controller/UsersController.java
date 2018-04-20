package br.edu.utfpr.web2.controller;

import java.util.ArrayList;
import br.edu.utfpr.web2.model.User;
import br.edu.utfpr.web2.persistency.UserPersistency;

public class UsersController {
    private final UserPersistency persistency = new UserPersistency();

    public ArrayList<User> index() {
        return this.persistency.index();
    }
    
    public boolean auth(String email, String password){
        if(this.persistency.auth(email, password)){
            //Criar sessão
            return true;
        }
        return false;
    }
    
    public User findUserByCredentials(String email, String password){
        return this.persistency.findByCredentials(email, password);
    }
    
    public void store(User u){
        this.persistency.store(u);
    }
}
