import java.util.Arrays;

public class Notebook {
    // step for changing array size
    final static int STEP = 10;


    private Entry[] entries = new Entry[STEP];
    //number of entries
    private int count = 0;

    //add entry
    public void add(String name, String lastName, String phoneNumber) {
        Entry entry = new Entry(name, lastName, phoneNumber);

        if (count == entries.length) {
            entries = Arrays.copyOf(entries,count+STEP);
        }

        entries[count++] = entry;
    }

    // modify entry by index number
    public void modify(int index, String name, String lastName, String phoneNumber){
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Запись под данным индексом не существует");
        }
        entries[index].modify(name, lastName, phoneNumber);
    }

    //delete entry
    public void delete(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Запись под данным индексом не существует");
        }
        count--;
        for (int i = index; i < count; i++) {
            entries[i] = entries[i+1];
        }
        entries[count] = null;
        if (entries.length > count + STEP) {
            entries = Arrays.copyOf(entries, count + STEP/2);
        }
    }

    //print out phonebook
    public String printOut() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(i+1).append(": ").append(entries[i].toString()).append("\n");
        }
        result.append("Entries count: ").append(count).append("\nArray length: ").append(entries.length).append("\n");
        return result.toString();
    }

    //returns entry index by name and last name
    public int findByNameLastName(String name, String lastName) {
        for (int i = 0; i < count; i++) {
            if (entries[i].getName().equals(name) && entries[i].getLastName().equals(lastName)){
                return i;
            }
        }
        //if no such entry or if phonebook is empty
        return -1;
    }

    //returns entry index by phone number
    public int findByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < count; i++) {
            if (entries[i].getPhoneNumber().equals(phoneNumber)){
                return i;
            }
        }
        //if no such entry or if phonebook is empty
        return -1;
    }

}
