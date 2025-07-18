
public class Cell {
	
	 private MarkType mark = MarkType.EMPTY;

	    public MarkType getMark() {
	        return mark;
	    }

	    public void mark(MarkType newMark) {
	        if (mark != MarkType.EMPTY)
	            throw new IllegalStateException("Cell is already marked!");
	        if (newMark == MarkType.EMPTY)
	            throw new IllegalArgumentException("Cannot mark EMPTY!");
	        this.mark = newMark;
	    }

}
