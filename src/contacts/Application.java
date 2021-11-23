package contacts;

import java.util.Scanner;

public class Application {
    Contact contact;
    Data data;

    public Application() {
        data = new Data();
        mainMenu();
    }

    public void addMenu () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the person:");
        String inputName = scanner.nextLine();
        System.out.println("Enter the surname of the person:");
        String inputSurname = scanner.nextLine();
        System.out.println("Enter the number:");
        String inputNumber = scanner.nextLine();
        this.contact = new Contact(inputName,inputSurname, inputNumber);
        System.out.println("The record added.");
        data.contacts.add(this.contact);
    }

    public void editMenu () {
        if(data.arrayCheck()) {
            System.out.println("No records to edit!");
        }else {
            data.showContacts();
            System.out.println("Select a record:");
            Scanner scanner = new Scanner(System.in);
            int inputik = scanner.nextInt();
            System.out.println("Select a field (name, surname, number):");
            String word = scanner.next();
            data.editContact(inputik,word);
        }
    }

    public void removeMenu () {
        if(data.arrayCheck()) {
            System.out.println("No records to remove!");
        }else {
            data.showContacts();
            System.out.println("Select a record:");
            Scanner scanner = new Scanner(System.in);
            int inputik = scanner.nextInt();
            data.removeContact(inputik);
        }
    }

    public void mainMenu () {
        boolean run = true;
        while(run) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            String input = scanner.nextLine();
            switch(input) {
                case "add":
                    addMenu();
                    break;
                case "remove":
                    removeMenu();
                    break;
                case "edit":
                    editMenu();
                    break;
                case "count":
                    System.out.println("The Phone Book has " + data.countContacts() +" records.");
                    break;
                case "list":
                    data.showContacts();
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    System.out.println("Wrong input.");
            }

        }
    }
}
