grammar Numbers;

file:
    line* EOF;

line:
    KEY '-' VALUE NEWLINE;

KEY:
    [0-9]+;

VALUE:
    [a-zA-Z]+;

NEWLINE:
    '\r'? '\n';

WS:
    [\t]+ ->skip;