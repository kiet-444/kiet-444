package manager;

import dto.UserDTO;
import java.util.Optional;
import java.util.Scanner;
import service.UserService;
/**
 *
 * @author 
 */
public class LoginManager {

    private UserService userService = new UserService();

    Optional<UserDTO> login(Scanner sc) {
        System.out.println("Please Login to System.");
        System.out.print("Your username: ");
        String username = sc.nextLine();
        System.out.print("Your password: ");
        String passwd = sc.nextLine();
        if (userService.login(username, passwd)) {
            return userService.find(username);
        }
        return Optional.empty();
    }

}
