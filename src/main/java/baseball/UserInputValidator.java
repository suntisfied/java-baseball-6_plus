package baseball;

import java.util.function.Predicate;

public class UserInputValidator {
    public boolean validatePlayerInput(String userInput) {
        return (isPositiveInteger.test(userInput)
                || isLowercaseAlphabet.test(userInput))
                && isBiggerThanLengthOne.test(userInput);
    }

    private final Predicate<String> isPositiveInteger = input -> {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    private final Predicate<String> isLowercaseAlphabet = input -> input.matches("[a-z]+");

    private final Predicate<String> isBiggerThanLengthOne = input -> input.length() > 1;
}
