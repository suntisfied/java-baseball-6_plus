package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserInputValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "123, true",
            "abc, false",
            "Abc, false",
            "12a, false",
            "12*/, false",
    })
    public void validateUserInputInNumber(String userInput, boolean isValid) {
        var playerInputValidator = new UserInputValidator();

        assertThat(playerInputValidator.validatePlayerInput(userInput, 3, 1)).isEqualTo(isValid);
    }

    @ParameterizedTest
    @CsvSource({
            "123, false",
            "abc, true",
            "Abc, false",
            "12a, false",
            "12*/, false",
    })
    public void validateUserInputInString(String userInput, boolean isValid) {
        var playerInputValidator = new UserInputValidator();

        assertThat(playerInputValidator.validatePlayerInput(userInput, 3, 2)).isEqualTo(isValid);
    }
}