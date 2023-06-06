package dto;

import java.io.Serializable;

//Data Transfer Object 
/**
 *
 * @author 
 */
public class UserDTO implements Serializable{

    private String username;
    private String passwd;
    private String role;
    private boolean status;

    public UserDTO() {
    }

    public UserDTO(String username, String passwd, String role, boolean status) {
        this.username = username;
        this.passwd = passwd;
        this.role = role;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "username=" + username + ", passwd=" + passwd + ", role=" + role + ", status=" + status + '}';
    }

}
