import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GameTest {
    
    @Test
    void testCellStartsEmpty() {
        Cell cell = new Cell();
        assertEquals(MarkType.EMPTY, cell.getMark());
    }

    @Test
    void testMarkXO() {
        Cell cell = new Cell();
        cell.mark(MarkType.X);
        assertEquals(MarkType.X, cell.getMark());
    }

    @Test
    void testCannotMarkAgain() {
        Cell cell = new Cell();
        cell.mark(MarkType.O );
        assertThrows(IllegalStateException.class, () -> {
            cell.mark(MarkType.X);
        });
    }
    
    @Test
    void testMarkingOnceIsAllowed() {
        Cell cell = new Cell();                     
        cell.mark(MarkType.O);                       
        assertEquals(MarkType.O, cell.getMark());   
    }


    @Test
    void testMarkingWithEmptyThrowsException() {
        Cell cell = new Cell();
        assertThrows(IllegalArgumentException.class, () -> {
            cell.mark(MarkType.EMPTY);
        });
    }
    
    @Test
    void testMarkFailsIncorrectly() {
        Cell cell = new Cell();
        cell.mark(MarkType.X);
        assertEquals(MarkType.O, cell.getMark(), "Expected O but got X");
    }

}
