package baseball;

import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private final UserInputValidator userInputValidator;

    public Player() {
        this.scanner = new Scanner(System.in);
        userInputValidator = new UserInputValidator();
    }

    public UserAnswer speculateAnswer(int gameType, int gameSize) {
        String input = scanner.nextLine();

        try {
            if (!userInputValidator.validatePlayerInput(input, gameType, gameSize)) {
                throw new IllegalArgumentException("Invalid User Answer Input");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return speculateAnswer(gameType, gameSize);
        }

        return new UserAnswer(input);
    }
}
