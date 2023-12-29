import java.util.ArrayList;

public class SetGeneric<T extends DrawingUsta>{
    private ArrayList<T> _places;

    public int Count()
    {
        return  _places.size();
    }

    public int maxCount;

    public SetGeneric(int count)
    {
        maxCount = count;
        _places = new ArrayList<>(count);
    }

    public int Insert(T usta)
    {
        return Insert(usta, 0);
    }

    public int Insert(T usta, int position)
    {
        if(position < 0 || position > maxCount)
            return -1;
        else
        {
            _places.add(position, usta);
            return position;
        }
    }

    public T Remove(int position)
    {
        if (position >= Count() || position < 0)
            return null;
        else
        {
            T plane = _places.get(position);
            _places.set(position, null);
            return plane;
        }
    }

    public T Get(int position)
    {
        if (position < 0 || position >= Count()) return null;
        return _places.get(position);
    }

    public void Set(int position, T usta) {
        // Проверка позиции
        // Проверка свободных мест в списке
        if (position < 0 || position >= maxCount || Count() == maxCount) {
            return;
        }
        // Вставка в список по позиции
        _places.set(position, usta);
    }

    public ArrayList<T> GetEnumerator() {
        return _places;
    }

}