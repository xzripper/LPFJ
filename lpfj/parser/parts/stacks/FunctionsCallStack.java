package lpfj.parser.parts.stacks;

import lpfj.parser.parts.generators.FunctionCall;

import java.util.ArrayList;

/**
 * Functions stack.
 */
public class FunctionsCallStack {
    private ArrayList<FunctionCall> stack = new ArrayList<>();

    /**
     * Append function call data to stack.
     *
     * @param funcCallData Function call data.
     */
    public void appendCallData(FunctionCall funcCallData) {
        stack.add(funcCallData);
    }

    /**
     * Get function call data from stack.
     *
     * @param functionName Function name.
     */
    public ArrayList<Object> getFunction(String functionName) {
        for(FunctionCall funcCallData : stack) {
            if(funcCallData.name.equals(functionName)) {
                ArrayList<Object> funcCallDataArray = new ArrayList<>();

                funcCallDataArray.add(funcCallData.name);
                funcCallDataArray.add(funcCallData.arguments);

                return funcCallDataArray;
            }
        }

        return null;
    }

    /**
     * Get function call data stack.
     */
    public ArrayList<FunctionCall> getStack() {
        return stack;
    }
}
