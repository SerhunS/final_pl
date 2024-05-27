import java.util.List;

public class Program {
    private List<Statement> statements;

    public Program(List<Statement> statements) {
        this.statements = statements;
    }

    public void execute(SymbolTable symbolTable) {
        for (Statement statement : statements) {
            statement.execute(symbolTable);
        }
    }
}
