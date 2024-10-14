    public void insertContact(String name, String phoneNumber) {
        ContactNode newContact = new ContactNode(name, phoneNumber); // Create a new contact node
        newContact.next = head; // Point new contact to the current head
        head = newContact; // Update head to the new contact
        sortPhoneBook();
    }
