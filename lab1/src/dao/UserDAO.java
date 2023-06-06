package dao;

import dto.UserDTO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
//Data Access Object 
/**
 *
 * @author 
 */

public class UserDAO {

    private final String FILE_NAME = "User.dat";

    public Map<String, UserDTO> read() throws IOException {
        HashMap<String, UserDTO> users = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(FILE_NAME);
            ois = new ObjectInputStream(fis);
            users = (HashMap<String, UserDTO>) ois.readObject();
        } catch (ClassNotFoundException ex) {
            //find or create a logger. 
            /*If there is a logger exists with the passed name then the method will return that logger 
            else method will create a new logger with that name and return it.*/
            // get an instance of a logger and then log a message with the given Level (severe) containing the exception's 
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return users == null ? new HashMap<>() : users;
    }

    public void write(Map<String, UserDTO> users) throws IOException {
        if (users.isEmpty()) {
            return;
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
        } finally {
            if (oos != null) {
                try {

                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
