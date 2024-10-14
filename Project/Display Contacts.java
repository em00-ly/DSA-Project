 public void displayContacts() {
        if (head == null) {
            System.out.println("Phonebook is empty."); 
        } else {
            ContactNode temp = head; 
            while (temp != null) {
               
                System.out.println("Name: " + temp.name + ", Phone: " + temp.phoneNumber);
                temp = temp.next; 
            }
        }
    }
