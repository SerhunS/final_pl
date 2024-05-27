public class VariableExpression implements Expression {
    private String identifier;

    public VariableExpression(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public int evaluate(SymbolTable symbolTable) {
        if (!symbolTable.contains(identifier)) {
            throw new RuntimeException("Değişken tanımlanmamış: " + identifier);
        }
        return (int) symbolTable.get(identifier);
    }
}
