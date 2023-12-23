import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Arc2D;
public class DrawingUsta {
    public EntityUsta EntityUsta;
    private DrawingWheel _drawingWheel;
    private int _pictureWidth;
    private int _pictureHeight;
    private int _startPosX;
    private int _startPosY;
    private final int _ustaWidth = 170;
    private final int _ustaHeight = 90;

    public boolean Init(int speed, double weight, Color bodyColor, Color additionalColor,
                        boolean bodyKit, boolean pushka, int width, int height)
    {

        if (width < _ustaWidth || height < _ustaHeight)
        {
            return false;
        }
        _pictureWidth = width;
        _pictureHeight = height;
        EntityUsta = new EntityUsta();
        _drawingWheel = new DrawingWheel();
        EntityUsta.Init(speed, weight, bodyColor, additionalColor, bodyKit, pushka);
        return true;
    }

    public void SetWheelsCount(int weelsCount) {

        _drawingWheel.SetWheelsCount(weelsCount);
    }

    public void SetPosition(int x, int y)
    {
        if (x < 0 || x + _ustaWidth > _pictureWidth)
        {
            x = 20;
        }
        if (y < 0 || y + _ustaHeight > _pictureHeight)
        {
            y = 20;
        }
        _startPosX = x;
        _startPosY = y;
    }

    public void MoveTransport(DyrectionType direction){
        if(EntityUsta == null) return;
        switch(direction)
        {
            case Up -> {
                if(_startPosY - EntityUsta.Step() >= 5)
                    _startPosY -= (int) EntityUsta.Step();
            }
            case Down -> {
                if(_startPosY + EntityUsta.Step() + _ustaHeight <= _pictureHeight)
                    _startPosY += (int) EntityUsta.Step();
            }
            case Left -> {
                if(_startPosX - EntityUsta.Step() >= 0)
                    _startPosX -= (int) EntityUsta.Step();
            }
            case Right -> {
                if(_startPosX + EntityUsta.Step() + _ustaWidth <= _pictureWidth)
                    _startPosX += (int) EntityUsta.Step();
            }
        }
    }
    public void DrawTransport(Graphics2D g) {
        if (EntityUsta == null) {
            return;
        }



        Color bodyColor = EntityUsta.BodyColor;
        Color additionalColor = EntityUsta.AdditionalColor;

        Color blackBrush = Color.BLACK;

        Color color1 = new Color(65, 72, 51);
        Color color2 = new Color(47, 69, 56);

        int cornerRadius1 = 12;

        _drawingWheel.DrawWheels(g, additionalColor, _startPosX, _startPosY);

        g.setColor(color1);
        g.fillRect(_startPosX + 45, _startPosY + 20, 40, 20);
        g.setColor(Color.BLACK);
        g.drawRect(_startPosX + 45, _startPosY + 20, 40, 20);



        g.setColor(color1);

        g.fillRect(_startPosX + 10, _startPosY + 40, 120, 10);

        g.setColor(Color.BLACK);
        g.drawRect(_startPosX + 10, _startPosY + 40, 120, 10);
        if(EntityUsta.BodyKit)
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



        if(EntityUsta.Pushka)
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

    }
}
