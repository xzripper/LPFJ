package lpfj.parser.parser_exceptions;

/**
 * Unknown token exception.
 */
public class UnknownToken extends Exception {
    /**
     * Initialize exception.
     *
     * @param exceptionType Exception type.
     * @param message Message.
     */
    public UnknownToken(String exceptionType, String message) {
        super(String.format("LuaParser.%s: %s", exceptionType, message));
    }

    /**
     * Initialize exception without exception type.
     *
     * @param message Message.
     */
    public UnknownToken(String message) {
        super(String.format("LuaParser.UnknownToken: %s", message));
    }
}
