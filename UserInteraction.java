import java.util.Scanner;

public class UserInteraction{//class with user inputs
   BinaryTree theTree = new BinaryTree();
   String first;
   String last;
   String address;
   String email;
   String city;
   String zip;
   String phone;
   
   public void dictionaryMenu(){//outputs an interactable user menu
           
        Scanner s = new Scanner(System.in);
        String input;
        do{
        System.out.println("Welcome to the personnel database");
        System.out.println("To add information press the 'A' key");
        System.out.println("To delete information press the 'D' key");
        System.out.println("To find a specific contact press the 'S' key");
        System.out.println("To modify a specifc user press the 'M' key");
        System.out.println("To list all records, press the 'L' key");
        System.out.println("To quit the program press the 'Q' key");
        input = s.next();
        input.toLowerCase();
        switch(input){
           case "a": 
              addContact(s);
           break;
           case "l":
              listContact(s);
           break;
           case "s":
              searchContact(s);
           break;
           case"d":
              deleteContact(s);
           break;
           case"m":
              modifyContact(s);
           break;           
        }
        }while(!input.equals("q"));

   }//end of menu method
   
   public void searchContact(Scanner s){//allows user to input a key to search for a contact
      System.out.println("To find the contact you wish to view, type the key for that contact");
      System.out.println("key: ");
      int k = s.nextInt();
      theTree.findEntry(k);
   
   }

   public void listContact(Scanner s){//allows user to list contacts by three options
   
      System.out.println("To view a list of the dictionary in order type '1'");
      System.out.println("To view a list of the dictionary in post-order type '2'");
      System.out.println("To view a list of the dictionary in pre-order type '3'");
      int k = s.nextInt();
      
      if(k == 1){
         asciiArt();
         System.out.println();
         theTree.inOrder(theTree.root);
     }else if(k == 2){
         asciiArt();
         System.out.println();
         theTree.postOrder(theTree.root);
     }else if(k == 3){
         asciiArt();
         System.out.println();
         theTree.preOrder(theTree.root);
     }else
         System.out.println("Please only enter a number 1-3");
     
       
   
   
   
   }

   public void addContact(Scanner s){//lets user input values for a node they want to add
   
       System.out.println("Enter the first name of the contact you wish to add: ");
       first = s.next();       
       System.out.println("Enter the last name of the contact you wish to add: ");
       last = s.next();
       System.out.println("Enter the address of the contact you wish to add: ");
       s.nextLine();
       address = s.nextLine();
       System.out.println("Enter the city of the contact you wish to add: ");       
       city = s.next();
       System.out.println("Enter the ZIP code of the contact you wish to add: ");
       zip = s.next();
       System.out.println("Enter the email of the contact you wish to add: ");
       email = s.next();
       System.out.println("Enter the phone # of the contact you wish to add: ");
       phone = s.next();
       System.out.println("Finally, enter a key for the contact");
       System.out.println("This key will be how you can locate the contact within the dictionary");
       System.out.println("For your first contact, it is recommended the key be at least two digits");
       System.out.println("Please only use one key per contact");
       System.out.println("Enter a number for the key: ");
       int key = s.nextInt();    
    
       theTree.addNode(key,first,last,address,city,zip,email,phone);
       System.out.println("entry successfully added");
    }
   
    public int deleteContact(Scanner s){//user selects which contact they wish to delete
       
       System.out.println("Enter the key for the contact you wish to remove");
       System.out.println("Key: ");
       int key = s.nextInt();
       theTree.deleteEntry(key);
       return 0;
    }
    
    public void modifyContact(Scanner s){//user selects which contact they wish to modify
       System.out.println("Enter the key for the contact you wish to modify");
       System.out.println("Key: ");
       int key = s.nextInt();
       theTree.modifyEntry(key,s);
    }
    public void asciiArt(){ //American flag art
  
       for (int i = 1; i <= 5; i++)
         System.out.println("* * * * * *#############################");
       
       for (int j = 1; j <= 6; j++)
       System.out.println("########################################");
           
   
   }//end of art method
}//end of UserInteraction