package manager;

import dto.DealerDTO;
import java.util.Optional;
import java.util.Scanner;
import service.DealerService;

/**
 *
 * @author 
 */
class DealerManager {

    private DealerService service = new DealerService();

    public void printMenu() {
        System.out.println("1-Add new dealer");
        System.out.println("2-Search a dealer");
        System.out.println("3-Remove a dealer");
        System.out.println("4-Update a dealer");
        System.out.println("5-Print all dealers");
        System.out.println("6-Print continuing dealers");
        System.out.println("7-Print un-continuing dealers");
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
                     System.out.print("Enter ID: ");
                    String ID = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Address ");
                    String address = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Status: ");                  
                    String status = sc.nextLine();
                    DealerDTO createDealer = new DealerDTO(ID, name, address, phone, status.equals("enable"));
                   boolean success= service.create(createDealer);
                    System.out.println("Create status: " +success);
                    break;
                case "2":
                    System.out.print("Enter ID you want to search: ");
                    Optional<DealerDTO> found = service.find(sc.nextLine().trim());
                    if (found.isPresent()) {
                        System.out.println(found.get());
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case "3":
                    System.out.print("Enter ID you want to remove: ");
                    Optional<DealerDTO> found3 = service.find(sc.nextLine());
                    if (found3.isPresent()) {
                        System.out.println(found3.get());
                        service.delete(found3.get().getId());
                    } else {
                        System.out.println("User not found.");
                    }

                    break;
                case "4":
                    System.out.print("Enter ID you want update: ");
                    Optional<DealerDTO> found2 = service.find(sc.nextLine());
                    DealerDTO dealer = found2.get();
                    if (found2.isPresent()) {
                        System.out.println(found2.get());
                        System.out.println("Ener the new Name: ");
                        String newName = sc.nextLine();
                        System.out.println("Ener the new Address: ");
                        String newAddress = sc.nextLine();
                        System.out.println("Ener the new Phone: ");
                        String newPhone = sc.nextLine();
                        System.out.println("Ener the new Status:");
                        String newStatus = sc.nextLine();
                        dealer.setAddres(newAddress);
                        dealer.setName(newName);
                        dealer.setPhone(newPhone);
                        dealer.setStatus(newStatus.equals("enable"));
                        

                        boolean update = service.update(dealer);
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
