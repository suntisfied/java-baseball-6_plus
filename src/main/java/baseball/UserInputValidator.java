package baseball;

import static baseball.ConvertingUtils.convertStringToList;
import static baseball.ConvertingUtils.convertStringToSet;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class UserInputValidator {
    public boolean validatePlayerInput(String userInput, Integer gameSize, Integer gameType) {
        boolean commonValidity = isUniqueOnly.test(userInput) && isPredefinedSize.test(userInput, gameSize);

        if (gameType == 1) {
            return isProperNumberRange.test(userInput) && isPositiveInteger.test(userInput) && commonValidity;
        }

        return isLowercaseAlphabet.test(userInput) && commonValidity;
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

    private final Predicate<String> isProperNumberRange = input -> input.length() > 1 && input.length() < 10;

    private final Predicate<String> isUniqueOnly = input ->
            convertStringToList(input).size() == convertStringToSet(input).size();

    private final Predicate<String> isValidType = input ->
            Integer.parseInt(input) == 1
                    || Integer.parseInt(input) == 2;

    public final BiPredicate<String, Integer> isPredefinedSize = (input, size) -> input.length() == size;
}
