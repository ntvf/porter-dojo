package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    private BoardCell[][] map;

    public Board(int dimension) {
        this.map = generateEmptyMap(dimension);
    }

    public Board(String lineMap) {      //TODO generate map from ready string

    }

    public String toString() {
        StringBuilder formation = new StringBuilder();
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                formation.append(map[rowIndex][colIndex].toString());

            }
        }
        return formation.toString();
    }

    public BoardCell[][] getMap() {
        return map;
    }

    private BoardCell[][] generateEmptyMap(int dimension) {
        BoardCell[][] generatedMap = new BoardCell[dimension][dimension];
        int startHelpIndex = dimension - 1;
        for (int rowIndex = 0; rowIndex <= dimension - 1; rowIndex++) {
            for (int colIndex = 0; colIndex <= dimension - 1; colIndex++) {
                generatedMap[rowIndex][colIndex] = new BoardCell(colIndex, startHelpIndex);

            }
            startHelpIndex--;
        }
        return generatedMap;
    }


    public void addObject(Object porter) {
    }
}
