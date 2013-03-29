package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 7:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Event {
    public static final int MOVING_LEFT = 1;
    public static final int MOVING_RIGHT = 2;
    private GameObject generating;
    private GameObject taking;
    private int eventCode;

    public Event(int eventCode, GameObject generating, GameObject taking) {
        this.generating = generating;
        this.taking = taking;
        this.eventCode = eventCode;
    }

    public GameObject getGenerating() {
        return generating;
    }

    public GameObject getTaking() {
        return taking;
    }

    public int getEventCode() {
        return eventCode;
    }
}
