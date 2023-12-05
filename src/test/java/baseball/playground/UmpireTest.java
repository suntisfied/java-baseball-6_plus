package baseball.playground;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.valueholder.CorrectAnswer;
import baseball.valueholder.PlayerAnswer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UmpireTest {
    @ParameterizedTest
    @CsvSource({
            "123, 124, 0, 2",
            "123, 312, 3, 0",
            "1234, 1243, 2, 2",
            "abc, cba, 2, 1",
    })
    void calculateBallAndStrike(String correctInput, String playerInput, String ballNumber, String strikeNumber) {
        var umpire = new Umpire(new PlayerAnswer(playerInput), new CorrectAnswer(correctInput));

        assertAll(
                () -> assertEquals(Integer.valueOf(ballNumber), umpire.callBall()),
                () -> assertEquals(Integer.valueOf(strikeNumber), umpire.callStrike())
        );
    }
}
