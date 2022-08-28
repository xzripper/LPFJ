package lpfj.parser;

import lpfj.parser.lua.LuaFile;

import lpfj.parser.parser_exceptions.UnknownType;

import lpfj.parser.parser_exceptions.etc.SyntaxError;

import lpfj.parser.parts.stacks.VariablesStack;
import lpfj.parser.parts.stacks.FunctionsCallStack;

import lpfj.parser.parts.ParsingResult;

import java.io.FileNotFoundException;

/**
 * Wrapper for Lua parser.
 */
public class LuaParser {
    /**
     * Parser version.
     */
    public static final float parserVersion = 1.0f;

    /**
     * Source.
     */
    public final LuaFile luaFile;

    /**
     * Local variables stuck.
     */
    public final VariablesStack localVariablesStack = new VariablesStack();

    /**
     * Local function call data stack.
     */
    public final FunctionsCallStack localFunctionCallDataStack = new FunctionsCallStack();

    /**
     * Initialize Lua parser.
     */
    public LuaParser(String _luaFile) throws FileNotFoundException {
        luaFile = new LuaFile(_luaFile);
    }

    /**
     * Get Lua parsing results.
     */
    public ParsingResult getParsingResult() throws FileNotFoundException, UnknownType, SyntaxError {
        ParsingResult parsingResult = new ParsingResult();

        Parser parser = new Parser(this);

        parser.registerVariableCreation();
        parser.registerFunctionsCalls();

        parsingResult.updateVariablesStack(localVariablesStack);
        parsingResult.updateFunctionsCallData(localFunctionCallDataStack);

        return parsingResult;
    }
}
