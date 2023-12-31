package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
public class User implements Serializable{
    private int id;
    private String passwordHash;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }
    public User(int id, String passwordHash) {
        this.id = id;
        this.passwordHash = passwordHash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
