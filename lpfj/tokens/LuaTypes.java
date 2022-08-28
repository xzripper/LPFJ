package lpfj.tokens;

import java.util.function.Consumer;
import java.util.function.Supplier;

import java.util.concurrent.Callable;

import java.util.HashMap;
import java.util.Map;

/**
 * Lua types.
 * @see <a href="https://www.lua.org/manual/2.2/section3_3.html">Lua Types.</a>
 */
public enum LuaTypes {
    NIL, NUMBER, STRING, FUNCTION, TABLE;

    /**
     * Get Lua type from java object.
     *
     * @param javaObject Java object.
     */
    public static LuaTypes getLuaTypeFromJavaObject(Object javaObject) {
        if(javaObject == null) {
            return NIL;
        } else if(javaObject instanceof Integer || javaObject instanceof Float || javaObject instanceof Double) {
            return NUMBER;
        } else if(javaObject instanceof String) {
            return STRING;
        } else if(javaObject instanceof Runnable || javaObject instanceof Consumer<?> || javaObject instanceof Supplier<?> || javaObject instanceof Callable<?>) {
            return FUNCTION;
        } else if(javaObject instanceof HashMap<?, ?> || javaObject instanceof Map<?, ?>) {
            return TABLE;
        } else {
            return null;
        }
    }

    /**
     * Is Java type exist in Lua.
     *
     * @param javaObject Java object.
     */
    public static boolean typeExist(Object javaObject) {
        return getLuaTypeFromJavaObject(javaObject) == null;
    }
}
