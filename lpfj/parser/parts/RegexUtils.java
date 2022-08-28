package lpfj.parser.parts;

import java.util.function.Function;

/**
 * Some regex utils.
 */
public class RegexUtils {
    /**
     * Generate regex.<br>
     * Regex that generated from this function example:
     *
     * Comma example.
     * ```
     * string = "1, 2, 3, 'X, Y'"
     * string.split(RegexUtils.SPLIT_BY_COMMA_RE) -> [1, 2, 3, 'X, Y']
     * ```
     */
    public static final Function<String, String> generateRegex = regex -> String.format("%s(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", regex);

    /**
     * Split by space regex.
     */
    public static final String SPLIT_BY_SPACE_RE = generateRegex.apply("\s");

    /**
     * Split by comma regex.
     */
    public static final String SPLIT_BY_COMMA_RE = generateRegex.apply(",");

    /**
     * Matches to digit regex.
     */
    public static final String MATCHES_TO_DIGIT_RE = "\\d+";

    /**
     * Is string pure. (Doesn't contains certain characters).
     */
    public static final String PURE_STRING_RE = "^[\\w&.\\-]+$";

    /**
     * Matches to function call.
     */
    public static final String MATCHES_TO_FUNCTION_CALL_RE = ".*\\(.*?\\)";

    /**
     * Find function arguments from function call.
     */
    public static final String FIND_FUNC_ARGS_RE = "\\(";

    /**
     * Is string starts with digit.
     */
    public static final String STARTS_WITH_DIGIT_RE = "^\\D.*";
}
