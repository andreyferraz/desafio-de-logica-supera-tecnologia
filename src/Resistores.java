import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Resistores {

    private static final Map<Integer, String> colorMap = new HashMap<>();
    static {
        colorMap.put(0, "preto");
        colorMap.put(1, "marrom");
        colorMap.put(2, "vermelho");
        colorMap.put(3, "laranja");
        colorMap.put(4, "amarelo");
        colorMap.put(5, "verde");
        colorMap.put(6, "azul");
        colorMap.put(7, "violeta");
        colorMap.put(8, "cinza");
        colorMap.put(9, "branco");
    }

    public static String resistorCode(String input) {
        // Remover a palavra "ohms" e extrair o valor
        String valueString = input.replace(" ohms", "").toLowerCase();
        double value;
        int multiplier;

        // Verificar se o valor é em kilo ou mega ohms
        if (valueString.contains("k")) {
            value = Double.parseDouble(valueString.replace("k", ""));
            multiplier = 3; // 1k = 10^3
        } else if (valueString.contains("m")) {
            value = Double.parseDouble(valueString.replace("m", ""));
            multiplier = 6; // 1M = 10^6
        } else {
            value = Double.parseDouble(valueString);
            multiplier = 0; // Ohms padrão
        }

        // Converter para valor inteiro
        int resistorValue = (int) (value * Math.pow(10, multiplier));

        // Quebrar o resistorValue em dígitos
        String digits = Integer.toString(resistorValue);

        if (digits.length() < 2) {
            return "Entrada inválida! Forneça um valor válido. Ex: 47 ohms, 4.7k ohms.";
        }

        int firstDigit = Character.getNumericValue(digits.charAt(0));
        int secondDigit = Character.getNumericValue(digits.charAt(1));
        int powerOfTen = digits.length() - 2; // Quantos zeros virão após os dois primeiros dígitos

        // Construir a sequência de cores
        StringBuilder colorSequence = new StringBuilder();
        colorSequence.append(colorMap.get(firstDigit)).append(" ");
        colorSequence.append(colorMap.get(secondDigit)).append(" ");
        colorSequence.append(colorMap.get(powerOfTen)).append(" ");
        colorSequence.append("dourado"); // Sempre tolerância 5%

        return colorSequence.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira o valor do resistor
        System.out.print("Digite o valor do resistor (ex: 47 ohms, 4.7k ohms, 1M ohms): ");
        String inputValue = scanner.nextLine(); // Lê a entrada do usuário

        // Chama o método resistorCode e exibe a sequência de cores
        String result = resistorCode(inputValue);
        System.out.println(result);

        scanner.close(); // Fecha o scanner após o uso
    }
}
