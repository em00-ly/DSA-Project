import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

public class PhonebookApp {
    private List<Contact> phonebook;

    public PhonebookApp() {
        phonebook = new ArrayList<>();
        // Adding some sample contacts
        phonebook.add(new Contact("Alice", "123-456-7890"));
        phonebook.add(new Contact("Bob", "987-654-3210"));
        phonebook.add(new Contact("Charlie", "555-123-4567"));
    }

    public String searchContact(String name) {
        for (Contact contact : phonebook) {
            if (contact.name.equalsIgnoreCase(name)) {
                return contact.phoneNumber;  // Return phone number if found
            }
        }
        return null;  // Return null if not found
    }

    public static void main(String[] args) {
        PhonebookApp app = new PhonebookApp();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the contact you want to search for: ");
        String name = scanner.nextLine();

        String phoneNumber = app.searchContact(name);

        if (phoneNumber != null) {
            System.out.println("Contact found: " + name + " - " + phoneNumber);
        } else {
            System.out.println("Contact not found.");
        }

        scanner.close();
    }
}

