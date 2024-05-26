package chess;

import boardgame.BoardException;

public class ChessException extends BoardException {
	private final static long serialVersionUID = 1L;
	
	public ChessException(String msg) {
		super(msg);
	}
}