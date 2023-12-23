import java.awt.*;

public class EntityUstaBat extends  EntityUsta {
    public Color AdditionalColor;
    public boolean Pushka;
    public boolean BodyKit;
    public EntityUstaBat(int speed, double weight, Color bodyColor, Color additionalColor, boolean pushka, boolean bodyKit)
    {
        super(speed, weight, bodyColor);
        AdditionalColor = additionalColor;
        Pushka = pushka;
        BodyKit = bodyKit;
    }

}
