package baseball.inputform;

import baseball.giveup.GiveUpException;
import baseball.util.ConsoleManager;

public abstract class ConsoleInputForm {
    @FunctionalInterface
    public interface Instruction {
        void show();
    }

    @FunctionalInterface
    public interface InputInspector {
        void inspectInput(String input) throws IllegalArgumentException, GiveUpException;
    }

    protected String getInputUntilCorrect(Instruction instruction, InputInspector inputInspector) {
        instruction.show();
        String input = ConsoleManager.getConsoleInput();

        try {
            inputInspector.inspectInput(input);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getInputUntilCorrect(instruction, inputInspector);

        } catch (GiveUpException giveUpException) {
            System.out.println(giveUpException.getMessage());
        }

        return input;
    }
}
