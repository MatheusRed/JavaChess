package boadgame;

public class Piece {
  protected Position position;
  private Board board;

  public Piece(Board board) {
    this.board = board;
    position = null;
  }

  public Piece(Position position, Board board) {
    this.position = position;
    this.board = board;
  }

  protected Board getBoard() {
    return board;
  }

}
