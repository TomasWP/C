@SuppressWarnings("CheckReturnValue")
public class Execute extends PrefixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(PrefixCalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(PrefixCalculatorParser.StatContext ctx) {
      Double res = visit(ctx.expr());
      System.out.println("Resultado: "+res);
      return res;
   }

   @Override public Double visitExprSuffix(PrefixCalculatorParser.ExprSuffixContext ctx) {
      Double left = visit(ctx.expr(0));
      Double right = visit(ctx.expr(1));
      String op = ctx.op.getText();
      System.out.println(left+" "+op+" "+right);

      switch(op){
         case "+":
            return  left+right;
         case "-":
            return  left-right;
         case "*":
            return left*right;
         case "/":
            return  left/right;
         default:
            throw new IllegalArgumentException("Operador desconhecido: "+op);
      } 
   }

   @Override public Double visitExprNumber(PrefixCalculatorParser.ExprNumberContext ctx) {
      return Double.valueOf(ctx.Number().getText());
   }
}
