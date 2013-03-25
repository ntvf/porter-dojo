package ua.porter.model;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainLoop {
    public static void main(String[] args) {
        Game porterGame = new GameImpl(15);
        System.out.println(split(porterGame.getBoardAsString(), 15));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("wa")) {
                porterGame.getJoystick().up();
                porterGame.getJoystick().left();
            } else if (command.equals("wd")) {
                porterGame.getJoystick().up();
                porterGame.getJoystick().right();
            } else if (command.equals("a")) {
                porterGame.getJoystick().left();
            } else if (command.equals("d")) {
                porterGame.getJoystick().right();
            } else if (command.equals("w")) {
                porterGame.getJoystick().up();
            }
            System.out.println(split(porterGame.getBoardAsString(), 15));
        }

    }

    private static String split(String board, int size) {
        StringBuffer result = new StringBuffer();
        for (int index = 0; index < size; index++) {
            result.append(board.substring(index * size, (index + 1) * size)).append("\n");
        }
        return result.toString();
    }
}
