package lpfj.parser.parser_exceptions;

/**
 * Unknown keyword exception.
 */
public class UnknownKeyword extends UnknownToken {
    /**
     * Initialize exception.
     *
     * @param message Message.
     */
    public UnknownKeyword(String message) {
        super("UnknownKeyword", message);
    }
}
