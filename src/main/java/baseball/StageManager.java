package baseball;

public class StageManager {
    private final Player player;

    public StageManager() {
        player = new Player();
    }

    public void proceedMainGameUntilCorrectAnswer() {
        UserAnswer userAnswer;
        CorrectAnswer correctAnswer;
        do {
            userAnswer = player.speculateAnswer();
            correctAnswer = new CorrectAnswerGenerator(userAnswer).generateCorrectAnswer();
            System.out.println("User Input: " + userAnswer.answer());
            System.out.println("Correct Answer: " + correctAnswer.answer());

            var umpire = new Umpire(userAnswer, correctAnswer);
            int ball = umpire.callBall();
            int strike = umpire.callStrike();
            System.out.println("ball: " + ball);
            System.out.println("strike: " + strike);
        } while (!userAnswer.answer().equals(correctAnswer.answer()));
    }
}
