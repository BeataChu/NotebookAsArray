import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// comment for commit
public class Interaction {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Notebook phoneBook = new Notebook();

    public static void main(String[] args) {
        String answer ="";
        do {
            showMenu();
            answer = myReadLine();

            switch (answer) {
                case ("1") :
                    addEntry();
                    break;
                case ("2") :
                    modifyEntry();
                    break;
                case ("3") :
                    deleteEntry();
                    break;
                case ("4") :
                    System.out.println(phoneBook.printOut());
            }

        } while (!answer.equals("0"));
    }

    private static void showMenu(){
        System.out.println("Пожалуйста, выберите действие:");
        System.out.println("1 - добавить запись");
        System.out.println("2 - редактировать запись");
        System.out.println("3 - удалить запись");
        System.out.println("4 - распечатать все записи");
        System.out.println("0 - выход");
    }

    private static String myReadLine(){
        String answer = "";
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    private static void addEntry() {
        phoneBook.add(
                requestName(),
                requestLastName(),
                requestPhoneNumber()
        );
        System.out.println("Запись добавлена" + "\n");
    }

    private static void modifyEntry() {
        try {
            phoneBook.modifyByNameLastName(
                    requestName(),
                    requestLastName(),
                    requestNewName(),
                    requestNewLastName(),
                    requestNewPhoneNumber());
            System.out.println("Запись изменена" + "\n");
        } catch (Exception e) {
            System.out.println("Запись не найдена" + "\n");
        }
    }

    private static void deleteEntry() {

        try {
            phoneBook.deleteByNameLastName(
                    requestName(),
                    requestLastName()
            );
            System.out.println("Запись удалена" + "\n");
        } catch (Exception e) {
            System.out.println("Запись не найдена" + "\n");
        }
    }

    //methods to read data
    private static String requestName() {
        System.out.println("Введите имя: ");
        return myReadLine();
    }

    private static String requestLastName() {
        System.out.println("Введите фамилию: ");
        return myReadLine();
    }


    private static String requestPhoneNumber() {
        System.out.println("Введите номер телефона: ");
        return myReadLine();
    }

    private static String requestNewName() {
        System.out.println("Введите новое имя: ");
        return myReadLine();
    }

    private static String requestNewLastName() {
        System.out.println("Введите новую фамилию: ");
        return myReadLine();
    }

    private static String requestNewPhoneNumber() {
        System.out.println("Введите новый номер телефона: ");
        return myReadLine();
    }
}
