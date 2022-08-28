package lpfj.parser.parser_exceptions;

/**
 * Unknown type exception.
 */
public class UnknownType extends UnknownToken {
    /**
     * Initialize exception.
     *
     * @param message Message.
     */
    public UnknownType(String message) {
        super("UnknownType", message);
    }
}
