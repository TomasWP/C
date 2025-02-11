import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        
        if(!scanner.hasNext()){
            System.err.println("Primeiro número inválido!");
            return;
        }
        double num1 = scanner.nextDouble();

        if(!scanner.hasNext()){
            System.err.println("Operador ausente!");
            return;
        }
        String operador = scanner.next();

        if(!scanner.hasNextDouble()){
            System.err.println("Segundo número inválido!");
            return;
        }
        double num2 = scanner.nextDouble();

        double resultado = 0;

        switch(operador){  
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 == 0){
                    System.err.println("Erro: Denominador inválido.");
                } else {
                    resultado = num1 / num2;
                }
                break;
            default:
                System.err.println("Erro: Operador inválido.");
        }
        System.out.println("Resultado: "+ resultado);
    }
}