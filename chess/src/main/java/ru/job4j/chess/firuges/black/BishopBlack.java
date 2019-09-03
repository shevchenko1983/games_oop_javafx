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
         * Find length of chess Cells diagonal
         */
        int size = dest.x - source.x;
        /**
         * check if size  is < 0,
         * make from negative value -> positive value
         */
        if (size < 0) {
            size = -size;
        }
        Cell[] steps = new Cell[size];
        /**
         * Define Deltas - is difference between dest and source positions.
         */
        int deltaX = dest.x > source.x ? 1 : -1;
        int deltaY = dest.y > source.y ? 1 : -1;
        for (int index = 0; index < size; index++) {
            /**
             * Set new positions
             */
            int x = source.x + (index + 1) * deltaX;
            int y = source.y + (index + 1) * deltaY;
            /**
             * Set to array positions via findCell(x, y) method
             */
            steps[index] = position.findCell(x, y);
            /**
             * if we found the dest Cell - brake and return steps array with way cells.
             */
            if (position.findCell(x,y) == dest) {
                return steps;
            }
        }
       return null;
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
        /**
         * Get Cell counter by steps
         */
        int countSteps = dest.x - source.x;
        System.out.println(countSteps);
        /**
         * If difference between dest and source coordinates not equals countSteps Cell - it's not Diagonal
         */
       if ((dest.x - source.x) % countSteps == 0 && (dest.y - source.y) % countSteps == 0) {
           return true;
       }
       return false;
    }
}
