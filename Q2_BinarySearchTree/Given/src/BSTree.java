/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        //System.out.println(p);
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }
    
    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    
     public Node insert_Rec(Node t,String xName, int xAge, int xId) 
        {
            User x = new User(xName,xAge,xId);
            if (t.info.id > xId)
                    if (t.left == null)
                            t.left = new Node (x);
                    else
                            t.left = insert_Rec(t.left, x.name,x.age,x.id);
            if (t.info.id < xId)
                    if (t.right == null)
                            t.right = new Node (x);
                    else
                            t.right = insert_Rec(t.right, x.name,x.age,x.id);
            return t;
        }


    public Node insert(String xName, int xAge, int xId) 
    {
        User x = new User(xName,xAge,xId);
            if (root == null)
                    root = new Node (x);
            else
                    root = insert_Rec(root, x.name,x.age,x.id);
            return root;
    }
    
    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        if(p.info.age < 25){
            fvisit(p, f);
        }
    }
    void addAge(Node node, RandomAccessFile f) throws Exception {
        if (node == null) {
            return;
        }
        if((node.left != null && node.right == null) || (node.left == null &&  node.right != null)){
            node.info.age += 3;
        }
        addAge(node.left,f);
        addAge(node.right,f);
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        postOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
   
// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/  
        addAge(root,f);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }


    
 
//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        int h=0;//Height of the last node
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        Node lastNode = lastNodePostOrder(root);
        h = height(lastNode);
        //------------------------------------------------------------------------------------
        f.writeBytes(h+"");
        f.writeBytes("\r\n");
        f.close();
    }
    
    
    int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            if (height(node.left) > height(node.right)) {
                return (height(node.left) + 1);
            } else {
                return (height(node.right) + 1);
            }
        }
    }

    Node lastNodePostOrder(Node node) {
        if (node == null) {
            return null;
        }

        Node left = lastNodePostOrder(node.left);
        Node right = lastNodePostOrder(node.right);

        if (right != null) {
            return right;
        } else if (left != null) {
            return left;
        } else {
            return node;
        }
    }


    
//=============================================================    
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        preOrder2(root.left,f);
        //------------------------------------------------------------------------------------
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        p.info.age = 0;
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }
    
//=============================================================
    void f6() throws Exception {
        clear();
        loadData(21);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        Node right_most = null;//right_most node
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        right_most = findMaxId(root);
        //------------------------------------------------------------------------------------
        fvisit(right_most,f);
        f.writeBytes("\r\n");
        f.close();
    }
    Node findMaxId(Node node) {
        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }

        return node;
    }
    
}
