import java.awt.*;
import java.awt.geom.Path2D;

public class DrawingUstaBat extends DrawingUsta {
    public DrawingUstaBat(int speed, double weight, Color bodyColor, Color additionalColor,
                          boolean pushka, boolean bodyKit, int width, int height)
    {
        super(speed, weight, bodyColor, width, height, 170, 90);
        if (EntityUsta != null)
        {
            EntityUsta = new EntityUstaBat(speed, width, bodyColor, additionalColor, pushka, bodyKit);
        }
    }

    public DrawingUstaBat(EntityUstaBat entityUstaBat, IDrawingWheels iDrawingWheels,
                                     int width, int height)
    {
        super(entityUstaBat,iDrawingWheels, width, height, 150, 50);
    }
    @Override
    public void DrawTransport(Graphics2D g)
    {
        if (EntityUsta instanceof EntityUstaBat ustabat) /////////     WARNING    INSTANCEOF
        {
            Color bodyColor = EntityUsta.BodyColor;
            Color additionalColor = ustabat.AdditionalColor;

            Color blackBrush = Color.BLACK;

            Color color1 = new Color(65, 72, 51);
            Color color2 = new Color(47, 69, 56);

            if(ustabat.BodyKit)
            {
                Path2D path1 = new Path2D.Double();
                path1.moveTo(_startPosX + 15, _startPosY + 40);
                path1.lineTo(_startPosX + 15, _startPosY + 30);
                path1.lineTo(_startPosX + 15, _startPosY + 35);
                path1.lineTo(_startPosX + 25, _startPosY + 35);
                path1.lineTo(_startPosX + 30, _startPosY + 30);
                path1.lineTo(_startPosX + 35, _startPosY + 40);
                path1.closePath();

                g.setColor(Color.BLACK);

                g.draw(path1);

                g.setColor(color2);
                g.fill(path1);

                Path2D path2 = new Path2D.Double();
                path2.moveTo(_startPosX + 15, _startPosY + 30);
                path2.lineTo(_startPosX + 40, _startPosY + 20);
                path2.lineTo(_startPosX + 40, _startPosY + 25);
                path2.lineTo(_startPosX + 25, _startPosY + 35);
                path2.closePath();

                g.setColor(Color.BLACK);
                g.draw(path2);

                g.setColor(additionalColor);
                g.fill(path2);

                Path2D path3 = new Path2D.Double();
                path3.moveTo(_startPosX + 10, _startPosY + 32);
                path3.lineTo(_startPosX, _startPosY + 10);
                path3.lineTo(_startPosX + 40, _startPosY - 7);
                path3.lineTo(_startPosX + 50, _startPosY + 16);
                path3.closePath();

                g.setColor(Color.BLACK);
                g.draw(path3);

                g.setColor(bodyColor);
                g.fill(path3);

                Path2D path4 = new Path2D.Double();
                path4.moveTo(_startPosX, _startPosY + 10);
                path4.lineTo(_startPosX + 40, _startPosY - 7);
                path4.lineTo(_startPosX + 43, _startPosY - 5);
                path4.lineTo(_startPosX + 41, _startPosY - 3);
                path4.lineTo(_startPosX + 2, _startPosY + 13);
                path4.closePath();

                g.setColor(Color.BLACK);

                g.draw(path4);

                g.setColor(additionalColor);
                g.fill(path4);

                Path2D path5 = new Path2D.Double();
                path5.moveTo(_startPosX + 3, _startPosY + 15);
                path5.lineTo(_startPosX + 45, _startPosY - 2);
                path5.lineTo(_startPosX + 46, _startPosY - 2);
                path5.lineTo(_startPosX + 49, _startPosY - 1);
                path5.lineTo(_startPosX + 46, _startPosY + 3);
                path5.lineTo(_startPosX + 6, _startPosY + 20);
                path5.closePath();

                g.setColor(Color.BLACK);

                g.draw(path5);

                g.setColor(bodyColor);
                g.fill(path5);

                Path2D path6 = new Path2D.Double();
                path6.moveTo(_startPosX + 5, _startPosY + 22);
                path6.lineTo(_startPosX + 47, _startPosY + 5);
                path6.lineTo(_startPosX + 51, _startPosY + 5);
                path6.lineTo(_startPosX + 53, _startPosY + 7);
                path6.lineTo(_startPosX + 8, _startPosY + 25);
                path6.closePath();

                g.setColor(Color.BLACK);

                g.draw(path6);

                g.setColor(additionalColor);
                g.fill(path6);

                Path2D path7 = new Path2D.Double();
                path7.moveTo(_startPosX + 7, _startPosY + 27);
                path7.lineTo(_startPosX + 46, _startPosY + 11);
                path7.lineTo(_startPosX + 51, _startPosY + 9);
                path7.lineTo(_startPosX + 56, _startPosY + 11);
                path7.lineTo(_startPosX + 10, _startPosY + 31);
                path7.closePath();

                g.setColor(Color.BLACK);

                g.draw(path7);

                g.setColor(bodyColor);
                g.fill(path7);
            }





            if(ustabat.Pushka)
            {
                g.fillRect(_startPosX + 80, _startPosY + 25, 10, 10);

                g.setColor(Color.BLACK);
                g.drawRect(_startPosX + 80, _startPosY + 25, 10, 10);
                g.setColor(color1);
                g.fillRect(_startPosX + 90, _startPosY + 28, 40, 5);

                g.setColor(Color.BLACK);
                g.drawRect(_startPosX + 90, _startPosY + 28, 40, 5);
                g.setColor(additionalColor);
                g.fillRect(_startPosX + 130, _startPosY + 27, 5, 7);

                g.setColor(Color.BLACK);
                g.drawRect(_startPosX + 130, _startPosY + 27, 5, 7);
            }
            super.DrawTransport(g);
        }
    }
}
