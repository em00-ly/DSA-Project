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
        return "Contact not found."; // Return not found message if contact doesn't exist
    }
}



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
