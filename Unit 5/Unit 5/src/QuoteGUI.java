import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuoteGUI {
    private final int WIDTH = 300, HEIGHT = 100;
    private JPanel primary;
    private Label quote;
    private JRadioButton comedy, philosophy, carpentry;
    private String comedyQuote = "Take my wife, please.";
    private String philosophyQuote = "I think, therefore I am.";
    private String carpentryQuote = "Measure twice. Cut once.";

    public QuoteGUI() {
        quote = new Label(comedyQuote);
        quote.setFont(new Font("Helvetica", Font.BOLD, 24));
        comedy = new JRadioButton("Comedy", true);
        comedy.setBackground(Color.green);
        philosophy = new JRadioButton("Philosophy");
        philosophy.setBackground(Color.green);
        carpentry = new JRadioButton("Carpentry");
        carpentry.setBackground(Color.green);
        ButtonGroup group = new ButtonGroup();
        group.add(comedy);
        group.add(philosophy);
        group.add(carpentry);
        QuoteListener listener = new QuoteListener();
        comedy.addActionListener(listener);
        philosophy.addActionListener(listener);
        carpentry.addActionListener(listener);
        primary = new JPanel();
        primary.add(quote);
        primary.add(comedy);
        primary.add(philosophy);
        primary.add(carpentry);
        primary.setBackground(Color.green);
        primary.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public JPanel getPanel() {
        return primary;
    }

    private class QuoteListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (source == comedy)
                quote.setText(comedyQuote);
            else if (source == philosophy)
                quote.setText(philosophyQuote);
            else
                quote.setText(carpentryQuote);
        }
    }

}