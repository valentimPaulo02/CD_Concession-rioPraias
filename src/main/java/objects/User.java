package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
public class User implements Serializable{
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
