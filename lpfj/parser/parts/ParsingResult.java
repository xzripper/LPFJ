package lpfj.parser.parts;

import lpfj.parser.parts.generators.Variable;
import lpfj.parser.parts.generators.FunctionCall;

import lpfj.parser.parts.stacks.VariablesStack;
import lpfj.parser.parts.stacks.FunctionsCallStack;

import java.util.ArrayList;

/**
 * Parsing result.
 */
public class ParsingResult {
    private VariablesStack variables = new VariablesStack();
    private FunctionsCallStack callsData = new FunctionsCallStack();

    /**
     * Update variables stack.
     *
     * @param varsStack Variables stack.
     */
    public void updateVariablesStack(VariablesStack varsStack) {
        variables = varsStack;
    }

    /**
     * Update functions call data.
     *
     * @param _callsData Call's data.
     */
    public void updateFunctionsCallData(FunctionsCallStack _callsData) {
        callsData = _callsData;
    }

    /**
     * Get variables stack.
     */
    public ArrayList<Variable> getVariablesStack() {
        return variables.getStack();
    }

    /**
     * Get functions call data.
      */
    public ArrayList<FunctionCall> getCallsDataStack() {
        return callsData.getStack();
    }
}
