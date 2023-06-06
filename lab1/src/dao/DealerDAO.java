
package dao;

import dto.DealerDTO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 
 */
public class DealerDAO {
    private final String FILE_NAME = "Dealer.dat";
    public Map<String, DealerDTO> read() throws IOException {
        HashMap<String, DealerDTO> dealers = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(FILE_NAME);
            ois = new ObjectInputStream(fis);
            dealers = (HashMap<String, DealerDTO>) ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DealerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(DealerDTO.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(DealerDTO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return dealers == null ? new HashMap<>() : dealers;
    }

    public void write(Map<String, DealerDTO> dealers) throws IOException {
        if (dealers.isEmpty()) {
            return;
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(dealers);
        } finally {
            if (oos != null) {
                try {

                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DealerDTO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DealerDTO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
//    public static void main(String[] args) {
//        try {
//            new DealerDAO().write(new HashMap<>());
//        } catch (IOException ex) {
//            Logger.getLogger(DealerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
