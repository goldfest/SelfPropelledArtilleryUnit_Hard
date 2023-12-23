import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;

public class DrawingWheel {
    private WheelsCount _wheelsCount;
    public void SetWheelsCount(int enginesCount) {
        for (WheelsCount val : WheelsCount.values()) {
            if (val.count == enginesCount) {
                this._wheelsCount = val;
                return;
            }
        }
    }

    public void DrawWheels(Graphics2D g, Color color, int startPosX, int startPosY) {
        if (_wheelsCount == null) {
            return;
        }

        int cornerRadius1 = 12;
        Color color1 = new Color(65, 72, 51);

        if (_wheelsCount.count >= _wheelsCount.Four.count) {

            Path2D path = new Path2D.Double();

            path.append(new Arc2D.Double(startPosX + 5, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 180, 90, Arc2D.OPEN), true);

            path.append(new Arc2D.Double(startPosX + 110, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 270, 90, Arc2D.OPEN), true);

            path.append(new Arc2D.Double(startPosX + 110, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 0, 90, Arc2D.OPEN), true);

            path.append(new Arc2D.Double(startPosX + 5, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 90, 90, Arc2D.OPEN), true);
            path.closePath();

            g.setColor(color1);

            g.fill(path);
            g.setColor(Color.BLACK);
            g.draw(path);


            /* наверху гусеницы*/
            g.fillOval(startPosX + 47, startPosY + 44, 13, 13);
            g.fillOval(startPosX + 62, startPosY + 44, 13, 13);
            g.fillOval(startPosX + 77, startPosY + 44, 13, 13);

            /* по середине гусеницы*/
            g.drawOval(startPosX + 40, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 55, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 70, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 85, startPosY + 59, 13, 13);


            /* два крайних на гусенице*/
            g.fillOval(startPosX + 10, startPosY + 50, 25, 25);
            g.fillOval(startPosX + 105, startPosY + 50, 25, 25);

        }

        if (_wheelsCount.count >= _wheelsCount.Five.count) {
            Path2D path = new Path2D.Double();

            path.append(new Arc2D.Double(startPosX + 5, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 180, 90, Arc2D.OPEN), true);

            path.append(new Arc2D.Double(startPosX + 125, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 270, 90, Arc2D.OPEN), true);

            path.append(new Arc2D.Double(startPosX + 125, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 0, 90, Arc2D.OPEN), true);

            path.append(new Arc2D.Double(startPosX + 5, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 90, 90, Arc2D.OPEN), true);
            path.closePath();

            g.setColor(color1);

            g.fill(path);
            g.setColor(Color.BLACK);
            g.draw(path);


            /* наверху гусеницы*/
            g.fillOval(startPosX + 47, startPosY + 44, 13, 13);
            g.fillOval(startPosX + 62, startPosY + 44, 13, 13);
            g.fillOval(startPosX + 77, startPosY + 44, 13, 13);
            g.fillOval(startPosX + 92, startPosY + 44, 13, 13);

            /* по середине гусеницы*/
            g.drawOval(startPosX + 40, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 55, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 70, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 85, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 100, startPosY + 59, 13, 13);


            /* два крайних на гусенице*/
            g.fillOval(startPosX + 10, startPosY + 50, 25, 25);
            g.fillOval(startPosX + 120, startPosY + 50, 25, 25);
        }

        if (_wheelsCount.count >= _wheelsCount.Six.count) {
            Path2D path = new Path2D.Double();

            path.append(new Arc2D.Double(startPosX + 5, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 180, 90, Arc2D.OPEN), true);

            path.append(new Arc2D.Double(startPosX + 140, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 270, 90, Arc2D.OPEN), true);

            path.append(new Arc2D.Double(startPosX + 140, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 0, 90, Arc2D.OPEN), true);

            path.append(new Arc2D.Double(startPosX + 5, startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 90, 90, Arc2D.OPEN), true);
            path.closePath();

            g.setColor(color1);

            g.fill(path);
            g.setColor(Color.BLACK);
            g.draw(path);


            /* наверху гусеницы*/
            g.fillOval(startPosX + 47, startPosY + 44, 13, 13);
            g.fillOval(startPosX + 62, startPosY + 44, 13, 13);
            g.fillOval(startPosX + 77, startPosY + 44, 13, 13);
            g.fillOval(startPosX + 92, startPosY + 44, 13, 13);
            g.fillOval(startPosX + 107, startPosY + 44, 13, 13);

            /* по середине гусеницы*/
            g.drawOval(startPosX + 40, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 55, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 70, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 85, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 100, startPosY + 59, 13, 13);
            g.drawOval(startPosX + 115, startPosY + 59, 13, 13);


            /* два крайних на гусенице*/
            g.fillOval(startPosX + 10, startPosY + 50, 25, 25);
            g.fillOval(startPosX + 135, startPosY + 50, 25, 25);
        }
    }
}
