/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog512;

import java.util.Scanner;

/**
 *
 * @author Student
 */

/**
 *
 * @author khany
 */
public class PROG512{
    static Scanner sc=new Scanner(System.in);
    static String storedUsername;
    static String storedPassword;
    static String storedCellphoneNumber;
  //will store the registered username//
            static String username;
 //will store the registered password//
            static String password;
 // will store the registered cellphoneNumber//
            static String cellphoneNumber;
    
 //creating method for username//
       public static boolean checkusername(String inputUsername){
 //creating conditions for creation of username// 
    if (inputUsername.length()<=5 && inputUsername.contains("_")){
             return true; //only when valid username is entered//
       }
    else{
        System.out.println("Username is not correctly formatted ");
    }
                 return false;    //invalid username// 
    } 
 //creating method for password//
        public static boolean checkPasswordComplexity(String inputPassword){
     if (inputPassword.length()>=8 && inputPassword.matches(".*[A-Z].*")&& inputPassword.matches(".*[0-9]*") && inputPassword.matches(".*[!@#$%^&*].*")){
                 return true;    //only when a valid paasword is entered//
    }
    else{
        System.out.println("password does not meet complexity requirement");
    }
                  return false;     //invalid password//
    }        
    //creating cell phone number method //
        public static boolean checkCellphoneNumber(String cellphoneNumber){
     if (
             (cellphoneNumber.startsWith("+27")&& cellphoneNumber.length()==12&& cellphoneNumber.matches("\\+\\d+"))
        )
     {
        System.out.println("you have entered a valid cellphone number ");
                  return true;     //only when valid cellphone number is entered//
    }
    else {
          System.out.println("you have entered an invalid cellphone number");
       }
                  return false;
    } 
    //creating method for registering a user//   
        public static String RegisterUser(String inputUsername,String inputPassword){
     if (checkusername(inputUsername)&&checkPasswordComplexity(inputPassword)){
             username=inputUsername;
             password=inputPassword;
                  return "user has been registered successfully."; //only when details entered are valid//
         }
         
     else{
            return "user has not been registered successfully";
}
         }
    //method for checking login details//
        public static boolean loginUser(String inputUsername,String inputPassword){
               return inputUsername.equals(username)&&inputPassword.equals(password);
    
}
    //method for logging in//
        public static String returnLoginStatus(){
              Scanner sc= new Scanner(System.in);  //login using username created//
              System.out.println("enter username");
              String inputUsername=sc.nextLine();

              System.out.println("enter password");//login using password created//
              String inputPassword=sc.nextLine();
  
    if(loginUser(inputUsername, inputPassword)){
    
        return "welcome:"+inputUsername+", it is great to see you again"; //when entered deatails are correct//
    } 
    else{
         return"Username or password is invalid, please try again";
            
}
}
              //main method//    
      public static void main(String[] args) {
            //using class name//
     System.out.println("Welcome to Nontando chatApp but firt create and sign up for account");
         PROG512 user=new PROG512();
              //Menu//
              while(true) {
         System.out.println("\n1. Register");
         System.out.println("2. login");
         System.out.println("3. exit");
         System.out.println("Enter choice:");
         int choice=sc.nextInt();
         sc.nextLine();
         
    switch(choice){
                  case 1: 
                //call register method//
                   user.register();
                  break;
                  case 2: 
                //call login mehod//
                   user.login();
                      break;
                  case 3:
              System.out.println("Goodbye");
                   return;
                  default:
              System.out.println("Invalid option");
                  }
 }
  }
     //register method with loop//
      public void register() {
        String username;
        String  password;
        String cellphoneNumber;
          
                  //create login details with loop//
               while(true){
                  System.out.println("create your username, it should be five characters or less and must contain an underscore");
               username=sc.nextLine();         
               
                //input conditions for username//
    if (checkusername(username)){
        System.out.println("you have successfully captured your username"); 
        break;
       }
    else{
        System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
    }
               }
           
    // create a strong paaswords that meeets the requirements with loop//
          while(true){
             System.out.println(" create your password it should be 8 characters contain capital letters,numbers and special characters ");
             password=sc.nextLine(); 
    
    // input conditions for password//
              
    if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured");
                break;
    }
    else{
        System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
    }
}
    //insert your cellphone number//
       while(true){
        System.out.println("insert your cellphone number");
              cellphoneNumber=sc.nextLine();
    //insert cellphone number conditions and show local or international and loop//
    if (checkCellphoneNumber(cellphoneNumber)){
        System.out.println("Cellphone number successfully captured ");
        break;
    }
    else {
          System.out.println("Cellphone number is incorrectly formatted or does not contain international code, please correct the number and try again");
          
    } 
       } 
       storedCellphoneNumber = cellphoneNumber;
  {
      System.out.println(RegisterUser(username, password));
      System.out.println("\n login to account using details you have created");
      login();
  }
  
      }
      
          
 //for logging in after registering//   
  public void login(){
            while(true){
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
           String password = sc.nextLine();
     if (loginUser(username,password)) {
                System.out.println("Welcome:"+username +",it is great to see you again.");
                break; //only if details entered correspond with the onres used for registering//
               
              
} else {
    System.out.println("Username or password incorrect, please try again");
     }
        }
  }
}


