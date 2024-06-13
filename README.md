  In this project, we developed a new Turkish programming language implemented in Java. The goal was to understand the fundamental components and working principles of a programming language. The project focused on language definition and syntax (BNF), lexical analysis, syntax analysis, support for Turkish characters and keywords, example programs, and modifying existing analysis tools to conform to the language's grammar rules. The project structure is organized under the MyLanguageProject directory, with the BNF rules defined. State diagrams of the language were also created to illustrate its flow and control structures.
        
        The BNF of the Language
program ::= statement*
statement ::= variableDeclaration | assignment | ifStatement | whileStatement | printStatement
variableDeclaration ::= 'değişken' identifier ':' type ';'
assignment ::= identifier '=' expression ';'
ifStatement ::= 'eğer' '(' expression ')' '{' block '}' ('değilse' '{' block '}')?
whileStatement ::= 'döngü' '(' expression ')' '{' block '}'
printStatement ::= 'yazdır' expression ';'
block ::= statement*
expression ::= term (('+' | '-') term)*
term ::= factor (('' | '/') factor)
factor ::= number | identifier | '(' expression ')'
The skeleton structure of our codes:

    MyLanguageProject/
├── src/
│   ├── Main.java
│   ├── Lexer.java
│   ├── Token.java
│   ├── TokenType.java
│   ├── Parser.java
│   ├── SymbolTable.java
│   ├── Statement.java
│   ├── Program.java
│   ├── VariableDeclaration.java
│   ├── Assignment.java
│   ├── IfStatement.java
│   ├── WhileStatement.java
│   ├── PrintStatement.java
│   ├── Expression.java
│   ├── BinaryExpression.java
│   ├── NumberExpression.java
│   ├── VariableExpression.java
│   ├── TokenLookup.java
├── grammar.bnf

    some examples
![doğru syntax](https://github.com/SerhunS/tr_programming_language/assets/124397473/6ee2341a-b4e3-4450-8bef-01e511378760)
![hatalı syntax](https://github.com/SerhunS/tr_programming_language/assets/124397473/192a8b12-1957-4123-a87c-f1be9e9e0f93)
![eğer](https://github.com/SerhunS/tr_programming_language/assets/124397473/85f7dfb6-9efb-444f-9618-d1aa2341dbc0)
![print](https://github.com/SerhunS/tr_programming_language/assets/124397473/3ee65fa7-d26c-482b-9f21-05681d7a4e3c)
![döngü](https://github.com/SerhunS/tr_programming_language/assets/124397473/7e67479b-8759-48ff-ad3d-b92ffb8d05e6)
![değilse içeren](https://github.com/SerhunS/tr_programming_language/assets/124397473/0957c19b-aaf4-46af-b076-6013caa167df)
![toplama](https://github.com/SerhunS/tr_programming_language/assets/124397473/f5680461-d94c-4cd7-bf7a-d820619b38d7)

