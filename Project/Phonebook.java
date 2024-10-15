import java.util.Scanner; // Importing the Scanner class to read input from the user 

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

    // Function to add a contact to the linked list
    public void insertContact(String name, String phoneNumber) {
        ContactNode newContact = new ContactNode(name, phoneNumber); // Create a new contact node
        newContact.next = head; // Point new contact to the current head
        head = newContact; // Update head to the new contact
        sortPhoneBook();
    }

    // Function to delete a contact by name
    public String deleteContact(String contactName) {
        ContactNode temp = head; // Start from the head
        ContactNode previous = null; // To keep track of the previous node


        // Traverse the linked list to find the contact
        while (temp != null) {
            if (temp.name.equals(contactName)) { // Check if the current contact matches
                if (previous == null) {
                    head = head.next; // Update head if deleting the first contact
                } else {
                    previous.next = temp.next; // Bypass the current node
                }
                return "Contact deleted successfully."; // Return success message
            }
            previous = temp; // Move previous to current
            temp = temp.next; // Move to the next contact
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
        ContactNode temp = head; // Start from the head
        while (temp != null) {
            if (temp.name.equals(name)) { // Check for a match
                return temp.phoneNumber; // Return phone number if found
            }
            temp = temp.next; // Move to the next contact
        }
        return null; // Return null if not found
    }

    // Function to sort the phonebook by contact names
    public void sortPhoneBook() {
        if (head == null || head.next == null) {
            return; // No need to sort if the list is empty or has only one contact
        }
        else {
            ContactNode temp = head; // Start from the head

            // Traverse the list and swap contacts if needed
            while (temp != null && temp.next != null) {
                // Compare names and swap if needed
                if (temp.name.compareTo(temp.next.name) > 0) {
                    // Swap names and phone numbers
                    String tempName = temp.name;
                    String tempPhoneNumber = temp.phoneNumber;
                    temp.name = temp.next.name;
                    temp.phoneNumber = temp.next.phoneNumber;
                    temp.next.name = tempName;
                    temp.next.phoneNumber = tempPhoneNumber;
                }
                temp = temp.next; // Move to the next contact
            }
        }
    }

    // Function to update a contact's phone number
    public String updateContact(String name, String newPhoneNumber , String newName) {
        ContactNode temp = head; // Start from the head
        while (temp != null) {
            if (temp.name.equals(name)) { // Check for a match
                temp.name = newName;
                temp.phoneNumber = newPhoneNumber; // Update the phone number
                sortPhoneBook();
                return "Contact updated successfully."; // Return success message
            }
            temp = temp.next; // Move to the next contact
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
            System.out.println("6. Exit");
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
                    myContacts.sortPhoneBook(); // Sort contacts
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
