public class BinaryExpression implements Expression {
    private Expression left;
    private String operator;
    private Expression right;

    public BinaryExpression(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public int evaluate(SymbolTable symbolTable) {
        int leftValue = left.evaluate(symbolTable);
        int rightValue = right.evaluate(symbolTable);
        switch (operator) {
            case "+": return leftValue + rightValue;
            case "-": return leftValue - rightValue;
            case "*": return leftValue * rightValue;
            case "/": return leftValue / rightValue;
            case "<": return leftValue < rightValue ? 1 : 0;
            default: throw new RuntimeException("Bilinmeyen operatör: " + operator);
        }
    }
}
