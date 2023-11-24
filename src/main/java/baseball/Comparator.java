package baseball;

import java.util.List;

public class Comparator implements Comparable<UserAnswer> {
    @Override
    public int compareTo(UserAnswer userAnswer) {
        int matchedCount = 0;

        var userAnswerList = convertToList(userAnswer.answer());

        var correctAnswerList = convertToList(new CorrectAnswer("123").answer());

        for (int i = 0; i < 3; i++) {
            if (userAnswerList.get(i).equals(correctAnswerList.get(i))) {
                matchedCount++;
            }
        }
        return matchedCount;
    }

    public List<String> convertToList(String answer) {
        return answer.chars()
                .mapToObj(character -> String.valueOf((char) character))
                .toList();
    }
}
