grammar Hello;              // Define a grammar called Hello
accept: greetings | bye;    
greetings: 'hello' ID+;      // math keyword helllo folowed by an indentifier
bye: 'bye' ID+;
ID: [a-zA-Z]+;                 // match lower-case indentifiers
WS: [ \t\r\n]+ -> skip;      // skip spaces, tabs, newlines, \r (Windows)