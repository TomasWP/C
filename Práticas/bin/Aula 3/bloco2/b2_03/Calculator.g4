grammar Calculator; // Define o nome da gramática como "Calculator"

// Define a regra principal do programa
program:
    stat* EOF // O programa consiste em zero ou mais declarações (stat) seguidas pelo fim do arquivo (EOF)
    ;

// Define uma declaração (stat)
stat:
    expr? NEWLINE // Uma declaração pode conter uma expressão opcional (expr?) seguida por uma nova linha (NEWLINE)
    ;

// Define uma expressão (expr)
expr:
    op=('+' | '-') expr                 #ExprUnary       // Operador unário ('+' ou '-') seguido por uma expressão
    | expr op=('*' | '/' | '%') expr    #ExprMultDivMod  // Duas expressões separadas por um operador ('*', '/', '%')
    | expr op=('+' | '-') expr          #ExprAddSub      // Duas expressões separadas por um operador ('+' ou '-')
    | Integer                           #ExprInteger     // Um número inteiro
    | '('expr')'                        #ExprParent      // Uma expressão entre parênteses
    ;

// Define um número inteiro (Integer)
Integer: [0-9]+; // Um ou mais dígitos (0-9). Implementado como inteiros longos

// Define uma nova linha (NEWLINE)
NEWLINE: '\r'? '\n'; // Pode ser '\n' (Unix/Linux) ou '\r\n' (Windows)

// Define espaços em branco (WS)
WS: [\t]+ -> skip; // Tabulações são ignoradas pelo analisador

// Define comentários (COMMENT)
COMMENT: '#' .*? '\n' -> skip; // Comentários começam com '#' e terminam na nova linha. São ignorados pelo analisador