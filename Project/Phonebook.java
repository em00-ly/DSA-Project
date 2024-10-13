import java.util.Scanner; // Importing the Scanner class to read input from the user 
import java.util.ArrayList;  // Importing the ArrayList class and List interface from the java.util package  
import java.util.List;  

// Define the structure for a contact as a linked list node
class ContactNode {
    String name; // Contact's name
    String phoneNumber; // Contact's phone number
    ContactNode next; // Pointer to the next contact in the list

    // Constructor to initialize a new contact node
    ContactNode(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.next = null; // Initially, the next pointer is null
    }
}

// Class to manage the linked list of contacts
class ContactList {
    private ContactNode head; // Head of the linked list

    // Constructor to initialize the contact list
    public ContactList() {
        head = null; // Initially, the list is empty
    }
     // insert contact 
    public void insertContact(String name, String phoneNumber) {
        ContactNode newContact = new ContactNode(name, phoneNumber); 
        newContact.next = head; 
        head = newContact; 
    }

    // Function to delete a contact by name
    public String deleteContact(String contactName) {
        ContactNode current = head; // Start from the head
        ContactNode previous = null; // To keep track of the previous node

        // Traverse the linked list to find the contact
        while (current != null) {
            if (current.name.equalsIgnoreCase(contactName)) { // Check if the current contact matches
                if (previous == null) {
                    head = current.next; // Update head if deleting the first contact
                } else {
                    previous.next = current.next; // Bypass the current node
                }
                return "Contact deleted successfully."; // Return success message
            }
            previous = current; // Move previous to current
            current = current.next; // Move to the next contact
        }
        return "Contact not found."; // Return not found message if contact doesn't exist
    }

    // Function to display all contacts
    public void displayContacts() {
        if (head == null) {
            System.out.println("Phonebook is empty."); // Message if the list is empty
        } else {
            ContactNode temp = head; // Temporary node for traversal
            while (temp != null) {
                // Display each contact's name and phone number
                System.out.println("Name: " + temp.name + ", Phone: " + temp.phoneNumber);
                temp = temp.next; // Move to the next contact
            }
        }
    }

    // Function to search for a contact by name
    public String searchContact(String name) {
        ContactNode current = head; // Start from the head
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) { // Check for a match
                return current.phoneNumber; // Return phone number if found
            }
            current = current.next; // Move to the next contact
        }
        return null; // Return null if not found
    }

    // Function to sort the phonebook by contact names
    public void sortPhoneBook() {
        if (head == null || head.next == null) {
            return; // No need to sort if the list is empty or has only one contact
        }

        boolean swapped; // Flag to check if a swap occurred
        do {
            ContactNode current = head; // Start from the head
            swapped = false; // Reset swapped flag

            // Traverse the list and swap contacts if needed
            while (current != null && current.next != null) {
                // Compare names and swap if needed
                if (current.name.compareToIgnoreCase(current.next.name) > 0) {
                    // Swap names and phone numbers
                    String tempName = current.name;
                    String tempPhoneNumber = current.phoneNumber;
                    current.name = current.next.name;
                    current.phoneNumber = current.next.phoneNumber;
                    current.next.name = tempName;
                    current.next.phoneNumber = tempPhoneNumber;
                    swapped = true; // Set swapped flag to true
                }
                current = current.next; // Move to the next contact
            }
        } while (swapped); // Continue sorting until no swaps are needed
    }

    // Function to update a contact's phone number
    public String updateContact(String name, String newPhoneNumber , String newName) {
        ContactNode current = head; // Start from the head
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) { // Check for a match
                current.name = newName;
                current.phoneNumber = newPhoneNumber; // Update the phone number
                return "Contact updated successfully."; // Return success message
            }
            current = current.next; // Move to the next contact
        }
        return "Contact not found."; // Return not found message if contact doesn't exist
    }
}

// Main class for the Phonebook application
 class PhonebookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner for user input
        ContactList myContacts = new ContactList(); // Create a new contact list

        // Adding some sample contacts
        myContacts.insertContact("Alisha", "081 223 4943");
        myContacts.insertContact("Prince", "081 877 1432");
        myContacts.insertContact("Nathan", "081 323 2839");

        // Main loop for the phonebook menu
        while (true) {
            // Display menu options
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Display Contacts");
            System.out.println("2. Search Contact");
            System.out.println("3. Insert Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); // Get user choice
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    myContacts.displayContacts(); // Display all contacts
                    break;
                case 2:
                    System.out.print("Enter the name of the contact you want to search for: ");
                    String searchName = scanner.nextLine(); // Get name to search
                    String phoneNumber = myContacts.searchContact(searchName); // Search for contact
                    if (phoneNumber != null) {
                        System.out.println("Contact found: " + searchName + " - " + phoneNumber); // Display found contact
                    } else {
                        System.out.println("Contact not found."); // Display not found message
                    }
                    break;
                case 3:
                    System.out.print("Enter the name of the new contact: ");
                    String newName = scanner.nextLine(); // Get new contact name
                    System.out.print("Enter the phone number of the new contact: ");
                    String newPhoneNumber = scanner.nextLine(); // Get new contact phone number
                    myContacts.insertContact(newName, newPhoneNumber); // Add new contact
                    System.out.println("Contact added successfully."); // Display success message
                    break;
                case 4:
                    System.out.print("Enter the name of the contact you want to delete: ");
                    String deleteName = scanner.nextLine(); // Get name to delete
                    String result = myContacts.deleteContact(deleteName); // Delete contact
                    System.out.println(result); // Display result

                case 5:
                    System.out.print("Enter the name of the contact you want to update: ");
                    String updateName = scanner.nextLine(); // Name of contact to update

                    // Fetch the current contact details to keep them if no new info is provided
                    String currentPhoneNumber = myContacts.searchContact(updateName);
                    if (currentPhoneNumber == null) {
                        System.out.println("Contact not found.");
                        break;
                    }

                    System.out.print("Enter new name (leave blank to keep current name): ");
                    String updatedName = scanner.nextLine(); // Get new contact name (or keep current name)

                    System.out.print("Enter the new phone number (leave blank to keep current phone number): ");
                    String updatedPhoneNumber = scanner.nextLine(); // Get new phone number

                    // If no new name is provided, keep the old one
                    if (updatedName.isEmpty()) {
                        updatedName = updateName; // Keep current name
                    }

                    // If no new phone number is provided, keep the old one
                    if (updatedPhoneNumber.isEmpty()) {
                        updatedPhoneNumber = currentPhoneNumber; // Keep current phone number
                    }

                    String updateResult = myContacts.updateContact(updateName, updatedPhoneNumber, updatedName); // Update contact
                    System.out.println(updateResult); // Display result
                    break;

                case 6:
                    myContacts.sortPhoneBook(); // Sort contacts
                    System.out.println("Contacts sorted successfully."); // Display success message
                    break;
                case 7:
                    System.out.println("Exiting the program."); // Exit message
                    scanner.close(); // Close scanner
                    System.exit(0); // Exit program
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // Handle invalid input
            }
        }
    }
}

