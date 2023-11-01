package chess.pieces;

import boadgame.Board;
import boadgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

  private ChessMatch chessMatch;

  public King(Board board, Color color, ChessMatch chessMatch) {
    super(board, color);
    this.chessMatch = chessMatch;
  }

  private boolean canMove(Position position) {
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return (p == null || p.getColor() != getColor());

  }

  private boolean testRookCastiling(Position position) {
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return p != null
        && p instanceof Rook
        && p.getColor() == getColor()
        && p.getMoveCount() == 0;
  }

  @Override
  public String toString() {
    return "K";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

    Position p = new Position(0, 0);

    // up
    p.setValue(position.getRow() - 1, position.getColumn());
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // down
    p.setValue(position.getRow() + 1, position.getColumn());
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // left
    p.setValue(position.getRow(), position.getColumn() - 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // right
    p.setValue(position.getRow(), position.getColumn() + 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // up-left
    p.setValue(position.getRow() - 1, position.getColumn() - 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // up-rigt
    p.setValue(position.getRow() - 1, position.getColumn() + 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // down-left
    p.setValue(position.getRow() + 1, position.getColumn() - 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // down-right
    p.setValue(position.getRow() + 1, position.getColumn() + 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // Castiling
    if (getMoveCount() == 0 && !chessMatch.getCheck()) {
      // right rook
      Position posR1 = new Position(position.getRow(), position.getColumn() + 3);
      if (testRookCastiling(posR1)) {
        Position p1 = new Position(position.getRow(), position.getColumn() + 1);
        Position p2 = new Position(position.getRow(), position.getColumn() + 2);
        if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
          mat[position.getRow()][position.getColumn() + 2] = true;
        }
      }
      // left rook
      Position posR2 = new Position(position.getRow(), position.getColumn() - 4);
      if (testRookCastiling(posR2)) {
        Position p1 = new Position(position.getRow(), position.getColumn() - 1);
        Position p2 = new Position(position.getRow(), position.getColumn() - 2);
        Position p3 = new Position(position.getRow(), position.getColumn() - 3);

        if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
          mat[position.getRow()][position.getColumn() - 2] = true;

        }
      }
    }

    return mat;
  }

}
