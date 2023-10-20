/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

/**
 *
 * @author guoc7
 */
import java.util.ArrayList;
import JavaFashionAssignment.productClass;
public class posClass extends posFileHandler {

   private productClass i = new productClass();
   private ArrayList<Double> price = new ArrayList<Double>();
    
    public posClass(){
        super();
    }
    
    public void setProduct(){
    
    }
    
    public String getProduct(){
        return i.getProductID()+i.getProductName() + i.getProductPrice();
    }
    
   
    
 
 
    
}
