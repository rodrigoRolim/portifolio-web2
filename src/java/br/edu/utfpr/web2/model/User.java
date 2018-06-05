package br.edu.utfpr.web2.model;

public class User {
    private String name;
    private String password;

    public User() {

    }
    public User(String name, String password) throws Exception {
        this();
        this.setName(name);
        this.setPassword(password);
    }
    public void setName(String name) throws Exception {
        if(name.length() > 5) {
            this.name = name;
        } else {
            throw new Exception("Name must be greater than 5 characters");
        }
    }
    public void setPassword(String password) throws Exception {
        if(password.length() > 5) {
            this.password = password;
        } else {
            throw new Exception("Password must be greater than 5 characters");
        }
    }
    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }
}
