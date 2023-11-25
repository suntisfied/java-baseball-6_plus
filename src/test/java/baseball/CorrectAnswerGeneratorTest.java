package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CorrectAnswerGeneratorTest {

    @ParameterizedTest
    @CsvSource({
            "3",
            "4",
    })
    public void generateCorrectAnswerInNumber(Integer gameSize) {
        var correctAnswerGenerator = new CorrectAnswerGenerator(gameSize, 1);
        var correctAnswer = correctAnswerGenerator.generateCorrectAnswer();
        System.out.println("Correct Answer: " + correctAnswer.answer());

        assertThat(correctAnswer.answer().length()).isEqualTo(gameSize);
    }

    @ParameterizedTest
    @CsvSource({
            "3",
            "4",
    })
    public void generateCorrectAnswerInString(Integer gameSize) {
        var correctAnswerGenerator = new CorrectAnswerGenerator(gameSize, 2);
        var correctAnswer = correctAnswerGenerator.generateCorrectAnswer();
        System.out.println("Correct Answer: " + correctAnswer.answer());

        assertThat(correctAnswer.answer().length()).isEqualTo(gameSize);
    }
}