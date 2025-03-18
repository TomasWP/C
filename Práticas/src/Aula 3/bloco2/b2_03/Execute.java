@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Integer> {

   @Override
   public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx); // Visita todas as declarações no programa
   }

   @Override
   public Integer visitStat(CalculatorParser.StatContext ctx) {
      Integer res = visit(ctx.expr()); // Calcula o resultado da expressão
      System.out.println("Resultado: " + res); // Exibe o resultado
      return res;
   }

   @Override
   public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Integer left = visit(ctx.expr(0)); // Visita o lado esquerdo da expressão
      Integer right = visit(ctx.expr(1)); // Visita o lado direito da expressão
      if (ctx.op.getText().equals("+")) {
         return left + right; // Soma
      } else {
         return left - right; // Subtração
      }
   }

   @Override
   public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr()); // Avalia a expressão dentro dos parênteses
   }

   @Override
   public Integer visitExprUnary(CalculatorParser.ExprUnaryContext ctx) {
      Integer value = visit(ctx.expr()); // Visita a expressão
      if (ctx.op.getText().equals("-")) {
         return -value; // Negativo
      } else {
         return value; // Positivo
      }
   }

   @Override
   public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.Integer().getText()); // Converte o número para inteiro
   }

   @Override
   public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Integer left = visit(ctx.expr(0)); // Visita o lado esquerdo da expressão
      Integer right = visit(ctx.expr(1)); // Visita o lado direito da expressão
      switch (ctx.op.getText()) {
         case "*":
            return left * right; // Multiplicação
         case "/":
            if (right == 0) {
               throw new ArithmeticException("ERRO! Divisão por zero!"); // Tratamento de erro
            }
            return left / right; // Divisão
         case "%":
            return left % right; // Módulo
         default:
            throw new IllegalArgumentException("Operador desconhecido: " + ctx.op.getText());
      }
   }
}
