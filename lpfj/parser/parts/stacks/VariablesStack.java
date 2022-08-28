package lpfj.parser.parts.stacks;

import lpfj.parser.parts.generators.Variable;

import java.util.ArrayList;

/**
 * Variables stack.
 */
public class VariablesStack {
    private final ArrayList<Variable> stack = new ArrayList<>();

    /**
     * Append variable to stack.
     */
    public void addVariable(Variable var) {
        stack.add(var);
    }

    /**
     * Get variable from stack.
     */
    public Object getVariable(String varName) {
        for(Variable variable : stack) {
            if(variable.name.equals(varName)) {
                return variable.value;
            }
        }

        return null;
    }

    /**
     * Get variable stack.
     */
    public ArrayList<Variable> getStack() {
        return stack;
    }
}
