package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserInputValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "123, true",
            "12345, true",
            "abc, true",
            "Abc, false",
            "12a, false",
            "12*/, false",
    })
    public void validateUserInput(String userInput, boolean isValid) {
        var playerInputValidator = new UserInputValidator();

        assertThat(playerInputValidator.validatePlayerInput(userInput)).isEqualTo(isValid);
    }
}