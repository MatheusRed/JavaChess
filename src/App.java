import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner read = new Scanner(System.in);
        List<ChessPiece> captured = new ArrayList<>();
        ChessMatch chessMatch;
        UI.clearScreen();

        System.out.println("Would you like to use Nerd Fonts? \ue659 (Y / N)  ");
        String icon = read.nextLine();
        if (icon.equals("Y")) {
            chessMatch = new ChessMatch(true);
            chessMatch.setIcon(true);
        } else {
            chessMatch = new ChessMatch();
        }

        System.out.println();

        while (!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.println("Source: ");
                ChessPosition source = UI.readChessPosition(read);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(read);

                ChessPiece capturedPiece = chessMatch.perfomeChessMove(source, target);

                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }

                if (chessMatch.getPromoted() != null) {
                    System.out.print("Enter piece for promotion (B/N/R/Q): ");
                    String type = read.nextLine().toUpperCase();
                    while (!type.equals("B")
                            && !type.equals("N")
                            && !type.equals("R")
                            && !type.equals("Q")) {
                        System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                        type = read.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                read.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                read.nextLine();
            }

        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
