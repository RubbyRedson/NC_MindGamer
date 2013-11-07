package ru.netcracker.education;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 06.11.13
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */

import ru.netcracker.education.abstract_classes.AbstractArbiter;

public class Arbiter extends AbstractArbiter {
    public Arbiter(int RHL, int RHH, int RVL, int RVH, int numberOfPlayers) {
        super();
        RangeHorizontalLow = RHL;
        RangeHorizontalHigh = RHH;
        RangeVerticalLow = RVL;
        RangeVerticalHigh = RVH;

    }

    @Override
    public void arrangeMatch() {
        PlayingField = new Field();
        player1 = new Gamer(new FieldCells());    // тут нужно найти двух ботов
        player2 = new Gamer(new FieldCells());
        Cell move;
        String winner = "";
        boolean endGame = false;
        boolean fullField = false;
        do {
            fullField = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!PlayingField.getField().getCells()[i][j].isFilled()) {
                        fullField = false;
                    }
                }
            }
            try {
                move = player1.getNextMove();
                if (checkValidityOfMove(move)) {
                    move.setFilledO(true);
                    updateWithO(move);
                }
                System.out.println("Player 1 made a move " + move.toString());
                player1.updateFieldCells(move);
                player2.updateFieldCells(move);
                if (hasWinner()) {
                    winner = "Winner is Player 1";
                    endGame = true;
                }
            }
            catch (IllegalArgumentException e) {
                winner = "Winner is Player 2";
                endGame = true;
            }
            catch (Throwable e) {
                e.printStackTrace();
            }
            fullField  = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!PlayingField.getField().getCells()[i][j].isFilled()) {
                        fullField = false;
                    }
                }
            }
            if (!endGame && !fullField) {
                try {
                    move = player2.getNextMove();
                    if (checkValidityOfMove(move)) {
                        move.setFilledX(true);
                        updateWithX(move);
                    }
                    System.out.println("Player 2 made a move " + move.toString());
                    player1.updateFieldCells(move);
                    player2.updateFieldCells(move);
                    if (hasWinner()) {
                        winner = "Winner is Player 2";
                        endGame = true;
                    }
                }
                catch (IllegalArgumentException e) {
                    winner = "Winner is Player 1";
                    endGame = true;
                }
                catch (Throwable e) {
                    e.printStackTrace();
                }
            }
            if (!hasWinner() && fullField) {
                endGame = true;
                winner = "Tie";
            }
        } while (!endGame);
        System.out.println(winner);
    }

    @Override
    public void updateField(Cell move) {
        //not used, more specified methods are in use
    }

    public void updateWithX(Cell move) {
        PlayingField.getField().getCells()[move.getHorizontal()][move.getVertical()].setFilledX(true);
    }

    public void updateWithO(Cell move) {
        PlayingField.getField().getCells()[move.getHorizontal()][move.getVertical()].setFilledO(true);
    }

    @Override
    public boolean hasWinner() { //тут проверка на победителя
        return this.PlayingField.getField().checkHasWinner();
    }
}
