package zad2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NBPRate {

    public static String URI = "http://api.nbp.pl/api/exchangerates/tables/{table}/";

    public static String callNBP(){
        try{
            URL url = new URL(setUri(URI,"a"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            System.out.print(Service.debug ? "NBP Response: "+response+"\n" : "");
            return response.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "Something went wrong!";
    }

    public static String setUri(String uri, String table){
        String result = uri.replace("{table}", table);
        System.out.print(Service.debug ? "NBP URI: "+result+"\n" : "");
        return result;
    }

    public static String getCurrencyCodeFromResponse(String response){
        String result = "N/A";
        String[] list = response.split(",");
        String currencyCode= CountryCurrency.getCurrency(CountryCurrency.getCurrencyFromCountry(Service.getCountry()));

//        for(String l : list){
//            System.out.println(l);
//        }

        for(int i=0;i<list.length ;i++){
            if(list[i].contains(currencyCode)){
                result = list[i+1].replace("\"mid\":","").replace("\"","").replace("}","");
                System.out.print(Service.debug ? "NBP Currency Rate: "+result+"\n" : "");
                break;
            }
        }

        return result;
    }

    public static Double getRateAsDouble(String rate){
        return Double.parseDouble(rate);
    }

}
