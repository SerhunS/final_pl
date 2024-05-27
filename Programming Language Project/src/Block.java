import java.util.ArrayList;
import java.util.List;

public class Block implements Statement {
    private List<Statement> statements = new ArrayList<>();

    public void addStatement(Statement statement) {
        statements.add(statement);
    }

    @Override
    public void execute(SymbolTable symbolTable) {
        for (Statement statement : statements) {
            statement.execute(symbolTable);
        }
    }
}
