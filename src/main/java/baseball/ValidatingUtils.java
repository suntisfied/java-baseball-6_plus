package baseball;

import static baseball.ConvertingUtils.convertStringToList;
import static baseball.ConvertingUtils.convertStringToSet;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ValidatingUtils {
    public final Predicate<String> isPositiveInteger = input -> {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    public final Predicate<String> isValidType = input -> input.equals("1") || input.equals("2");
    public final Predicate<String> isValidEndingInput = input -> input.equals("1") || input.equals("2");

    public final Predicate<String> isLowercaseAlphabet = input -> input.matches("[a-z]+");

    public final Predicate<String> isProperNumberRange = input -> input.length() > 1 && input.length() < 10;
    public final Predicate<String> isProperAlphabetRange = input -> input.length() > 1 && input.length() <= 26;

    public final Predicate<String> isUniqueOnly = input ->
            convertStringToList(input).size() == convertStringToSet(input).size();

    public final BiPredicate<String, Integer> isPredefinedSize = (input, size) -> input.length() == size;
}
