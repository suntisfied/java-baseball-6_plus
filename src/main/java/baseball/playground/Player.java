package baseball.playground;

import baseball.giveup.GiveUp;
import baseball.inputform.ConsoleInputForm;
import baseball.textformat.TextFormatter;
import baseball.validator.PlayerInputValidator;
import baseball.valueholder.InitialSettings;
import baseball.valueholder.PlayerAnswer;

public class Player extends ConsoleInputForm {
    public PlayerAnswer speculateAnswer(InitialSettings initialSettings) {
        String userInput = getInputUntilCorrect(
                () -> System.out.print(new TextFormatter().formatPlayerInput(initialSettings)),
                input -> {
                    new GiveUp().checkGiveUp(input);
                    new PlayerInputValidator().checkPlayerInputValidity(input, initialSettings);
                }
        );
        return new PlayerAnswer(userInput);
    }
}
