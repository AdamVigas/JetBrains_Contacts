package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    ArrayList<Contact>contacts = new ArrayList<Contact>();

    public void addContact (Contact contact) {
        contacts.add(contact);
    }

    public void showContacts () {
        Scanner scanner = new Scanner(System.in);
        if(contacts.isEmpty()) {
            System.out.println("No records to show!");
        }else {
            int j = 0;
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println(++j +"." + " "  + contacts.get(i).who());
            }
        }
    }

    public void searchName(String slovo) {
        int cislo = 0;
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).who().toLowerCase().contains(slovo) || contacts.get(i).getName().toLowerCase().contains(slovo)){
                cislo++;
            }
        }
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getPhoneNumber().contains(slovo) || contacts.get(i).getPhoneNumber().contains(slovo)){
                cislo++;
            }
        }
        System.out.println("Found "+ cislo +" results:");
        int k = 1;
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getPhoneNumber().contains(slovo) || contacts.get(i).getPhoneNumber().contains(slovo)){
                System.out.println(k++ + ". " + contacts.get(i).who());
            }
        }
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).who().toLowerCase().contains(slovo) || contacts.get(i).getName().toLowerCase().contains(slovo)){
                System.out.println(k++ + ". " + contacts.get(i).who());
            }
        }
        System.out.println();
    }

    public void information(int num) {
        contacts.get(--num).showYourself();
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
        String temp;
        if(word.equals("name")) {
            System.out.print("Enter name: ");
            temp = scanner.nextLine();
            contacts.get(i).setName(temp);
        }else if(word.equals("surname")){
            System.out.print("Enter surname: ");
            temp = scanner.nextLine();
            contacts.get(i).setSurname(temp);
        }else if(word.equals("birth")){
            System.out.print("Enter birth: ");
            temp = scanner.nextLine();
            contacts.get(i).setBirthdate(LocalDate.parse(temp));
        }else if(word.equals("gender")){
            System.out.print("Enter gender: ");
            temp = scanner.nextLine();
            contacts.get(i).setGender(temp);
        }else if(word.equals("address")){
            System.out.print("Enter address: ");
            temp = scanner.nextLine();
            contacts.get(i).editAddress(temp);
        }else if(word.equals("number")){
            System.out.print("Enter number: ");
            temp = scanner.nextLine();
            contacts.get(i).setContact(temp);
        }else if(word.equals("organization")){
            System.out.print("Enter name: ");
            temp = scanner.nextLine();
            contacts.get(i).setName(temp);
        }
        System.out.println("Saved");
        contacts.get(i).edited = LocalDateTime.now();
        information(i+1);
    }

    public boolean arrayCheck () {
        if (contacts.isEmpty()) {
            return true;
        }else return false;
    }

}
