package baseball;

public class StageManager {
    private final GameInitializer gameInitializer;
    private final Player player;
    private final GameFinalizer gameFinalizer;
    private final TextFormatter textFormatter;

    public StageManager() {
        gameInitializer = new GameInitializer();
        player = new Player();
        gameFinalizer = new GameFinalizer();
        textFormatter = new TextFormatter();
    }

    public void repeatEntireGameUntilEnd() {
        do {
            proceedMainGameUntilCorrectAnswer();
        } while (gameFinalizer.isRepeating());
    }

    private void proceedMainGameUntilCorrectAnswer() {
        int gameType = gameInitializer.setGameType();
        int gameSize = gameInitializer.setGameSize();
        System.out.println();

        PlayerAnswer playerAnswer;
        var correctAnswer = new CorrectAnswerGenerator(gameType, gameSize).generateCorrectAnswer();
        System.out.println(textFormatter.formatGameStart(gameType));
        do {
            playerAnswer = player.speculateAnswer(gameType, gameSize);
            System.out.println("User Input: " + playerAnswer.answer());
            System.out.println("Correct Answer: " + correctAnswer.answer());

            var umpire = new Umpire(playerAnswer, correctAnswer);
            int ball = umpire.callBall();
            int strike = umpire.callStrike();
            System.out.println(textFormatter.formatBallStrike(ball, strike));
        } while (!playerAnswer.answer().equals(correctAnswer.answer()));
        System.out.println(textFormatter.formatGameEnd(gameType, gameSize));
    }
}
