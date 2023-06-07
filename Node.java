



public class Node{//node object class creates the individual nodes of the tree

    int key;
    String first;
    String last;
    String address;
    String city;
    String zip;
    String email;
    String phoneNumber;
      
      
    Node leftChild;
    Node rightChild;

   public Node(int key,String first, String last, String address, String city, String zip, String email, String phoneNumber){
   //constructor method
        this.key = key;
        this.first = first;
        this.last = last;
        this.address = address;
        this.city = city; 
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String toString(){//prints out value of one node

        return first + " " + last + " has a key " + key + "\n" +
        "address: " + address + "\n" + 
        "city: " + city + "\n" + 
        "ZIP code: " + zip + "\n" + 
        "email: " + email + "\n" + 
        "phone number: " + phoneNumber + "\n";
    }
    

}//end of node class