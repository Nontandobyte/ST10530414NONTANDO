/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog512;

import java.util.Scanner;
import java.util.Random;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author Student
 */

/**
 *
 * @author khany
 */
public class PROG512{
    private static boolean exit;
    private static int maxMessages = 0;
    private static int Total_messages = 0;
    private static int messageCounter = 0;
    static final JSONArray messageStorage = new JSONArray();

    static Scanner scanner = new Scanner(System.in);
    static String storedUsername;
    static String storedPassword;
    static String storedCellphoneNumber;
  //will store the registered username//
            static String username;
 //will store the registered password//
            static String password;
 // will store the registered cellphoneNumber//
            static String cellphoneNumber;
     

    public static void main(String[] args) {
          System.out.println("Welcome to Nontando chatApp but first reate and sign up for account");
         PROG512 user=new PROG512();
              //Menu//
              boolean loggedIn= false;
              while(!loggedIn){
                  System.out.println("\n---ChatIT");
         System.out.println("\n1. Register");
         System.out.println("2. login");
         System.out.println("3. quite");
         System.out.println("Enter choice:");
         int choice=scanner.nextInt();
         scanner.nextLine();
         
    switch(choice){
                  case 1: 
                //call register method//
                   user.register();
                  break;
                  case 2: 
                //call login mehod//
                   user.login();
                   loggedIn=true;
                      break;
                  case 3:
              System.out.println("Goodbye");
                   return;
                  default:
              System.out.println("Invalid option");
                  }
       

        try {
            System.out.print("How many messages do you wish to send? ");
            maxMessages = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, exiting programme");
            return;
        }

        while (!exit) {
            System.out.println("\nWelcome to QuickChat");
            System.out.println("\nSelect an Option:");
            System.out.println("1. Send Message");
            System.out.println("2. show Messages");
            System.out.println("3. discard last messages");
            System.out.println("4. Save mesaages"); 
            System.out.println("5. Quit");
            System.out.println("Enter your option");
            
            System.out.print("Choice: ");

           choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    if (Total_messages < maxMessages) {
                        SendMessage();
                    } else {
                        System.out.println("Maximum Message Reached. You may not send more");
                    }
                    break;
                case 2:
                    showRecentlySentMessages();
                    break;
                //Discard last messages//
                case 3:
                    System.out.println("Coming soon");
                    break;
                //save messages//
                case 4: 
                    System.out.println("Coming soon");
                    break;
                //quit//
                case 5:
                    System.out.println("Thank you for using QuickChat. Goodbye");
                    System.exit(0);
                   
                    break;
                    
                default: 
                    System.out.println("Invalid Option . pick 1-5");
                    
            }
        } 
        }
    }
    

     
    
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
     // sending message method//
        static void SendMessage(){
            long messageId=10000000000L + new Random().nextInt(900000000);
            messageCounter++;
            
         System.out.print("Input recipient number (+CCXXXXXXXXXX) ");
         String recipient =scanner.nextLine ();
         recipient=CheckRecipient(recipient);
         if(recipient==null)
             return;
         System.out.print("Enter your message (max 250 character):");
         String message = scanner.nextLine();
        
    if (message.length()>250){
        System.out.println("message exceeds 250 characters");
        return;
    } 
    String[]words=message.trim().split("\\s+");
    String hash = String.format("%02d:%d:%s%s",
            Long.valueOf(Long.toString(messageId).substring(0, 2)),
            messageCounter,
            words[0].toUpperCase(),
            words.length > 1? words[words.length - 1].toUpperCase() : "");

    System.out.println("\nSelect action:");
    System.out.println("1. Post");
    System.out.println("2. Cancel");
    System.out.println("3. Archive");

    int action = Integer.parseInt(scanner.nextLine());

    if (action == 2) {
        System.out.println("Message Cancelled");
        return;
    }

    JSONObject jsonMessage = new JSONObject();
    jsonMessage.put("MessageID", messageId);
    jsonMessage.put("MessageHash", hash);
    jsonMessage.put("Recipient", recipient);
    jsonMessage.put("Message", message);
       
       if (action==3) {
           messageStorage.add(jsonMessage);
           System.out.println("message stored.");
           return;
                     }
       Total_messages++;
       System.out.println("\nMessage Sent");
       System.out.println("MessageID: "+messageId);
       System.out.println("MessageHash"+hash);
       System.out.println("Recipient:"+recipient);
       System.out.println("Message:"+message);
    
        }  
        static void saveMessagesToJSON() {
    try (FileWriter file = new FileWriter("storedMessages.json")) {
        file.write(messageStorage.toJSONString());
        file.flush();
        System.out.println("Stored messages saved to storedMessages.json");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static String CheckRecipient(String recipient) {
    if (recipient == null || !recipient.matches("^\\+\\d{9,12}$")) {
        System.out.println("Invalid number. Must include country code and be <=12 digits.");
        return null;
    }
    return recipient;
}

static void showRecentlySentMessages() {
    if (messageStorage.isEmpty()) {
        System.out.println("No stored messages.");
    } else {
        System.out.println("Stored Messages:");
        for (Object obj : messageStorage) {
            System.out.println(obj);
        }
    }
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
        
               //register method with loop//
      public void register() {
        String username;
        String  password;
        String cellphoneNumber;
          
                  //create login details with loop//
               while(true){
                  System.out.println("create your username, it should be five characters or less and must contain an underscore");
               username=scanner.nextLine();         
               
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
             password=scanner.nextLine(); 
    
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
              cellphoneNumber=scanner.nextLine();
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
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
           String password = scanner.nextLine();
     if (loginUser(username,password)) {
                System.out.println("Welcome:"+username +",it is great to see you again.");
                break; //only if details entered correspond with the onres used for registering//
               
              
} else {
    System.out.println("Username or password incorrect, please try again");
     }
        }
  }
}
 