package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import boardgame.BoardException;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> capturedPieces = new ArrayList<>();

		while (true) {
			try {
				UI.clearScreen();
				System.out.println();
				UI.printMatch(chessMatch, capturedPieces);

				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				UI.clearScreen();
				System.out.println();
				UI.printBoard(chessMatch.getPieces(), chessMatch.possibleMoves(source));
				System.out.println();
				
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if(capturedPiece != null) {
					capturedPieces.add(capturedPiece);
				}
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
				sc.nextLine();
			} catch (BoardException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
				sc.nextLine();
			}
		}

	}

}