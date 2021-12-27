package contacts;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    Contact contact;
    Data data;
    Boolean isPerson;

    public Application() {
        data = new Data();
        mainMenu();
    }

    public void addMenu () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the type (person, organization): ");
        String type = scanner.nextLine();
        setType(type);
        if(this.isPerson){
            System.out.print("Enter the name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the surname: ");
            String surname = scanner.nextLine();
            System.out.print("Enter the birth date: ");
            String birthdate = scanner.nextLine();
            LocalDate temp = setBirth(birthdate);
            System.out.print("Enter the gender (M, F): ");
            String gender = scanner.nextLine();
            String tempGender = checkGender(gender);
            System.out.print("Enter the number: ");
            String inputNumber = scanner.nextLine();
            this.contact = new Person(inputNumber,name,surname,temp,tempGender);
        }else {
            System.out.print("Enter the organization name: ");
            String organization = scanner.nextLine();
            System.out.print("Enter the address: ");
            String address = scanner.nextLine();
            System.out.print("Enter the number: ");
            String inputNumber = scanner.nextLine();
            this.contact = new Organization(inputNumber,organization,address);
        }

        System.out.println("The record added.\n");
        data.contacts.add(this.contact);
    }


    public LocalDate setBirth(String birthdate) {
        LocalDate temp;
        try{
            temp = LocalDate.parse(birthdate);
            return temp;
        }catch(Exception e){
            System.out.println("Bad birth date!");
        }
        return null;
    }
    public String checkGender(String gender){
        if(gender.equals("M") || gender.equals("F")) {
            return gender;
        }else {
            System.out.println("Bad gender!");
            return "[no data]";
        }
    }


    public void editMenu () {
        if(data.arrayCheck()) {
            System.out.println("No records to edit!");
        }else {
            data.showContacts();
            System.out.print("Select a record: ");
            Scanner scanner = new Scanner(System.in);
            int inputik = scanner.nextInt();
            data.contacts.get(--inputik).fields();
            String word = scanner.next();
            data.editContact(inputik,word);
        }
    }


    public void removeMenu () {
        if(data.arrayCheck()) {
            System.out.println("No records to remove!");
        }else {
            data.showContacts();
            System.out.print("Select a record: ");
            Scanner scanner = new Scanner(System.in);
            int inputik = scanner.nextInt();
            data.removeContact(inputik);
        }
    }

    public void setType(String type){
        if(type.equals("person")){
            this.isPerson = true;
        }else this.isPerson = false;
    }

    public void mainMenu () {
        boolean run = true;
        while(run) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
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
                case "info":
                    data.showContacts();
                    data.information();
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
