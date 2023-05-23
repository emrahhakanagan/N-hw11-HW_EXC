import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker passwordChecker = new PasswordChecker();

        int minLength = 0;
        int maxRepeats = 0;

        System.out.println("Пожалуйста введите настройки пароля:");

        try {
            System.out.print("Введите мин. длину пароля: ");
            minLength = scanner.nextInt();
            passwordChecker.setMinLength(minLength);

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            maxRepeats = scanner.nextInt();
            passwordChecker.setMaxRepeats(maxRepeats);
        } catch (InputMismatchException exception) {
            System.out.println("Не верный тип ввода!\n");
        }

        while (true) {
            System.out.println("Введите пароль или end: ");
            String input = scanner.next();

            if (input.equals("end")) {
                break;
            }

            String msg = passwordChecker.verify(input) ? "Подходит!" : "Не подходит!";
            System.out.println(msg + "\n");
        }

    }
}