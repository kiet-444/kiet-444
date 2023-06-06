package manager;

import dto.UserDTO;
import java.util.Optional;
import java.util.Scanner;
/**
 *
 * @author 
 */
public class Main {

    private Scanner sc = new Scanner(System.in);
    private LoginManager loginManager = new LoginManager();
    private UserManager userManager = new UserManager();
    private DealerManager dealerManager = new DealerManager();
    //private DeliveryManager deliveryManager = new DeliveryManager();

    public static void main(String[] args) {
        new Main().excute();
    }

    public void excute() {
        while (true) {
            Optional<UserDTO> logedIn = loginManager.login(sc);
            if (logedIn.isPresent()) {
                UserDTO user = logedIn.get();
                System.out.println("Your role: " + user.getRole());
                //phan quyen
                switch (user.getRole()) {
                    case "ADMIN":
                        userManager.handle(sc);
                        break;
                    case "R001":
                        dealerManager.handle(sc);
                        break;
                    case "R002":
                       // deliveryManager.handle(sc);
                        break;
                    default:
                }
            } else {
                System.out.println("Your username or password is incorrect!!!");
                System.out.print("Do you wanna continue (y/n): ");
                String isContinue = sc.nextLine();
                if (isContinue.equals("y")) {
                    break;
                }
            }
        }
    }
//d-s-m
}
