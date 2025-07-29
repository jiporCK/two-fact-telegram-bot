import java.util.Scanner;

public class TelegramDemo {

    private static final String EMAIL = "admin@gmail.com";
    private static final String PASSWORD = "admin@123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (email.equals(EMAIL) && password.equals(PASSWORD)) {
                break;
            } else {
                System.out.println("Invalid email or password");
            }
        }

        System.out.println("Sending confirmation code to your Telegram...");

        String generatedCode = String.valueOf((int) (Math.random() * 900000) + 100000);

        TelegramService telegramService = new TelegramService();
        Thread sendThread = new Thread(() -> {
            telegramService.sendCodeToTelegram(generatedCode);
            System.out.println("✅ Code sent via Telegram.");
        });

        sendThread.start();

        try {
            sendThread.join(); // Wait for code to be sent before asking for input
        } catch (InterruptedException e) {
            System.out.println("Error while sending code.");
            return;
        }

        System.out.print("Please enter the code you received: ");

        String enteredCode = scanner.nextLine();

        if (generatedCode.equals(enteredCode)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid code.");
        }
    }
}
