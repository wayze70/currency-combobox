public class Currencyx {

    private String country, currency, code;

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public int getQuiantity() {
        return quiantity;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    private int quiantity;
    private double currencyRate;

    public Currencyx(String country, String currency, int quantity, String code, double currencyRate) {

        this.country = country;
        this.currency = currency;
        this.quiantity = quantity;
        this.code = code;
        this.currencyRate = currencyRate;
    }

    @Override
    public String toString() {
        return country + " || " +  code;
    }
}
