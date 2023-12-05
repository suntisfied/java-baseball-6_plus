package baseball.playground;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.valueholder.PlayerAnswer;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameRecorderTest {
    @ParameterizedTest
    @CsvSource({
            "'123,456,789'",
    })
    void shouldReturnAccurateNumberOfPitchingNumberAndRecord(String concatenatedUserInputs) {
        var gameRecorder = new GameRecorder();

        List<String> userInputs = List.of(concatenatedUserInputs.split(","));

        userInputs.forEach(userInput -> {
            var playerAnswer = new PlayerAnswer(userInput);
            gameRecorder.recordPitching(playerAnswer);
        });

        assertAll(
                () -> assertEquals(3, gameRecorder.retrievePitchingNumber()),
                () -> assertThat(gameRecorder.retrievePitchingRecords()).containsExactly(new PlayerAnswer("123"),
                        new PlayerAnswer("456"), new PlayerAnswer("789"))
        );
    }
}