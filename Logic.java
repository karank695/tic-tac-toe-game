package TicTacToe;

public class Logic {
	private static boolean check(char[][] board,char c,int i,int j) {
		int[][] dir= {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
		int count=1;
		boolean find=false;
		for(int d=0;d<dir.length;d++) {
			int x=i+dir[d][0];
			int y=j+dir[d][1];
			if(x>=0 && x<3 && y>=0 && y<3 && board[x][y]==c) {
				count++;
				x=x+dir[d][0];
				y=y+dir[d][1];
				if(x>=0 && x<3 && y>=0 && y<3 && board[x][y]==c) {
					count++;
					
				}
				x=i-dir[d][0];
				y=j-dir[d][1];
				if(x>=0 && x<3 && y>=0 && y<3 && board[x][y]==c) {
					count++;
				}
				
			}
			if(count==3) {
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
	public static void main(String arg[]) {
		char[][] b= {{'c','a','a'},{'a','a','c'},{'b','b','c'}};
		System.out.println(check(b,'c',2,2));
	}
}
