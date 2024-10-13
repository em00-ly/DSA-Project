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
