import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CurrencyList extends AbstractTableModel {

    // String country, String currency, int quantity, String code, double currencyRate
    private final int COUNTRY = 0;
    private final int CURRENCY = 1;
    private final int QUIANTITY = 2;
    private final int CODE = 3;
    private final int CURRENCY_RATE = 4;
    private final int COLUMN_COUNT = 5;
    private final String[] NAZVY_SLOUPCU = {"Země","Měna","Množství","Kód","Kurz"};


    private List<Currencyx> currencyList;
    public CurrencyList() {
        currencyList = new ArrayList<>();
        currencyList = CurrencyReader.read();
    }

    public List<Currencyx> getCurrencyList() {
        return currencyList;
    }

    @Override
    public int getRowCount() {
        return currencyList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Currencyx currencyx = currencyList.get(rowIndex);

        switch (columnIndex) {
            case COUNTRY -> {
                return currencyx.getCountry();
            }
            case CURRENCY -> {
                return currencyx.getCurrency();
            }
            case QUIANTITY -> {
                return currencyx.getQuiantity();
            }
            case CODE -> {
                return currencyx.getCode();
            }
            case CURRENCY_RATE -> {
                return currencyx.getCurrencyRate();
            }
            default -> {
                throw new IllegalArgumentException("Incorrect table's column index");
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        return NAZVY_SLOUPCU[column];
    }
}
