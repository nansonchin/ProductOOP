/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

/**
 *
 * @author guoc7
 */
public class productClass extends productFileHandle {

    private String productID;
    private String productName;
    private double productPrice;

    
    public productClass() {
        super();
    }

    public productClass(String productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    
    public productClass(String productID, String productName, double productPrice,int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
         
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String WrittenString() {
        return this.productID + "|" + this.productName + "|" + this.productPrice + "|" + "\n";
    }

    public void append() {
         super.appendFile(this.WrittenString());
    }

    @Override
    public String toString() {
        return "ID >" + this.productID + "Name >" + this.productName + "Price" + this.productPrice;
    }
}
