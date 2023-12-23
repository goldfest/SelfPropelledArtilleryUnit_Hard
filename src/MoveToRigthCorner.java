public class MoveToRigthCorner extends AbstractStrategy {
    @Override
    protected boolean IsTargetDestinaion()
    {
        var objParams = GetObjectParameters();
        if (objParams == null) return false;

        return objParams.RightBorder() >= FieldWidth - GetStep() && objParams.DownBorder() >= FieldHeight - GetStep();
    }
    @Override
    protected void MoveToTarget()
    {
        var objParams = GetObjectParameters();
        if (objParams == null) return;

        if (objParams.RightBorder() < FieldWidth - GetStep()) MoveRight();
        if (objParams.DownBorder() < FieldHeight - GetStep()) MoveDown();
    }
}
