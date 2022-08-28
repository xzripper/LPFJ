package lpfj.parser.lua;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import java.util.ArrayList;

/**
 * Lua file.
 */
public class LuaFile {
    private final String filePath;

    private final File fileObject;

    /**
     * Initialize new lua file.
     *
     * @param luaFile Lua file.
     */
    public LuaFile(String luaFile) throws FileNotFoundException {
        filePath = luaFile;

        fileObject = new File(luaFile);

        if(!fileObject.exists()) {
            throw new FileNotFoundException("Lua file not found.");
        }
    }

    /**
     * Read lines from Lua file.
     */
    public String[] readLines() throws FileNotFoundException {
        Scanner fileReader = new Scanner(fileObject);

        ArrayList<String> lines = new ArrayList<>();

        while(fileReader.hasNextLine()) {
            lines.add(fileReader.nextLine());
        }

        String[] linesArray = new String[lines.size()];

        for(int lineIndex=0; lineIndex < lines.size(); lineIndex++) {
            linesArray[lineIndex] = lines.get(lineIndex);
        }

        return linesArray;
    }

    /**
     * Read Lua content.
     */
    public String readContent() throws FileNotFoundException {
        return String.join("\n", readLines());
    }

    /**
     * Is Lua file exist.
     */
    public boolean luaFileExist() {
        return fileObject.exists();
    }

    /**
     * Get Lua source name.
     */
    public String luaFileName() {
        return fileObject.getName();
    }
}
