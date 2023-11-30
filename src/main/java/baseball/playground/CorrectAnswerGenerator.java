package baseball.playground;

import static baseball.setting.GameRangeCharacter.INITIAL_CHARACTER;
import static baseball.setting.GameRangeCharacter.LAST_CHARACTER;
import static baseball.setting.GameRangeNumber.INITIAL_NUMBER;
import static baseball.setting.GameRangeNumber.LAST_NUMBER;

import baseball.setting.Buttons;
import baseball.valueholder.CorrectAnswer;
import baseball.valueholder.InitialSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CorrectAnswerGenerator {
    public final CorrectAnswer generateCorrectAnswer(InitialSettings initialSettings) {
        String gameType = initialSettings.gameType();
        if (gameType.equals(Buttons.GAME_TYPE_NUMBER.getButton())) {
            return generateNumberCorrectAnswer(initialSettings);
        }
        return generateStringCorrectAnswer(initialSettings);
    }

    private CorrectAnswer generateNumberCorrectAnswer(InitialSettings initialSettings) {
        int gameSize = initialSettings.gameSize();
        List<Integer> correctAnswerNumberDigits = new ArrayList<>(
                IntStream.rangeClosed(INITIAL_NUMBER.getNumber(), LAST_NUMBER.getNumber()).boxed().toList());
        Collections.shuffle(correctAnswerNumberDigits);

        String correctAnswerNumber = correctAnswerNumberDigits.stream()
                .limit(gameSize)
                .map(String::valueOf)
                .collect(Collectors.joining());

        return new CorrectAnswer(correctAnswerNumber);
    }

    private CorrectAnswer generateStringCorrectAnswer(InitialSettings initialSettings) {
        int gameSize = initialSettings.gameSize();
        List<Character> correctAnswerAlphabets =
                new ArrayList<>(IntStream.rangeClosed(INITIAL_CHARACTER.getCharacter(), LAST_CHARACTER.getCharacter())
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
