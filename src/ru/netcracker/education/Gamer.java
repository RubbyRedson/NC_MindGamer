package ru.netcracker.education;

import ru.netcracker.education.abstract_classes.AbstractGamer;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 06.11.13
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class Gamer extends AbstractGamer {
    public Gamer(FieldCells f) {
        super(f);
    }

    @Override
    public Cell getNextMove() {
        Random n = new Random();
        Cell move = new Cell(n.nextInt(3), n.nextInt(3), true);
        if (!Field.getCells()[move.getHorizontal()][move.getVertical()].isFilled())
            return move;
        else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!Field.getCells()[i][j].isFilled()) {
                        return getNextMove();
                    }
                }
            }
        }
        return null;
    }
}
