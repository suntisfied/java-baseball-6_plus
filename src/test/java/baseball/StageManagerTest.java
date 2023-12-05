package baseball;

import static baseball.setting.Texts.LINE_BREAK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import baseball.playground.CorrectAnswerGenerator;
import baseball.util.ConsoleManager;
import baseball.valueholder.CorrectAnswer;
import baseball.valueholder.InitialSettings;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StageManagerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));

    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(System.in);
        System.setOut(System.out);
        ConsoleManager.closeConsole();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 3, 123, 145, 1스트라이크",
            "1, 3, 123, 312, 3볼",
            "1, 3, 123, 123, 모두 맞히셨습니다",
            "1, 3, 123, 456, 낫싱",
            "2, 4, abcd, defg, 1볼",
            "2, 4, abcd, abdc, 2볼 2스트라이크",
            "2, 4, abcd, abcd, 모두 맞히셨습니다",
            "2, 4, abcd, efgh, 낫싱",
    })
    void checkGameLogic(String gameType, int gameSize, String correctInput, String playerInput, String outputText) {
        var initialSettings = new InitialSettings(gameType, gameSize);
        var mockCorrectAnswerGenerator = mock(CorrectAnswerGenerator.class);
        given(mockCorrectAnswerGenerator.generateCorrectAnswer(initialSettings)).willReturn(
                new CorrectAnswer(correctInput));

        var stageManager = new StageManager(mockCorrectAnswerGenerator);

        String mockInput =
                gameType + LINE_BREAK.getText() + gameSize + LINE_BREAK.getText() + playerInput;
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        try {
            stageManager.repeatEntireGameUntilEnd();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains(outputText);
    }
}