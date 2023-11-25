package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Judge {
    private final List<String> convertedUserAnswer;
    private final List<String> convertedCorrectAnswer;

    public Judge(UserAnswer userAnswer, CorrectAnswer correctAnswer) {
        this.convertedUserAnswer = convertToList(userAnswer.answer());
        this.convertedCorrectAnswer = convertToList(correctAnswer.answer());
    }

    public int judgeBall() {
        return (int) convertedUserAnswer.stream()
                .filter(convertedCorrectAnswer::contains)
                .count() - judgeStrike();
    }

    public int judgeStrike() {
        return (int) IntStream.range(0, convertedCorrectAnswer.size())
                .filter(location -> convertedUserAnswer.get(location).equals(convertedCorrectAnswer.get(location)))
                .count();
    }

    private static List<String> convertToList(String answer) {
        return Arrays.asList(answer.split(""));
    }
}
