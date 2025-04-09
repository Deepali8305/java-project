import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {


    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);
        exchangeRates.put("JPY", 110.0);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Available currencies: " + exchangeRates.keySet());
        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();


        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency selection. Please try again.");
            return;
        }


        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();


        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);


        System.out.printf("%.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {

        double baseToUSD = exchangeRates.get(baseCurrency);
        double targetToUSD = exchangeRates.get(targetCurrency);


        double amountInUSD = amount / baseToUSD;
        return amountInUSD * targetToUSD;
    }
}