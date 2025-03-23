package Chapter14;

import java.util.Scanner;

public class PasswordValidation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password");
        String password = scanner.nextLine();
        System.out.println(passwordValidation(password));
    }

    public static boolean passwordValidation (String password){
        return password.matches("^(?=.*[A-Z])(?=.*\\d)[A-Za-z][A-Za-z\\d]{7,14}$");
    }
}
