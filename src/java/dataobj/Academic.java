/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataobj;

/**
 *
 * @author ADMIN
 */
public class Academic {
    private int id;
    private String username;
    private String pass;
    private String email;

    public Academic() {
        
    }

    public Academic(int id, String username, String pass) {
        this.id = id;
        this.username = username;
        this.pass = pass;
    }

    public Academic(int id, String username, String pass, String email) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Academic{" + "id=" + id + ", username=" + username + ", pass=" + pass + ", email=" + email + '}';
    }
    
    
    
}
