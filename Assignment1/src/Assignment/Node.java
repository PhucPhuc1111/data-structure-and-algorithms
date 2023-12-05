package Assignment;
public class Node {
    Node next;
    Phone data;
    Node (){
    }
    Node (Phone data,Node p){
        this.data = data;
        next = p;
    }
   
    Node(Phone data){
        this(data,null);
    }
}
