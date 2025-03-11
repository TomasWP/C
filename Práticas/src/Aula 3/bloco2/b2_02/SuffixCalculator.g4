grammar SuffixCalculator;

// Define a regra principal do programa, que consiste em zero ou mais declarações (stat) seguidas pelo fim do arquivo (EOF).
program:
    stat* EOF
    ;

// Define uma declaração (stat), que é uma expressão opcional (expr) seguida por uma nova linha (NEWLINE).
stat:
    expr? NEWLINE
    ;

// Define uma expressão (expr), que pode ser uma das seguintes:
// 1. Duas expressões seguidas por um operador ('+', '-', '*', '/'), representando uma expressão sufixa (ExprSuffix).
// 2. Um número (Number), representando uma expressão numérica (ExprNumber).
expr:
    expr expr op=('+' | '-' | '*' | '/')    #ExprSuffix
    | Number                                #ExprNumber
    ;

// Define um número (Number), que pode ser um número inteiro ou um número de ponto fixo (com uma parte decimal opcional).
Number: [0-9]+('.'[0-9]+)?;

// Define uma nova linha (NEWLINE), que pode ser um caractere de retorno de carro opcional ('\r') seguido por um caractere de nova linha ('\n').
NEWLINE: '\r'? '\n';

// Define espaços em branco (WS), que são ignorados pelo analisador (skip).
WS: [ \t]+ -> skip;