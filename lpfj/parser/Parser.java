package lpfj.parser;

import lpfj.parser.parts.RegexUtils;
import lpfj.parser.parts.TypesMatcher;

import lpfj.parser.parser_exceptions.UnknownType;

import lpfj.parser.parser_exceptions.etc.SyntaxError;

import lpfj.parser.parts.generators.Variable;
import lpfj.parser.parts.generators.FunctionCall;

import lpfj.tokens.LuaKeywords;

import java.io.FileNotFoundException;

/**
 * Parser.<br>
 * Parser Lua file.
 */
public class Parser {
    private final LuaParser luaParser;

    /**
     * Initialize new parser.
     *
     * @param _lp Lua Parser.
     */
    public Parser(LuaParser _lp) {
        luaParser = _lp;
    }

    /**
     * Register variable creation.
     */
    public void registerVariableCreation() throws FileNotFoundException, UnknownType, SyntaxError {
        for(String line : luaParser.luaFile.readLines()) {
            String[] dividedLine = line.split(RegexUtils.SPLIT_BY_SPACE_RE);

            String identifier = dividedLine[0];

            if(LuaKeywords.getKeywordIfExist(identifier) == LuaKeywords.LOCAL) {
                String variableName = dividedLine[1];

                if(!variableName.matches(RegexUtils.STARTS_WITH_DIGIT_RE) || !variableName.matches(RegexUtils.PURE_STRING_RE)) {
                    throw new SyntaxError(String.format("Invalid variable name in '%s' in file '%s'.", variableName, luaParser.luaFile.luaFileName()));
                }

                String variableValue_notype = dividedLine[3];

                if(variableValue_notype.endsWith(";")) {
                    variableValue_notype = variableValue_notype.substring(0, variableValue_notype.length() - 1);
                }

                Object variableValue;

                if(TypesMatcher.matchesToString(variableValue_notype, true)) {
                    variableValue = variableValue_notype.substring(1).substring(0, variableValue_notype.length() - 2);
                } else if(TypesMatcher.matchesToDigit(variableValue_notype)) {
                    variableValue = Integer.parseInt(variableValue_notype);
                } else if(TypesMatcher.matchesToBoolean(variableValue_notype)) {
                    variableValue = variableValue_notype.equals("true");
                } else {
                    if(luaParser.localVariablesStack.getVariable(variableValue_notype) != null) {
                        variableValue = luaParser.localVariablesStack.getVariable(variableValue_notype);
                    } else {
                        throw new UnknownType(String.format("An unknown type was set in variable '%s' in file '%s'.", variableName, luaParser.luaFile.luaFileName()));
                    }
                }

                Variable newVar = new Variable(variableName, variableValue);

                luaParser.localVariablesStack.addVariable(newVar);
            }
        }
    }

    /**
     * Register function calling.
     */
    public void registerFunctionsCalls() throws FileNotFoundException, UnknownType {
        for(String line : luaParser.luaFile.readLines()) {
            if(line.matches(RegexUtils.MATCHES_TO_FUNCTION_CALL_RE)) {
                String[] dividedLine = line.split(RegexUtils.FIND_FUNC_ARGS_RE);

                String functionName = dividedLine[0];

                String[] functionArguments_notype = dividedLine[1].substring(0, dividedLine[1].length() - 1).split(RegexUtils.SPLIT_BY_COMMA_RE);

                if(functionArguments_notype.length <= 1 && functionArguments_notype[0].isBlank()) {
                    FunctionCall newFunc = new FunctionCall(functionName, new Object[] {});

                    luaParser.localFunctionCallDataStack.appendCallData(newFunc);
                } else {
                    Object[] functionArguments = new Object[functionArguments_notype.length];

                    for(int argIndex=0; argIndex < functionArguments_notype.length; argIndex++) {
                        String _funcArg = functionArguments_notype[argIndex];

                        if(TypesMatcher.matchesToString(_funcArg, true)) {
                            functionArguments[argIndex] = _funcArg.substring(1).substring(0, _funcArg.length() - 2);
                        } else if(TypesMatcher.matchesToDigit(_funcArg)) {
                            functionArguments[argIndex] = Integer.parseInt(_funcArg);
                        } else if(TypesMatcher.matchesToBoolean(_funcArg)) {
                            functionArguments[argIndex] = _funcArg.equals("true");
                        } else {
                            if(luaParser.localVariablesStack.getVariable(_funcArg) != null) {
                                functionArguments[argIndex] = luaParser.localVariablesStack.getVariable(_funcArg);
                            } else {
                                throw new UnknownType(String.format("An unknown argument type was set in '%s' in file '%s'.", functionName, luaParser.luaFile.luaFileName()));
                            }
                        }
                    }

                    FunctionCall newFunc = new FunctionCall(functionName, functionArguments);

                    luaParser.localFunctionCallDataStack.appendCallData(newFunc);
                }
            }
        }
    }
}
