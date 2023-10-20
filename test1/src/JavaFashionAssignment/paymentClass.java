/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import JavaFashionAssignment.productFileHandle;
import JavaFashionAssignment.productClass;

/**
 *
 * @author guoc7
 */
public class paymentClass {

    private double totalPrice;
    private static double serviceCharge = 1.02;
    private static double gst = 1.06;
    productFileHandle productPrice = new productFileHandle();
    productClass prod1 = new productClass();

    paymentClass() {
    }

    paymentClass(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPayment(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getPayment() {
        return this.totalPrice;
    }
    
    public static double getGST(){
        return (gst-1);
    }
    
    public static double getServiceCharge(){
        return (serviceCharge-1);
    }
    
    public double balance(double price){
        return (price - this.totalPrice);
    }

    public double getPrice() {
        BufferedReader read;
        ArrayList<productClass> product = new ArrayList<productClass>();
        
        try {
            read = new BufferedReader(new FileReader("Cart.txt"));
            String data = null;
            // 
            System.out.println("ID" + "    " + "Name" + "    " + "Price");
            while((data=read.readLine())!=null){
            String[] line=data.split("\\|");
            prod1.setProductID(line[0]);
            prod1.setProductName(line[1]);
            prod1.setProductPrice(Double.parseDouble(line[2]));
            System.out.println(prod1.getProductID() + "  " + prod1.getProductName() + "  " + prod1.getProductPrice());
            product.add(new productClass(prod1.getProductID(), prod1.getProductName(), prod1.getProductPrice()));
            this.totalPrice+=prod1.getProductPrice();   
                
        }
            read.close();
            
        }catch(IOException e){
        e.printStackTrace();
        }
        return getPayment();
    }

    public double calculation(double price) {
        return ((price * serviceCharge) * gst);
    }
}
