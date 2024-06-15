/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.oop2assignment;

import java.util.regex.Pattern;

/**
 *
 * @author Sandaruwan
 */
public class ExGUI {
    //private static final int MAX_USERS =10;
    //private static ExGUI array[]= new ExGUI[10];
    String name;
    String password;
    String nic;
    String cpassword;
   // private static int count=0;

  //  public static int getMAX_USERS() {
  //      return MAX_USERS;
  //  }

   // public static ExGUI[] getArray() {
   //     return array;
   // }

    public String getname() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getNic() {
        return nic;
    }

    public String getCpassword() {
        return cpassword;
    }

   /* public static int getCount() {
        return count;
    }
    public static ExGUI getUser(int index) {
    if (index >= 0 && index < count) {
            return array[index];
        } else {
            return null;
        }
    } */
    
    public ExGUI(String name,String nic,String password){
        this.name=name;
        this.password=password;
        this.nic=nic;
        
      //  array[count]= this;
       // count++;
    }
    
    /*public static void addUser(String uname, String password, String email) {
        if (count < MAX_USERS) {
            ExGUI user = new ExGUI(name, password,nic);
        } else {
            System.out.println("Maximum number of users reached.");
        }
    }*/
    
    
    public static boolean validateName(String name){
        String regx = "^[a-zA-Z]+$"; 
        return Pattern.matches(regx, name);
    }
    
    public static boolean validateNic(String text){
        String regx = "\\d{10,15}"; // Allow for NICs between 10 and 15 digits long
        return text.matches(regx);
    }
    
    public static boolean validatePassword(String password){
        String regx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return Pattern.matches(regx, password);
    }
    
    public static boolean checkSameP(String password,String cpassword){
        return password.equals(cpassword);  
    }
    
   /* public static boolean UName(String uname){
        boolean out=false;
        
        for(int i=0;i<array.length;i++){
            if(array[i].name.equals(uname)){
                out=true;
            }
        }
        return out;
    }
    */
}
