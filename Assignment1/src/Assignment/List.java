package Assignment;

import java.util.Scanner;

public class List {
    Scanner sc = new Scanner(System.in);
    Node head, tail;
    Node next;

    public List() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public int length() {
        Node p = head;
        int count = 0;

        while (p != null) {
            p = p.next;
            count++;
        }

        return count;
    }

    public void show() {
        for(Node k =head;k!=null;k=k.next){
            System.out.println(k.data.getID());
        }
    }

    public void show2() {
        for(Node k =head;k!=null;k=k.next){
            if(k.data.getYear() > 2020){
                System.out.println(k.data.getID());
            }
        }
    }

    public void add_First(Phone data) {
        System.out.println("Enter ID: ");
        String id = sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();
        System.out.println("Enter Amount: ");
        int amount = sc.nextInt();
        System.out.println("Enter year: ");
        int year = sc.nextInt();
        
        if (isEmpty()) {
            head = tail = new Node(data);
        } else {
            Node p = new Node(data);
            p.next = head;
            head = p;
        }
    }

    public void add_Last(Phone data) {
        if (isEmpty()) {
            head = tail = new Node(data);
        } else {
            Node p = new Node(data);
            tail.next = p;
            tail = p;
        }
    }

    public void add_Node(Object data, int PhoneID) {
        
    }

    public void delete_first() {
        if (isEmpty()) {
            tail = null;
        } else {
            Node p = head;
            head = head.next;
            p = null;
        }
    }

    public void delete_last() {
        if (isEmpty()) {
            head = null;
        } else {

            Node p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            p.next = null;
            tail = p;
        }
    }

    public void deleteNode(int PhoneID) {
        if (isEmpty()) {
            return;
        }
        Node p = head;
        Node prev = null;
        if (!isExisting(PhoneID)) {
            System.out.println("NOT FOUND !!!");
        }
        if (isExisting(PhoneID)) {
            while (p != null && p.data.getID() == PhoneID) {

            }

        }
    }

    public boolean isExisting(int PhoneID) {
        Node p = head;
        while (p != null) {
            if (p.data.equals(PhoneID)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public int search(String name) {
        Node p = head;
        int pos = 0;
        while (p != null) {
            if (p.data.getName().equals(name)) {
                pos++;
            }
            p = p.next;
        }
        return pos;
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\t\tPHONE MANAGEMENT");
            System.out.print("\n1.Add first");
            System.out.print("\n2.Add last");
            System.out.print("\n3.Add index");
            System.out.print("\n4.Show");
            System.out.print("\n5.Show with condition");
            System.out.print("\n6.Delete first");
            System.out.print("\n7.Delete last");
            System.out.print("\n8.Delete index");
            System.out.print("\n9.Check exist");
            System.out.print("\n10.Search");
            System.out.print("\n11.Find value max");
            System.out.print("\n12.Quit");
            System.out.print("\n\tEnter choice(1-12): ");
            choice = sc.nextInt();
            if (choice == 1) {
                
            } else if (choice == 2) {
                
            } else if (choice == 3) {
                
            } else if (choice == 4) {
                
            } else if (choice == 5) {
                
            } else if (choice == 6) {
                
            } else if (choice == 7) {
                
            } else if (choice == 8){
                
            } else if (choice == 9){
                
            } else if (choice == 10){
                
            } else if (choice == 11){
                
            } else if (choice == 12){
                break;
            }
            else {
                System.out.print("\n\t\tWRONG CHOICE,Enter again");
            }
        }
    }
}
