import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();

        System.out.println("Lütfen programınızı girin (sonlandırmak için boş satır bırakın):");

        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }
            inputBuilder.append(line).append("\n");
        }

        String input = inputBuilder.toString();

        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer.tokenize());

        Program program = parser.parseProgram();
        SymbolTable symbolTable = new SymbolTable();
        program.execute(symbolTable);
    }
}
