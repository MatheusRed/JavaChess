package chess.pieces;

import boadgame.Board;
import boadgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

  private ChessMatch chessMatch;
  private boolean icon;

  public Pawn(Board board, Color color, ChessMatch chessMatch, boolean icon) {
    super(board, color);
    this.chessMatch = chessMatch;
    this.icon = icon;
  }

  @Override
  public String toString() {
    if (icon == true) {
      return "\udb82\udc59";
    }
    return "P";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
    Position p = new Position(0, 0);

    if (getColor() == Color.WHITE) {
      p.setValue(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValue(position.getRow() - 2, position.getColumn());
      Position p2 = new Position(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(p)
          && !getBoard().thereIsAPiece(p)
          && getBoard().positionExists(p2)
          && !getBoard().thereIsAPiece(p2)
          && getMoveCount() == 0) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValue(position.getRow() - 1, position.getColumn() - 1);
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValue(position.getRow() - 1, position.getColumn() + 1);
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      // en passant
      if (position.getRow() == 3) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(left)
            && isThereOpponentPiece(left)
            && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
          mat[left.getRow() - 1][left.getColumn()] = true;
        }
        Position right = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(right)
            && isThereOpponentPiece(right)
            && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
          mat[right.getRow() - 1][right.getColumn()] = true;
        }
      }
    } else {
      p.setValue(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValue(position.getRow() + 2, position.getColumn());
      Position p2 = new Position(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(p)
          && !getBoard().thereIsAPiece(p)
          && getBoard().positionExists(p2)
          && !getBoard().thereIsAPiece(p2)
          && getMoveCount() == 0) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValue(position.getRow() + 1, position.getColumn() - 1);
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValue(position.getRow() + 1, position.getColumn() + 1);
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      // en passant
      if (position.getRow() == 4) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(left)
            && isThereOpponentPiece(left)
            && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
          mat[left.getRow() + 1][left.getColumn()] = true;
        }
        Position right = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(right)
            && isThereOpponentPiece(right)
            && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
          mat[right.getRow() + 1][right.getColumn()] = true;
        }
      }
    }
    return mat;
  }
}
