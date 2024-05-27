import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int position;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.position = 0;
    }

    public Program parseProgram() {
        List<Statement> statements = new ArrayList<>();
        while (position < tokens.size()) {
            Statement statement = parseStatement();
            if (statement != null) {
                statements.add(statement);
            }
        }
        return new Program(statements);
    }

    private Statement parseStatement() {
        Token currentToken = tokens.get(position);
        switch (currentToken.getType()) {
            case KEYWORD:
                return parseKeywordStatement(currentToken.getValue());
            case IDENTIFIER:
                return parseAssignment();
            default:
                return null;
        }
    }

    private Statement parseKeywordStatement(String keyword) {
        switch (keyword) {
            case "değişken":
                return parseVariableDeclaration();
            case "eğer":
                return parseIfStatement();
            case "döngü":
                return parseWhileStatement();
            case "yazdır":
                return parsePrintStatement();
            default:
                return null;
        }
    }

    private VariableDeclaration parseVariableDeclaration() {
        consume(TokenType.KEYWORD); // 'değişken'
        String identifier = consume(TokenType.IDENTIFIER).getValue();
        consume(TokenType.COLON);
        String type = consume(TokenType.IDENTIFIER).getValue();
        consume(TokenType.SEMICOLON);
        return new VariableDeclaration(identifier, type);
    }

    private Assignment parseAssignment() {
        String identifier = consume(TokenType.IDENTIFIER).getValue();
        consume(TokenType.EQUALS);
        Expression expression = parseExpression();
        consume(TokenType.SEMICOLON);
        return new Assignment(identifier, expression);
    }

    private IfStatement parseIfStatement() {
        consume(TokenType.KEYWORD); // 'eğer'
        consume(TokenType.LEFT_PAREN);
        Expression condition = parseExpression();
        consume(TokenType.RIGHT_PAREN);
        consume(TokenType.LEFT_BRACE);
        List<Statement> ifStatements = parseBlock();
        consume(TokenType.RIGHT_BRACE);
        List<Statement> elseStatements = new ArrayList<>();
        if (match(TokenType.KEYWORD, "değilse")) {
            consume(TokenType.KEYWORD); // 'değilse'
            consume(TokenType.LEFT_BRACE);
            elseStatements = parseBlock();
            consume(TokenType.RIGHT_BRACE);
        }
        return new IfStatement(condition, ifStatements, elseStatements);
    }

    private WhileStatement parseWhileStatement() {
        consume(TokenType.KEYWORD); // 'döngü'
        consume(TokenType.LEFT_PAREN);
        Expression condition = parseExpression();
        consume(TokenType.RIGHT_PAREN);
        consume(TokenType.LEFT_BRACE);
        List<Statement> statements = parseBlock();
        consume(TokenType.RIGHT_BRACE);
        return new WhileStatement(condition, statements);
    }

    private PrintStatement parsePrintStatement() {
        consume(TokenType.KEYWORD); // 'yazdır'
        Expression expression = parseExpression();
        consume(TokenType.SEMICOLON);
        return new PrintStatement(expression);
    }

    private List<Statement> parseBlock() {
        List<Statement> statements = new ArrayList<>();
        while (position < tokens.size() && tokens.get(position).getType() != TokenType.RIGHT_BRACE) {
            statements.add(parseStatement());
        }
        return statements;
    }

    private Expression parseExpression() {
        Expression expression = parseTerm();
        while (match(TokenType.PLUS) || match(TokenType.MINUS) || match(TokenType.LESS_THAN)) {
            Token operator = consume();
            Expression right = parseTerm();
            expression = new BinaryExpression(expression, operator.getValue(), right);
        }
        return expression;
    }

    private Expression parseTerm() {
        Expression expression = parseFactor();
        while (match(TokenType.MULTIPLY) || match(TokenType.DIVIDE)) {
            Token operator = consume();
            Expression right = parseFactor();
            expression = new BinaryExpression(expression, operator.getValue(), right);
        }
        return expression;
    }

    private Expression parseFactor() {
        if (match(TokenType.NUMBER)) {
            return new NumberExpression(Integer.parseInt(consume().getValue()));
        } else if (match(TokenType.IDENTIFIER)) {
            return new VariableExpression(consume().getValue());
        } else if (match(TokenType.LEFT_PAREN)) {
            consume(TokenType.LEFT_PAREN);
            Expression expression = parseExpression();
            consume(TokenType.RIGHT_PAREN);
            return expression;
        } else {
            throw new RuntimeException("Beklenmeyen token: " + tokens.get(position));
        }
    }

    private Token consume(TokenType expectedType) {
        Token currentToken = tokens.get(position);
        if (currentToken.getType() != expectedType) {
            throw new RuntimeException("Beklenen token: " + expectedType + " ama bulundu: " + currentToken.getType());
        }
        position++;
        return currentToken;
    }

    private Token consume() {
        return tokens.get(position++);
    }

    private boolean match(TokenType type) {
        return position < tokens.size() && tokens.get(position).getType() == type;
    }

    private boolean match(TokenType type, String value) {
        return position < tokens.size() && tokens.get(position).getType() == type && tokens.get(position).getValue().equals(value);
    }
}
