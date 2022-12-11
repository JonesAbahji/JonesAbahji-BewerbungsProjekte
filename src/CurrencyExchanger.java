import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;

public class CurrencyExchanger implements ActionListener {

    JRadioButton dollarButton;
    JRadioButton yenButton;
    JRadioButton poundButton;
    JRadioButton canadianDollarButton;

    JPanel BoxLayout = new JPanel();

    Scanner scanner = new Scanner(System.in);
    double amount;
    JTextField amountEuro = new JTextField();
    JLabel convertedResult = new JLabel();

    CurrencyExchanger() {
        Font fontTextfield = new Font("SansSerif", Font.BOLD, 20);
        ImageIcon logo = new ImageIcon("Logo.png");

        JFrame frame = new JFrame();
        frame.setTitle("Currency Exchanger by Jones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 350);
        frame.setResizable(false);
        frame.setIconImage(logo.getImage());

        JLabel textLabel = new JLabel();
        textLabel.setText("Please choose the Currency you would like to convert to");
        textLabel.setFont(fontTextfield);

        JPanel panelTextfield = new JPanel();
        panelTextfield.add(textLabel);
        panelTextfield.setBounds(0, 0, 700, 250);

        ImageIcon canadaIcon = new ImageIcon("CanadaIcon.png");
        ImageIcon japanIcon = new ImageIcon("JapanIcon.png");
        ImageIcon ukIcon = new ImageIcon("UKIcon.png");
        ImageIcon USAIcon = new ImageIcon("USAIcon.png");

        dollarButton = new JRadioButton("Dollar");
        poundButton = new JRadioButton("Pound");
        yenButton = new JRadioButton("Yen");
        canadianDollarButton = new JRadioButton("CanadianDollar");

        ButtonGroup group = new ButtonGroup(); //allows to only select one button
        group.add(dollarButton);
        group.add(poundButton);
        group.add(yenButton);
        group.add(canadianDollarButton);

        dollarButton.addActionListener(this);
        yenButton.addActionListener(this);
        poundButton.addActionListener(this);
        canadianDollarButton.addActionListener(this);

        canadianDollarButton.setIcon(canadaIcon);
        dollarButton.setIcon(USAIcon);
        yenButton.setIcon(japanIcon);
        poundButton.setIcon(ukIcon);

        JPanel buttonPanels = new JPanel();

        buttonPanels.setPreferredSize(new Dimension(50, 50));
        buttonPanels.add(dollarButton);
        buttonPanels.add(poundButton);
        buttonPanels.add(yenButton);
        buttonPanels.add(canadianDollarButton);
        buttonPanels.setBounds(0, 0, 700, 200);

        JLabel amountTextfield = new JLabel();
        amountTextfield.setText("Please enter the amount you would like to Convert (EUR):");
        amountTextfield.setFont(fontTextfield);

        JPanel amountText = new JPanel();
        amountText.add(amountTextfield);
        amountText.setBounds(0, 0, 700, 200);

        amountEuro.setBackground(Color.lightGray);
        amountEuro.setFont(fontTextfield);
        amountEuro.setBounds(120, 50, 400, 45);
        amountEuro.setPreferredSize(new Dimension(250, 40));

        convertedResult.setFont(fontTextfield);

        BoxLayout.setLayout(new BoxLayout(BoxLayout, javax.swing.BoxLayout.PAGE_AXIS));
        BoxLayout.add(Box.createRigidArea(new Dimension(0, 10)));
        BoxLayout.add(amountText);
        BoxLayout.add(panelTextfield);
        BoxLayout.add(buttonPanels);
        BoxLayout.add(convertedResult);

        frame.add(amountEuro);
        frame.add(BoxLayout);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new CurrencyExchanger();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yenButton) {
            String euroString = amountEuro.getText();
            double euroDouble = Double.parseDouble(euroString);
            euroDouble = euroDouble * 144.04;
            DecimalFormat dFormatter = new DecimalFormat("0.00");
            String formatter = dFormatter.format(euroDouble);
            convertedResult.setText(euroString + " Euro equal " + formatter + " Yen (12/11/2022)");
        }
        else if (e.getSource() == dollarButton) {
            String euroString = amountEuro.getText();
            double euroDouble = Double.parseDouble(euroString);
            euroDouble = euroDouble * 1.05;
            DecimalFormat dFormatter = new DecimalFormat("0.00");
            String formatter = dFormatter.format(euroDouble);
            convertedResult.setText(euroString + " Euro equal " + formatter + " Dollar (12/11/2022)");
        }
        else if (e.getSource() == poundButton) {
            String euroString = amountEuro.getText();
            double euroDouble = Double.parseDouble(euroString);
            euroDouble = euroDouble * 0.86;
            DecimalFormat dFormatter = new DecimalFormat("0.00");
            String formatter = dFormatter.format(euroDouble);
            convertedResult.setText(euroString + " Euro equal " + formatter + " British Pounds (12/11/2022)");
        }
        else if (e.getSource() == canadianDollarButton) {
            String euroString = amountEuro.getText();
            double euroDouble = Double.parseDouble(euroString);
            euroDouble = euroDouble * 1.44;
            DecimalFormat dFormatter = new DecimalFormat("0.00");
            String formatter = dFormatter.format(euroDouble);
            convertedResult.setText(euroString + " Euro equal " + formatter + " Canadian Dollar (12/11/2022)");
        }
    }
}