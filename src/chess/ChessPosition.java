package chess;

import boardgame.Position;

public class ChessPosition {
	private char column;
	private Integer row;
	
	public ChessPosition(char column, Integer row) {
		this.column = column;
		this.row = row;
	}

	public Integer getRow() {
		return row;
	}

	public char getColumn() {
		return column;
	}	
	
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}