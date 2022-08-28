<img src="lpfj\media\banner.png"><br>
# LPFJ - Lua Parser For Java.
This library allows wrap Lua files, for example creating API that powered by Java.<br>
Or allows you to bind some functions to Lua, and call them in Lua.<br>
<br>
Library using example (Embedding Java function to Lua).

**Wrapper.java**
```java
import lpfj.parser.LuaParser;
import lpfj.parser.parts.ParsingResult;
import lpfj.parser.parts.generators.FunctionCall;
import lpfj.parser.parser_exceptions.UnknownType;
import lpfj.parser.parser_exceptions.etc.SyntaxError;

import java.io.FileNotFoundException;

public class Main {
  public static void main(String[] args) throws FileNotFoundException, UnknownType, SyntaxError {
    String luaBindedFunctionName = "getParserVersion";

    LuaParser luaParser = new LuaParser('Main.lua');

    ParsingResult parseResult = luaParser.getParsingResult();

    for(FunctionCall callData : parseResult.getCallsDataStack()) {
      if(callData.name.equals(luaBindedFunctionName)) {
        printParserVersion();
      }
    }

  public static void printParserVersion() {
    System.out.println(LuaParser.parserVersion);
    System.out.println("");
  }
}
```

**Main.lua**
```lua
print("Gonna print parser version lower...\n")

getParserVersion()

print("Printed!")
```

After starting **Wrapper.java**, we can see this.
```
Gonna print parser version lower...

1.0

Printed!
```

### Install.
With Git:<br>
```
git clone https://github.com/xzripper/LPFJ/
```

After that move folder "LPFJ\lpfj" to main project directory.<br>
Done!<br>

Without Git:<br>
<a href="https://github.com/xzripper/LPFJ/archive/refs/heads/main.zip">Download </a> repository.
Un-zip "LPFJ\lpfj" from zip to main project directory.<br>
Done!

### I have questions?
You can ask them on Repo Issues.

<hr>
<p align="center"><b>^-^</b></p>
