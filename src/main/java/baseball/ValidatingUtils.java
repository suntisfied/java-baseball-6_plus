package baseball;

import static baseball.ConvertingUtils.convertStringToList;
import static baseball.ConvertingUtils.convertStringToSet;
import static baseball.GameRangeCharacter.INITIAL_CHARACTER;
import static baseball.GameRangeCharacter.LAST_CHARACTER;
import static baseball.GameRangeNumber.INITIAL_NUMBER;
import static baseball.GameRangeNumber.LAST_NUMBER;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ValidatingUtils {
    private final int CHARACTER_RANGE =
            (int) LAST_CHARACTER.getCharacter() - (int) INITIAL_CHARACTER.getCharacter() + 1;

    public final Predicate<String> isPositiveInteger = input -> {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    public final Predicate<String> isValidType = input ->
            input.equals(Buttons.GAME_TYPE_NUMBER.getButton()) || input.equals(Buttons.GAME_TYPE_ALPHABET.getButton());

    public final Predicate<String> isProperNumberSetting = input -> {
        int parsedInput = Integer.parseInt(input);
        return parsedInput > INITIAL_NUMBER.getNumber() && parsedInput <= LAST_NUMBER.getNumber();
    };

    public final Predicate<String> isProperAlphabetSetting = input -> {
        int parsedInput = Integer.parseInt(input);
        return parsedInput > 1 && parsedInput <= CHARACTER_RANGE;
    };

    public final Predicate<String> isProperNumberRange = input ->
            input.length() > 1 && input.length() <= LAST_NUMBER.getNumber();

    public final Predicate<String> isProperAlphabetRange = input ->
            input.length() > 1 && input.length() <= CHARACTER_RANGE;

    public final Predicate<String> isLowercaseAlphabet = input ->
            input.matches("[" + INITIAL_CHARACTER.getCharacter() + "-" + LAST_CHARACTER.getCharacter() + "]+");

    public final Predicate<String> isUniqueOnly = input ->
            convertStringToList(input).size() == convertStringToSet(input).size();

    public final BiPredicate<String, Integer> isPredefinedSize = (input, size) -> input.length() == size;

    public final Predicate<String> isValidEndingInput = input ->
            input.equals(Buttons.GAME_REPEAT.getButton()) || input.equals(Buttons.GAME_END.getButton());
}
