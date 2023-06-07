package TicTacToe;

import java.util.Scanner;

public class Manager {
private static final int MAX_SIZE=3;
private static void print(char[][] board) {
	for(int i=0;i<board.length;i++) {
		for(int j=0;j<board[0].length;j++) {
			System.out.print(board[i][j]+" ");
		}
		System.out.println();
	}
	System.out.println();
}
private boolean check(char[][] board,char c,int i,int j) {
	int[][] dir= {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
	int count=1;
	boolean find=false;
	for(int d=0;d<dir.length;d++) {
		int x=i+dir[d][0];
		int y=j+dir[d][1];
		if(x>=0 && x<MAX_SIZE && y>=0 && y<MAX_SIZE  && board[x][y]==c) {
			count++;
			x=x+dir[d][0];
			y=y+dir[d][1];
			if(x>=0 && x<MAX_SIZE && y>=0 && y<MAX_SIZE && board[x][y]==c) {
				count++;
				
			}
			x=i-dir[d][0];
			y=j-dir[d][1];
			if(x>=0 && x<MAX_SIZE && y>=0 && y<MAX_SIZE && board[x][y]==c) {
				count++;
			}
			
		}
		if(count==MAX_SIZE) {
			find=true;
			break;
		}
		count=1;
	}
	if(find) {
		return true;
	}
	return false;
}
protected int isTerminate(char[][] board,char c1,char c2) {
	for(int i=0;i<board.length;i++) {
		for(int j=0;j<board[0].length;j++) {
			if(board[i][j]==c1) {
				boolean b=check(board,c1,i,j);
				if(b) {
					return 1;
				}
			}
			else if(board[i][j]==c2) {
				boolean b=check(board,c2,i,j);
				if(b) {
					return 2;
				}
			}
		}
	}
	for(int i=0;i<board.length;i++) {
		for(int j=0;j<board[0].length;j++) {
			if(board[i][j]=='\0') {
				return -1;
			}
		}
	}
	return 0;
}
protected void execute() {
	Scanner sc=new Scanner(System.in);
	System.out.println("--------------Welcome to our game plateform!-------------");
	System.out.println("Enter the first player name: ");
	String p1Name=sc.next();
	System.out.println("Enter the first player symbol: ");
	char c1=sc.next().charAt(0);
	System.out.println("Enter the second player name: ");
	String p2Name=sc.next();
	System.out.println("Enter the second player symbol: ");
	char c2=sc.next().charAt(0);
	Player p1=new Player(p1Name,c1);
	Player p2=new Player(p2Name,c2);
	Board board=new Board(p1,p2);
	start(board);
}
protected void start(Board board) {
	Scanner sc=new Scanner(System.in);
	boolean toggle=true;
	while(toggle) {
		System.out.println("Enter your indices mr "+board.p1.getName());
		int x=sc.nextInt();
		int y=sc.nextInt();
		board.board[x][y]=board.p1.getSymbol();
		int b = isTerminate(board.board,board.p1.getSymbol(),board.p2.getSymbol());
		if(b==board.DROP) {
			System.out.println("drop");
			break;
		}
		else if(b==board.firstPlayerWon) {
			System.out.println(board.p1.getName()+" won");
		}
		else if(b==board.NOT_COMPLETE) {
			print(board.board);
		}
		
		System.out.println("Enter your indices mr "+board.p2.getName());
		x=sc.nextInt();
		y=sc.nextInt();
		board.board[x][y]=board.p2.getSymbol();
		 b =isTerminate(board.board,board.p1.getSymbol(),board.p2.getSymbol());
		 if(b==board.DROP) {
				System.out.println("drop");
				break;
			}
			else if(b==board.secondPlayerWon) {
				System.out.println(board.p2.getName()+" won");
			}
			else if(b==board.NOT_COMPLETE) {
				print(board.board);
			}
	}
	
	
}
}
