import javax.swing.*;

public class StyleOptions {
    public static void main(String[] args) {
        JFrame styleFrame = new JFrame("Style Options");
        styleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StyleGUI gui = new StyleGUI();
        styleFrame.getContentPane().add(gui.getPanel());
        styleFrame.pack();
        styleFrame.show();
    }
}