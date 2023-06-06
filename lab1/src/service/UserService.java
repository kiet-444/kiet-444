package service;

import dao.UserDAO;
import dto.UserDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author 
 */
public class UserService implements IService<UserDTO> {

    private UserDAO dao = new UserDAO();
    private List<String> roles;

    public UserService() {
        roles = new ArrayList<>();
        roles.add("ADMIN");
        roles.add("R001");
        roles.add("R002");
    }

    public boolean create(UserDTO user) {
        Map<String, UserDTO> users;
        try {
            users = dao.read();
            //check dulicate username
            if (users.containsKey(user.getUsername())) {
                return false;
            }
            //validate user's role: admin r001 r002
            if (!roles.contains(user.getRole().toUpperCase())) {
                return false;
            }
            //encrypt passwd before add to file
            user.setPasswd(encryptByBCrypt(user.getPasswd()));
            //add to list
            users.put(user.getUsername(), user);
            //write list to file
            dao.write(users);
            return users.containsKey(user.getUsername());
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Optional<UserDTO> find(String username) {
        Map<String, UserDTO> users;
        try {
            users = dao.read();
            if (users.containsKey(username)) {
                return Optional.of(users.get(username));
            }
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public List<UserDTO> findAll() {
        Map<String, UserDTO> users;
        try {
            users = dao.read();
            if (!users.isEmpty()) {
                return users.values().stream().collect(Collectors.toList());
            }
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList();
    }

    public boolean update(UserDTO user) {
        Map<String, UserDTO> users;
        try {
            users = dao.read();
            //check exist username
            if (!users.containsKey(user.getUsername())) {
                return false;
            }
            //encrypt passwd before add to file
            user.setPasswd(encryptByBCrypt(user.getPasswd()));
            //update to list
            users.replace(user.getUsername(), user);
            //write list to file
            dao.write(users);
            return users.containsKey(user.getUsername());
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(String username) {
        Map<String, UserDTO> users;
        try {
            users = dao.read();
            if (users.containsKey(username)) {
                users.remove(username);
                dao.write(users);
                return !users.containsKey(username);
            }
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean login(String username, String passwd) {
        Map<String, UserDTO> users;
        try {
            users = dao.read();
            if (users.containsKey(username)) {
                return checkPasswd(passwd, users.get(username).getPasswd());
            }
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean checkPasswd(String passwd, String encryptedPasswd) {
        return BCrypt.checkpw(passwd, encryptedPasswd);
    }

    private String encryptByBCrypt(String passwd) {
        return BCrypt.hashpw(passwd, BCrypt.gensalt(10));
    }

}
    