package baseball.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.valueholder.InitialSettings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerInputValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "1, 3, abc",
            "2, 3, 123",
            "1, 2, 123",
            "2, 2, abc",
            "1, 3, 1",
            "2, 3, a",
            "1, 3, 1234567890",
            "1, 3, 112",
            "2, 3, aab",
    })
    void throwIllegalArgumentExceptionToInvalidInput(String gameType, int gameSize, String userInput) {
        var initialSettings = new InitialSettings(gameType, gameSize);

        assertThatIllegalArgumentException().isThrownBy(() ->
                new PlayerInputValidator().checkPlayerInputValidity(userInput, initialSettings));
    }
}