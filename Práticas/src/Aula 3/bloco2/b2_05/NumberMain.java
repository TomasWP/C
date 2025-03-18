import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class NumberMain {
    public static void main(String[] args) throws IOException {
        // Lê o arquivo numbers.txt
        CharStream input = CharStreams.fromFileName("bloco1/numbers.txt");

        // Cria o lexer e o parser
        NumbersLexer lexer = new NumbersLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NumbersParser parser = new NumbersParser(tokens);

        // Gera a árvore de análise
        ParseTree tree = parser.file();

        // Cria o listener e percorre a árvore
        NumberMapping listener = new NumberMapping();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        // Exibe o array associativo
        System.out.println("Array Associativo: " + listener.numbers());
    }
}