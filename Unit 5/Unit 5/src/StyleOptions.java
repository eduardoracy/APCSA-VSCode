import javax.swing.*;

public class StyleOptions {
    public static void main(String[] args) {
        JFrame styleFrame = new JFrame("Eduardo Racy");
        styleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        StyleGUI gui = new StyleGUI();
        styleFrame.getContentPane().add(gui.getPanel());

        styleFrame.pack();
        styleFrame.setVisible(true);
        ;
    }
}