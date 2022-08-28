package lpfj.parser.parser_exceptions.etc;

import lpfj.parser.parser_exceptions.UnknownToken;

/**
 * Syntax error.
 */
public class SyntaxError extends UnknownToken {
    /**
     * Initialize exception.
     *
     * @param message Message.
     */
    public SyntaxError(String message) {
        super("SyntaxError", message);
    }
}
