/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

/**
 *
 * @author guoc7
 */
import java.util.Scanner;
import java.io.File;

public class productMenu {

    static void menuproduct() {
        int userinput1 = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(" Welcom to XXX Menu ");
            System.out.println("Enter your Selection > ");
            System.out.println("1. Staff Part => Zi An Part");
            System.out.println("2. Product >");
            System.out.println("3. Enter Point of Sales System >");
            System.out.println("4. Exit >");
            userinput1 = scanner.nextInt();

            switch (userinput1) {
                case 1:
                    testFashionPosSystem FPS = new testFashionPosSystem();
                    FPS.displayMenu();
                    break;
                case 2:
                    productMenu();
                    break;

                case 3:
                    posMenu.posMenu();
                    break;
                case 4:
                    System.exit(-3);
                    break;
                default:
                    System.out.println("Invalid Input");
            }

//            if (userinput1 == 1) {
//                productMenu();
//            } else if (userinput1 == 2) {
//                posMenu.posMenu();
//            } else if (userinput1 == 3) {
//                System.out.println("Exit...");
//                System.exit(3);
//            }
        } while (userinput1 != 4);

    }

    static void productMenu() {
        int userinput4 = 0;
        productClass prod1 = new productClass();
        prod1.setFileName();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("<< Product Session >>");
            System.out.println("1. Check Product");
            System.out.println("2. Add in Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Back");
            System.out.println("5. Exit");
            userinput4 = scanner.nextInt();

            switch (userinput4) {
                case 1:
                    System.out.println("<< View Product Session >>");
                    viewProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    prod1.readLinebyLine();
                    deleteProduct();
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(-5);
                    break;
                default:
                    System.out.println("Invalid Input");

            }

        } while (userinput4 != 5);

    }

    static void addProduct() {
        productClass prod1 = new productClass();
        productFileHandle check = new productFileHandle();
        prod1.setFileName();
        boolean flagYesNo1 = true;
        //break throgh the while loop
        Scanner scanner = new Scanner(System.in);
        do {
            char yesNo1;
            char yesNo2;
            boolean flagCheck = true;
            boolean check1 = true;
            boolean check2 = true;
            boolean check3 = true;
            boolean check4 = true;
            System.out.println("<< ADD PRODUCT SESSION >>");
            System.out.println("Enter Product ID >");
            String id = scanner.nextLine();
            while (!check.checkProductDuplicate(id)) {
                // check product existing
                System.out.println("The product ID is Existing");
                System.out.println("Please try another Product ID");
                System.out.println("Enter Product ID >");
                id = scanner.nextLine();

            }
            prod1.setProductID(id);
            System.out.println("Enter Product Name >");
            prod1.setProductName(scanner.nextLine());
            System.out.println("Enter Product Price >");
            double price = scanner.nextDouble();
            prod1.setProductPrice(price);

            System.out.println("This is the product you added >");
            System.out.println("ID >" + prod1.getProductID());
            System.out.println("NAME >" + prod1.getProductName());
            System.out.println("PRICE >" + prod1.getProductPrice());

            System.out.println("\n");
            do {
                if (!check1 || !check2) {
                    break;
                }
                System.out.println("You wish to add this product?");
                yesNo2 = scanner.next().charAt(0);

                switch (yesNo2) {
                    case 'y':
                    case 'Y':
                        prod1.append();
                        System.out.println("Added ");
                        check1 = false;
                        flagYesNo1 = false;
                        break;
                    case 'n':
                    case 'N':
                        System.out.println("Cancelled");
                        check2 = false;
                        break;
                    default:
                        System.out.println("Invalid Input");

                }
            } while (yesNo2 != 'N' || yesNo2 != 'n' || yesNo2 != 'y' || yesNo2 != 'Y');

//            do {
//                if (!check3 || !check4) {
//                    break;
//                }
//                System.out.println("Any more Product?");
//                yesNo1 = scanner.next().charAt(0);
//                switch (yesNo1) {
//                    case 'N':
//                    case 'n':
//                        System.out.println("Leaving....");
//                        flagYesNo1 = false;
//                        check3 = false;
//                        break;
//                    case 'y':
//                    case 'Y':
//                        check4 = false;
//                        break;
//                    default:
//                        System.out.println("Invalid Input");
//                }
//            } while (yesNo1 != 'n' || yesNo1 != 'N');
        } while (flagYesNo1 != false);
    }

    static void viewProduct() {
        productClass prod1 = new productClass();
        prod1.setFileName();
        prod1.readLinebyLine();
        Scanner scanner = new Scanner(System.in);
        int userinput5 = 0;
        do {

            System.out.println("1. Back");
            System.out.println("2. Exit");
            userinput5 = scanner.nextInt();

            switch (userinput5) {
                case 1:
                    return;
                case 2:
                    System.exit(-2);
                default:
                    System.out.println("Invalid Input");
            }

//            if (userinput5 == 1) {
//                break;
//            } else if (userinput5 == 2) {
//                System.out.println("Exit....");
//                System.exit(2);
//            }
        } while (userinput5 != 2);

    }

    static void deleteProduct() {
        productClass prod1 = new productClass();
        prod1.setFileName();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product ID >");
        String input = scanner.nextLine();
        prod1.removeData(input);
        prod1.renameFile();
    }

}
