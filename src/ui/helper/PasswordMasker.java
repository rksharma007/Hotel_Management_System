package ui.helper;

import java.io.Console;

public class PasswordMasker {
    public static String readPassword(Console console, String prompt) {
        StringBuilder password = new StringBuilder();
        console.printf(prompt);

        char[] mask = new char[] { '*' }; // Character to show as mask

        while (true) {
            char[] input = console.readPassword("");  // Read password silently
            for (char ch : input) {
                password.append(ch);  // Append actual character to password
                console.printf("%s", new String(mask));  // Print asterisk
            }
            break;
        }

        return password.toString();
    }
}
