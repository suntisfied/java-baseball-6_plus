package baseball;

public class StageManager {
    private final GameInitializer gameInitializer;
    private final Player player;
    private final GiveUp giveUp;
    private final GameFinalizer gameFinalizer;
    private final TextFormatter textFormatter;

    public StageManager() {
        gameInitializer = new GameInitializer();
        player = new Player();
        giveUp = new GiveUp();
        gameFinalizer = new GameFinalizer();
        textFormatter = new TextFormatter();
    }

    public void repeatEntireGameUntilEnd() {
        do {
            proceedMainGameUntilCorrectAnswer();
        } while (gameFinalizer.isRepeating());
    }

    private void proceedMainGameUntilCorrectAnswer() {
        var initialSettings = initializeMainGame();
        proceedMainGame(initialSettings);
    }

    private InitialSettings initializeMainGame() {
        int gameType = gameInitializer.setGameType();
        int gameSize = gameInitializer.setGameSize(gameType);
        System.out.println();
        return new InitialSettings(gameType, gameSize);
    }

    private void proceedMainGame(InitialSettings initialSettings) {
        PlayerAnswer playerAnswer;
        CorrectAnswer correctAnswer = new CorrectAnswerGenerator(initialSettings).generateCorrectAnswer();
        Umpire umpire;

        System.out.println(textFormatter.formatGameStart(initialSettings));
        GameRecorder gameRecorder = new GameRecorder();
        do {
            playerAnswer = player.speculateAnswer(initialSettings);
            if (giveUp.isGivingUp(playerAnswer)) {
                break;
            }

            System.out.println("User Input: " + playerAnswer.answer());
            System.out.println("Correct Answer: " + correctAnswer.answer());
            gameRecorder.recordPitching(playerAnswer);

            umpire = new Umpire(playerAnswer, correctAnswer);
            var pitchingResult = umpire.umpire();

            System.out.println(textFormatter.formatPitchingResult(pitchingResult));
        } while (!umpire.isCompleteAnswer());
        System.out.print(textFormatter.formatGameEnd(playerAnswer, initialSettings));
        System.out.println(new GameRecorderFormatter(gameRecorder, correctAnswer).combineAnalyses());
    }
}
