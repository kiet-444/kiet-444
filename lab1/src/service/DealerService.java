
package service;

import dao.DealerDAO;
import dto.DealerDTO;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author 
 */
// xu ly du lieu truoc khi day xuong file
public class DealerService implements IService<DealerDTO> {

    private DealerDAO dao = new DealerDAO();
    private List<String> roles;

    @Override
    public boolean create(DealerDTO dealer) {
        Map<String, DealerDTO> dealers;
        try {
            dealers = dao.read();
            if (dealers.containsKey(dealer.getId())) {
                return false;
            }
            dealers.put(dealer.getId(), dealer);
            dao.write(dealers);
            return true;
        } catch (IOException ex) {

            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public boolean delete(String id) {
        try {
            Map<String, DealerDTO> dealers;
            dealers = dao.read();
            if (dealers.containsKey(id)) {
                dealers.remove(id);
                dao.write(dealers);
                return !dealers.containsKey(id);
                //check xoa success chua hay ko
            }
        } catch (IOException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(DealerDTO dealer) {
        try {
            Map<String, DealerDTO> dealers;
            dealers = dao.read();
            if(!dealers.containsKey(dealer.getId())){
                return false;
            }
            dealers.replace(dealer.getId(), dealer );
            dao.write(dealers);
            
        } catch (IOException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public List<DealerDTO> findAll() {
        try {
            Map<String, DealerDTO> dealers;
            dealers = dao.read();
            if (!dealers.isEmpty()) {
                return dealers.values().stream().collect(Collectors.toList());
            }
            return null;
        } catch (IOException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList();
        //tra ve tap hop rong
        //khong nen tra ve null de gay loi

    }

    @Override
    public Optional<DealerDTO> find(String id) {
        try {
            Map<String, DealerDTO> dealers;
            dealers = dao.read();
            if (dealers.containsKey(id)) {
                return Optional.ofNullable(dealers.get(id));
            }
        } catch (IOException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

}
