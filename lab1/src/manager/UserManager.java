package manager;

import dto.UserDTO;
import java.util.Optional;
import java.util.Scanner;
import service.UserService;
/**
 *
 * @author 
 */
class UserManager {

    private UserService service = new UserService();

    public void printMenu() {
        System.out.println("1-Add new user");
        System.out.println("2-Search a user");
        System.out.println("3-Remove a user");
        System.out.println("4-Update a user");
        System.out.println("5-Print all users");
        System.out.println("6-Print continuing users");
        System.out.println("7-Print un-continuing users");
        System.out.println("8-Write to file");
        System.out.println("Other to quit.");
    }

    void handle(Scanner sc) {
        boolean loope = true;
        while (loope) {
            printMenu();
            System.out.print("Choose [1..8]: ");
            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter password: ");
                    String passwd = sc.nextLine();
                    System.out.print("Enter role: ");
                    String role = sc.nextLine();
                    System.out.print("Enter status: ");
                    String status = sc.nextLine();
                    UserDTO user = new UserDTO(name, passwd, role, status.equals("enable"));
                    service.create(user);
                    break;
                case "2":
                    System.out.print("Enter username you want to search: ");
                    Optional<UserDTO> found = service.find(sc.nextLine());
                    if (found.isPresent()) {
                        System.out.println(found.get());
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case "3":
                    System.out.print("Enter username you want to remove: ");
                    Optional<UserDTO> found3 = service.find(sc.nextLine());               
                    if (found3.isPresent()) {
                        System.out.println(found3.get());
                        service.delete(found3.get().getUsername());
                    } else {
                        System.out.println("User not found.");
                    }
                   
                    
                    break;
                case "4":
                     System.out.print("Enter username you want update: ");
                   Optional<UserDTO> found2 = service.find(sc.nextLine());
                    if (found2.isPresent()) {
                        System.out.println(found2.get());
                        System.out.print("Enter the new password: ");
                        String Newpassword =  sc.nextLine();
                        found2.get().setPasswd(Newpassword);
                boolean update = service.update(found2.get());
                        System.out.println("update success!!!");
                    } else {
                        System.out.println("User not found.");
                    }
                    

                    //Update
                    break;
                case "5":
                    service.findAll().forEach(System.out::println);
                    System.out.println("-------------------------------------");
                    break;
                case "6":
                    //fill
                    break;
                case "7":
                    //fill
                    break;
                case "8":
                    System.out.println("Automatic");
                    break;
                default:
                    loope = false;
            }
        }
    }

   

}
