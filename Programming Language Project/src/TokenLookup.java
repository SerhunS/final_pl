import java.util.HashMap;
import java.util.Map;

public class TokenLookup {
    private static final Map<String, TokenType> lookupTable = new HashMap<>();

    static {
        lookupTable.put("değişken", TokenType.KEYWORD);
        lookupTable.put("eğer", TokenType.KEYWORD);
        lookupTable.put("değilse", TokenType.KEYWORD);
        lookupTable.put("döngü", TokenType.KEYWORD);
        lookupTable.put("yazdır", TokenType.KEYWORD);
    }

    public static TokenType getTokenType(String keyword) {
        return lookupTable.getOrDefault(keyword, TokenType.IDENTIFIER);
    }

    public static void printLookupTable() {
        for (Map.Entry<String, TokenType> entry : lookupTable.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
