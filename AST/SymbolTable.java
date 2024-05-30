package AST;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private static Map<String, Object> table = new HashMap<>();

    // Assign a variable with a value
    public static void assignVariable(String name, Object value) {
        table.put(name, value);
    }

    // Retrieve a variable's value
    public static Object getVariable(String name) {
        if (table.containsKey(name)) {
            return table.get(name);
        }
        throw new RuntimeException("Variable " + name + " not defined.");
    }

    // Check if a variable is already defined
    public static boolean isVariableDefined(String name) {
        return table.containsKey(name);
    }
}

