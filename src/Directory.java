import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Directory {
    private List<Contact> contacts;

    public Directory() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (contacts.contains(contact)) {
            throw new IllegalArgumentException("Contact already exists in directory");
        }
        contacts.add(contact);

    }

    public void removeContact(String phoneNumberToRemove) {

        boolean doesExist = false;
//        for(int i = 0; i < contacts.size(); i++) {
//            Contact contact = contacts.get(i);
//        }
        for (Contact contact : contacts) {
            String currentPhoneNumber = contact.getPhoneNumber();
            doesExist = doesExist || phoneNumberToRemove.equals(currentPhoneNumber);//'or equals', a = a or b
            if (doesExist) {
                contacts.remove(contact);
            }
        }
        if (!doesExist) {
            throw new IllegalArgumentException("Contact does not exist");
        }
    }

    public void updateContact(String phoneNumber) {
        Contact contactToUpdate = findContact(phoneNumber);

        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to update 'first name', 'last name', or 'phone number'?");
        String selection = input.nextLine();
        selection = selection.toLowerCase();

        if (selection.equals("first name")) {
            System.out.println("What is the new first name?");
            String newFirst = input.nextLine();
            contactToUpdate.setFirst(newFirst);

        } else if (selection.equals("last name")) {
            System.out.println("What is the new last name?");
            String newLast = input.nextLine();
            contactToUpdate.setLast(newLast);
        } else if (selection.equals("phone number")) {
            System.out.println("What is the new phone number");
            String newNumber = input.nextLine();
            contactToUpdate.setPhoneNumber(newNumber);
        } else {
            System.out.println("Please select one of the options");
            updateContact(phoneNumber);
        }
    }

    private Contact findContact(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("Contact does not exist");
    }

    public String toString() {
        return "Directory: " + contacts.toString();
    }
}
