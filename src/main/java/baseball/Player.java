package baseball;

public class Player extends ConsoleInputForm {
    private final UserInputValidator userInputValidator;

    public Player() {
        userInputValidator = new UserInputValidator();
    }

    public UserAnswer speculateAnswer(int gameType, int gameSize) {
        String userInput = getInputUntilCorrect(
                () -> System.out.print("Your Guess: "),
                input -> {
                    if (!userInputValidator.validatePlayerInput(input, gameType, gameSize)) {
                        throw new IllegalArgumentException("Invalid User Answer Input");
                    }
                }
        );
        return new UserAnswer(userInput);
    }
}
