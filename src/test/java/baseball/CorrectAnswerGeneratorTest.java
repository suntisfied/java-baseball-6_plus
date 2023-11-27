package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.playground.CorrectAnswerGenerator;
import baseball.valueholder.InitialSettings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CorrectAnswerGeneratorTest {

    @ParameterizedTest
    @CsvSource({
            "1, 3",
            "1, 4",
            "2, 3",
            "2, 4",
    })
    public void generateCorrectAnswerInNumber(String gameType, int gameSize) {
        var correctAnswerGenerator = new CorrectAnswerGenerator(new InitialSettings(gameType, gameSize));
        var correctAnswer = correctAnswerGenerator.generateCorrectAnswer();
        System.out.println("Correct Answer: " + correctAnswer.answer());

        assertThat(correctAnswer.answer().length()).isEqualTo(gameSize);
    }
}