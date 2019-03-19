public class Entry {
    private String name;;
    private String lastName;
    private String phoneNumber;

    public Entry(String name, String lastName, String phoneNumber){
        this.modify(name, lastName, phoneNumber);
    }

    public void modify(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        if (!name.isEmpty()) result.append("name: ").append(name);
        if (result.length() != 0) result.append(", ");
        if (!lastName.isEmpty()) result.append("last name: ").append(lastName);
        if (result.length() != 0) result.append(", ");
        if (!phoneNumber.isEmpty()) result.append("phone number: ").append(phoneNumber);
        if (result.length() == 0) result.append("empty entry");
        return result.toString();
    }
}
