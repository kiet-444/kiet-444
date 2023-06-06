
package dto;

import java.io.Serializable;
/**
 *
 * @author 
 */
public class DealerDTO implements Serializable {
    private String id;
    private String name;
    private String addres;
    private String phone;
    private boolean  status;

    public DealerDTO(String id, String name, String addres, String phone, boolean status) {
        this.id = id;
        this.name = name;
        this.addres = addres;
        this.phone = phone;
        this.status = status;
    }
    public DealerDTO(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DealerDTO{" + "id=" + id + ", name=" + name + ", addres=" + addres + ", "
                + "phone=" + phone + ", status=" + status + '}';
    }
    
    
}
