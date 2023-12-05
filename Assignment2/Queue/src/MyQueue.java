import java.util.*;
import java.io.*;

public class MyQueue {
    // In this question, we consider:
    //      front of queue ~ head of list
    //      rear of queue ~ tail of list
    // That means:
    //      dequeue() = remove the first node in the list (e.g., removeFirst())
    //      enqueue(Laptop laptop) = insert 'laptop' into the tail of the list (e.g., addLast(Laptop laptop))

    Node front, rear;
    int size;

    // Default constructor
    MyQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public void clear() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = front;
        while(p != null) {
            f.writeBytes(p.getInfo() + " "); // write data in node p to the file f
            p = p.next;
        }
        
        f.writeBytes("\r\n");
    }
    
    /**
     * Do NOT modify this method
     * Load 3 lines of data from file: 
     *      line k (for owner), 
     *      line k+1 (for price), and
     *      line k+2 (for color)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void loadData(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        double [] b = Lib.readLineToDoubleArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        
        int n = a.length;
        for(int i = 0; i < n; i++) 
            // insert the new Node(a[i], b[i], c[i]) into the queue
            enqueue(a[i],b[i],c[i]);
    }
   
    /**
     * Do NOT modify this method
     * This is a helper method for Questions 1.1; 1.2; 1.3; and 1.4
     * @throws Exception 
     */
    void helpFunction(int questionNo) throws Exception {
        clear();
        loadData(questionNo * 4 - 3);
        
        String fname = "f" + Integer.toString(questionNo) + ".txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        
        if (questionNo == 2){
            updateQueue();
            ftraverse(f);
        }
        
        if (questionNo == 3){
            dequeue();
            ftraverse(f);
        }
          
        if (questionNo == 4){
            reverse();
            ftraverse(f);
        }
        
        if(!isEmpty()){
            System.out.println("The resulting queue:");
            
            System.out.println("       Front's Info = " + front.getInfo().getName());
            
            System.out.println("       Rear's Info = " + rear.getInfo().getName());
        }
        
        f.close();
    }
   
    void f1() throws Exception {
        helpFunction(1);
    }
    
    void f2() throws Exception {
        helpFunction(2);
    }
    
    void f3() throws Exception {
        helpFunction(3);    
    }
    
    void f4() throws Exception {
        helpFunction(4);
    }
    /**
     * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh Error khi run chuong trinh.
     *        2. Neu khong tuan thu se nhan diem 0 (khong).
	 
	 
     * Question 1.1: implement the 'enqueue' method that inserts
     * a new Node into the rear of the queue if the price is less than 90.0
     * Note: increase the queue's size by 1 if you enqueue successfully
     * The output of this method will be written into the file 'f1.txt'. 
     * Therefore, you should open this file to inspect your code output.
     * Example: with the data given in the file 'data.txt', 
     *          then the output should be:
     * The resulting queue:
     *          Front's Info = H
     *          Rear's Info = F
     * Your output:
     *  Content of the file f1.txt:
     *   (H, 10.0, 22) (A, 9.8, 8) (B, 5.3, 3) (C, 6.2, 5) (D, 2.5, 4) (F, 40.4, -7)
     * @param xName the name of the input Laptop
     * @param xPrice the price of the input Laptop
     * @param xColor the color of the input Laptop
     */
    void enqueue(String xName, double xPrice, int xColor) {
        if (xPrice < 90.0) {
            Laptop newLaptop = new Laptop(xName, xPrice, xColor);
            Node newNode = new Node(newLaptop, null);
            if (isEmpty()){
                front = newNode;
                rear = newNode;
            }
            else{
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }
    }
    
    private boolean isPrime(int n){
        // Corner case
        //------ Start your code here---------------------------------------------------------
        // Corner case: 0 and 1 are not prime numbers
    	if (n <= 1) {
        	return false;
    	}

    	// Check for prime by testing divisibility up to the square root of n
    	for (int i = 2; i <= Math.sqrt(n); i++) {
        	if (n % i == 0) {
           	 // If n is divisible by any number in this range, it's not prime
           	 return false;
                }

        }
        return true;
        
        //------ End your code here-----------------------------------------------------------
    }   
    
    /**
     * Question 1.2: visit every node in the queue and do following tasks
     *      1. if Laptop's color is a prime number then update price = price + 5.0
     *      2. if Laptop's color is NOT a prime then update price = price + 10.0
     *      Def: a prime number is a natural number greater than 1 whose only factors are 1 and itself. 
     *           For example, the first few prime numbers are 2, 3, 5, 7, 11, 13, 17
     *      The function 'boolean isPrime(int n)' is already implemented in the class MyQueue, you just call it in this question
     * The output of this method will be written into the file 'f2.txt'. 
     * Therefore you should open this file to see/test your code output. 
     * Example: with in data given, the output should be:
     * The resulting queue:
     *          Front's Info = H
     *          Rear's Info = F
     * Your output:
     *  Content of the file f3.txt:
     *   (H, 10.0, 22) (A, 29.8, 8) (B, 35.3, 3) (C, 6.2, 5) (D, 52.5, 4) (F, 46.4, -7) 
     *   (H, 20.0, 22) (A, 39.8, 8) (B, 40.3, 3) (C, 11.2, 5) (D, 62.5, 4) (F, 56.4, -7)
     * Note: You should use methods getPrice(), getColor(), and setColor(int) in the class Laptop rather than directly accessing the private attributes 'color', and 'price'
     */
    void updateQueue(){
        //------ Start your code here---------------------------------------------------------
	Node p = front;
        while (p != null) {
            Laptop laptop = p.getInfo();

            if (isPrime(laptop.getColor())) {
                laptop.setPrice(laptop.getPrice() + 5.0);
            } else {
                laptop.setPrice(laptop.getPrice() + 10.0);
            }

            p = p.next;
        }
        
        
        //------ End your code here-----------------------------------------------------------
    } // end updateQueue()
    
    /**
    * Question 1.3: Implement the dequeue method that remove a node from queue's front (similar to removeFirst() in the list)
    * The output of this method will be written into the file 'f3.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: with the data given, the output should be:
    * The resulting queue:
    *       Front's Info = A
    *       Rear's Info = F
    * Your output:
    *  Content of the file f3.txt:
    *   (H, 10.0, 22) (A, 29.0, 8) (B, 35.0, 3) (C, 6.5, 5) (D, 52.5, 4) (F, 46.5, -7) 
    *   (A, 29.0, 8) (B, 35.0, 3) (C, 6.5, 5) (D, 52.5, 4) (F, 46.5, -7)
    */   
    Laptop dequeue(){
        //------ Start your code here-------------------------------------------------------
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null; // modify the return value appropriately
        } else {
            Laptop removedLaptop = front.getInfo();
            front = front.next;
            size--;
            return removedLaptop;
        }
        
        
        // remember to decrease queue's size by 1
        
        //------ End your code here---------------------------------------------------------  
    } // end dequeue()
    
    /**
    * Question 1.4: Reverse the order of all nodes in the queue 
    * The output of this method will be written into the file 'f4.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: with data given in the file "data.txt",
    *           the output and the queue before and after reversing is: 
    * The resulting queue:
    *       Front's Info = K
    *       Rear's Info = C
    * Your output:
    *  Content of the file f4.txt:
    *   (C, 1.0, 2) (F, 14.0, 6) (J, 11.0, 12) (K, 7.0, 9) 
    *   (K, 7.0, 9) (J, 11.0, 12) (F, 14.0, 6) (C, 1.0, 2)  
    */
    void reverse(){
        
        //------ Start your code here-------------------------------------------------------
	Node prev = null;
        Node current = front;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        front = prev;
        
        
        //------ End your code here---------------------------------------------------------
    } // end reverse()
    
} // end MyQueue