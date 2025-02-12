import java.util.*;

public class Ex2c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> variables = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            String[] tokens;
            if (line.isEmpty()) continue;

            if (line.contains(" ")){
                tokens = line.split(" ");
            } else {
                // Se for apenas um número ou variável, não divide mais
                tokens = new String[] {line};
            }

            if (tokens.length >= 3 && tokens[1].equals("=")) {
                // Atribuição de variável (ex: n = 10)
                try {
                    double value = evaluateExpression(Arrays.copyOfRange(tokens, 2, tokens.length), variables);
                    variables.put(tokens[0], value);
                } catch (NumberFormatException e) {
                    System.err.println("Erro: Valor inválido para variável.");
                }
            } else {
                // Expressão matemática
                try {
                    double resultado = evaluateExpression(tokens, variables);
                    System.out.println("Resultado: " + resultado);
                } catch (NumberFormatException e) {
                    System.err.println("Erro: Operação inválida.");
                }
            }
        }
        scanner.close();
    }

    private static double evaluateExpression(String[] tokens, Map<String, Double> variables) throws NumberFormatException {
        double result = parseOperand(tokens[0], variables);
        for (int i = 1; i < tokens.length; i += 2) {
            if (i + 1 >= tokens.length) {
                System.err.println("Erro: Expressão inválida.");
                return Double.NaN;
            }
            String operador = tokens[i];
            double num = parseOperand(tokens[i + 1], variables);
            result = calcular(result, num, operador);
        }
        return result;
    }

    private static double parseOperand(String token, Map<String, Double> variables) throws NumberFormatException {
        if (variables.containsKey(token)) {
            return variables.get(token);
        } else {
            return Double.parseDouble(token);
        }
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