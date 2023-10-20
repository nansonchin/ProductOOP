/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Functions {

    Customers c = new Customers();
    Scanner scanner = new Scanner(System.in);  //INT
    Scanner scanner1 = new Scanner(System.in); //STRING
    File file = new File("Customers.txt");
    ArrayList<Customers> cs = new ArrayList<Customers>();
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    ListIterator li = null;

    public void filefunction() throws FileNotFoundException, IOException, ClassNotFoundException {
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            cs = (ArrayList<Customers>) ois.readObject();
            ois.close();
        }
    }

    public void add() throws ClassNotFoundException, FileNotFoundException, IOException {
        int input;
        filefunction();
        System.out.print("===================\n");
        System.out.print("CREATE MEMBER\n");
        System.out.print("===================\n");
        System.out.print("How many Customers you want to Insert: ");
        input = scanner.nextInt();

        for (int i = 0; i < input; i++) {
            System.out.println("Customer ID :");
            int id = scanner.nextInt();
            c.setCustomer_ID(id);

            System.out.println("Name :");
            String name = scanner1.nextLine();
            c.setCustomer_Name(name.toUpperCase());

            System.out.println("Age :");
            int c_age = scanner.nextInt();
            c.setAge(c_age);

            System.out.println("Gender :");
            String c_gender = scanner1.nextLine();
            c.setGender(c_gender);

            System.out.println("Email :");
            String c_email = scanner1.nextLine();
            c.setEmail(c_email.toLowerCase());

            System.out.println("Contact Number :");
            String phoneNumber = scanner1.nextLine();
            c.setContact_number(phoneNumber);

            System.out.println("Address :");
            String c_address = scanner1.nextLine();
            c.setAddress(c_address.toUpperCase());

            cs.add(new Customers(c.getCustomer_ID(), c.getCustomer_Name(), c.getAge(), c.getGender(), c.getEmail(), c.getContact_number(), c.getAddress())); 
        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        System.out.println("Saved successful");
        oos.writeObject(cs);
        oos.close();
    }

    public void display() throws FileNotFoundException, IOException, ClassNotFoundException {

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            cs = (ArrayList<Customers>) ois.readObject();
            ois.close();
            System.out.print("=========================================\n");
            System.out.print("VIEW CUSTOMER DETAILS\n");
            System.out.print("==========================================\n");
            li = cs.listIterator();
            while (li.hasNext()) {
                System.out.println(li.next());
            }
            System.out.println("========================================");
        } else {
            System.out.println("File no exists");
        }
    }

    public void search() throws IOException, FileNotFoundException, ClassNotFoundException {

        char option = 'N';
        do {
            if (file.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(file));
                cs = (ArrayList<Customers>) ois.readObject();
                ois.close();
                boolean found = false;
                System.out.print("========================================\n");
                System.out.print("SEARCH CUSTOMER DETAILS\n");
                System.out.print("========================================\n");
                System.out.println("Enter Customer ID to search :");
                int id = scanner.nextInt();
                System.out.println("========================================");
                li = cs.listIterator();
                while (li.hasNext()) {
                    Customers cust = (Customers) li.next();
                    if (cust.getCustomer_ID() == id) {
                        System.out.println(cust);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Record no found !");
                }
                System.out.println("========================================");
            } else {
                System.out.println("File no exists");
            }

            System.out.print("Do you wish to continue? (Y/N) :");
            option = scanner1.next().charAt(0);
             
        } while (option == 'Y');
    }

    public void delete() throws IOException, FileNotFoundException, ClassNotFoundException {
        int id;
        char option = 'N';
        do {
            if (file.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(file));
                cs = (ArrayList<Customers>) ois.readObject();
                ois.close();
                boolean found = false;
                System.out.print("========================================\n");
                System.out.print("DELETE CUSTOMER DETAILS\n");
                System.out.print("========================================\n");
                System.out.println("Enter Customer ID to delete :");
                id = scanner.nextInt();
                System.out.println("========================================");
                li = cs.listIterator();
                while (li.hasNext()) {
                    Customers cust = (Customers) li.next();
                    if (cust.getCustomer_ID() == id) {
                        li.remove();
                        found = true;
                    }
                }
                if (found) {
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(cs);
                    oos.close();
                    System.out.println("Record delete successfully");
                } else {
                    System.out.println("Record no found !");
                }
                System.out.println("========================================");
            } else {
                System.out.println("File no exists");
            }
            
            System.out.print("Do you wish to continue? (Y/N) :");
            option = scanner1.next().charAt(0);
        } while (option == 'Y');
    }

    public void Update() throws IOException, FileNotFoundException, ClassNotFoundException {
        int id, c_age;
        String name, c_gender, c_email, phoneNumber, c_address;
        char option = 'N';

        do {
            if (file.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(file));
                cs = (ArrayList<Customers>) ois.readObject();
                ois.close();
                boolean found = false;
                System.out.print("========================================\n");
                System.out.print("UPDATE CUSTOMER DETAILS\n");
                System.out.print("========================================\n");
                System.out.println("Enter Customer ID to update :");
                id = scanner.nextInt();
                System.out.println("========================================");
                li = cs.listIterator();
                while (li.hasNext()) {
                    Customers cust = (Customers) li.next();
                    if (cust.getCustomer_ID() == id) {

                        System.out.println("New Name :");
                        name = scanner1.nextLine();
                        c.setCustomer_Name(name.toUpperCase());

                        System.out.println("New Age :");
                        c_age = scanner.nextInt();
                        c.setAge(c_age);

                        System.out.println("New Gender :");
                        c_gender = scanner1.nextLine();
                        c.setGender(c_gender);

                        System.out.println("New Email :");
                        c_email = scanner1.nextLine();
                        c.setEmail(c_email.toLowerCase());

                        System.out.println("New Contact Number :");
                        phoneNumber = scanner1.nextLine();
                        c.setContact_number(phoneNumber);

                        System.out.println("New Address :");
                        c_address = scanner1.nextLine();
                        c.setAddress(c_address.toLowerCase());

                        li.set(new Customers(c.getCustomer_ID(), c.getCustomer_Name(), c.getAge(), c.getGender(), c.getEmail(), c.getContact_number(), c.getAddress()));
                        found = true;
                    }
                }
                if (found) {
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(cs);
                    oos.close();
                    System.out.println("Update delete successfully");
                } else {
                    System.out.println("Record no found !");
                }
                System.out.println("========================================");
            } else {
                System.out.println("File no exists");
            }
            
            System.out.print("Do you wish to continue? (Y/N) :");
            option = scanner1.next().charAt(0);
        } while (option == 'Y');
    }
}

