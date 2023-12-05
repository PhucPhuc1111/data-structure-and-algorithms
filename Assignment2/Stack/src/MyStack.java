import java.util.*;
import java.io.*;

public class MyStack {
        Node top;
    int size;

    // Default constructor
    MyStack() {
        this.top = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public void clear() {
        this.top = null;
        this.size = 0;
    }
    
    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = top;
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
            push(a[i],b[i],c[i]);
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
            pop();
            ftraverse(f);
        }
          
        
        if(!isEmpty()){
            System.out.println("The resulting queue:");
            
            System.out.println("       Top's Info = " + top.getInfo().getName());
            
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
   
    
    /**
     * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh Error khi run chuong trinh.
     *        2. Neu khong tuan thu se nhan diem 0 (khong).
     * Question 1.1: implement the 'push' method that inserts
     * a new Node into the top of the stack if the price is less than 100.0
     * Note: increase the stack's size by 1 if you enqueue successfully
     * The output of this method will be written into the file 'f1.txt'. 
     * Therefore, you should open this file to inspect your code output.
     * Example: with the data given in the file 'data.txt', 
     * Your output:
     *  Content of the file f1.txt:
     * (F, 40.4, -7) (D, 2.5, 4) (C, 6.2, 5) (B, 5.3, 3) (A, 9.8, 8) (H, 10.0, 22)
     * @param xName the name of the input Laptop
     * @param xPrice the price of the input Laptop
     * @param xColor the color of the input Laptop
     */
    void push(String xName, double xPrice, int xColor) {
       
        //------ Start your code here---------------------------------------------------------
        if (xPrice < 100.0) {
            Laptop newLaptop = new Laptop(xName, xPrice, xColor);
            Node newNode = new Node(newLaptop);
            newNode.next = top;
            top = newNode;
            size++;

            // Writing to file f1.txt
            try {
                FileWriter writer = new FileWriter("f1.txt", true);
                writer.write(newLaptop.toString() + " ");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
    

    
    /**
     * Question 1.2: visit every node in the stack and do following tasks
     *      1. if Laptop's color is a prime number then update price = price + 10.0
            2. if Laptop's color is NOT a prime then update price = price + 20.0
      Def: a prime number is a natural number greater than 1 whose only factors are 1 and itself. 
           For example, the first few prime numbers are 2, 3, 5, 7, 11, 13, 17
      
 The output of this method will be written into the file 'f2.txt'. 
 Therefore you should open this file to see/test your code output. 
 Example: with in data given, the output should be:
 Your output:
  Content of the file f3.txt:
   (F, 40.4, -7) (D, 2.5, 4) (C, 6.2, 5) (B, 5.3, 3) (A, 9.8, 8) (H, 10.0, 22)
   (F, 60.4, -7) (D, 22.5, 4) (C, 16.2, 5) (B, 15.3, 3) (A, 29.8, 8) (H, 30.0, 22)
 Note: You should use methods getPrice(), getColor(), and setColor(int) in the class Laptop rather than directly accessing the private attributes 'color', and 'price'
     */
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    void updateQueue(){
        //------ Start your code here---------------------------------------------------------
        Node p = top;
        try {
            FileWriter writer = new FileWriter("f2.txt", true);

            while (p != null) {
                Laptop laptop = p.getInfo();

                if (isPrime(laptop.getColor())) {
                    laptop.setPrice(laptop.getPrice() + 10.0);
                } else {
                    laptop.setPrice(laptop.getPrice() + 20.0);
                }

                writer.write(laptop.toString() + " ");
                p = p.next;
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
        
        //------ End your code here-----------------------------------------------------------
    } 
    
    /**
    * Question 1.3: Implement the pop method that remove a node from the top (similar to removeFirst() in the list)
    * The output of this method will be written into the file 'f3.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: with the data given, the output should be:

    * Your output:
    *  Content of the file f3.txt:
    *   (F, 40.4, -7) (D, 2.5, 4) (C, 6.2, 5) (B, 5.3, 3) (A, 9.8, 8) (H, 10.0, 22)
    *   (D, 2.5, 4) (C, 6.2, 5) (B, 5.3, 3) (A, 9.8, 8) (H, 10.0, 22)
    */   
    Laptop pop(){
        //------ Start your code here-------------------------------------------------------
        if (top != null) {
            Laptop poppedLaptop = top.getInfo();
            top = top.next;
            size--;

            // Writing to file f3.txt
            try {
                FileWriter writer = new FileWriter("f3.txt", true);

                Node p = top;
                while (p != null) {
                    Laptop laptop = p.getInfo();
                    writer.write(laptop.toString() + " ");
                    p = p.next;
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return poppedLaptop;
        } 
        return null; // you should update this statement !!!
        
        //------ End your code here---------------------------------------------------------  
    } // 
    
} // end MyStack


