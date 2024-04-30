import java.util.Scanner;

// Insertion at begin, end and at specific position
public class Assignment2 {
    // Structure of a node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    // Initializing head\start
    Node head = null;

    // Creation of nodes - Insertion
    public void creation() {
        int data, n;
        Scanner inp = new Scanner(System.in);
        do {
            System.out.println("Enter data of node: ");
            data = inp.nextInt();
            int choice;
            // Creating node
            Node new_node = new Node(data);

            // Does Linked List exist
            // What to do ? if not
            if (head == null) {
                head = new_node;
            }

            // What to do ? if yes
            else {
                // Choice
                System.out.println("Enter 1 to insert at beginning of node, 2 for end of node, 3 for specific location: ");
                choice = inp.nextInt();
                switch (choice){
                    case 1:
                        // insert new node at beginning
                        new_node.next = head;
                        head = new_node;
                        break;

                    case 2:
                        // insert new node at the end
                        Node temp = head;
                        while (temp.next != null){
                            temp = temp.next;
                        }
                        temp.next = new_node;
                        break;

                    case 3:
                        // insert node at specific location
                        int pos;
                        temp = head;
                        System.out.println("Which position do you want to add node: ");
                        pos = inp.nextInt();
                        for (int i = 0; i < pos-1; i++) {
                            temp = temp.next;
                        }
                        new_node.next = temp.next;
                        temp.next = new_node;
                        break;
                }

            }

            System.out.println("Do you want to add more data/nodes(if yes: press 1 otherwise 0): ");
            n = inp.nextInt();
        }
        while (n == 1);
    }

    public void display() {
        Node temp = head;     // initialize a temp node to store head of LL
        if (head == null) {
            System.out.println("Linked List does not exist!");
        } else {
            System.out.print("Linked List : ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    // Deletion of nodes
    public void deletion() {
        int data, n;
        Scanner inp = new Scanner(System.in);
        do {
            int choice;

            // Does Linked List exist
            // What to do ? if not
            if (head == null) {
                System.out.println("Linked List is empty!");
            }

            // What to do ? if yes
            else {
                // Choice
                System.out.println("Enter 1 to delete at beginning of node, 2 for end of node, 3 for specific location: ");
                choice = inp.nextInt();

                switch (choice){
                    case 1:
                        // delete node at beginning
                        head = head.next;
                        break;

                    case 2:
                        // delete node at the end
                        Node temp = head;
                        Node prev = null;
                        while (temp.next != null){
                            prev = temp;
                            temp = temp.next;
                        }
                        if (prev != null) {
                            prev.next = null;
                        } else {
                            head = null; // If only one node exists
                        }
                        break;

                    case 3:
                        // delete node at specific location
                        int pos;
                        temp = head;
                        prev = null;
                        System.out.println("Which position do you want to delete node: ");
                        pos = inp.nextInt();
                        for (int i = 0; i < pos-1; i++) {
                            prev = temp;
                            temp = temp.next;
                        }
                        if (prev != null) {
                            prev.next = temp.next;
                        } else {
                            head = temp.next; // If first node is deleted
                        }
                        break;
                }
            }

            System.out.println("Do you want to delete more data/nodes(if yes: press 1 otherwise 0): ");
            n = inp.nextInt();
        }
        while (n == 1);
    }

    // Search for a node with given data in the list
    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {

        // Calling class and functions
       Assignment2 LL = new Assignment2();
        LL.creation();
        LL.display();
        LL.deletion();
        LL.display();

        // Searching for an element
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the element to search: ");
        int element = scanner.nextInt();
        if (LL.search(element)) {
            System.out.println("Element " + element + " found in the linked list.");
        } else {
            System.out.println("Element " + element + " not found in the linked list.");
        }
        scanner.close();
    }
}
