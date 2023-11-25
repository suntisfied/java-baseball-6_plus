package baseball;

import java.util.function.Predicate;

public class UserInputValidator {
    public boolean validatePlayerInput(String userInput) {
        return (isPositiveInteger.test(userInput)
                || isLowercaseAlphabet.test(userInput))
                && isBiggerThanLengthOne.test(userInput);
    }

    public boolean validateGameSizeInput(String userInput) {
        return isPositiveInteger.test(userInput);
    }

    public boolean validateGameTypeInput(String userInput) {
        return isValidType.test(userInput);
    }

    public final Predicate<String> isPositiveInteger = input -> {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    public final Predicate<String> isLowercaseAlphabet = input -> input.matches("[a-z]+");

    private final Predicate<String> isBiggerThanLengthOne = input -> input.length() > 1;

    private final Predicate<String> isValidType = input ->
            Integer.parseInt(input) == 1
                    || Integer.parseInt(input) == 2;
}
