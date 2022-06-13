/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws3guitar;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author LEGION
 */
public class Tester {

    public static void main(String[] args) throws Exception {
        int choice;
        Scanner sc = new Scanner(System.in);
        GuitarManager obj = new GuitarManager();
        do {
            System.out.println("Selection!");
            System.out.println("1. Add guitar.");
            System.out.println("2. Search guitar by serial number.");
            System.out.println("3. Print list of guitar.");
            System.out.println("4. Exit!");
            System.out.println("Select: ");
            System.out.println(".......................................");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.inputInforGuitar();
                    System.out.println("Inputted");
                    break;
                case 2:
                    System.out.println("Input serial number you want to find: ");
                    String check;
                    sc = new Scanner(System.in);
                    check = sc.nextLine();
                    obj.searchBySeri(check);
                    break;
                case 3:
                    System.out.println("List of Guitars: ");
                    obj.showListOfGuitars();
                    break;
                case 4:
                    System.out.println("Thank you! Good bye!");
                    System.exit(0);
                default:
                    System.out.println("Please try again!");
            }
        } while (true);
    }
}
