grammar Calculator;
program:
    stat* EOF
    ;
stat:
    expr? NEWLINE       // pode ou nao existir expressao
    ;
expr:
    op=('+' | '-') expr                 #ExprUnary
    | expr op=('*' | '/' | '%') expr    #ExprMultDivMod
    | expr op=('+' | '-') expr          #ExprAddSub
    | Integer                           #ExprInteger
    | '('expr')'                        #ExprParent
    ;
Integer:    [0-9]+; // implement with long integers
NEWLINE: '\r'? '\n';
WS: [\t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;