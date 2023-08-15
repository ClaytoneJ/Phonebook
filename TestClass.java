//Clayton Johnson
//CS 145 Phonebook assignment
//7/14/2023
//This is the UI for a phonebook program
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();
        Scanner input = new Scanner(System.in);
        boolean run = true;
        //while loop that lets you pick options till you quit
        while (run) {
            System.out.println("Pick an option");
            System.out.println("1. Add a contact");
            System.out.println("2. Delete a field in the phonebook");
            System.out.println("3. Modify a contact");
            System.out.println("4. Print the phonebook");
            System.out.println("5. Quit");
            String option = input.nextLine();
            switch (option) {
                //Adds a contact
                case "1":
                    System.out.println("Name: ");
                    String name = input.nextLine();
                    System.out.println("Address: ");
                    String address = input.nextLine();
                    System.out.println("City: ");
                    String city = input.nextLine();
                    System.out.println("Phone Number: ");
                    String phoneNum = input.nextLine();
                    manager.add(name, address, city, phoneNum);
                    break;
                //Deletes a contact or field of contact
                case "2":
                    System.out.println("Would you like to delete a whole contact? y/n: ");
                    String answer = input.nextLine().toLowerCase();
                    if (answer.equals("y")) {
                        System.out.println("Enter exact name you would like to delete: ");
                        String delName = input.nextLine();
                        manager.delete(delName, "", true);
                        break;
                    } else if (answer.equals("n")) {
                        System.out.println("Exact name of contact for partial deletion: ");
                        String delName2 = input.nextLine();
                        System.out.println("Enter field you would like to delete: ");
                        String fieldToDelete = input.nextLine().toLowerCase();
                        manager.delete(delName2, fieldToDelete, false);
                        break;
                    } else {
                        System.out.println("invalid option");
                    }

                //Modifies a field in a contact
                case "3":
                    System.out.println("Enter name of contact you would like to modify: ");
                    String modName = input.nextLine();
                    System.out.println("Enter name of field you would like to modify: ");
                    String fieldToChange = input.nextLine().toLowerCase();
                    System.out.println("Enter new value: ");
                    String newValue = input.nextLine();
                    manager.modify(modName, fieldToChange, newValue);
                    break;
                //Prints out phonebook
                case "4":
                    manager.printPhoneBook();
                    break;
                //quits program
                case "5":
                    run = false;
                    break;
                default:
                    System.out.println("invalid option, enter 1 through 5");
                    break;
            }
        }
    }
}