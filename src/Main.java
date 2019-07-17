import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Directory directory = new Directory();
        String selection = "";
        while (!selection.equals("5")) {
            String first;
            String last;
            String phone;
            System.out.println("~Phone Directory~");
            System.out.println("Please select one of the following options: ");
            System.out.println("1. Add a new contact");
            System.out.println("2. Update an existing contact");
            System.out.println("3. Remove a contact");
            System.out.println("4. Display the directory");
            System.out.println("5. Exit");

            Scanner reader = new Scanner(System.in);
            selection = reader.next();

            if (selection.equals("1")) {
                System.out.println("Enter a new first name: ");
                first = reader.next();
                System.out.println("Enter a new last name: ");
                last = reader.next();
                System.out.println("Enter a new phone number: ");
                phone = reader.next();
                Contact newContact = new Contact(first, last, phone);
                directory.addContact(newContact);
            } else if (selection.equals("2")) {
                System.out.println("Enter the phone number of the contact you want to update: ");
                phone = reader.next();
                try {
                    directory.updateContact(phone);
                }catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (selection.equals("3")) {
                System.out.println("Please enter a phone number to remove: ");
                String s = reader.next();
                directory.removeContact(s);
            } else if (selection.equals("4")) {
                System.out.println(directory);
            } else {
                System.out.println("Invalid selection");

            }
        }
    }
}



