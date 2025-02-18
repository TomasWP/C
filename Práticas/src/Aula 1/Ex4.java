import java.util.Scanner;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Ex4 {
    public static void main(String[] args) {
        String filePath = "bloco1/numbers.txt";
        Map<String, Integer> numbers = new HashMap<>();
        StringBuilder output = new StringBuilder();

        // Ler o ficheiro
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    try {
                        int number = Integer.parseInt(parts[0].trim());
                        numbers.put(parts[1].trim(), number);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao converter número: " + parts[0]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
            return; 
        }
        
        String value;
        String[] values;

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                value = sc.next();
                if (value.contains("-")) {
                    values = value.split("-");
                } else {
                    values = new String[]{value};
                }
                
                for (String val : values) {
                    if (numbers.containsKey(val)) {
                        output.append(numbers.get(val)).append(" ");
                    } else {
                        output.append(val).append(" ");
                    }
                }
            }
        }

        System.out.println(output.toString().trim());
    }
}