package baseball;

import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private final UserInputValidator userInputValidator;

    public Player() {
        this.scanner = new Scanner(System.in);
        userInputValidator = new UserInputValidator();
    }

    public UserAnswer speculateAnswer(int gameSize, int gameType) {
        String input = scanner.nextLine();

        try {
            if (!userInputValidator.validatePlayerInput(input, gameSize, gameType)) {
                throw new IllegalArgumentException("Invalid User Answer Input");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return speculateAnswer(gameSize, gameType);
        }

        return new UserAnswer(input);
    }
}
