import java.awt.*;

public class EntityUsta {
    public int Speed;
    public double Weight;
    public Color BodyColor;
    public EntityUsta(int speed, double weight, Color bodyColor) {
        Speed = speed;
        Weight = weight;
        BodyColor = bodyColor;
    }
    public double Step()
    {
        return (double) Speed * 100 / Weight;
    }
    public void Init(int speed, double weight, Color bodyColor, Color additionalColor, boolean horns, boolean seifbatteries) {
        Speed = speed;
        Weight = weight;
        BodyColor = bodyColor;
    }
}
