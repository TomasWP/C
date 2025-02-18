import java.util.Scanner;
import java.util.Stack;


public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Double> stack = new Stack<>();
        if(!sc.hasNextDouble()){
            System.err.println("Operando em falta!");
            sc.close();
            return;
        }
        while(sc.hasNext()){
            String token = sc.next();
            double result, num1;
            try{
                num1 = Double.parseDouble(token);
                stack.push(num1);
            }catch(Exception innerException){
                try{
                    result = calcular(stack.get(stack.size() - 1),stack.get(stack.size() - 2), token);
                    stack.pop();
                    stack.pop();
                    stack.push(result);
                }catch(Exception e){
                    System.err.println("Erro no calculo!");
                }
            }
        }
        sc.close();
        System.out.println("Stack: " + stack);
    }

    private static double calcular(double num1, double num2, String operador) {
        switch (operador) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": 
                if (num2 == 0) {
                    System.err.println("Erro: Divisão por zero.");
                    return Double.NaN;
                }
                return num1 / num2;
            default:
                System.err.println("Erro: Operador inválido.");
                return Double.NaN;
        }
    }
}
