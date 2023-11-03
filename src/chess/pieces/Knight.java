package chess.pieces;

import boadgame.Board;
import boadgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

  private boolean icon;

  public Knight(Board board, Color color, boolean icon) {
    super(board, color);
    this.icon = icon;
  }

  private boolean canMove(Position position) {
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return (p == null || p.getColor() != getColor());

  }

  @Override
  public String toString() {
    if (icon == true) {
      return "\udb82\udc58";
    }
    return "N";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

    Position p = new Position(0, 0);

    // up left up
    p.setValue(position.getRow() - 2, position.getColumn() - 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // up left down
    p.setValue(position.getRow() - 1, position.getColumn() - 2);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // up right up
    p.setValue(position.getRow() - 2, position.getColumn() + 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // up right down
    p.setValue(position.getRow() - 1, position.getColumn() + 2);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // down left down
    p.setValue(position.getRow() + 2, position.getColumn() - 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // down left up
    p.setValue(position.getRow() + 1, position.getColumn() - 2);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // down right down
    p.setValue(position.getRow() + 2, position.getColumn() + 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // down right up
    p.setValue(position.getRow() + 1, position.getColumn() + 2);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    return mat;
  }

}
