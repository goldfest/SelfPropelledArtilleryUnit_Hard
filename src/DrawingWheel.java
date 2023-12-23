import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;

public class DrawingWheel implements IDrawingWheels {
    private WheelsCount _wheelsCount;
    public void SetWheelsCount(int enginesCount) {
        for (WheelsCount val : WheelsCount.values()) {
            if (val.count == enginesCount) {
                this._wheelsCount = val;
                return;
            }
        }
        this._wheelsCount = WheelsCount.Five;
    }

    @Override
    public WheelsCount GetWheelsCount() {
        return _wheelsCount;
    }

    public void DrawWheel(Graphics2D g2d, Color color, int x, int y, int w, int h) {
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x, y, w, h);
    }
}
