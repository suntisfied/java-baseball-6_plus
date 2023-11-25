package baseball;

import java.util.Scanner;

public class GameInitializer {
    private final Scanner scanner;
    private final UserInputValidator userInputValidator;

    public GameInitializer() {
        this.scanner = new Scanner(System.in);
        userInputValidator = new UserInputValidator();
    }

    public int setGameSize() {
        System.out.print("Set Game Size: ");
        String input = scanner.nextLine();

        try {
            if (!userInputValidator.validateGameSizeInput(input)) {
                throw new IllegalArgumentException("Invalid Game Length Input");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setGameSize();
        }

        return Integer.parseInt(input);
    }

    public int setGameType() {
        System.out.print("Set Game Type: ");
        String input = scanner.nextLine();

        try {
            if (!userInputValidator.validateGameTypeInput(input)) {
                throw new IllegalArgumentException("Invalid Game Type Input");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setGameType();
        }

        return Integer.parseInt(input);
    }
}
