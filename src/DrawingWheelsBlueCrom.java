import java.awt.*;

public class DrawingWheelsBlueCrom implements IDrawingWheels{
    private WheelsCount _wheelsCount;
    @Override
    public void SetWheelsCount(int wheelsCount) {
        for (WheelsCount val : WheelsCount.values()) {
            if (val.count == wheelsCount) {
                _wheelsCount = val;
                return;
            }
        }
        this._wheelsCount = WheelsCount.Five;
    }

    @Override
    public WheelsCount GetWheelsCount() {
        return _wheelsCount;
    }

    @Override
    public void DrawWheel(Graphics2D g2d, Color color, int x, int y, int w, int h) {
        g2d.setColor(Color.GRAY);
        g2d.drawOval(x, y + 3, w-5, h-5);
        g2d.setColor(Color.GREEN);
        g2d.drawOval(x - 2, y - 2, w, h);
        g2d.setColor(Color.WHITE);
        g2d.drawOval(x + 3, y, w - 10, h - 10);

        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, w, h);
    }
}
