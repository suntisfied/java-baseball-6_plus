package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Comparator {
    private final List<String> convertedUserAnswer;
    private final List<String> convertedCorrectAnswer;

    public Comparator(UserAnswer userAnswer, CorrectAnswer correctAnswer) {
        this.convertedUserAnswer = convertToList(userAnswer.answer());
        this.convertedCorrectAnswer = convertToList(correctAnswer.answer());
    }

    public int calculateBall() {
        return (int) convertedUserAnswer.stream()
                .filter(convertedCorrectAnswer::contains)
                .count() - calculateStrike();
    }

    public int calculateStrike() {
        return (int) IntStream.range(0, convertedCorrectAnswer.size())
                .filter(location -> convertedUserAnswer.get(location).equals(convertedCorrectAnswer.get(location)))
                .count();
    }

    public List<String> convertToList(String answer) {
        return answer.chars()
                .mapToObj(character -> String.valueOf((char) character))
                .toList();
    }
}
