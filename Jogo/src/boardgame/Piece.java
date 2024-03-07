package boardgame;

public class Piece {
	protected Position position;
	private Board board;

	public Position getPosition() {
		return position;
	}


	protected Board getBoard() {
		return board;
	}


	public Piece(Board board) {
		this.board = board;
	}

}
