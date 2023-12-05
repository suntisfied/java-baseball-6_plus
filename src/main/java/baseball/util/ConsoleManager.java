package baseball.util;

import java.util.Scanner;

public class ConsoleManager {
    private static Scanner scanner;

    private ConsoleManager() {
    }

    public static String getConsoleInput() {
        return callScanner().nextLine();
    }

    public static void closeConsole() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    private static Scanner callScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
