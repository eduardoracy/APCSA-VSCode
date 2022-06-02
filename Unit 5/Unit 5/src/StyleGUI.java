import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StyleGUI {
    private final int WIDTH = 525, HEIGHT = 150, FONT_SIZE = 72;
    private Label saying;
    private JCheckBox bold, italic;
    private JPanel primary;

    public StyleGUI() {
        saying = new Label("Eduardo Racy");
        saying.setFont(new Font("Times New Roman", Font.PLAIN, FONT_SIZE));

        bold = new JCheckBox("Bold");
        bold.setBackground(Color.blue);
        italic = new JCheckBox("Italic");
        italic.setBackground(Color.yellow);

        StyleListener listener = new StyleListener();
        bold.addItemListener(listener);
        italic.addItemListener(listener);

        primary = new JPanel();
        primary.add(saying);
        primary.add(bold);
        primary.add(italic);
        primary.setBackground(Color.green);
        primary.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public JPanel getPanel() {
        return primary;
    }

    private class StyleListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            int style = Font.PLAIN;
            if (bold.isSelected()) {
                style = Font.BOLD;
            }
            if (italic.isSelected()) {
                style += Font.ITALIC;
            }
            saying.setFont(new Font("Helvetica", style, FONT_SIZE));
        }
    }
}