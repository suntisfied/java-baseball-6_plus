package baseball;

public class Comparator implements Comparable<UserAnswer> {
    @Override
    public int compareTo(UserAnswer userAnswer) {
        int matchedCount = 0;

        var correctAnswer = new CorrectAnswer("123");

        for (int i = 0; i < 3; i++) {
            if (userAnswer.answer().charAt(i) == correctAnswer.answer().charAt(i)) {
                matchedCount++;
            }
        }
        return matchedCount;
    }
}
