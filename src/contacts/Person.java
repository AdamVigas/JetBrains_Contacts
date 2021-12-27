package contacts;

import java.time.LocalDate;

public class Person extends Contact{
    String name;
    String surname;
    LocalDate birthdate;
    String gender;

    public Person(String phoneNumber, String name, String surname, LocalDate date, String gender) {
        super(phoneNumber);
        this.name = name;
        this.surname = surname;
        this.birthdate = date;
        this.gender = gender;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String who() {
        return name + " " + surname;
    }

    @Override
    public void fields() {
        System.out.println("Select a field (name, surname, birth, gender, number):");
    }

    @Override
    public void showYourself(){
        System.out.println("Name: " + checkerNull(this.name));
        System.out.println("Surname: " + checkerNull(this.surname));
        System.out.println("Birth date: " + checkerNull(this.birthdate));
        System.out.println("Gender: " + checkerNull(this.gender));
        System.out.println("Number: " + checkerNull(super.phoneNumber));
        System.out.println("Time created: " + checkerNull(super.created));
        System.out.println("Time last edit: " + checkerNull(super.edited));
        System.out.println();
    }
    public Object checkerNull(Object a) {
        if(a == null) {
            return "[no data]";
        }else return a;
    }
}
