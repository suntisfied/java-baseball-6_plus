package baseball;

public class GameInitializer extends ConsoleInputForm {
    public int setGameType() {
        String userInput = getInputUntilCorrect(
                () -> System.out.print("Set Game Type: "),
                input -> {
                    if (!new ValidatingUtils().isValidType.test(input)) {
                        throw new IllegalArgumentException("Invalid Game Type Input");
                    }
                });
        return Integer.parseInt(userInput);
    }

    public int setGameSize() {
        String userInput = getInputUntilCorrect(
                () -> System.out.print("Set Game Size: "),
                input -> {
                    if (!new ValidatingUtils().isPositiveInteger.test(input)) {
                        throw new IllegalArgumentException("Invalid Game Size Input");
                    }
                });
        return Integer.parseInt(userInput);
    }
}
