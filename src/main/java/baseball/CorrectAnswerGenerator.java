package baseball;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CorrectAnswerGenerator {
    private final int gameSize;
    private final int gameType;
    private final Random random;

    public CorrectAnswerGenerator(int gameSize, int gameType) {
        this.gameSize = gameSize;
        this.gameType = gameType;
        random = new Random();
    }

    public final CorrectAnswer generateCorrectAnswer() {
        if (gameType == 1) {
            return generateNumberCorrectAnswer();
        }
        return generateStringCorrectAnswer();
    }

    private CorrectAnswer generateNumberCorrectAnswer() {
        int DigitLength = (int) Math.pow(10, gameSize - 1);

        int correctAnswerNumber = random.nextInt(9 * DigitLength) + DigitLength;
        return new CorrectAnswer(String.valueOf(correctAnswerNumber));
    }

    private CorrectAnswer generateStringCorrectAnswer() {
        String correctAnswerString = IntStream.range(0, gameSize)
                .mapToObj(location -> (char) ('a' + random.nextInt(26)))
                .map(String::valueOf)
                .collect(Collectors.joining());
        return new CorrectAnswer(correctAnswerString);
    }
}
