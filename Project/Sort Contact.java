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
