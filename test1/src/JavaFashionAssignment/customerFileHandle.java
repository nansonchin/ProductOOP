/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFashionAssignment;

/**
 *
 * @author guoc7
 */
            import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class customerFileHandle {


/**
 *
 * @author user
 */
    
    private String fileName;
    private String input;
    
    public customerFileHandle(){
        
    }
    
    public customerFileHandle(String input){
        this.fileName = "Customers.txt";
        this.input = input;
    }
    
    public void setFileName(){
        this.fileName = "Customers.txt";
    }
    
    public void setInput(String input){
        this.input = input;
    }
    
    public String getInput(){
        return this.input;
    }
    
    public String getFileName(){
        return this.fileName;
    }
    
    public String createFile(){
        
        try{
            File file = new File(this.fileName);
            if(file.createNewFile()){
                return "File created:" + file.getName();
            }else{
                return "File already exists.";
            }
        }catch(IOException e){
             e.printStackTrace();
            return "An error occurred. System have bug! Required some IT Personnel Help";
        }
    }
    
    public String appendFile(String input) {
        
        try ( FileWriter file = new FileWriter("Customers.txt", true)) {
            file.write(input);
        } catch (IOException e) {
            e.printStackTrace();
            return "File is unabe to append";
        }
        return "File is Appended";
    }
    
    public void readbyLine(){
        BufferedReader read;
        Customers c = new Customers();
        ArrayList<Customers> list = new ArrayList<Customers>();
        try{
            read = new BufferedReader(new FileReader("Customers.txt"));
            String data = null;
            System.out.println("Customer ID" + "    " + "Customer Name" + "    " + "Age" + "    " +"Gender" + "    " +"Email" + "    " +"Contact Number" + "    " +"Address");
            while((data = read.readLine())!= null){
                String[] line = data.split("\\|");
                c.setCustomer_ID(Integer.parseInt(line[0]));
                c.setCustomer_Name(line[1]);
                c.setAge(Integer.parseInt(line[2]));
                c.setGender(line[3]);
                c.setEmail(line[4]);
                c.setContact_number(line[5]);
                c.setAddress(line[6]);
                System.out.println(c.getCustomer_ID() + "  " + c.getCustomer_Name() + "  " + c.getAge() + "  " + c.getGender() + "  " + c.getEmail() + "  " + c.getContact_number() + "  " + c.getAddress());
                list.add(new Customers(c.getCustomer_ID(),c.getCustomer_Name(),c.getAge(),c.getGender(),c.getEmail(),c.getContact_number(),c.getAddress()));
            }
            read.close();
        }catch(IOException e ){
            e.printStackTrace();
        }
    }
    
    public void storeFromFile(String input) {
        BufferedReader read;
        Customers c = new Customers();
        ArrayList<Customers> list = new ArrayList<Customers>();
        try {
            read = new BufferedReader(new FileReader(this.fileName));
            String data = null;
            while ((data = read.readLine()) != null) {
                String[] line = data.split("\\|");
                c.setCustomer_ID(Integer.parseInt(line[0]));
                c.setCustomer_Name(line[1]);
                c.setAge(Integer.parseInt(line[2]));
                c.setGender(line[3]);
                c.setEmail(line[4]);
                c.setContact_number(line[5]);
                c.setAddress(line[6]);
                if(input.equals(c.getCustomer_ID())){
                    System.out.println("Customer ID: " + c.getCustomer_ID() + 
                                       " Customer Name: " + c.getCustomer_Name() + 
                                       " Age: " + c.getAge() + 
                                       " Gender: " + c.getGender() + 
                                       " Email: " + c.getEmail() + 
                                       " Contact Number: " + c.getContact_number() + 
                                       " Address: " + c.getAddress());
                }
                list.add(new Customers(c.getCustomer_ID(),c.getCustomer_Name(),c.getAge(),c.getGender(),c.getEmail(),c.getContact_number(),c.getAddress()));
                read.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkCustomerDuplicate(int name){
        BufferedReader read;
        Customers c = new Customers();
        ArrayList<Customers> list = new ArrayList<Customers>();
        try{
            read = new BufferedReader(new FileReader("Customers.txt"));
            String data = null;
            
            while((data = read.readLine()) != null){
                String [] line = data.split("\\|");
                c.setCustomer_ID(Integer.parseInt(line[0]));
                c.setCustomer_Name(line[1]);
                c.setAge(Integer.parseInt(line[2]));
                c.setGender(line[3]);
                c.setEmail(line[4]);
                c.setContact_number(line[5]);
                c.setAddress(line[6]);
                list.add(new Customers(c.getCustomer_ID(),c.getCustomer_Name(),c.getAge(),c.getGender(),c.getEmail(),c.getContact_number(),c.getAddress()));
                if(name == c.getCustomer_ID()){
                    return false;
                }
            }
            read.close();
        }catch (IOException e) {
             e.printStackTrace();
        }
        return true;
    }
    
    public boolean checkGender(String gender){
        if(gender != "F" || gender != "M"){
            return false;
        }
        return true;
    }
    
    public void removeData(int removeTerm){
        BufferedReader read;
        Customers c = new Customers();
        ArrayList<Customers> list = new ArrayList<Customers>();
        String tempFile = "Tempcustomer.txt";
        File oldFile = new File("Customers.txt");
        File newFile = new File(tempFile);
        try{
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            read = new BufferedReader(new FileReader("Customers.txt"));
            String data = null;
            while((data = read.readLine()) != null){
                String[] line = data.split("\\|");
                c.setCustomer_ID(Integer.parseInt(line[0]));
                c.setCustomer_Name(line[1]);
                c.setAge(Integer.parseInt(line[2]));
                c.setGender(line[3]);
                c.setEmail(line[4]);
                c.setContact_number(line[5]);
                c.setAddress(line[6]);
                if(removeTerm==c.getCustomer_ID()){
                    System.out.println("Customer ID: " + c.getCustomer_ID() + 
                                       " Customer Name: " + c.getCustomer_Name() + 
                                       " Age: " + c.getAge() + 
                                       " Gender: " + c.getGender() + 
                                       " Email: " + c.getEmail() + 
                                       " Contact Number: " + c.getContact_number() + 
                                       " Address: " + c.getAddress());
                }
                
                if(removeTerm!=c.getCustomer_ID()){
                    list.add(new Customers(c.getCustomer_ID(),c.getCustomer_Name(),c.getAge(),c.getGender(),c.getEmail(),c.getContact_number(),c.getAddress()));
                    pw.println(c.getCustomer_ID() + "|" + c.getCustomer_Name() + "|" + c.getAge() + "|" + c.getGender() + "|" + c.getEmail() + "|" + c.getContact_number() + "|" + c.getAddress() + "|");
                }
            }
            read.close();
            pw.flush();
            pw.close();
            bw.close();  
            fw.close();
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    
    public void renameFile(){
        try{
            File oldFile = new File("Customers.txt");
            File newFile = new File("Tempcustomer.txt");
            boolean success = oldFile.delete();
            File dump = new File("Customers.txt");
            newFile.renameTo(dump);
            if(success){
                System.out.println(newFile.getName() + " is renamed and deleted!");
            }else{
                System.out.println("Operation Failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    

}

   
