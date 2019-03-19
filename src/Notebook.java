import java.util.Arrays;

public class Notebook {
    private final int bound =3;


    private Entry[] entries = new Entry[bound];
    private int count = 0;

    public void add(String name, String lastName, String phoneNumber) {
        Entry entry = new Entry(name, lastName, phoneNumber);

        if (count == entries.length) {
            entries = Arrays.copyOf(entries,count+bound);
        }

        entries[count++] = entry;
    }

    public void modify(int index, String name, String lastName, String phoneNumber) throws IndexOutOfBoundsException{
        if (index == -1 || index >= count) {
            throw new IndexOutOfBoundsException("Запись под данным индексом не существует");
        }
        entries[index].modify(name, lastName, phoneNumber);
    }

    public void delete(int index) throws IndexOutOfBoundsException{
        if (index == -1 || index >= count) {
            throw new IndexOutOfBoundsException("Запись под данным индексом не существует");
        }
        count--;
        for (int i = index; i < count; i++) {
            entries[i] = entries[i+1];
        }
        entries[count] = null;
        if (entries.length > count + bound) {
            entries = Arrays.copyOf(entries, count + bound/2);
        }
    }

    public String printOut() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(i+1).append(": ").append(entries[i].toString()).append("\n");
        }
        result.append("Entries count: ").append(count).append("\nArray length: ").append(entries.length).append("\n");
        return result.toString();
    }

    public int findByNameLastName(String name, String lastName) {
        for (int i = 0; i < count; i++) {
            if (entries[i].getName().equals(name) && entries[i].getLastName().equals(lastName)){
                return i;
            }
        }
        return -1; //если не найдено подходящей записи или блокнот пустой
    }

    public int findByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < count; i++) {
            if (entries[i].getPhoneNumber().equals(phoneNumber)){
                return i;
            }
        }
        return -1; //если не найдено подходящей записи или блокнот пустой
    }

    public void modifyByNameLastName (String name, String lastName, String newName, String newLastName, String newPhoneNumber) {
        modify(findByNameLastName(name, lastName), newName, newLastName, newPhoneNumber);
    }

    public void deleteByNameLastName (String name, String lastName) {
        delete(findByNameLastName(name, lastName));
    }
}
