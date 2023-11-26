package baseball;

public class StageManager {
    private final Player player;

    public StageManager() {
        player = new Player();
    }

    public void proceedMainGameUntilCorrectAnswer() {
        var gameInitializer = new GameInitializer();
        int gameSize = gameInitializer.setGameSize();
        int gameType = gameInitializer.setGameType();

        UserAnswer userAnswer;
        var correctAnswer = new CorrectAnswerGenerator(gameType, gameSize).generateCorrectAnswer();
        do {
            System.out.println("Main Game Starts");
            userAnswer = player.speculateAnswer(gameSize, gameType);
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
