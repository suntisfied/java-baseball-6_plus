package baseball.staff;

import baseball.inputform.ConsoleInputForm;
import baseball.setting.Texts;
import baseball.validator.InitializingInputValidator;

public class GameInitializer extends ConsoleInputForm {
    private final InitializingInputValidator initializingInputValidator;

    public GameInitializer() {
        initializingInputValidator = new InitializingInputValidator();
    }

    public String setGameType() {
        return getInputUntilCorrect(
                () -> System.out.println(Texts.GAME_TYPE_INPUT.getText()),
                initializingInputValidator::checkGameType);
    }

    public int setGameSize(String gameType) {
        String userInput = getInputUntilCorrect(
                () -> System.out.println(Texts.GAME_SIZE_INPUT.getText()),
                gameSize -> initializingInputValidator.checkGameSize(gameSize, gameType));
        return Integer.parseInt(userInput);
    }
}
