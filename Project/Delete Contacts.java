
        // Delete a contact by name - O(n)
        public boolean deleteContact(String name) {
            if (head == null) return false; // Empty phonebook

            // Check if the head needs to be deleted
            if (head.contact.name.equalsIgnoreCase(name)) {
                head = head.next; // Move head to the next node
                size--;
                return true;
            }

            Node current = head;
            Node prev = null; // Previous node reference
            // Search for the contact to delete
            while (current != null && !current.contact.name.equalsIgnoreCase(name)) {
                prev = current;
                current = current.next;
            }

            // If contact was not found
            if (current == null) return false;

            // Update previous node to skip over the deleted node
            prev.next = current.next;
            size--;
            return true;
        }
