package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserInputValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "123, 1, 3, true",
            "123, 1, 4, false",
            "122, 1, 3, false",
            "1, 1, 1, false",
            "1234567890, 1, 10, false",
            "abc, 1, 3, false",
            "abc, 2, 3, true",
            "abc, 2, 4, false",
            "abb, 2, 3, false",
            "abcdefghij, 2, 10, true",
            "Abc, 1, 3, false",
            "12a, 1, 3, false",
            "12*/, 1, 3, false",
    })
    public void validateUserInputInNumber(String userInput, int gameType, int gameSize, boolean isValid) {
        var playerInputValidator = new UserInputValidator();

        assertThat(playerInputValidator.validatePlayerInput(userInput, gameType, gameSize)).isEqualTo(isValid);
    }
}