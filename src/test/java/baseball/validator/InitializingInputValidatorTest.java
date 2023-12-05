package baseball.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InitializingInputValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "0",
            "3",
            "a",
    })
    void throwIllegalArgumentExceptionToInvalidGameType(String gameType) {
        var initializingInputValidator = new InitializingInputValidator();

        assertThatIllegalArgumentException().isThrownBy(() -> initializingInputValidator.checkGameType(gameType));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "1, 10",
            "2, 1",
            "2, 27",
    })
    void throwIllegalArgumentExceptionToInvalidGameSize(String gameType, String gameSize) {
        var initializingInputValidator = new InitializingInputValidator();

        assertThatIllegalArgumentException().isThrownBy(
                () -> initializingInputValidator.checkGameSize(gameSize, gameType));
    }
}