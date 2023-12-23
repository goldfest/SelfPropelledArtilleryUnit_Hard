public class MoveToCenter extends  AbstractStrategy{
    @Override
    protected boolean IsTargetDestinaion()
    {
        var objParams = GetObjectParameters();
        if (objParams == null) return false;

        return objParams.ObjectMiddleHorizontal() <= FieldWidth / 2 && objParams.ObjectMiddleHorizontal() + GetStep()
                >= FieldWidth / 2 && objParams.ObjectMiddleVertical() <= FieldHeight / 2 && objParams.ObjectMiddleVertical()
                + GetStep() >= FieldHeight / 2;
    }

    @Override
    protected void MoveToTarget()
    {
        var objParams = GetObjectParameters();
        if (objParams == null) return;
        var diffX = objParams.ObjectMiddleHorizontal() - FieldWidth / 2;
        if (Math.abs(diffX) > GetStep())
        {
            if (diffX > 0)
            {
                MoveLeft();
            }
            else
            {
                MoveRight();
            }
        }
        var diffY = objParams.ObjectMiddleVertical() - FieldHeight / 2;
        if (Math.abs(diffY) > GetStep())
        {
            if (diffY > 0)
            {
                MoveUp();
            }
            else
            {
                MoveDown();
            }
        }
    }
}
