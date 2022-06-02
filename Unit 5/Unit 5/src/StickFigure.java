import java.awt.*;

public class StickFigure {
    private int baseX;
    private int baseY;
    private Color color;
    private int height;

    public StickFigure(int center, int bottom, Color shade, int size) {
        baseX = center;
        baseY = bottom;
        color = shade;
        height = size;
    }

    public void draw(Graphics page) {
        int top = baseY - height; // top of head
        page.setColor(color);
        page.drawOval(baseX - 10, top, 20, 20); // head
        page.drawLine(baseX, top + 20, baseX, baseY - 30); // trunk
        page.drawLine(baseX, baseY - 30, baseX - 15, baseY);
        page.drawLine(baseX, baseY - 30, baseX + 15, baseY); // legs
        page.drawLine(baseX, baseY - 70, baseX - 25, baseY - 70);
        page.drawLine(baseX, baseY - 70, baseX + 20, baseY - 85); // arms
    }

}
