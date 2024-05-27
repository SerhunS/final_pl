public class Assignment implements Statement {
    private String identifier;
    private Expression expression;

    public Assignment(String identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public void execute(SymbolTable symbolTable) {
        int value = expression.evaluate(symbolTable);
        symbolTable.put(identifier, value);
    }
}
