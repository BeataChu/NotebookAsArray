import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//main class, interaction with user
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
    //data input: readLine throws exception, myReadLine catches it
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

    //modify entry
    private static void modifyEntry() {
        System.out.println("Изменить запись: 1 - по имени и фамилии, 2 - по номеру телефона");
        String answer = myReadLine();
        try {
            int index =-1;
            if (answer.equals("1")) {
                index = phoneBook.findByNameLastName(
                        requestName(),
                        requestLastName());

            } else if (answer.equals("2")) {
                index = phoneBook.findByPhoneNumber(
                        requestPhoneNumber());
            } else {
                System.out.println("Введен неверный символ");
                return;
            }
            if (index >= 0) {
                phoneBook.modify(
                        index,
                        requestNewName(),
                        requestNewLastName(),
                        requestNewPhoneNumber());
                System.out.println("Запись изменена" + "\n");
            }


        } catch (Exception e) {
            System.out.println("Запись не найдена" + "\n");
        }
    }

    //delete entry
    private static void deleteEntry() {
        System.out.println("Удалить запись: 1 - по имени и фамилии, 2 - по номеру телефона");
        String answer = myReadLine();
        try {
            int index = -1;
            if (answer.equals("1")) {
                index = phoneBook.findByNameLastName(
                        requestName(),
                        requestLastName());

            } else if (answer.equals("2")) {
                index = phoneBook.findByPhoneNumber(
                        requestPhoneNumber());
            } else {
                System.out.println("Введен неверный символ");
                return;
            }
            phoneBook.delete(index);
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
