package baseball;

public class StageManager {
    private final GameInitializer gameInitializer;
    private final Player player;
    private final GameFinalizer gameFinalizer;

    public StageManager() {
        gameInitializer = new GameInitializer();
        player = new Player();
        gameFinalizer = new GameFinalizer();
    }

    public void repeatEntireGameUntilEnd() {
        do {
            proceedMainGameUntilCorrectAnswer();
        } while (gameFinalizer.isRepeating());
    }

    private void proceedMainGameUntilCorrectAnswer() {
        int gameType = gameInitializer.setGameType();
        int gameSize = gameInitializer.setGameSize();

        PlayerAnswer playerAnswer;
        var correctAnswer = new CorrectAnswerGenerator(gameType, gameSize).generateCorrectAnswer();
        do {
            System.out.println("Main Game Starts");
            playerAnswer = player.speculateAnswer(gameType, gameSize);
            System.out.println("User Input: " + playerAnswer.answer());
            System.out.println("Correct Answer: " + correctAnswer.answer());

            var umpire = new Umpire(playerAnswer, correctAnswer);
            int ball = umpire.callBall();
            int strike = umpire.callStrike();
            System.out.println("ball: " + ball);
            System.out.println("strike: " + strike);
        } while (!playerAnswer.answer().equals(correctAnswer.answer()));
    }
}
