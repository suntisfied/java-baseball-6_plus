package baseball.playground;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.util.ConsoleManager;
import baseball.valueholder.InitialSettings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class PlayerTest {
    @ParameterizedTest
    @CsvSource({
            "1, 3, 123",
            "2, 3, abc",
    })
    void produceAnswerOnlyFromValidInput(String gameType, int gameSize, String userInput) {
        try (MockedStatic<ConsoleManager> mockedConsoleReader = Mockito.mockStatic(ConsoleManager.class)) {
            mockedConsoleReader.when(ConsoleManager::getConsoleInput).thenReturn(userInput);

            var initialSettings = new InitialSettings(gameType, gameSize);
            var player = new Player();
            var playerAnswer = player.speculateAnswer(initialSettings);

            assertEquals(userInput, playerAnswer.answer());
        }
    }
}