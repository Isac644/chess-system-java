package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) throws BoardException{
		if (rows <= 0 || columns <= 0) {
			throw new BoardException("Error: Invalid board size");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public Piece[][] getPieces(){
		return pieces;
	}
	
	public Piece piece(int row, int column)  throws BoardException {
		if(!positionExists(row, column)) {
			throw new BoardException("Error: Invalid position");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position)  throws BoardException {
		if(!positionExists(position)) {
			throw new BoardException("Error: Invalid position");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Invalid position");
		}
		if(!thereIsAPiece(position)) {
			return null;
		}
		Piece aux = pieces[position.getRow()][position.getColumn()];
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	public void placePiece(Piece piece, Position position) throws BoardException{
		if(thereIsAPiece(position)) {
			throw new BoardException("Error: Already exists a piece on position");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public boolean positionExists(int row, int column) {
		return row < rows && row >= 0 && column < columns && column >= 0;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) throws BoardException {
		if(!positionExists(position)) {
			throw new BoardException("Error: Invalid position");
		}
		return pieces[position.getRow()][position.getColumn()] != null;
	}
}
