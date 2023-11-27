package baseball;

public class PlayerInputValidator extends ValidatingUtils {
    public boolean validatePlayerInput(String userInput, InitialSettings initialSettings) {
        int gameType = initialSettings.gameType();
        int gameSize = initialSettings.gameSize();
        boolean commonValidity = isUniqueOnly.test(userInput) && isPredefinedSize.test(userInput, gameSize);

        if (gameType == 1) {
            return isProperNumberRange.test(userInput) && isPositiveInteger.test(userInput) && commonValidity;
        }

        return isProperAlphabetRange.test(userInput) && isLowercaseAlphabet.test(userInput) && commonValidity;
    }
}
