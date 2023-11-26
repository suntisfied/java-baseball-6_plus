package baseball;

public class UserInputValidator extends ValidatingUtils {
    public boolean validatePlayerInput(String userInput, Integer gameType, Integer gameSize) {
        boolean commonValidity = isUniqueOnly.test(userInput) && isPredefinedSize.test(userInput, gameSize);

        if (gameType == 1) {
            return isProperNumberRange.test(userInput) && isPositiveInteger.test(userInput) && commonValidity;
        }

        return isProperAlphabetRange.test(userInput) && isLowercaseAlphabet.test(userInput) && commonValidity;
    }
}
