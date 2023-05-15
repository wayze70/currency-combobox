import javax.swing.*;
import java.awt.*;

public class View {
    private JPanel mainPanel;
    private JComboBox<Currencyx> combobox;
    private JTable table;
    private JTextField num, resultTextField;
    private JButton jButton;
    private CurrencyList currencyList;

    public View() {
        mainPanel = new JPanel();
        currencyList = new CurrencyList();
        combobox = new JComboBox(currencyList.getCurrencyList().toArray());
        num = new JTextField();
        mainPanel.add(combobox);
        mainPanel.add(textField());
        mainPanel.add(tableCurrency());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }

    private JScrollPane tableCurrency() {
        table = new JTable(currencyList);
        return new JScrollPane(table);
    }

    private JPanel textField() {
        JPanel jPanel = new JPanel(new GridLayout());
        num = new JTextField();
        resultTextField = new JTextField();
        resultTextField.setEditable(false);
        jPanel.add(num);
        jButton = new JButton("Konverze");
        jButton.addActionListener(e -> {
            Currencyx selectedCurrency = (Currencyx) combobox.getSelectedItem();
            try {
                resultTextField.setText(String.format("%.4f",
                        selectedCurrency.getCurrencyRate() * Double.parseDouble(num.getText()) / selectedCurrency.getQuiantity()).replace(".", ",") + " Kč");
            } catch (NumberFormatException error) {
                resultTextField.setText("");
            }
        });
        jPanel.add(jButton);
        jPanel.add(resultTextField);
        return jPanel;
    }

    public void init() {
        JFrame mainWindow = new JFrame("Syřiště Michal - syrismi1");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setContentPane(mainPanel);
        mainWindow.setVisible(true);
        mainWindow.pack();
    }
}
