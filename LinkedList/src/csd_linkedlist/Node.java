/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_linkedlist;
class Node {
    int data;
    Node next;
    
    Node() {
    }
    Node(int d)
    {
        data = d;
        next = null;
    }

    
}
class LinkedList {
    Node head; // head of list
    Node tail;
    /* Function to swap Nodes x and y in linked list by
       changing links */
    
    
    
     void addFirst(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }
     
    static Node removeLastNode(Node head) 
    { 
        if (head == null) 
            return null; 
  
        if (head.next == null) { 
            return null; 
        } 
  
        // Find the second last node 
        Node second_last = head; 
        while (second_last.next.next != null) 
            second_last = second_last.next; 
  
        // Change next of second last 
        second_last.next = null; 
  
        return head; 
    } 
  
    // Function to push node at head 
    static Node push(Node head_ref, int new_data) 
    { 
        Node new_node = new Node(); 
        new_node.data = new_data; 
        new_node.next = (head_ref); 
        (head_ref) = new_node; 
        return head_ref; 
    } 
  
    // Driver code 
    
    public void swapNodes(int x, int y)
    {
        // Nothing to do if x and y are same
        if (x == y)
            return;
 
        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
 
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else // make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
 
    /* Function to add Node at beginning of list. */
    public void push(int new_data)
    {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);
 
        /* 2. Make next of new Node as head */
        new_Node.next = head;
 
        /* 3. Move the head to point to new Node */
        head = new_Node;
    }
 
    /* This function prints contents of linked list starting
       from the given Node */
    
    void addlast(int new_data)
    {
        Node new_node = new Node(new_data);
 
        if (head == null) {
            head = new_node;
            return;
        }
 
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
 
        last.next = new_node;
    }
    public void printList()
    {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }
    // Prints the contents of the linked list
 
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
 
        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
//        llist.push(7);
//        llist.push(6);
//        llist.push(5);
//        llist.push(4);
//        llist.push(3);
//        llist.push(2);
//        llist.push(1);
// 
//        System.out.print(
//            "\n Linked list before calling swapNodes() ");
//        llist.printList();
// 
//        llist.swapNodes(4, 3);
// 
//        System.out.print(
//            "\n Linked list after calling swapNodes() ");
//        llist.printList();
        
        // Start with the empty list / 
        Node head = null; 
  
        // Use push() function to construct 
        // the below list 8 . 23 . 11 . 29 . 12 / 
        head = push(head, 12); 
        head = push(head, 29); 
        head = push(head, 11); 
        head = push(head, 23); 
        head = push(head, 8); 
  
        head = removeLastNode(head); 
        for (Node temp = head; temp != null; temp = temp.next) 
            System.out.print(temp.data + " "); 
    }

    private boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
