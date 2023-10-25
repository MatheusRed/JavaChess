import boadgame.Board;
import chess.ChessMatch;

public class App {
    public static void main(String[] args) throws Exception {

        ChessMatch chessMatch = new ChessMatch();

        System.out.println();
        UI.printBoard(chessMatch.getPieces());
    }
}
