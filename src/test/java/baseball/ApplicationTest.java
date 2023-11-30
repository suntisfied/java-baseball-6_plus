package baseball;

import static baseball.setting.Texts.LINE_BREAK;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.ConsoleManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApplicationTest {
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
            "1, 2",
            "2, 1",
    })
    void restartAfterEnd(String restartButton, int giveUpNumber) {
        String mockInput =
                "1" + LINE_BREAK.getText() + "3" + LINE_BREAK.getText() + "!" + LINE_BREAK.getText() + restartButton
                        + LINE_BREAK.getText() + "1" + LINE_BREAK.getText() + "3" + LINE_BREAK.getText() + "!";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        try {
            Application.main(new String[]{});
        } catch (NoSuchElementException ignored) {
        }

        String outputString = outputStream.toString();
        System.out.println(outputString);

        int count = countOccurrences(outputString, "게임을 포기하셨습니다.");

        assertThat(count).isEqualTo(giveUpNumber);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 3, 123",
            "3, 3, 123",
            "a, 3, 123",
            "1, 3, abc",
            "1, 3, 12",
            "2, 3, 123",
            "2, 3, ab",
    })
    void showErrorMessageForInvalidInput(String gameType, String gameSize, String playerInput) {
        String mockInput =
                gameType + LINE_BREAK.getText() + gameSize + LINE_BREAK.getText() + playerInput;
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        try {
            Application.main(new String[]{});
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    private int countOccurrences(String haystack, String needle) {
        Matcher matcher = Pattern.compile(Pattern.quote(needle)).matcher(haystack);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}