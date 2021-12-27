package contacts;

public class Organization extends Contact{
    String orgName;
    String address;

    public Organization(String phoneNumber, String orgName, String address) {
        super(phoneNumber);
        this.orgName = orgName;
        this.address = address;
    }

    @Override
    public void setName(String name) {
        this.orgName = name;
    }

    @Override
    public void editAddress(String add) {
        this.address = add;
    }

    @Override
    public String who() {
        return orgName;
    }

    @Override
    public void fields() {
        System.out.print("Select a field (organization, address, number): ");
    }

    @Override
    public void showYourself(){
        System.out.println("Organization name: " + checkerNull(this.orgName));
        System.out.println("Address: " + checkerNull(this.address));
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
