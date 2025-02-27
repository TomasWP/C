@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitAccept(HelloParser.AcceptContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      System.out.print("Olá");
      for (int i = 0; i < ctx.ID().size(); i++) {
         System.out.print(" " + ctx.ID(i).getText()); // Aceder ao elemento i diretamente
      }
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
      System.out.print("Adeus");
      for (int i = 0; i < ctx.ID().size(); i++) {
         System.out.print(" " + ctx.ID(i).getText()); // Aceder ao elemento i diretamente
      }
      return visitChildren(ctx);
      //return res;
   }
}
