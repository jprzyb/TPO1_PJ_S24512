/**
 *
 *  @author Przybylski Jakub S24512
 *
 */

package test;

import zad2.Service;

public class Main {
    public static void main(String[] args) {
        Service s = new Service("");
        String weatherJson = s.getWeather("");
        Double rate1 = s.getRateFor("");
        Double rate2 = s.getNBPRate();
        // ...
        // część uruchamiająca GUI
    }
}
