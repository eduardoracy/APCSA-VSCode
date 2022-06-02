import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuoteGUI {
    private final int WIDTH = 400, HEIGHT = 101;
    private JPanel primary;
    private Label quote;
    private JRadioButton serenity, ruby, sophie;
    private String serenityQuote = "Forknife, let's go to UW";
    private String rubyQuote = "Scotty P, Skeeterson";
    private String sophieQuote = "I had a toy lion as a kid";

    public QuoteGUI() {
        quote = new Label(serenityQuote);
        quote.setFont(new Font("Times New Roman", Font.BOLD, 30));
        serenity = new JRadioButton("Serenity", true);
        serenity.setBackground(Color.pink);
        ruby = new JRadioButton("Sophie");
        ruby.setBackground(Color.orange);
        sophie = new JRadioButton("Ruby");
        sophie.setBackground(Color.blue);
        ButtonGroup group = new ButtonGroup();
        group.add(serenity);
        group.add(ruby);
        group.add(sophie);
        QuoteListener listener = new QuoteListener();
        serenity.addActionListener(listener);
        ruby.addActionListener(listener);
        sophie.addActionListener(listener);
        primary = new JPanel();
        primary.add(quote);
        primary.add(serenity);
        primary.add(ruby);
        primary.add(sophie);
        primary.setBackground(Color.red);
        primary.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public JPanel getPanel() {
        return primary;
    }

    private class QuoteListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (source == serenity) {
                quote.setText(serenityQuote);
            } else if (source == ruby) {
                quote.setText(rubyQuote);
            } else {
                quote.setText(sophieQuote);
            }
        }
    }

}