import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {

        // Cria um mapa para armazenar variáveis e seus valores
        Map<String, Double> variaveis = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite uma operação ou 'exit' para encerrar:");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Remove todos os espaços em branco antes de tentar processar
            input = input.replaceAll("\\s+", "");

            // Verifica se a entrada é uma atribuição de valor a uma variável (exemplo: n = 10)
            if (input.contains("=")) {
                // Divide a linha de entrada na variável e valor
                String[] partes = input.split("=");
                if (partes.length == 2) {
                    String variavel = partes[0].trim();
                    String valor = partes[1].trim();

                    try {
                        double valorNumerico = Double.parseDouble(valor);
                        variaveis.put(variavel, valorNumerico);  // Armazena a variável e seu valor
                        System.out.println("Variável " + variavel + " atribuída com sucesso!");
                    } catch (NumberFormatException e) {
                        System.err.println("Erro: Valor inválido para a variável.");
                    }
                } else {
                    System.err.println("Erro: Formato de atribuição inválido.");
                }
            } else {
                // Se a entrada não for uma atribuição, é uma operação matemática
                String[] tokens = input.split("(?=[-+*/])|(?<=[-+*/])");

                if (tokens.length == 3) {
                    try {
                        // Tenta obter os valores das variáveis, se existirem
                        double num1 = 0;
                        // Verifica se o primeiro token é uma variável ou número
                        try {
                            num1 = Double.parseDouble(tokens[0]);
                        } catch (NumberFormatException e) {
                            // Se não for um número, tenta buscar no mapa
                            if (variaveis.containsKey(tokens[0])) {
                                num1 = variaveis.get(tokens[0]);
                            } else {
                                System.err.println("Erro: A variável '" + tokens[0] + "' não foi definida.");
                                continue;
                            }
                        }

                        String operador = tokens[1];

                        double num2 = 0;
                        // Verifica se o segundo token é uma variável ou número
                        try {
                            num2 = Double.parseDouble(tokens[2]);
                        } catch (NumberFormatException e) {
                            // Se não for um número, tenta buscar no mapa
                            if (variaveis.containsKey(tokens[2])) {
                                num2 = variaveis.get(tokens[2]);
                            } else {
                                System.err.println("Erro: A variável '" + tokens[2] + "' não foi definida.");
                                continue;
                            }
                        }

                        double resultado = 0;

                        // Realiza a operação
                        switch (operador) {
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
                                if (num2 == 0) {
                                    System.err.println("Erro: Denominador inválido.");
                                    continue;
                                } else {
                                    resultado = num1 / num2;
                                }
                                break;
                            default:
                                System.err.println("Erro: Operador inválido.");
                                continue;
                        }

                        System.out.println("Resultado: " + resultado);
                    } catch (Exception e) {
                        System.err.println("Erro: Entrada inválida.");
                    }
                } else {
                    System.err.println("Erro: Formato de operação inválido.");
                }
            }
        }

        scanner.close();
    }
}
