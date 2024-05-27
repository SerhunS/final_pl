import java.util.List;

public class WhileStatement implements Statement {
    private Expression condition;
    private List<Statement> statements;

    public WhileStatement(Expression condition, List<Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public void execute(SymbolTable symbolTable) {
        while (condition.evaluate(symbolTable) != 0) {
            for (Statement statement : statements) {
                statement.execute(symbolTable);
            }
        }
    }
}
