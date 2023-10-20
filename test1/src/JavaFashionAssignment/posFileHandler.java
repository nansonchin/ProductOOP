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
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class posFileHandler extends productClass {

    private static ArrayList<productClass> pc = new ArrayList<productClass>();

    public posFileHandler() {
        super();
    }

    public void searchCart(String input) {

        BufferedReader read;
        productClass pc1 = new productClass();
        ArrayList<productClass> test = new ArrayList<productClass>();
        String cartFile = "Cart.txt";
        File fromFile = new File("Product.txt");
        boolean trueFalse = false;

        try {
            FileWriter fw = new FileWriter(cartFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            read = new BufferedReader(new FileReader(fromFile));
            String data = null;
            while ((data = read.readLine()) != null) {
                String[] line = data.split("\\|");
                pc1.setProductID(line[0]);
                pc1.setProductName(line[1]);
                pc1.setProductPrice(Double.parseDouble(line[2]));
                if (input.equals(line[0])) {

//                    System.out.println("ID > " + pc1.getProductID() + " Name > " + pc1.getProductName()
//                            + " Price >" + pc1.getProductPrice());
                    System.out.println(pc1.toString());
                    test.add(pc1);

                    pw.println(pc1.getProductID() + "|" + pc1.getProductName() + "|" + pc1.getProductPrice() + "|");
                    pw.flush();
                    pw.close();
                    trueFalse = true;

                }

            }
            if (!trueFalse) {

                System.out.println("Unable to find the product");

            }
            fw.close();
            bw.close();
            pw.close();
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void checkCart() {
        BufferedReader read;
//        ArrayList<productClass> pc1=new ArrayList<productClass>();
        productClass pc1 = new productClass();
        ArrayList<productClass> test = new ArrayList<productClass>();

        try {
            read = new BufferedReader(new FileReader("Cart.txt"));
            String data = null;
            System.out.println("ID" + "    " + "Name" + "    " + "Price");
            while ((data = read.readLine()) != null) {
                String[] line = data.split("\\|");
                pc1.setProductID(line[0]);
                pc1.setProductName(line[1]);
                pc1.setProductPrice(Double.parseDouble(line[2]));
                
                System.out.println(pc1.getProductID() + "  " + pc1.getProductName() + "  " + "  " + pc1.getProductPrice());
                test.add(new productClass(pc1.getProductID(), pc1.getProductName(), pc1.getProductPrice()));
//                System.out.println(data);
//                data = read.readLine();
            }
            read.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeData(String removeTerm) {
        BufferedReader read;
        productClass pc1 = new productClass();
        ArrayList<productClass> test = new ArrayList<productClass>();
        String tempFile = "Carttemp.txt";
        File oldFile = new File("Cart.txt");
        File newFile = new File(tempFile);
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            read = new BufferedReader(new FileReader("Cart.txt"));
            String data = null;
            while ((data = read.readLine()) != null) {

                String[] line = data.split("\\|");
                pc1.setProductID(line[0]);
                pc1.setProductName(line[1]);
                pc1.setProductPrice(Double.parseDouble(line[2]));
                if (removeTerm.equals(pc1.getProductID())) {
                    System.out.println("ID > " + pc1.getProductID() + " Name > " + pc1.getProductName() + " Price >" + pc1.getProductPrice());
                }
                if (!removeTerm.equals(pc1.getProductID())) {
                    test.add(new productClass(pc1.getProductID(), pc1.getProductName(), pc1.getProductPrice()));
                    pw.println(pc1.getProductID() + "|" + pc1.getProductName() + "|" + pc1.getProductPrice() + "|");
                }
            }
            pw.flush();
            // flush it all out the data 
            pw.close();
            bw.close();
            read.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }

//        oldFile.delete();
//        File dump = new File("Cart.txt");
//        newFile.renameTo(dump);
    }

    @Override
    public void renameFile() {
        try {
            File oldFile = new File("Cart.txt");
            File newFile = new File("Carttemp.txt");
            boolean success = oldFile.delete();
            File dump = new File("Cart.txt");
            newFile.renameTo(dump);
            if (success) {
                System.out.println(newFile.getName() + "is renamed and deleted!");
            } else {
                System.out.println("Operation Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
