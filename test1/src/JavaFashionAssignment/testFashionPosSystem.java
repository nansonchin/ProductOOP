/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author guoc7
 */
public class testFashionPosSystem {
         public  static  String filename = "Employee.txt";


    public static void createNewFileWithHeaders(){
        File Employee = new File(filename);

        try {

            if( Employee.createNewFile() == true){

                try {
                    FileWriter writer = new FileWriter(filename,true);
                    writer.append("First Name" + "|" + "\n" + "Last Name" + "|" + "\n" + "Staff ID" + "|" + 
                            "\n" + "Password" + "|" + "\n" + "Email ID" + "|" + "\n" + "Phone No" + "|");
                    //String staffID.sort();
                    writer.append("\n");
                    writer.close();
                    System.out.println("File Successfully Created!");
                } catch (IOException e) {
                    System.out.println(e);
                }

            }
            else {
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    static int i = 0;
    String[] admin = {"admin", "admin123"};
    static ArrayList<String> list = new ArrayList<>();
    private Scanner s = new Scanner(System.in);
    
    public void register() {
        System.out.println("Please enter the name :");
        if (s.next().equals(admin[0])) {
            System.out.println("Please enter the password :");
            if (s.next().equals(admin[1])) {
                System.out.println("Login successfully!(^.^)");
            } else {
                System.out.println("Invalid Password! Please enter again!(0.0)");
                register();
            }
        } else {
            System.out.println("Invalid the name!Please enter again!(0.0)");
            register();
        }
    }

    public static void SignIn( Scanner input){
        System.out.println("Enter Your First Name: ");
        String firstName = input.next();
        
        System.out.println("Enter Your Last Name: ");
        String lastName = input.next();
        
        System.out.println("Enter Your Staff ID: ");
        String staffID = input.next();
        
        System.out.println("Enter Your Password: ");
        String password = input.next();
        
        System.out.println("Enter Your Email ID: ");
        String emailId = input.next();
        
        System.out.println("Enter Your Phone No: ");
        String phoneNo = input.next();
        
        FashionPosSystem FPS = new FashionPosSystem(firstName, lastName, staffID, password, emailId, phoneNo);

        try {
            FileWriter writer = new FileWriter(filename,true);
            writer.append(FPS.toString());
            writer.append("\n");
            writer.close();
            System.out.println("Register Succefully!(^.^)");
        } catch (IOException e) {
            System.out.println(e);
        }
        

    }

    public static void  deleteStaff(ArrayList<String> arrayList,Scanner input){
        System.out.println("Enter the Staff ID You Want To Delete @.@: ");
        String searchKey=input.next();
        String line;
        try {

            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine())!=null){
                if(line.contains(searchKey)){
                    System.out.println(line);
                    continue;
                }else {
                    arrayList.add(line);
                }
            }

        }catch (Exception e){

        }
        try {
            FileWriter fw = new FileWriter(filename);
            for (int i = 0; i < arrayList.size(); i++){
                fw.append( arrayList.get(i));
                fw.append("\n");
            }
            fw.close();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("Successfully Delete (^.^)!");
        }}

    public static void ModifyStaff(ArrayList<String>arrayList,Scanner input){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            System.out.println("Please Enter Staff ID Wanted To Change!(~.~)");
            String searchKey = input.next();
            String line;
            while ((line=br.readLine())!=null){
                if(   line.contains(searchKey)){
                    System.out.println("Enter The Staff Detail You Want To Change(~.~): ");
                    String oldValue = input.next();
                    System.out.println("Enter The New Staff Detail(^.^): ");
                    String newValue = input.next();
                    arrayList.add(line.replace(oldValue,newValue));


                }else {
                    arrayList.add(line);
                }

            }
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            FileWriter w = new FileWriter(filename);
            for(int i = 0; i <arrayList.size(); i++){
                w.append(arrayList.get(i));
                w.append("\n");
            }
            w.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void searchStaffID(Scanner input){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            System.out.println("Please Enter The Staff Details!@.@");
            String searchKey = input.next();
            String line;
            while ((line = br.readLine()) != null){
                if(   line.contains(searchKey)){
                    System.out.println(line);
                }
            }


        }catch (Exception e){
            System.out.println(e);
        }


    }
    public static void getAllStaff(){

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));


            String line;
            while ((line = br.readLine())!=null){

                System.out.println(line);

            }

        }catch (Exception e){
            System.out.println(e);
        }
    }



    public void displayMenu(){
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        while(true){
            ArrayList<String> arrayList = new ArrayList<String>();

            System.out.println(" ---------------------------------------------------");
            System.out.println("|                  Staff Menu                       |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("|                  1.Register                       |");
            System.out.println("|                  2.Delete                         |");
            System.out.println("|                  3.Modify                         |");
            System.out.println("|                  4.Seach                          |");
            System.out.println("|                  5.Back                           |");
            System.out.println(" ---------------------------------------------------");
            System.out.print("Choose (1-5): ");
            int x = input.nextInt();
            if(x == 5) {
                System.out.println();
                System.out.print("Successfully EXIT!@.@");
                System.out.println();
                break;
            }
            else if(x == 1){
                SignIn(input);
            }
            else if(x == 2){
                deleteStaff(arrayList,input);
            }
            else  if(x==3){
                ModifyStaff(arrayList,input);
            }
            else  if(x==4){
                searchStaffID(input);
            }
            else{
                System.out.println("Please Enter A Vaild Number(1-5):");
            }
        }
    }
}
