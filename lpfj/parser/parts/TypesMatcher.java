package lpfj.parser.parts;

/**
 * Types matcher.<br>
 * Allows you convert for example string to integer if string matches to digit.
 */
public class TypesMatcher {
    /**
     * String matches to string. (With brackets).
     *
     * @param string String.
     * @param supportsSingleQuotes Supports single quotes?
     */
    public static boolean matchesToString(String string, boolean supportsSingleQuotes) {
        return (supportsSingleQuotes) ? (string.startsWith("\"") && string.endsWith("\"")) || (string.startsWith("'") || string.endsWith("'")) : (string.startsWith("\"") && string.endsWith("\""));
    }

    /**
     * String matches to digit.
     *
     * @param string String.
     */
    public static boolean matchesToDigit(String string) {
        return string.matches(RegexUtils.MATCHES_TO_DIGIT_RE);
    }

    /**
     * String matches to boolean.
     *
     * @param string String.
     */
    public static boolean matchesToBoolean(String string) {
        return string.equals("true");
    }
}
