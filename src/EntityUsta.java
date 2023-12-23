import java.awt.*;

public class EntityUsta {
    public int Speed;
    public double Weight;
    public Color BodyColor;
    public Color AdditionalColor;
    public boolean BodyKit;
    public boolean Pushka;
    public double Step()
    {
        return (double) Speed * 100 / Weight;
    }
    public void Init(int speed, double weight, Color bodyColor, Color additionalColor,
                     boolean bodyKit, boolean pushka)
    {
        Speed = speed;
        Weight = weight;
        BodyColor = bodyColor;
        AdditionalColor = additionalColor;
        BodyKit = bodyKit;
        Pushka = pushka;
    }
}
