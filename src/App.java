import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner read = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        System.out.println();
        while (true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.println("Source: ");
            ChessPosition source = UI.readChessPosition(read);

            System.out.println();
            System.out.println("Target: ");
            ChessPosition target = UI.readChessPosition(read);

            ChessPiece capturedPiece = chessMatch.perfomeChessMove(source, target);
        }
    }
}
