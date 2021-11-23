package contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    ArrayList<Contact>contacts = new ArrayList<Contact>();

    public void addContact (Contact contact) {
        contacts.add(contact);
    }

    public void showContacts () {
        if(contacts.isEmpty()) {
            System.out.println("No records to remove!");
        }else {
            int j = 0;
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println(++j +"." + " " + contacts.get(i).getName() +" "+ contacts.get(i).getSurname() + ", " + contacts.get(i).getPhoneNumber());
            }
        }
    }

    public int countContacts () {
        int j = 0;
        for (int i = 0; i < contacts.size(); i++) {
            j++;
        }
        return j;
    }

    public void removeContact (int i) {
        i -= 1;
        contacts.remove(i);
        System.out.println("The record removed!");
    }

    public void editContact (int i, String word) {
        Scanner scanner = new Scanner(System.in);
        i -= 1;
        String name = contacts.get(i).getName();
        String surname = contacts.get(i).getSurname();
        String number = contacts.get(i).getPhoneNumber();
        if(word.equals("name")) {
            System.out.println("Enter name:");
            String nameInput = scanner.nextLine();
            contacts.get(i).setName(nameInput);
            System.out.println("The record updated!");
        }else if (word.equals("surname")) {
            System.out.println("Enter surname:");
            String surnameInput = scanner.nextLine();
            contacts.get(i).setSurname(surnameInput);
            System.out.println("The record updated!");
        }else if (word.equals("number")) {
            System.out.println("Enter number:");
            String inputNum = scanner.nextLine();
            contacts.get(i).setContact(inputNum);
            System.out.println("The record updated!");
        }
    }

    public boolean arrayCheck () {
        if (contacts.isEmpty()) {
            return true;
        }else return false;
    }

}
