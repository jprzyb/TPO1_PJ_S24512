package zad2;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountryCurrency {

    public static String getCurrencyFromCountry(String country){
        String fileName = "Currencies.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(country)) {
                    System.out.print(Service.debug ? "Currency line for " + country + ": " + line + "\n" : "");
                    return line;
                }
            }
        } catch (Exception e) {
            System.err.println("File read exception: " + e.getMessage());
        }
        return "N/A";
    }
    public static String getCurrency(String line){
        String result = line.trim().substring(0,3);
        System.out.print(Service.debug ? "Currency in \"" + line + "\": " + result + "\n" : "");
        return result;
    }
}
