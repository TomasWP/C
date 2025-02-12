import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex2b {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> variaveis = new HashMap<>();

        while(scanner.hasNextLine()){
            double result = calculate(scanner, variaveis);
        }
    }

    public static double calculate(Scanner scanner, HashMap variaveis){

        if(scanner.nextLine().contains("=")){
            String next = scanner.next();
            while(scanner.hasNext()){
                if(isnumeric(next)){
                    if(!scanner.hasNextDouble()){
                        System.err.println("Erro: Número em falta!");
                    }else{
                        double num1 = scanner.nextDouble();
                        variaveis.put(var,num1);
                    }
                }else if(isoperand){
                    switch (next) {
                        case "+":
                            
                            break;
                        case "-":
                            break;
                        case "/":
                            break;
                        case "*":
                            break;
                        default:
                            break;
                    }
                }else if(isstring)
            }
            System.out.println(var+" = "+variaveis.get(var));
        }else{

        }
        return 0.0;
    }
}
