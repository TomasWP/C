@SuppressWarnings("CheckReturnValue")
public class Execute extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      Double res = visit(ctx.expr());
      System.out.println("Resultado: "+res);
      return res;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDoule(ctx.Integer().getText());
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double left = visit(ctx.expr(0));
      Double right = visit(ctx.expr(1));
      String op = ctx.op.getText();
      System.out.println(left+" "+op+" "+right);

      switch(op){
         case "+":
            return  left+right;
            break;
         case "-":
            return  left-right;
            break;
         case "*":
            return left*right;
            break;
         case "/":
            return  left/right;
            break;
         default:
            throw new IllegalArgumentException("Operador desconhecido: "+op);
      } 
   }
}