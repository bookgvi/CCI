package backtracking;

public class Sudoku {
    int[][] storedCells = new int[81][2];
    int counter = 0;
    boolean isFinish = false;
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    private void backtrack(char[][] board, int row) {
        int maxCount = board.length;
        int col = 0;
        for (; col < maxCount; col += 1) {
            if (isEmptyCell(board[row][col])) {
                String digits = "123456789";
                for (char digit : digits.toCharArray()) {
                    if (isValid(board, row, col, digit)) {
                        place(board, row, col, digit);
                        backtrack(board, row);
                        if (!isFinish) {
                            removeLast(board);
                        }
                    }
                }
                break;
            }
        }
        if (col >= maxCount && row + 1 < maxCount) {
            backtrack(board, row + 1);
        }
        if (!isFinish && row + 1 >= maxCount) {
            isFinish = true;
        }
    }
    
    private void removeLast(char[][] board) {
        if (counter + 1 > 0) {
            int lastRow = storedCells[counter - 1][0];
            int lastCol = storedCells[counter - 1][1];
            storedCells[counter] = new int[2];
            counter -= 1;
            board[lastRow][lastCol] = '.';
        }
    }

    private void place(char[][] board, int row, int col, char digit) {
        board[row][col] = digit;
        storedCells[counter++] = new int[]{row, col};
    }

    private boolean isValid(char[][] board, int row, int col, char digit) {
        return canPlaceInSmallSquare(board, row, col, digit) && canPlaceInRowAndCol(board, row, col, digit);
    }

    private boolean canPlaceInRowAndCol(char[][] board, int row, int col, char digit) {
        for (int i = 0; i < 9; i += 1) {
            if (digit == board[row][i]) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 1) {
            if (digit == board[i][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean canPlaceInSmallSquare(char[][] board, int row, int col, char digit) {
        int smallRowStart = row - (row % 3);
        for (int r = smallRowStart; r < smallRowStart + 3; r += 1) {
            int smallColStart = col - (col % 3);
            for (int c = smallColStart; c < smallColStart + 3; c += 1) {
                if (digit == board[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEmptyCell(char c) {
        return c == '.';
    }
}
