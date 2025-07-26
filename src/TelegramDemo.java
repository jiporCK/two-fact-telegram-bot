import java.util.Scanner;

public class TelegramDemo {

    private static String email = "admin@gmail.com";
    private static String password = "admin@123";
    private static String generatedCode;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        email = scanner.nextLine();

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        System.out.println("Sending confirmation code to your Telegram...");

        generatedCode = String.valueOf((int)(Math.random() * 900000) + 100000);

        TelegramService telegramService = new TelegramService();
        telegramService.sendCodeToTelegram(generatedCode);

        System.out.println("Please enter the code you received:");

        String enteredCode = scanner.nextLine();

        if (generatedCode.equals(enteredCode)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid code.");
        }
    }
}
