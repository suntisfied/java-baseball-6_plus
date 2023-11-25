package baseball;

import java.util.Random;

public class CorrectAnswerGenerator {
    private final Random random;
    private final int length;

    public CorrectAnswerGenerator(UserAnswer userAnswer) {
        random = new Random();
        length = userAnswer.answer().length();
    }

    public CorrectAnswer generateNumberCorrectAnswer() {
        int DigitLength = (int) Math.pow(10, length - 1);

        int correctAnswerNumber = random.nextInt(9 * DigitLength) + DigitLength;
        return new CorrectAnswer(String.valueOf(correctAnswerNumber));
    }
}
