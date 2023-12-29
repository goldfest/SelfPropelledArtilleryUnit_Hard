public class SetGeneric<T extends DrawingUsta>{
    private T[] _places;
    public int Count(){
       return  _places.length;
    }
    public SetGeneric(int count) {
        _places = (T[]) new DrawingUsta[count];
    }

    public int Insert(T loco)
    {
        return Insert(loco, 0);
    }

    public int Insert(T loco, int position)
    {
        int NoEmpty = 0, temp = 0;
        for (int i = position; i < Count(); i++)
        {
            if (_places[i] != null) NoEmpty++;
        }
        if (NoEmpty == Count() - position - 1) return -1;

        if (position < Count() && position >= 0)
        {
            for (int j = position; j < Count(); j++)
            {
                if (_places[j] == null)
                {
                    temp = j;
                    break;
                }
            }
            // shift right
            for (int i = temp; i > position; i--)
            {
                _places[i] = _places[i - 1];
            }
            _places[position] = loco;
            return position;
        }
        return -1;
    }

    public T Remove(int position)
    {
        if (position >= Count() || position < 0)
            return null;

        T tmp = _places[position];
        _places[position] = null;
        return tmp;
    }

    public T Get(int position)
    {
        // TODO проверка позиции
        if (position < 0 || position >= Count()) return null;
        return _places[position];
    }
}
