/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

import java.io.File;
import java.util.Scanner;
import JavaFashionAssignment.productMenu;

/**
 *
 * @author guoc7
 */
public class posMenu {

    static void posMenu() {

        int userinput2 = 0;
        Scanner scanner = new Scanner(System.in);
        posFileHandler cart = new posFileHandler();
        boolean flag = false;
        do {
            File oldFile = new File("Cart.txt");
            System.out.println(" XXX Point of Sales System ");
            System.out.println("Enter your Selection ");
            System.out.println("1. Add Cart");
            System.out.println("2. Check Cart");
            System.out.println("3. Delete Cart");
            System.out.println("4. Made Payment");
            System.out.println("5. Back");
            System.out.println("6. Exit");
            userinput2 = scanner.nextInt();

            switch (userinput2) {
                case 1:
                    productClass prod1 = new productClass();
                    prod1.setFileName();
                    prod1.readLinebyLine();
                    System.out.print("\n");
                    addCart();
                    break;
                case 2:
                    cart.checkCart();
                    // system pause;
                    System.out.println("Press Any Key To Continue...");
                    new java.util.Scanner(System.in).nextLine();
                    break;
                case 3:
                    cart.checkCart();
                    deleteCart();
                    break;
                case 4:
                    paymentMenu.paymentMenu();
                    break;
                case 5:
                    oldFile.delete();
                    return;
                case 6:
                    System.exit(-6);
                    oldFile.delete();
                    break;
                default:
                    System.out.println("Invalid Input");
            }

//            if (userinput2 == 1) {
//                addCart();
//            } else if (userinput2 == 2) {
//                cart.checkCart();
//            } else if (userinput2 == 3) {
//              deleteCart();
//            } else if (userinput2 == 4) {
//                 paymentMenu.paymentMenu();
//            } else if (userinput2 == 5) {
//                return productMenu.menu();
//            } else if (userinput2 == 6) {
//                System.out.println("Exit...");
//            }
        } while (userinput2 != 6);

    }

    static void addCart() {
        Scanner scanner = new Scanner(System.in);
        posFileHandler pos = new posFileHandler();
        System.out.println("Enter the product ID >");
        pos.searchCart(scanner.nextLine());
    }

    static void deleteCart() {
        Scanner scanner = new Scanner(System.in);
        posFileHandler pos = new posFileHandler();
        System.out.println("Enter the product ID you wish to delete");
        pos.removeData(scanner.nextLine());
        pos.renameFile();
    }

}
