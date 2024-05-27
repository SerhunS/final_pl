public class PrintStatement implements Statement {
    private Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute(SymbolTable symbolTable) {
        int value = expression.evaluate(symbolTable);
        System.out.println(value);
    }
}
