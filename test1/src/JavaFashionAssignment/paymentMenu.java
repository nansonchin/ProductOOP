/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

import java.io.File;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.IOException;

/**
 *
 * @author guoc7
 */
public class paymentMenu {

    static void paymentMenu() {
        int userinput3 = 0;
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        //half up 0.5 ^
        //half down 0.5 down
        //up
        df.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println("Payment Session Here >");
        paymentClass pay = new paymentClass();
        double roundOffPrice = Double.parseDouble(df.format(pay.getPrice()));
        System.out.println("Price         > " + roundOffPrice);
        // formatting decimal test 
        System.out.println("Serive Charge > " + df.format(pay.getServiceCharge()) + "%");
        System.out.println("GST Charge    > " + df.format(pay.getGST()) + "%");
        double tempPrice = pay.getPayment();
        do {
            System.out.print("Total Price > ");
            double roundOffPrice1 = pay.calculation(tempPrice);

            System.out.print(df.format(roundOffPrice1));
            double tempTotalPrice = Double.parseDouble(df.format(roundOffPrice1));
            System.out.println("\n");
            System.out.println("1. Pay");
            System.out.println("2. Member Pay And Register Member? => Ignatius Part");
            System.out.println("3. Back");
            System.out.println("4. Exit");
            userinput3 = scanner.nextInt();

            switch (userinput3) {
                case 1:
//                    System.out.println("Do you have a member card?[ y|n ]");
//                    char yesNo = scanner.next().charAt(0);
//                    switch(yesNo){
//                     case 'y':
//                        case 'Y':
//                            customerMenu.custMenu();
////                            System.out.println("Server is Currently Maintainnig \n");
////                            // system pause;
////                             System.out.println("Press Any Key To Continue...");
////                             new java.util.Scanner(System.in).nextLine();
//                            break;
//                        case 'n':
//                        case 'N':
                    System.out.println("Enter Amount > ");
                    double price = scanner.nextDouble();
                    System.out.println("");
                    System.out.print("Your Balance >");
                    double totalPrice = (price - tempTotalPrice);
                    System.out.println(df.format(totalPrice));
                    System.out.println("Press Any Key To Continue...");
                    File oldFile = new File("Cart.txt");
                    oldFile.delete();
                    new java.util.Scanner(System.in).nextLine();
                    break;
                //}
//                    return;
                case 2:
//                   customerMenu.custMenu();
//                    memberMenu();
                try {
                    IgMemberDriver.memberDriver();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                case 3:
                    return;
                case 4:
                    System.out.println("Exit...");
                    System.exit(-3);
                    break;
            }

        } while (userinput3 != 1);
    }

    static void memberMenu() {
        int userinput4 = 0;
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        //half up 0.5 ^
        //half down 0.5 down
        //up
        df.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println("Payment Session Here >");
        paymentClass pay1 = new paymentClass();
        double roundOffPrice = Double.parseDouble(df.format(pay1.getPrice()));
        System.out.println("Price         > " + roundOffPrice);
        // formatting decimal test 
        System.out.println("Serive Charge > " + df.format(pay1.getServiceCharge()) + "%");
        System.out.println("GST Charge    > " + df.format(pay1.getGST()) + "%");
        double tempPrice1 = pay1.getPayment();
        do {
            System.out.print("Total Price > ");
            double roundOffPrice2 = pay1.calculation(tempPrice1);
            double tempMemberPrice1 = (roundOffPrice2 * 0.9);
            System.out.print(df.format(tempMemberPrice1));
            double tempTotalPrice = Double.parseDouble(df.format(tempMemberPrice1));

            System.out.println("\n");
            System.out.println("1. Pay");
            System.out.println("2. Back");
            System.out.println("3. Exit");
            userinput4 = scanner.nextInt();

            switch (userinput4) {
                case 1:
                    System.out.println("Enter Amount > ");
                    double price = scanner.nextDouble();
                    System.out.println("");
                    System.out.print("Your Balance >");
                    double totalPrice = (price - tempTotalPrice);
                    System.out.println(df.format(totalPrice));
                    System.out.println("Press Any Key To Continue...");
                    File oldFile = new File("Cart.txt");
                    oldFile.delete();
                    new java.util.Scanner(System.in).nextLine();
                    break;

                case 2:
                    return;
                case 3:
                    System.out.println("Exit...");
                    System.exit(-3);
                    break;
                default:
                    System.out.println("Invalid Input");

            }

        } while (userinput4 != 1);
    }

}
