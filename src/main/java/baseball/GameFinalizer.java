package baseball;

public class GameFinalizer extends ConsoleInputForm {
    public boolean isRepeating() {
        String userInput = getInputUntilCorrect(
                () -> System.out.print("Set Game Repeat: "),
                input -> {
                    if (!new ValidatingUtils().isValidEndingInput.test(input)) {
                        throw new IllegalArgumentException("Invalid Game Ending Input");
                    }
                });
        return userInput.equals("1");
    }
}
