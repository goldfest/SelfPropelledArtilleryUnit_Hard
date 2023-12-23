public class ObjectParameters {
    private final int _x;
    private final int _y;
    private final int _width;
    private final int _height;

    /// Левая граница
    public int LeftBorder()
    {
        return _x;
    };

    /// Верхняя граница
    public int TopBorder()
    {
        return _y;
    }

    /// Правая граница
    public int RightBorder()
    {
       return _x + _width;
    }

    /// Нижняя граница
    public int DownBorder()
    {
        return _y + _height;
    }

    /// Середина объекта по горизонтали
    public int ObjectMiddleHorizontal()
    {
        return _x + _width / 2;
    }

    /// Середина объекта по вертикали
    public int ObjectMiddleVertical()
    {
        return _y + _height / 2;
    }

    public ObjectParameters(int x, int y, int width, int height)
    {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }
}
