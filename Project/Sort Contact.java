 public String updateContact(String name, String newPhoneNumber , String newName) {
        ContactNode temp = head; // Start from the head
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) { // Check for a match
                temp.name = newName;
                temp.phoneNumber = newPhoneNumber; // Update the phone number
                return "Contact updated successfully."; // Return success message
            }
            temp = temp.next; // Move to the next contact
        }
        return "Contact not found."; // Return not found message if contact doesn't exist
    }
}
