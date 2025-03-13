import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordManager {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    public static void printBanner() {
        System.out.println("\n");
        System.out.println(" ██████╗  █████╗ ███████╗███████╗ ██████╗ ███████╗");
        System.out.println(" ██╔══██╗██╔══██╗██╔════╝██╔════╝██╔═══██╗██╔════╝");
        System.out.println(" ██████╔╝███████║███████╗█████╗  ██║   ██║█████╗  ");
        System.out.println(" ██╔═══╝ ██╔══██║╚════██║██╔══╝  ██║   ██║██╔══╝  ");
        System.out.println(" ██║     ██║  ██║███████║███████╗╚██████╔╝██║     ");
        System.out.println(" ╚═╝     ╚═╝  ╚═╝╚══════╝╚══════╝ ╚═════╝ ╚═╝     ");
        System.out.println("--------------------------------------------------");
        System.out.println("|           🔐 Password Manager CLI 🔐           |");
        System.out.println("--------------------------------------------------");
        System.out.println("| 1. Generate a Strong Password                  |");
        System.out.println("| 2. Check Password Strength                     |");
        System.out.println("| 3. Exit                                        |");
        System.out.println("--------------------------------------------------");
    }

    public static String generatePassword(int length) {
        String allChars = UPPERCASE + LOWERCASE + DIGITS + SPECIALS;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allChars.length());
            password.append(allChars.charAt(index));
        }

        return password.toString();
    }

    public static String checkPasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 12) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[!@#$%^&*()-_=+\\[\\]{}|;:'\",.<>?/].*")) score++;

        if (score >= 4) return "🔥 Strong 🔥";
        else if (score == 3) return "⚠️ Medium ⚠️";
        else return "❌ Weak ❌";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBanner();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter password length: ");
                int length = scanner.nextInt();
                String password = generatePassword(length);
                System.out.println("🔑 Generated Password: " + password);
            } else if (choice == 2) {
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.println("🔍 Password Strength: " + checkPasswordStrength(password));
            } else if (choice == 3) {
                System.out.println("🚀 Exiting... Stay secure! 🔒");
                break;
            } else {
                System.out.println("❌ Invalid choice! Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine(); // Wait for user to press Enter
        }

        scanner.close();
    }
}
