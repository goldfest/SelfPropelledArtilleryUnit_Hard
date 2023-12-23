public interface IMoveableObject {
    ObjectParameters GetObjectPosition();
    int GetStep();
    boolean CheckCanMove(DyrectionType direction);
    void MoveObject(DyrectionType direction);
}
