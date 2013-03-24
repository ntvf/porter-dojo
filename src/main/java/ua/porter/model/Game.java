package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Game extends Tickable {
    Joystick getJoystick();  // джойстик для управления игрой

    int getMaxScore();      // максимальное количество очков, которое удалось достичь во время одной игры (между двумя gemaover)

    int getCurrentScore();  // очки текущей игру

    boolean isGameOver(); // закончилась ли игра

    void newGame();  // стартовать новую игру, обновить поле, сбросить очки и т.д...

    String getBoardAsString(); // получить доску в теквтовом виде

}
