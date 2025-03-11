@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Integer> {

   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
      Integer res = visit(ctx.expr());
      System.out.println("Resultado: "+res);
      return visitChildren(ctx);
      //return res;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Integer visitExprUnary(CalculatorParser.ExprUnaryContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInteger(ctx.Integer().getText());
   }

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      //return res;
   }
}
