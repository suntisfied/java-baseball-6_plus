package baseball;

import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private final UserInputValidator userInputValidator;

    public Player() {
        this.scanner = new Scanner(System.in);
        userInputValidator = new UserInputValidator();
    }

    public UserAnswer speculateAnswer() {
        String input = scanner.nextLine();

        try {
            if (!userInputValidator.validatePlayerInput(input)) {
                throw new IllegalArgumentException("Invalid Input");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return speculateAnswer();
        }

        return new UserAnswer(input);
    }
}
