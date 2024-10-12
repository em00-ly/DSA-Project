  public void insertContact(String name, String phoneNumber) {
        ContactNode newContact = new ContactNode(name, phoneNumber); 
        newContact.next = head; 
        head = newContact; 
    }
