package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardCell {
    private int x;
    private int y;
    private GameObject object;

    public BoardCell() {

    }

    public BoardCell(int horisontalPosition, int verticalPosition) {
        this.x = horisontalPosition;
        this.y = verticalPosition;

    }

    public String toString() {
        if (object != null) {
            return object.toString();
        }
        return ObjectsLiterals.emptySpase;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof BoardCell))
            return false;
        BoardCell cell = (BoardCell) obj;
        return (this.x == cell.x && this.y == cell.y);
    }

    @Override
    public int hashCode() {
        int code = 11;
        int k = 7;
        code = k * code + this.x;
        code = k * code + this.y;
        return code;
    }

    public void setObject(GameObject object) {
        this.object = object;
    }

    public GameObject getObject() {
        return this.object;
    }
}
