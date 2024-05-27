public class VariableDeclaration implements Statement {
    private String identifier;
    private String type;

    public VariableDeclaration(String identifier, String type) {
        this.identifier = identifier;
        this.type = type;
    }

    @Override
    public void execute(SymbolTable symbolTable) {
        symbolTable.put(identifier, 0); // Varsayılan değer olarak 0
    }
}
