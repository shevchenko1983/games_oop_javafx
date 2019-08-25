package ru.job4j.figures.black;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    BishopBlack bishopBlack;

    @Before
    public void setUp () {
        bishopBlack = new BishopBlack(Cell.C1);
    }

    /**
     * Проверка метода position.
     * Создайте объект и вызовите у него метод position.
     * Проверьте, что он занимает ту же ячейку, что и при создании объекта.
     */
    @Test
    public void TheSamePositionWhenItStarted () {
      assertThat(Cell.C1, is(bishopBlack.position()));
    }

    /**
     *  Проверка метода copy.
     *  Создайте объект и вызовите у него метод copy.
     *  Проверьте, что возвращенный объект имеет правильную позицию.
     */
    @Test
    public void TheSamePositionWhenObjectCopied () {
        assertThat(bishopBlack.copy(bishopBlack.position()).position(), is(bishopBlack.position()));
    }

    @Test
    public void TheWayWhenObjectMoved () {
        bishopBlack.way(Cell.C1, Cell.G5);
        assertThat(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}, is(bishopBlack.way(Cell.C1, Cell.G5)));

    }
}
