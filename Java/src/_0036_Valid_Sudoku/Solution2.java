package _0036_Valid_Sudoku;

import java.util.HashSet;

/**
 * Date: 2020/9/15 17:14
 * Content:
 */
public class Solution2 {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int t = board[i][j] - '0';
                int index = i / 3 * 3 + j / 3;
                if (row[i][t] || col[j][t] || box[index][t]) return false;

                row[i][t] = true;  // (i, j)在第i行
                col[j][t] = true;  // (i, j)在第j列
                box[index][t] = true;  // (i, j)在第index个九宫格
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

        char[][] board = {
                {'.', '9', '.', '.', '4', '.', '.', '.', '.'},
                {'1', '.', '.', '.', '.', '.', '6', '.', '.'},
                {'.', '.', '3', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '5', '.', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '4', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '7', '.', '.', '.', '.'}
        };
        System.out.println((new Solution2()).isValidSudoku(board));
    }
}
