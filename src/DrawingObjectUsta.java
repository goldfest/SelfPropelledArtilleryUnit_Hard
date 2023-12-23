public class DrawingObjectUsta implements IMoveableObject {
    private DrawingUsta _drawningUsta = null;
    public DrawingObjectUsta(DrawingUsta drawningUsta)
    {
        _drawningUsta = drawningUsta;
    }
    public ObjectParameters GetObjectPosition()
    {
        if (_drawningUsta == null || _drawningUsta.EntityUsta == null)
        {
            return null;
        }
        return new ObjectParameters(_drawningUsta.GetPosX(), _drawningUsta.GetPosY(),
                _drawningUsta.GetWidth(), _drawningUsta.GetHeight());
    }
    public int GetStep(){
        if(_drawningUsta == null) return -1;
        return (int)(_drawningUsta.EntityUsta.Step());
    }
    public boolean CheckCanMove(DyrectionType direction){
        if(_drawningUsta == null) return false;
        return _drawningUsta.CanMove(direction);
    }
    public void MoveObject(DyrectionType direction){
        if(_drawningUsta == null) return;
        _drawningUsta.MoveTransport(direction);
    }
}
