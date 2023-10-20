/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

/**
 *
 * @author guoc7
 */
public class FashionPosSystem {
          private String firstName;
    private String lastName;
    private String staffID;
    private String password;
    private String emailId;
    private String phoneNo;

    public FashionPosSystem(String firstName, String lastName, String staffID, String password, String emailId, String phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffID = staffID;
        this.password = password;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }
    
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getstaffID() {
        return staffID;
    }
    public void setstaffID(String staffID) {
        this.staffID = staffID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    @Override
    public String toString() {
        return "Register" + " | "
                 + "First Name -> " + firstName + /*"\n" +*/
                " | " + "Last Name -> " + lastName + /*"\n" +*/
                " | " + "Staff ID -> " + staffID + /*"\n" +*/
                " | " + "Password -> " + password + /*"\n" +*/
                " | " + "Email ID -> " + emailId + /*"\n" +*/
                " | " + "Phone No -> " + phoneNo /*+ "\n"*/;
    }
}
