package baseball;

import java.util.Scanner;

public abstract class ConsoleInputForm {
    private final Scanner scanner;

    public ConsoleInputForm() {
        this.scanner = new Scanner(System.in);
    }

    @FunctionalInterface
    public interface Instruction {
        void show();
    }

    @FunctionalInterface
    public interface InputValidator {
        void validate(String input) throws IllegalArgumentException;
    }

    public String getInputUntilCorrect(Instruction instruction, InputValidator inputValidator) {
        instruction.show();
        String input = scanner.nextLine();

        try {
            inputValidator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputUntilCorrect(instruction, inputValidator);
        }

        return input;
    }
}
