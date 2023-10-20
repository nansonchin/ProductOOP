/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customers implements Serializable {

    private int customer_ID;
    private String customer_Name;
    private int age;
    private String gender;
    private String email;
    private String contact_number;
    private String Address;

    public Customers(int customer_ID, String customer_Name, int age, String gender, String email, String contact_number, String Address) {
        this.customer_ID = customer_ID;
        this.customer_Name = customer_Name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.contact_number = contact_number;
        this.Address = Address;
    }

    public Customers() {
        
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "customer_ID :" + customer_ID + "\n" + 
               "customer_Name :" + customer_Name +  "\n" +
               "age :" + age +  "\n" +
               "gender :" + gender +  "\n" +
               "email :" + email +  "\n" +
               "contact_number :" + contact_number +  "\n" +
               "Address :" + Address +  "\n";
    }
    
    }


