import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.util.Random;

public class DrawingUsta {
    public EntityUsta EntityUsta;
    protected IDrawingWheels _drawingWheels;
    private int _pictureWidth;
    private int _pictureHeight;
    public int _startPosX;
    public int _startPosY;
    private int _ustaWidth = 170;
    private int _ustaHeight = 90;

    public int GetPosX(){
        return _startPosX;
    }
    public int GetPosY(){
        return _startPosY;
    }
    public int GetWidth(){
        return _ustaWidth;
    }
    public int GetHeight(){
        return _ustaHeight;
    }

    public DrawingUsta(int speed, double weight, Color bodyColor, int width, int height)
    {
        if (width < _ustaWidth || height < _ustaHeight)
        {
            return;
        }
        _pictureWidth = width;
        _pictureHeight = height;
        EntityUsta = new EntityUsta(speed, weight, bodyColor);

        Random rnd = new Random();
        int WhatWheels = rnd.nextInt(0, 3);

        if(WhatWheels == 0) _drawingWheels = new DrawingWheel();
        if(WhatWheels == 1) _drawingWheels = new DrawingEmptyWheels();
        if(WhatWheels == 2) _drawingWheels = new DrawingWheelsBlueCrom();
    }

    public void SetWheelsCount(int wheelsCount){
        _drawingWheels.SetWheelsCount(wheelsCount);
    }

    protected DrawingUsta(int speed, double weight, Color bodyColor, int width,
                                int height, int ustaWidth, int ustaHeight)
    {
        this(speed,weight, bodyColor, width, height);
        if (width < _ustaWidth || height < _ustaHeight)
        {
            return;
        }
        _pictureWidth = width;
        _pictureHeight = height;
        _ustaWidth = ustaWidth;
        _ustaHeight = ustaHeight;
    }

    protected DrawingUsta(EntityUsta entityUsta, IDrawingWheels iDrawingWheels,
                                int width, int height){
        EntityUsta = entityUsta;
        _drawingWheels  = iDrawingWheels;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    protected DrawingUsta(EntityUsta entityUsta, IDrawingWheels iDrawingWheels,
                                int width, int height, int ustaWidth, int  ustaHeight){
        this(entityUsta, iDrawingWheels, width, height);
        _ustaWidth = ustaWidth;
        _ustaHeight = ustaHeight;
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

        Color blackBrush = Color.BLACK;

        Color color1 = new Color(65, 72, 51);
        Color color2 = new Color(47, 69, 56);

        int cornerRadius1 = 12;

        Path2D path = new Path2D.Double();

        path.append(new Arc2D.Double(_startPosX + 5, _startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 180, 90, Arc2D.OPEN), true);

        path.append(new Arc2D.Double(_startPosX + 140, _startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 270, 90, Arc2D.OPEN), true);

        path.append(new Arc2D.Double(_startPosX + 140, _startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 0, 90, Arc2D.OPEN), true);

        path.append(new Arc2D.Double(_startPosX + 5, _startPosY + 50, 2 * cornerRadius1, 2 * cornerRadius1, 90, 90, Arc2D.OPEN), true);
        path.closePath();
        g.setColor(bodyColor);
        g.fill(path);
        g.setColor(Color.BLACK);
        g.draw(path);

        _drawingWheels.DrawWheels(g, blackBrush, _startPosX, _startPosY, 9,9);
        g.setColor(bodyColor);
        g.fillRect(_startPosX + 45, _startPosY + 20, 40, 20);
        g.setColor(Color.BLACK);
        g.drawRect(_startPosX + 45, _startPosY + 20, 40, 20);

        g.setColor(bodyColor);
        g.fillRect(_startPosX + 10, _startPosY + 40, 120, 10);
        g.setColor(Color.BLACK);
        g.drawRect(_startPosX + 10, _startPosY + 40, 120, 10);

    }

    public boolean CanMove(DyrectionType direction)
    {
        if (EntityUsta == null)
        {
            return false;
        }
        switch(direction) {
            //влево
            case Left:
                if (_startPosX - EntityUsta.Step() > 0) return true;
                break;
            case Up:
                if (_startPosY - EntityUsta.Step() > 0) return true;
                break;
            case Right:
                if (_startPosX + EntityUsta.Step() < _pictureWidth) return true;
                break;
            case Down:
                if (_startPosY + EntityUsta.Step() < _pictureHeight) return true;
                break;
        }
        return false;
    }

    public IMoveableObject GetMoveableObject() {
        return new DrawingObjectUsta(this);
    }
}
