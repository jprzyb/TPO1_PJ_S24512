package zad2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;

public class ExchangeRate {

    static final String URI = "http://api.exchangerate.host/live?access_key={apiKey}&source={source}&currencies={currencies}";
    static final String APIKEY = "12c87e7c70bde9c1a72df1b53f6d933b";

    public static String callExcghangeRate(String currency){

        try{
            String source = CountryCurrency.getCurrency(CountryCurrency.getCurrencyFromCountry(Service.getCountry()));
            URL url = new URL(setUri(URI,APIKEY, source, currency));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            System.out.print(Service.debug ? "ExchangeRate Response: "+response+"\n" : "");
            return response.toString();/*.
                    replace(",", ",\n\t").
                    replace("{","{\n").
                    replace("}","\n}").
                    replace(":{",":\n{").
                    replace(":",":\n{")
                    ;*/
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "Something went wrong!";
    }
    public static String setUri(String uri, String apiKey, String source, String currency){
        String result = uri.replace("{source}", source).replace("{currencies}", currency).replace("{apiKey}", apiKey).trim();
        System.out.print(Service.debug ? "ExchangeRate URI: "+result+"\n" : "");
        return result;
    }

    public static String getExchangeRateFromResponse(String response, String currency) {

        String[] s = response.split(",");
        String result="";

        for(String e : s){
            if(e.contains(currency)){
                result = e.replace("\"quotes\":{\"", "").replace("}","").replace(currency,"").replace("\"","").
                replace(":","").replace(CountryCurrency.getCurrency(CountryCurrency.getCurrencyFromCountry(Service.getCountry())), "");
            }
        }
        System.out.print(Service.debug ? "ExchangeRate result: "+result+"\n" : "");

        return result;
    }

    public static Double getExchangeRateAsDouble(String ExchangeRate){
        return Double.parseDouble(ExchangeRate);
    }
}

