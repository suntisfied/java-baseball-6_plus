package baseball.util;

import static baseball.setting.GameRangeCharacter.INITIAL_CHARACTER;
import static baseball.setting.GameRangeCharacter.LAST_CHARACTER;
import static baseball.setting.GameRangeNumber.INITIAL_NUMBER;
import static baseball.setting.GameRangeNumber.LAST_NUMBER;
import static baseball.util.ConvertingUtils.convertStringToList;
import static baseball.util.ConvertingUtils.convertStringToSet;

import baseball.setting.Buttons;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ValidatingUtils {
    private static final int CHARACTER_RANGE =
            (int) LAST_CHARACTER.getCharacter() - (int) INITIAL_CHARACTER.getCharacter() + 1;

    public static final Predicate<String> isPositiveInteger = input -> {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    public static final Predicate<String> isValidType = input ->
            input.equals(Buttons.GAME_TYPE_NUMBER.getButton()) || input.equals(Buttons.GAME_TYPE_ALPHABET.getButton());

    public static final Predicate<String> isProperNumberSetting = input -> {
        int parsedInput = Integer.parseInt(input);
        return parsedInput > INITIAL_NUMBER.getNumber() && parsedInput <= LAST_NUMBER.getNumber();
    };

    public static final Predicate<String> isProperAlphabetSetting = input -> {
        int parsedInput = Integer.parseInt(input);
        return parsedInput > 1 && parsedInput <= CHARACTER_RANGE;
    };

    public static final Predicate<String> isProperNumberRange = input ->
            input.length() > 1 && input.length() <= LAST_NUMBER.getNumber();

    public static final Predicate<String> isProperAlphabetRange = input ->
            input.length() > 1 && input.length() <= CHARACTER_RANGE;

    public static final Predicate<String> isLowercaseAlphabet = input ->
            input.matches("[" + INITIAL_CHARACTER.getCharacter() + "-" + LAST_CHARACTER.getCharacter() + "]+");

    public static final Predicate<String> isUniqueOnly = input ->
            convertStringToList(input).size() == convertStringToSet(input).size();

    public static final BiPredicate<String, Integer> isPredefinedSize = (input, size) -> input.length() == size;

    public static final Predicate<String> isValidEndingInput = input ->
            input.equals(Buttons.GAME_REPEAT.getButton()) || input.equals(Buttons.GAME_END.getButton());
}
