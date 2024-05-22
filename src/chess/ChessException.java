package chess;

public class ChessException extends RuntimeException {
	private final static long serialVersionUID = 1L;
	
	public ChessException(String msg) {
		super(msg);
	}
}