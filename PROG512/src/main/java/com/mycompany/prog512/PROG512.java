/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog512;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import org.json.simple.parser.JSONParser; 


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
    static ArrayList<String> sentMessages = new ArrayList<>();
    static ArrayList<String> disregardedMessages = new ArrayList<>();
    static ArrayList<JSONObject> storedMessages = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();
    static ArrayList<String> messageIDs = new ArrayList<>();
    static ArrayList<String> recipients= new ArrayList<>();
    static final JSONArray messageStorage = new JSONArray();
    static Scanner scanner = new Scanner(System.in);
    static String registeredUsername="";
    static String registeredPassword="";
    static String username="";        //will store the registered username//
    static String storedUsername;
    static String storedPassword;
    static String storedCellphoneNumber;
    static String testUsername ="kyl_1";
    static String testPassword= "Ch&&sec@ke99!";
    static String testCellPhoneNumber="+27838968976";
    static String password;          //will store the registered password//
    static String cellphoneNumber;  // will store the registered cellphoneNumber//
     

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
                loadStoredMessages();
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
        } 
                catch (NumberFormatException e) {
        System.out.println("Invalid input, exiting programme");
            return;
        }

                 while (!exit) {
        System.out.println("\nWelcome to QuickChat");
        System.out.println("\nSelect an Option:");
        System.out.println("1. Send Message");
        System.out.println("2. show Messages");
        System.out.println("3. discard last messages");
        System.out.println("4. stored mesaages"); 
        System.out.println("5. exit ");
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
                if (!sentMessages.isEmpty()){
                String LastMsg=sentMessages.remove(sentMessages.size()-1);
                Total_messages--;
        System.out.println("Discarded message:"+LastMsg);
                    } 
                    else{
                            
        System.out.println("NO messages to discard");
                    }
                    break;
                         //store messages//
                case 4: 
                String subChoice = "";
                while (!subChoice.equals("g")) {
        System.out.println("\nStored Messages");
        System.out.println("a. Show sender and recipient");
        System.out.println("b. Show longest message");
        System.out.println("c. Find by ID");
        System.out.println("d. Find by recipient");
        System.out.println("e. Delete by hash");
        System.out.println("f. Show all details");
        System.out.println("g. Back");
        System.out.print("Pick option: ");
        subChoice = scanner.nextLine().toLowerCase(); // ← scanner not scan
       
    switch (subChoice) {
                case "a":
        System.out.println("\nStored messages:");
                if (storedMessages.isEmpty()) {
       System.out.println("No messages stored");
              } else {
                for (int i = 0; i < storedMessages.size(); i++) {
                JSONObject msg = storedMessages.get(i); // ← Get JSON object
        System.out.println("From: " + msg.get("sender"));
        System.out.println("To: " + msg.get("recipient"));
        System.out.println("Message: " + msg.get("message"));
        System.out.println();
                    }
                }
                break;
               
                case "b":
        System.out.println("\nFinding longest message...");
                 if (storedMessages.isEmpty()) {
        System.out.println("No messages stored");
                } else {
                String longest = "";
                for (int i = 0; i < storedMessages.size(); i++) {
                JSONObject msg = storedMessages.get(i);
                String text = String.valueOf(msg.get("message"));
                if (!text.equals("null") && text.length() > longest.length()) {
                longest = text;
            }
        }
       
                if (longest.isEmpty()) {
        System.out.println("All stored messages are empty or null");
                } else {
        System.out.println("Longest message is: " + longest);
        }
    }
                break;
               
                case "c":
       System.out.print("Enter message ID: ");
                String id = scanner.nextLine(); 
                boolean foundId = false;
                for (int i = 0; i < storedMessages.size(); i++) {
                JSONObject msg = storedMessages.get(i);
                if (msg.get("id").toString().equals(id)) {
        System.out.println("Recipient: " + msg.get("recipient"));
        System.out.println("Message: " + msg.get("message"));
                foundId = true;
                break;
                    }
                }
                if (!foundId) {
                    System.out.println("ID not found");
                }
                break;
               
                 case "d":
        System.out.print("Enter recipient number: ");
                String rec = scanner.nextLine(); 
                boolean foundRec = false;
                for (int i = 0; i < storedMessages.size(); i++) {
                JSONObject msg = storedMessages.get(i);
                if (msg.get("recipient").toString().equals(rec)) {
       System.out.println(msg.get("message"));
                foundRec = true;
                    }
                }
                if (!foundRec) {
        System.out.println("No messages for that person");
                }
                break;
               
                case "e":
        System.out.print("Enter message hash: ");
                String hash = scanner.nextLine();
                boolean foundHash = false;
                for (int i = 0; i < storedMessages.size(); i++) {
                JSONObject msg = storedMessages.get(i);
                if (msg.get("hash").toString().equals(hash)) {
        System.out.println("Deleted this message: " + msg.get("message"));
                storedMessages.remove(i);
                foundHash = true;
                break;
                    }
                }
                if (!foundHash) {
                    System.out.println("Hash not found");
                }
                break;
               
                case "f":
        System.out.println("\nAll stored message details:");
                 if (storedMessages.isEmpty()) {
        System.out.println("Nothing stored yet");
                } else {
                for (int i = 0; i < storedMessages.size(); i++) {
                JSONObject msg = storedMessages.get(i);
        System.out.println("Message " + (i+1));
        System.out.println("ID: " + String.valueOf(msg.get("id")));
        System.out.println("Hash: " + String.valueOf(msg.get("hash")));
        System.out.println("From: " + String.valueOf(msg.get("sender")));
        System.out.println("To: " + String.valueOf(msg.get("recipient")));
        System.out.println("Text: " + String.valueOf(msg.get("message")));
        System.out.println();
        }
    }
               break;
               
                case "g":
        System.out.println("Going back...");
                break;
               
                default:
        System.out.println("Invalid option, please try again");
        }
    }
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
    System.out.println("1. Send");
    System.out.println("2. discard");
    System.out.println("3. store");

    int action = Integer.parseInt(scanner.nextLine());

    if (action == 2) {
        disregardedMessages.add(message);
        System.out.println("Message Cancelled");
        return;
    }

    JSONObject jsonMessage = new JSONObject();
    jsonMessage.put("id", String.valueOf(messageId)); 
    jsonMessage.put("hash", hash); 
    jsonMessage.put("sender", username); 
    jsonMessage.put("recipient", recipient); 
    jsonMessage.put("message", message); 
       if (action==3) {
           messageStorage.add(jsonMessage);
           storedMessages.add(jsonMessage);
           storedMessagesToJSON();
           System.out.println("message stored.");
           System.out.println("Stored:"+jsonMessage.toString());
           return;
                     }
       messageIDs.add(String.valueOf(messageId));
       messageHashes.add(hash);
       sentMessages.add(message);
       recipients.add(recipient);
       Total_messages++;
       System.out.println("\nMessage Sent");
       System.out.println("MessageID: "+messageId);
       System.out.println("MessageHash"+hash);
       System.out.println("Recipient:"+recipient);
       System.out.println("Message:"+message);
    
        }  
        static void storedMessagesToJSON() {
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
static void loadStoredMessages() {
    JSONParser parser = new JSONParser();
    try (FileReader reader = new FileReader("storedMessages.json")) {
        JSONArray jsonArray = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArray) {
            JSONObject msg = (JSONObject) obj;
            storedMessages.add(msg);
            messageIDs.add(msg.get("MessageID").toString());
            messageHashes.add(msg.get("MessageHash").toString());
        }
    } catch (Exception e) {
        System.out.println("No stored messages file found.");
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
        username=inputUsername;
    
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
 