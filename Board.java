package TicTacToe;

public class Board {
static final int SIZE=3;
static final int NOT_COMPLETE=-1;
static final int DROP=0;
static final int firstPlayerWon=1;
static final int secondPlayerWon=2;
protected char[][] board;
Player p1;
Player p2;
public Board(Player p1,Player p2) {
	this.p1=p1;
	this.p2=p2;
	board=new char[SIZE][SIZE];
	for(int i=0;i<SIZE;i++) {
		for(int j=0;j<SIZE;j++) {
			board[i][j]='\0';
		}
	}
}
}
