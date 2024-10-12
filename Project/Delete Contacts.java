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





             case 4:
                    System.out.print("Enter the name of the contact you want to delete: ");
                    String deleteName = scanner.nextLine(); // Get name to delete
                    String result = myContacts.deleteContact(deleteName); // Delete contact
                    System.out.println(result); // Display result



        }
