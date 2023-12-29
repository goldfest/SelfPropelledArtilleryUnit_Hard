import java.awt.*;

public class DrawingEmptyWheels implements  IDrawingWheels{
    private WheelsCount _wheelsCount;
    @Override
    public void SetWheelsCount(int wheelsCount) {
        for (WheelsCount val : WheelsCount.values()) {
            if (val.count == wheelsCount) {
                _wheelsCount = val;
                return;
            }
        }
        this._wheelsCount = WheelsCount.Four;
    }

    @Override
    public WheelsCount GetWheelsCount() {
        return _wheelsCount;
    }

    @Override
    public void DrawWheel(Graphics2D g2d, Color color, int x, int y, int w, int h) {
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, w, h);
    }
}
