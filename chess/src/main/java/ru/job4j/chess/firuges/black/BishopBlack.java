package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        /**
         * Check if these coordinates not from chess diagonals
         */
        if (!isDiagonal(source, dest)) {
            throw  new IllegalStateException(String.format("Could not move by diagonal from %s to %s", source, dest));
        }
        /**
         * Max length of chess diagonal
         */
        int size = 6;
        Cell[] steps = new Cell[size];
        int deltaX = source.x;
        int deltaY = source.y;
        for (int index = 0; index < size; index++) {
            if(index == 0) {
                steps[index] = source;
            }
            steps[index] = steps[deltaX];
        }
        return steps;
        //return new Cell[] { dest };
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    /**
     * Check if this is diagonal
     * @param source
     * @param dest
     * @return
     */
    public boolean isDiagonal(Cell source, Cell dest) {

       return false;
    }
}
