import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String input;
    private int position;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (position < input.length()) {
            char currentChar = input.charAt(position);
            if (Character.isWhitespace(currentChar)) {
                position++;
            } else if (Character.isDigit(currentChar)) {
                tokens.add(tokenizeNumber());
            } else if (Character.isLetter(currentChar)) {
                tokens.add(tokenizeIdentifier());
            } else {
                switch (currentChar) {
                    case '+': tokens.add(new Token(TokenType.PLUS, "+")); break;
                    case '-': tokens.add(new Token(TokenType.MINUS, "-")); break;
                    case '*': tokens.add(new Token(TokenType.MULTIPLY, "*")); break;
                    case '/': tokens.add(new Token(TokenType.DIVIDE, "/")); break;
                    case '=': tokens.add(new Token(TokenType.EQUALS, "=")); break;
                    case '(': tokens.add(new Token(TokenType.LEFT_PAREN, "(")); break;
                    case ')': tokens.add(new Token(TokenType.RIGHT_PAREN, ")")); break;
                    case '{': tokens.add(new Token(TokenType.LEFT_BRACE, "{")); break;
                    case '}': tokens.add(new Token(TokenType.RIGHT_BRACE, "}")); break;
                    case ':': tokens.add(new Token(TokenType.COLON, ":")); break;
                    case ';': tokens.add(new Token(TokenType.SEMICOLON, ";")); break;
                    case '<': tokens.add(new Token(TokenType.LESS_THAN, "<")); break;
                    default: throw new RuntimeException("Bilinmeyen karakter: " + currentChar);
                }
                position++;
            }
        }
        return tokens;
    }

    private Token tokenizeNumber() {
        int start = position;
        while (position < input.length() && Character.isDigit(input.charAt(position))) {
            position++;
        }
        return new Token(TokenType.NUMBER, input.substring(start, position));
    }

    private Token tokenizeIdentifier() {
        int start = position;
        while (position < input.length() && Character.isLetter(input.charAt(position))) {
            position++;
        }
        String value = input.substring(start, position);
        TokenType type = TokenLookup.getTokenType(value);
        return new Token(type, value);
    }
}
