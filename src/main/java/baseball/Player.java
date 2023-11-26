package baseball;

public class Player extends ConsoleInputForm {
    private final PlayerInputValidator playerInputValidator;

    public Player() {
        playerInputValidator = new PlayerInputValidator();
    }

    public PlayerAnswer speculateAnswer(int gameType, int gameSize) {
        String userInput = getInputUntilCorrect(
                () -> System.out.print("Your Guess: "),
                input -> {
                    if (!playerInputValidator.validatePlayerInput(input, gameType, gameSize)) {
                        throw new IllegalArgumentException("Invalid User Answer Input");
                    }
                }
        );
        return new PlayerAnswer(userInput);
    }
}
