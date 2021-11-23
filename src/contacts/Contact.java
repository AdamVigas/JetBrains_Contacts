package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.setContact(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
