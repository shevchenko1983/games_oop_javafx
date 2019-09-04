package ru.job4j.figures.black;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class LogicTest {
    Logic logic = new Logic();
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    @Test
    public void MoveWhenCellsWayIsNotEmpty () {
      assertFalse(logic.move(Cell.C2, Cell.E4));
    }

    @Test
    public void CheckWhenCellsWayIsEmpty () {
       Cell[] steps ={Cell.C3, Cell.E5};
       assertTrue(logic.checkForEmptyCell(steps));
    }

}
