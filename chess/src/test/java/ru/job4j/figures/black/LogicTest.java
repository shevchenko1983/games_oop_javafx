package ru.job4j.figures.black;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class LogicTest {
    Logic logic = new Logic();

    @Test
    public void MoveWhenCellsWayIsNotEmpty () {
       //Cell.C2 - not empty on start game
       assertFalse(logic.move(Cell.C2, Cell.E4));
    }

    @Test
    public void MoveWhenCellsWayIsEmpty () {
       assertTrue(logic.move(Cell.C3, Cell.E5));
    }

}
