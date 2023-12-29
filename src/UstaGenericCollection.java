import java.awt.*;

public class UstaGenericCollection<T extends DrawingUsta,U extends IMoveableObject>
{
    //ширина/высота окна
    private final int _pictureWidth;
    private final int _pictureHeight;
    //ширина/высота занимаемого места
    private final int _placeSizeWidth = 210;
    private final int _placeSizeHeight = 90;

    /// Набор объектов
    private final SetGeneric<T> _collection;

    public UstaGenericCollection(int picWidth, int picHeight)
    {
        //  немного странная логика, что-то я пока ее не особо понимаю, зачем нам ААААА дошло...
        //  высчитываем размер массива для setgeneric
        int width = picWidth / _placeSizeWidth;
        int height = picHeight / _placeSizeHeight;
        _pictureWidth = picWidth;
        _pictureHeight = picHeight;
        _collection = new SetGeneric<T>(width*height);
    }

    /// Перегрузка оператора сложения
    //да емае, почему в яве все по-другому?...

    public int AddOverload(T loco){
        if(loco == null){
            return -1;
        }
        return _collection.Insert(loco);
    }

    public T SubOverload(int pos){
        return _collection.Remove(pos);
    }

    // получение объекта imoveableObj
    public U GetU(int pos)
{
    return (U)_collection.Get(pos).GetMoveableObject();
}

    /// Вывод всего набора объектов
    public void ShowLocomotives(Graphics2D gr)
    {
        DrawBackground(gr);
        DrawObjects(gr);
    }
    private void DrawBackground(Graphics g)
    {
        Color blackColor = Color.BLACK;
        g.setColor(blackColor);
        for (int i = 0; i < _pictureWidth / _placeSizeWidth; i++)
        {
            for (int j = 0; j < _pictureHeight / _placeSizeHeight + 1; ++j)
            {
                //линия рамзетки места
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i * _placeSizeWidth + _placeSizeWidth / 2, j * _placeSizeHeight);
            }
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, _pictureHeight / _placeSizeHeight * _placeSizeHeight);
        }
    }

    private void DrawObjects(Graphics2D g)
    {
        int c = 11;

        for (int i = 0; i < _collection.Count(); i++)
        {
            if (i % 3 == 0 && i != 0)
            {
                c = c - 3;

            }
            T type = _collection.Get(i);
            if (type != null)
            {
                type.SetPosition(
                        (int)(i % (_pictureWidth / _placeSizeWidth) * _placeSizeWidth + 3),
                        (c / (_pictureWidth / _placeSizeWidth) * _placeSizeHeight + 10)
                );
                type.DrawTransport(g);
            }
        }
    }
}
