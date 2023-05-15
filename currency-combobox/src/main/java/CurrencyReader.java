import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyReader {
    public static List<Currencyx> read() {
        List<Currencyx> seznam = new ArrayList<>();
        try {
        String path = "src/main/java/data/denni_kurz.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;

            int i = 0;
            while ((line = reader.readLine()) != null) {
                i++;
                if (i > 2) {
                    String[] values = line.split("\\|");
                    String country = values[0];
                    String currency = values[1];
                    int quantity = Integer.parseInt(values[2]);
                    String code = values[3];
                    Double currencyRate = Double.parseDouble(values[4].replace(",","."));
                    seznam.add(new Currencyx(country, currency, quantity, code, currencyRate));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return seznam;
    }
}
