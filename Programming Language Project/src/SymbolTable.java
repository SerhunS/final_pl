import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Object> variables;

    public SymbolTable() {
        this.variables = new HashMap<>();
    }

    public void put(String name, Object value) {
        variables.put(name, value);
    }

    public Object get(String name) {
        return variables.get(name);
    }

    public boolean contains(String name) {
        return variables.containsKey(name);
    }
}
