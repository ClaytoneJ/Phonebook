//Clayton Johnson
//CS 145 Phonebook project
//7/14/23
//This class reperesents one node in the phonebook linked list
public class ListNode {
    String name;
    String address;
    String city;
    String phoneNum;
    ListNode next;

    //constructor for linked list
    public ListNode (String name, String address, 
                    String city, String phoneNum) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNum = phoneNum;
        this.next = null;
    }
}