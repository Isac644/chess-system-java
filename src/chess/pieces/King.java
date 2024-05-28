package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	public boolean canMove(Position position) {
		Piece p = getBoard().piece(position);
		return p == null || isThereOpponentPiece(position);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		// up
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// down
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// up
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// down
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// left
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// right
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		if(!chessMatch.getCheck() && getMoveCount() == 0) {
			// Castling right
			p.setValues(position.getRow(), position.getColumn() + 2);
			if(!getBoard().thereIsAPiece(new Position(p.getRow(), p.getColumn() - 1)) && !getBoard().thereIsAPiece(p) && testRookCheck(new Position(p.getRow(), p.getColumn() + 1))){
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Castling left
			p.setValues(position.getRow(), position.getColumn() - 2);
			if(!getBoard().thereIsAPiece(new Position(p.getRow(), p.getColumn() + 1)) && !getBoard().thereIsAPiece(p) && testRookCheck(new Position(p.getRow(), p.getColumn() - 2))){
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return mat;
	}
	
	public boolean testRookCheck(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && getColor() == p.getColor() && getMoveCount() == 0;
	}
	
	public String toString() {
		return "K";
	}
}
