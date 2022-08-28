package lpfj.tokens;

/**
 * Lua keywords.
 * @see <a href="https://www.lua.org/manual/5.1/manual.html">Lua Lexical Conventions.</a>
 */
public enum LuaKeywords {
    AND, BREAK, DO, ELSE, ELSEIF,
    END, FALSE, FOR, FUNCTION, IF,
    IN, LOCAL, NIL, NOT, OR,
    REPEAT, RETURN, THEN, TRUE, UNTIL, WHILE;

    /**
     * Is Lua keyword exist?
     *
     * @param keyword Lua keyword.
     */
    public static boolean isKeywordExist(String keyword) {
        for(LuaKeywords luaKeyword : LuaKeywords.values()) {
            if(keyword.equals(luaKeyword.toString().toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Key keyword from string as LuaKeywords if exists.
     *
     * @param keyword Lua keyword.
     */
    public static LuaKeywords getKeywordIfExist(String keyword) {
        if(!isKeywordExist(keyword)) {
            return null;
        } else {
            for(LuaKeywords luaKeyword : LuaKeywords.values()) {
                if(keyword.equals(luaKeyword.toString().toLowerCase())) {
                    return luaKeyword;
                }
            }

            return null;
        }
    }
}
