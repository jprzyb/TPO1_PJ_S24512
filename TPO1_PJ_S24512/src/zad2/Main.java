/**
 *
 *  @author Przybylski Jakub S24512
 *
 */

package zad2;


public class Main {
  public static void main(String[] args) {
    Service s = new Service("Georgia");
    String weatherJson = s.getWeather("Budapest");
//    Double rate1 = s.getRateFor("USD");
    Double rate2 = s.getNBPRate();
    // ...
    // część uruchamiająca GUI
      new MainFrame();
  }
}
