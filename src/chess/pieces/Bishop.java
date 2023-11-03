package chess.pieces;

import boadgame.Board;
import boadgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

  private boolean icon;

  public Bishop(Board board, Color color, boolean icon) {
    super(board, color);
    this.icon = icon;
  }

  @Override
  public String toString() {
    if (icon == true) {
      return "\ue29c";
    }
    return "B";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

    Position p = new Position(0, 0);

    // up - left
    p.setValue(position.getRow() - 1, position.getColumn() - 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setValue(p.getRow() - 1, p.getColumn() - 1);
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // up - right
    p.setValue(position.getRow() - 1, position.getColumn() + 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setValue(p.getRow() - 1, p.getColumn() + 1);

    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }
    // down - left
    p.setValue(position.getRow() + 1, position.getColumn() - 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setValue(p.getRow() + 1, p.getColumn() - 1);

    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // down - right
    p.setValue(position.getRow() + 1, position.getColumn() + 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setValue(p.getRow() + 1, p.getColumn() + 1);
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    return mat;
  }

}
