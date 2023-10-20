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
import JavaFashionAssignment.productClass;

public class productFileHandle {

    private String fileName;
    private String input;

    public productFileHandle() {
    }

    public productFileHandle(String input) {
        this.fileName = "Product.txt";
        this.input = input;
    }

    //setter
    public void setFileName() {
        this.fileName = "Product.txt";
    }

    public void setInput(String input) {
        this.input = input;
    }

    //getter
    public String getInput() {
        return this.input;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String createFile() {
        // 
        try {
            File posFile = new File(this.fileName);
            if (posFile.createNewFile()) {
                return "File created:" + posFile.getName();
            } else {
                return "File already exists.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred. System have bug! Required some IT Personnel Help";
        }
    }

    public String appendFile(String input) {
        // try append the file
        try ( FileWriter file = new FileWriter(this.fileName, true)) {
            file.write(input);
        } catch (IOException e) {
            e.printStackTrace();
            return "File is unabe to append";
        }
        return "File is Appended";
    }

    public void readLinebyLine() {
        BufferedReader read;
        productClass pc1 = new productClass();
        ArrayList<productClass> test = new ArrayList<productClass>();
        try {
            read = new BufferedReader(new FileReader(this.fileName));
            String data = null;
            System.out.println("ID" + "    " + "Name" + "    " + "Price");
            while ((data = read.readLine()) != null) {
                String[] line = data.split("\\|");
                pc1.setProductID(line[0]);
                pc1.setProductName(line[1]);
                pc1.setProductPrice(Double.parseDouble(line[2]));
                System.out.println(pc1.getProductID() + "  " + pc1.getProductName() + "  " + pc1.getProductPrice());
                test.add(new productClass(pc1.getProductID(), pc1.getProductName(), pc1.getProductPrice()));

            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeFromFile(String input) {
        
        BufferedReader read;
        productClass pc1 = new productClass();
        ArrayList<productClass> test = new ArrayList<productClass>();
        try {
            read = new BufferedReader(new FileReader(this.fileName));
            String data = null;
            while ((data = read.readLine()) != null) {

                String[] line = data.split("\\|");
                pc1.setProductID(line[0]);
                pc1.setProductName(line[1]);
                pc1.setProductPrice(Double.parseDouble(line[2]));
                if (input.equals(pc1.getProductID())) {
                   //check product existing 
                    System.out.println("ID > " + pc1.getProductID() + " Name > " + pc1.getProductName() + " Price >" + pc1.getProductPrice());
                }
                // store into array 
                test.add(new productClass(pc1.getProductID(), pc1.getProductName(), pc1.getProductPrice()));
                //close the buffered reader   
                read.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    public boolean checkProductDuplicate(String name) {
        BufferedReader read;
        productClass pc1 = new productClass();
        ArrayList<productClass> test = new ArrayList<productClass>();
        try {
            read = new BufferedReader(new FileReader("Product.txt"));
            String data = null;

            while ((data = read.readLine()) != null) {
                //search all the file 
                String[] line = data.split("\\|");
                pc1.setProductID(line[0]);
                pc1.setProductName(line[1]);
                pc1.setProductPrice(Double.parseDouble(line[2]));
                test.add(new productClass(pc1.getProductID(), pc1.getProductName(), pc1.getProductPrice()));
                if (name.equals(pc1.getProductID())) {
                    return false;
                }
            }
            read.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void removeData(String removeTerm) {
        BufferedReader read;
        productClass pc1 = new productClass();
        ArrayList<productClass> test = new ArrayList<productClass>();
        String tempFile = "temp.txt";
        File oldFile = new File("Product.txt");
        File newFile = new File(tempFile);
        try {

            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            read = new BufferedReader(new FileReader(this.fileName));
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
            read.close();
            pw.flush();
            pw.close();
            fw.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        
    }

    public void renameFile() {
        try {
            File oldFile = new File("Product.txt");
            File newFile = new File("Temp.txt");
            boolean success=oldFile.delete();
            File dump = new File("Product.txt");
            newFile.renameTo(dump);
            if (success) {
                System.out.println(newFile.getName() + " is renamed and deleted!");
            } else {
                System.out.println("Operation Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
