package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CorrectAnswerGenerator {
    private final int gameType;
    private final int gameSize;

    public CorrectAnswerGenerator(InitialSettings initialSettings) {
        gameType = initialSettings.gameType();
        gameSize = initialSettings.gameSize();
    }

    public final CorrectAnswer generateCorrectAnswer() {
        if (gameType == 1) {
            return generateNumberCorrectAnswer();
        }
        return generateStringCorrectAnswer();
    }

    private CorrectAnswer generateNumberCorrectAnswer() {
        List<Integer> correctAnswerNumberDigits = new ArrayList<>(IntStream.range(1, 10).boxed().toList());
        Collections.shuffle(correctAnswerNumberDigits);

        String correctAnswerNumber = correctAnswerNumberDigits.stream()
                .limit(gameSize)
                .map(String::valueOf)
                .collect(Collectors.joining());

        return new CorrectAnswer(correctAnswerNumber);
    }

    private CorrectAnswer generateStringCorrectAnswer() {
        List<Character> correctAnswerAlphabets =
                new ArrayList<>(IntStream.rangeClosed('a', 'z')
                        .mapToObj(numberValue -> (char) numberValue)
                        .toList());
        Collections.shuffle(correctAnswerAlphabets);

        String correctAnswerString =
                correctAnswerAlphabets.stream()
                        .limit(gameSize)
                        .map(String::valueOf)
                        .collect(Collectors.joining());

        return new CorrectAnswer(correctAnswerString);
    }
}
