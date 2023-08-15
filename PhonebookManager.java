//Clayton Johnson
//CS 145 Phonebook assignment
//7/14/2023
//This class manages the phonebook, 
//allowing you to add, delete, modify, and print contacts
public class PhonebookManager {
    private ListNode head;

    //constructor for PhonebookManager object
    public PhonebookManager() {
        this.head = null;
    }

    //Adds a contact to the phonebook
    public void add(String name, String address, String city, String phoneNum) {
        ListNode newNode = new ListNode(name, address, city, phoneNum);
        //if list is empty head becomes the newNode and this method ends
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode present = head;
        //finds the end of the list
        while (present.next != null) {
            present = present.next;
        }
        //makes the last list node the new contact
        present.next = newNode;
    }

    //Deletes a node or field in a node
    public void delete(String name, String fieldToDelete, boolean wholeContact) {
        //if the list is empty end the method
        if (isEmpty(head)) {
            return;
        }
        ListNode present = head;
        ListNode last = null;
        //goes through list to find node with given name
        while (present != null) {
            if (present.name.equals(name)) {
                if (wholeContact) {
                    // Delete the entire contact by setting the node to null
                    if (last == null) {
                        head = present.next;
                    } else {
                        last.next = present.next;
                    }
                    System.out.println("deleted");
                    return;
                } else {
                    //if the node is found, set the correct field to null
                    switch (fieldToDelete) {
                        case "address":
                            present.address = null;
                            break;
                        case "city":
                            present.city = null;
                            break;
                        case "phoneNum":
                            present.phoneNum = null;
                            break;
                        default:
                            System.out.println("Invalid field to delete");
                            return;
                    }
                    System.out.println("deleted");
                    return;
                }
            }
            last = present;
            present = present.next;
        }
        System.out.println("not found");
    }

    //Modifies a field in one of the nodes
    public void modify(String name, String fieldToMod, String newValue) {
        //if the list is empty end the method
        if (isEmpty(head)) {
            return;
        }
        ListNode present = head;
        ListNode last = null;
        //goes through list to find node with given name
        while (present != null) {
            if (present.name.equals(name)) {
                //if the node exists, give the right field the new value
                switch (fieldToMod) {
                    case "name":
                        present.name = newValue;
                        break;
                    case "address":
                        present.address = newValue;
                        break;
                    case "city":
                        present.city = newValue;
                        break;
                    case "phoneNum":
                        present.phoneNum = newValue;
                        break;
                    default:
                        System.out.println("Invalid field to modify");
                        return;
                }
                System.out.println("Field changed");
                return;
            }
            last = present;
            present = present.next;
        }

    }

    //prints out the phonebook
    public void printPhoneBook() {
        if (isEmpty(head)) {
            return;
        }
        ListNode current = head;
        System.out.println("Contacts:");
        System.out.println("-----------");
        //iterates over all of the nodes
        while (current != null) {
            System.out.println("Name: " + current.name);
            System.out.println("Address: " + current.address);
            System.out.println("City: " + current.city);
            System.out.println("Phone Number: " + current.phoneNum);
            System.out.println("-----------");
            current = current.next;
        }
    }

    //Returns true if list is empty
    //added to reduce redundancy
    public boolean isEmpty(ListNode head) {
        if (head == null) {
            System.out.println("Phonebook is empty");
            return true;
        }
        return false;
    }
}