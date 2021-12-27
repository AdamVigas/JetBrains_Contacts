package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    protected String phoneNumber;
    protected LocalDateTime created;
    protected LocalDateTime edited;

    public Contact(String phoneNumber) {
        this.setContact(phoneNumber);
        created = LocalDateTime.now();
        edited = LocalDateTime.now();
    }

    public String who(){
        return "Unknown who";
    }

    public void fields() {
        System.out.println("Contact class");
    }

    public void showYourself(){
        System.out.println("Unknown showYourself");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setContact(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\+?[\\w]{1}?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?|\\+?[\\w]{2,}?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?|\\+?(\\({1}[\\w]{2,}\\){1})?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?|\\+?[\\w]{2,}?([ -]{1}[\\(]{1}[\\w]{2,}[\\)]{1})?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?" +
                "|\\+?[\\w]{1}?([ -]{1}[\\(]{1}[\\w]{2,}[\\)]{1})?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?([ -]{1}[\\w]{2,})?");
        Matcher matcher = pattern.matcher(phoneNumber);
        if(matcher.matches()) {
            this.phoneNumber = phoneNumber;
        }else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }
    }

    public void setName(String name) {
    }

    public void setSurname(String surname) {
    }

    public void setBirthdate(LocalDate birthdate) {

    }

    public void setGender(String gender) {

    }

    public void editAddress(String name) {
    }

}
