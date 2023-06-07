import java.util.Scanner; 


public class BinaryTree{//beginning of tree class(This class constructs the tree)
    Node root;
    Node search;
    

    public BinaryTree(){//constructor class
        
        //this.root = null;              
    
    }

   
    public void addNode(int key,String first, String last, String address, String city, String zip, String email, String phoneNumber){
    //method adds nodes to the binary search tree
        Node newNode = new Node(key,first,last,address,city,zip,email,phoneNumber);

            if(root == null)//code goes through the tree until it finds null value then adds node
                root = newNode;
            else{
                Node focusNode = root;
                Node parent;
                while(true){

                    parent = focusNode;
                    if(key< focusNode.key){
                        focusNode = focusNode.leftChild;
                        
                        if(focusNode == null){
                            parent.leftChild = newNode;
                            return;
                        }
                    }else{
                        focusNode = focusNode.rightChild;
                        
                        if(focusNode == null){
                            parent.rightChild = newNode;
                            return;
                        }
                    }
                }
            }


    }
    
        
    public void inOrder(Node focusNode){//method sorts the dictionary in order


        if (focusNode != null) {
            inOrder(focusNode.leftChild);
            System.out.println(focusNode);
            inOrder(focusNode.rightChild);
        }
    }
    
    public void preOrder(Node focusNode){//method sorts the dictionary in a "pre-order" layout

        if (focusNode != null) {
            System.out.println(focusNode);
            preOrder(focusNode.leftChild);           
            preOrder(focusNode.rightChild);
        }
    }
    
    public void postOrder(Node focusNode){//method sorts the dictionary in a "post-order" layout

        if (focusNode != null) {
            postOrder(focusNode.leftChild);           
            postOrder(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public void findEntry(int k){//this method finds an entry based off of a key inputed by the user
    
      search = root;  
          
         while(search!=null){                 
            if(search.key == k){
               System.out.println(search);
               return;
            }else if(search.key < k){
               search = search.rightChild;
            }else if(search.key > k){
               search = search.leftChild;
            }
         }
     }
     
     public Node deleteEntry(int k){// this method removes a node from the tree
      
        Node curr = root;
        Node prev = null;
        while(curr!=null && curr.key !=k){   
           prev = curr;                  
           if(curr.key < k)
              curr = curr.rightChild;
           else
              curr = curr.leftChild;
                           
        }
      
        if (curr == null) {
            System.out.println("Key " + k
                               + " not found in the"
                               + " provided BST.");
            return root;
        }
        if (curr.leftChild == null || curr.rightChild == null) {
           Node newCurr;
           
            if (curr.leftChild == null)
                newCurr = curr.rightChild;
            else
                newCurr = curr.leftChild;
                
            if (prev == null)
                return newCurr;
            
            if (curr == prev.leftChild)
                prev.leftChild = newCurr;
            else
                prev.rightChild = newCurr;
        }
        
        else {
            Node p = null;
            Node temp;
            
            temp = curr.rightChild;
            while (temp.leftChild != null) {
                p = temp;
                temp = temp.leftChild;
            }
            if (p != null)
                p.leftChild = temp.rightChild;
                
           else
                curr.rightChild = temp.rightChild;
 
            curr.key = temp.key;
        }
        return root;
        
        
    }
    
    public void modifyEntry(int k,Scanner s){//this method allows the user to modify a node based off of a key value
         deleteEntry(k);
         System.out.println("Enter the new information you wish to add");
         System.out.println("new first: ");
         String first = s.next();
         System.out.println("new last: ");
         String last = s.next();
         System.out.println("new address: ");
         s.nextLine();
         String address = s.nextLine();
         System.out.println("new city: ");
         String city = s.next();
         System.out.println("new ZIP code: ");
         String zip = s.next();
         System.out.println("new email: ");
         String email = s.next();
         System.out.println("new phone #: ");
         String phone = s.next();
         addNode(k, first, last, address, city, zip, email, phone);
         System.out.println("contact succesfully modified");
       
    } 

    
}//end of tree object class
