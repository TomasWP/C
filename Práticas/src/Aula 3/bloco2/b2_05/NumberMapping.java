import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")

public class NumberMapping extends NumbersBaseListener {

   Map<String, Integer> numbers = new HashMap<>();

   @Override public void enterFile(NumbersParser.FileContext ctx) {
   }

   @Override public void exitFile(NumbersParser.FileContext ctx) {
   }

   @Override public void enterLine(NumbersParser.LineContext ctx) {
   }

   @Override public void exitLine(NumbersParser.LineContext ctx) {
      // Extrai KEY e VALUE do contexto
      int key = Integer.parseInt(ctx.KEY().getText()); // Converte KEY para int
      String value = ctx.VALUE().getText(); // Obtém VALUE como String
      
      // Adiciona o par KEY-VALUE ao array associativo
      numbers.put(value, key);
   }

}
