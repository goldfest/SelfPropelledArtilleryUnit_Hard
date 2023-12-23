public abstract class AbstractStrategy {
    private IMoveableObject _moveableObject;
    private Status _state = Status.NotInit;
    protected int FieldWidth;
    protected int FieldHeight;
    public Status GetStatus() { return _state; }

    public void SetData(IMoveableObject moveableObject, int width, int height)
    {
        if (moveableObject == null)
        {
            _state = Status.NotInit;
            return;
        }
        _state = Status.InProgress;
        _moveableObject = moveableObject;
        FieldWidth = width;
        FieldHeight = height;
    }

    public void MakeStep()
    {
        if (_state != Status.InProgress)
        {
            return;
        }
        if (IsTargetDestinaion())
        {
            _state = Status.Finish;
            return;
        }
        MoveToTarget();
    }

    protected boolean MoveLeft(){
        return MoveTo(DyrectionType.Left);
    }

    protected boolean MoveRight(){
        return MoveTo(DyrectionType.Right);
    }

    protected boolean MoveUp(){
        return MoveTo(DyrectionType.Up);
    }

    protected boolean MoveDown(){
        return  MoveTo(DyrectionType.Down);
    }

    /// Параметры объекта
    protected ObjectParameters GetObjectParameters(){
        if(_moveableObject == null) return null;
        return _moveableObject.GetObjectPosition();
    }

    protected int GetStep()
    {
        if (_state != Status.InProgress)
        {
            return -1;
        }
        if(_moveableObject == null) return -1;
        return _moveableObject.GetStep();
    }
    protected abstract void MoveToTarget();

    protected abstract boolean IsTargetDestinaion();

    private boolean MoveTo(DyrectionType directionType)
    {
        if (_state != Status.InProgress)
        {
            return false;
        }
        if (_moveableObject.CheckCanMove(directionType) == false) return false;
        {
            _moveableObject.MoveObject(directionType);
            return true;
        }
    }
}
