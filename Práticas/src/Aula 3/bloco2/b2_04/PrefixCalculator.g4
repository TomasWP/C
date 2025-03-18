grammar PrefixCalculator;

program:
    stat* EOF       // Define a regra principal do programa, que consiste em zero ou mais declarações (stat) seguidas pelo fim do arquivo (EOF).
    ;

stat:
    expr? NEWLINE   // Define uma declaração (stat), que é uma expressão opcional (expr) seguida por uma nova linha (NEWLINE).
    ;

expr:                                                           // Define uma expressão (expr), que pode ser uma das seguintes:
    op=('+' | '-' | '*' | '/') expr expr    #ExprSuffix         // 1. Duas expressões seguidas por um operador ('+', '-', '*', '/'), representando uma expressão sufixa (ExprSuffix).
    | Number                                #ExprNumber         // 2. Um número (Number), representando uma expressão numérica (ExprNumber).
    ;

Number: [0-9]+('.'[0-9]+)?;                                     // Define um número (Number), que pode ser um número inteiro ou um número de ponto fixo (com uma parte decimal opcional).

NEWLINE: '\r'? '\n';                                            // Define uma nova linha (NEWLINE), que pode ser um caractere de retorno de carro opcional ('\r') seguido por um caractere de nova linha ('\n').

WS: [ \t]+ -> skip;                                             // Define espaços em branco (WS), que são ignorados pelo analisador (skip).