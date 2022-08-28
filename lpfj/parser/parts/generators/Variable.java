package lpfj.parser.parts.generators;

/**
 * Variable template generator.
 */
public class Variable {
    /**
     * Variable name.
     */
    public final String name;

    /**
     * Variable value.
     */
    public final Object value;

    /**
     * Initialize new variable.
     *
     * @param _name Variable name.
     * @param _value Variable value.
     */
    public Variable(String _name, Object _value) {
        name = _name;
        value = _value;
    }
}
