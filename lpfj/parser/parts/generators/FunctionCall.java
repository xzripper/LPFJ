package lpfj.parser.parts.generators;

/**
 * Function call template generator.
 */
public class FunctionCall {
    /**
     * Function name.
     */
    public final String name;

    /**
     * Function arguments.
     */
    public final Object[] arguments;

    /**
     * Initialize new function call data.
     *
     * @param _name Function name.
     * @param _arguments Function arguments.
     */
    public FunctionCall(String _name, Object[] _arguments) {
        name = _name;
        arguments = _arguments;
    }
}
