package valid.sudoku;

public class Solution {
	public int[] init(int flg[]) {
		for (int i=0;i<flg.length;i++) {
			flg[i] = 0;
		}
		return flg;
	}
	public boolean isValidChar(char c) {
		if ( !(c>='1' && c<='9') && c!='.' ) return false;
		return true;
	}
	public boolean isValidSudoku(char[][] board) {
		int n = 9;
		if (board.length < n) return false;
		for (int i=0;i<board.length;i++) {
			if (board[i].length < n) return false;
		}
		
		//判断每一行
		int flgrow[] = new int[10];
		for (int i=0;i<n;i++) {
			flgrow = init(flgrow);
			for (int j=0;j<n;j++) {
				if (!isValidChar(board[i][j])) return false; //判断是否是正常的字符
				if (board[i][j] != '.') {
					flgrow[board[i][j] - '0']++;
					if (flgrow[board[i][j] - '0'] > 1) return false; //有一个数字出现了2次
				}
			}
		}
		
		//判断每一列
		int flgcol[] = new int[10];
		for (int i=0;i<n;i++) {
			flgcol = init(flgcol);
			for (int j=0;j<n;j++) {
				if (board[j][i] != '.') {
					flgcol[board[j][i] - '0']++;
					if (flgcol[board[j][i] - '0'] > 1) return false;
				}
			}
		}
		
		//判断每一个3*3的小方格
		int flgsquare[] = new int[10];
		int row = 0;
		int col = 0;
		while(row<n) {
			while(col<n) {
				flgsquare = init(flgsquare);
				for (int i=row;i<row+3;i++) {
					for (int j=col;j<col+3;j++) {
						if (board[i][j] != '.') {
							flgsquare[board[i][j] - '0']++;
							if (flgsquare[board[i][j] - '0'] > 1) return false;
						}
					}
				}
				col += 3;
			}
			col = 0;
			row += 3;
		}
		
        return true;
    }
}
