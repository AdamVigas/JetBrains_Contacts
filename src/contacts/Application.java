package contacts;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    Contact contact;
    Data data;
    Boolean isPerson;

    public Application() {
        data = new Data();
        System.out.println("open phonebook.db\n");
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


    public void editMenu (int num) {
        if(data.arrayCheck()) {
            System.out.println("No records to edit!");
        }else {
            Scanner scanner = new Scanner(System.in);
            data.contacts.get(--num).fields();
            String word = scanner.next();
            data.editContact(num,word);
        }
    }


    public void removeMenu (int n) {
        if(data.arrayCheck()) {
            System.out.println("No records to remove!");
        }else {
            data.removeContact(n);
        }
    }

    public void setType(String type){
        if(type.equals("person")){
            this.isPerson = true;
        }else this.isPerson = false;
    }

    public void searching(){
        System.out.print("Enter search query: ");
        Scanner scanner = new Scanner(System.in);
        String inputSearch = scanner.nextLine();
        data.searchName(inputSearch);

        System.out.print("[search] Enter action ([number], back, again): ");

        String inText = scanner.next();
        if (inText.equals("back")){

        }else if(inText.equals("again")){
            searching();
        } else if(inText.matches("\\D+")){
            System.out.println("Wrong input");
            searching();
        }else{
            int number = Integer.valueOf(inText);
            data.information(number);
            recordMenu(number);
        }
    }

    public void recordMenu(int num) {
        boolean beh = true;
        while(beh){
            System.out.print("[record] Enter action (edit, delete, menu): ");
            Scanner scanner = new Scanner(System.in);
            String inputSearch = scanner.nextLine();
            if(inputSearch.equals("menu")){
                beh = false;
                break;
            }else if(inputSearch.equals("edit")){
                editMenu(num);
            }else if(inputSearch.equals("delete")){
                removeMenu(num);
            }
        }
    }

    public void listMenu() {

        data.showContacts();
        System.out.print("[list] Enter action ([number], back): ");
        Scanner scanner = new Scanner(System.in);
        String inText = scanner.next();
        if (inText.equals("back")){

        }else if(inText.matches("\\D+")){
            System.out.println("Wrong input");
            listMenu();
        }else{
            int number = Integer.valueOf(inText);
            data.information(number);
            recordMenu(number);
        }

    }


    public void mainMenu () {
        boolean run = true;
        while(run) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            String input = scanner.nextLine();
            switch(input) {
                case "add":
                    addMenu();
                    break;
                case "list":
                    listMenu();
                    break;
                case "search":
                    searching();
                    break;
                case "count":
                    System.out.println("The Phone Book has " + data.countContacts() +" records.");
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
