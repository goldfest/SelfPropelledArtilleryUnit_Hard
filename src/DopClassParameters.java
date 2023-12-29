import java.util.Random;

public class DopClassParameters<T extends EntityUsta, U extends IDrawingWheels> {
    public T[] _entityUsta;
    public U[] _idrawningWheels;

    int _ustaCount;
    int _idrawningWheelsCount;

    private int _pictureWidth;
    private int _pictureHeight;

    public DopClassParameters(int count, int width, int height) {
        _entityUsta = (T[]) new EntityUsta[count];
        _idrawningWheels = (U[]) new IDrawingWheels[count];
        _pictureWidth = width;
        _pictureHeight = height;
        _ustaCount = 0;
        _idrawningWheelsCount = 0;
    }

    public void Add(T entityUstaObj) {
        if (_ustaCount < _entityUsta.length) {
            _entityUsta[_ustaCount] = entityUstaObj;
            _ustaCount++;
        }
    }

    public void Add(U idrawingWheels) {
        if (_idrawningWheelsCount < _idrawningWheels.length) {
            _idrawningWheels[_idrawningWheelsCount] = idrawingWheels;
            _idrawningWheelsCount++;
        }
    }

    public DrawingUsta RandomUsta(int pictureWidth, int pictureHeight) {
        Random rnd = new Random();
        if (_entityUsta == null || _idrawningWheels == null) {
            return null;
        }
        T entityUsta = _entityUsta[rnd.nextInt(_ustaCount)];
        U idrawingWheels = _idrawningWheels[rnd.nextInt(_idrawningWheelsCount)];

        DrawingUsta drawUsta;
        if (entityUsta instanceof EntityUstaBat) {
            drawUsta = new DrawingUstaBat(
                    (EntityUstaBat) entityUsta,
                    idrawingWheels,
                    pictureWidth,
                    pictureHeight
            );
        } else {
            drawUsta = new DrawingUsta(
                    entityUsta,
                    idrawingWheels,
                    pictureWidth,
                    pictureHeight
            );
        }
        return drawUsta;
    }
}
