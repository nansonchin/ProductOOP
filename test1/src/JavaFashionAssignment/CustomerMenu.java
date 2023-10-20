/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

/**
 *
 * @author guoc7
 */
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class CustomerMenu {

   Functions functions = new Functions();

    public void menu() throws ClassNotFoundException, IOException {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("  _          _     _   _       \n");
	    System.out.print(" \\ \\        / /   \\ \\ / /  \n");
	    System.out.print("  \\ \\  / \\ / /     \\ V /   \n");
            System.out.print("   \\ \\ / \\/ /       > <    \n");
            System.out.print("    \\  / \\ /       / . \\ \n");
	    System.out.print("     \\ / \\/  'O'  /_ /\\_\\  \n");
            System.out.print("===============================\n");
	    System.out.print("|        CUSTOMERS MENU       |\n");
            System.out.print("===============================\n");
            System.out.print("|1.Insert                     |\n");
            System.out.print("|2.Display                    |\n");
            System.out.print("|3.Search                     |\n");
            System.out.print("|4.Delete                     |\n");
            System.out.print("|5.Update                     |\n");
            System.out.print("|6.Pay With Member            |\n");
            System.out.print("|6.Back                       |\n");
            System.out.print("|0.Exit                       |\n");
            System.out.print("===============================\n");
            
            System.out.print("Enter your Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    functions.add();
                    break;
                case 2:
                    functions.display();
                    break;
                case 3:
                    functions.search();
                    break;
                case 4:
                    functions.delete();
                    break;
                case 5:
                    functions.Update();
                    break;
                case 6:
                functions.search();
                paymentMenu.memberMenu();
                break;
                case 7:
                    posMenu.posMenu();
                    break;
                case 0:
                    exit(0);
                default:
                    System.out.println("Please enter true Choice: ");
                    break;
            }
        } while (choice != 0);
    }
}
