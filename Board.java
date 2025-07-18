
public class Board {
	    private final Cell[][] cells = new Cell[3][3];

	    public Board() {
	        for (int i = 0; i < 3; i++)
	            for (int j = 0; j < 3; j++)
	                cells[i][j] = new Cell();
	    }

	    public Cell getCell(int row, int col) {
	        return cells[row][col];
	    }

	    public void placeMark(int row, int col, MarkType mark) {
	        cells[row][col].mark(mark);
	    }
	}

