//single entry class
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

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        if (!name.isEmpty()) result.append("имя: ").append(name);
        if (result.length() != 0) result.append(", ");
        if (!lastName.isEmpty()) result.append("фамилия: ").append(lastName);
        if (result.length() != 0) result.append(", ");
        if (!phoneNumber.isEmpty()) result.append("номер телефона: ").append(phoneNumber);
        if (result.length() == 0) result.append("пустая запись");
        return result.toString();
    }
}
