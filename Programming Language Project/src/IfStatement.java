import java.util.List;

public class IfStatement implements Statement {
    private Expression condition;
    private List<Statement> ifStatements;
    private List<Statement> elseStatements;

    public IfStatement(Expression condition, List<Statement> ifStatements, List<Statement> elseStatements) {
        this.condition = condition;
        this.ifStatements = ifStatements;
        this.elseStatements = elseStatements;
    }

    @Override
    public void execute(SymbolTable symbolTable) {
        if (condition.evaluate(symbolTable) != 0) {
            for (Statement statement : ifStatements) {
                statement.execute(symbolTable);
            }
        } else {
            for (Statement statement : elseStatements) {
                statement.execute(symbolTable);
            }
        }
    }
}
