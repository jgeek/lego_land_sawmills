package zalando;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    private static char GUARDED_CHAR = 'G';

    public boolean solution(String[] B) {
        // write your code in Java SE 11

        char[][] initBoard = toCharArr(B);
        char[][] board = fillGuards(initBoard);
        int[] aPos = positionOfA(board);
        boolean[] result = { false };
        hasSolution(board, aPos[0], aPos[1], result);
        return result[0];
    }

    private boolean hasSolution(char[][] board, int row, int col, boolean[] hasSolution) {

        if (row == board.length - 1 && col == board[0].length - 1) {
            return true;
        } else {
            if (isValidCell(board, row, col - 1)) {
                hasSolution[0] = hasSolution[0] || hasSolution(board, row, col - 1, hasSolution);
                return hasSolution[0];
            }
            if (isValidCell(board, row, col + 1)) {
                hasSolution[0] = hasSolution[0] || hasSolution(board, row, col - 1, hasSolution);
                return hasSolution[0];
            }
            if (isValidCell(board, row - 1, col)) {
                hasSolution[0] = hasSolution[0] || hasSolution(board, row, col - 1, hasSolution);
                return hasSolution[0];
            }
            if (isValidCell(board, row + 1, col)) {
                hasSolution[0] = hasSolution[0] || hasSolution(board, row, col - 1, hasSolution);
                return hasSolution[0];
            }
        }

        return false;
    }

    private boolean isValidCell(char[][] board, int row, int col) {
        char c = board[row][col];
        return row>0 && col >0 && row < board.length - 1 && col < board[0].length - 1 && c != 'X' && c != '<' && c != '>' && c != 'v' &&
                c != '^' && c != 'G';
    }

    private int[] positionOfA(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'A') {
                    var arr = new int[2];
                    arr[0] = row;
                    arr[1] = col;
                    return arr;
                }

            }
        }
        throw new RuntimeException();
    }

    private char[][] toCharArr(String[] b) {
        char[][] newBoard = new char[b.length][b[0].length()];
        for (int i = 0; i < b.length; i++) {
            char[] row = b[i].toCharArray();
            for (int j = 0; j < b[0].length(); j++) {
                newBoard[i][j] = row[j];
            }
        }
        return newBoard;
    }

    private char[][] fillGuards(char[][] baseBoard) {
        char[][] newBoard = new char[baseBoard.length][baseBoard[0].length];
        for (int row = 0; row < baseBoard.length; row++) {
            // char[] arr = baseBoard[row].toCharArray();
            for (int col = 0; col < baseBoard[0].length; col++) {
                switch (baseBoard[row][col]) {
                    case 'X':
                    case 'A':
                    case '.':
                        newBoard[row][col] = baseBoard[row][col]; continue;
                    case '>':
                        for (int i = col + 1; i < baseBoard[0].length; i++) {
                            char currentCell = baseBoard[row][i];
                            if (currentCell == '.' || currentCell == GUARDED_CHAR) {
                                newBoard[row][i] = GUARDED_CHAR;
                                baseBoard[row][i] = GUARDED_CHAR;
                                // setChar(baseBoard, i, col, GUARDED_CHAR);
                                // arr[i] = GUARDED_CHAR;
                            } else {
                                break;
                            }
                        }
                        newBoard[row][col] = '>';
                        // baseBoard[row] = arr.toString();
                        continue;
                    case '<':
                        for (int i = col - 1; i > 0; i--) {
                            char currentCell = baseBoard[row][i];
                            if (currentCell == '.' || currentCell == GUARDED_CHAR) {
                                newBoard[row][i] = GUARDED_CHAR;
                                baseBoard[row][i] = GUARDED_CHAR;
                                // setChar(baseBoard, i, col, GUARDED_CHAR);
                                // arr[i] = GUARDED_CHAR;
                            } else {
                                break;
                            }
                        }
                        newBoard[row][col] = '<';
                        // baseBoard[row] = arr.toString();
                        continue;
                    case '^':
                        for (int i = row - 1; i > 0; i--) {
                            char currentCell = baseBoard[i][col];
                            if (currentCell == '.' || currentCell == GUARDED_CHAR) {
                                newBoard[i][col] = GUARDED_CHAR;
                                baseBoard[i][col] = GUARDED_CHAR;
                                // setChar(baseBoard, i, col, GUARDED_CHAR);
                                // arr[i] = GUARDED_CHAR;
                            } else {
                                break;
                            }
                        }
                        newBoard[row][col] = '^';
                        // baseBoard[row] = arr.toString();
                        continue;
                    case 'v':
                        for (int i = row + 1; i < baseBoard.length; i++) {
                            char currentCell = baseBoard[i][col];
                            if (currentCell == '.' || currentCell == GUARDED_CHAR) {
                                newBoard[i][col] = GUARDED_CHAR;
                                // arr[i] = GUARDED_CHAR;
                                baseBoard[i][col] = GUARDED_CHAR;
                                // setChar(baseBoard, i, col, GUARDED_CHAR);
                            } else {
                                break;
                            }
                        }
                        newBoard[row][col] = 'v';
                        // baseBoard[row] = arr.toString();
                        continue;
                }
            }
        }
        return newBoard;
    }

    private void setChar(String[] baseBoard, int i, int col, char guardedChar) {
        char[] chars = baseBoard[i].toCharArray();
        chars[col] = guardedChar;
        baseBoard[i] = chars.toString();
    }

    public static void main(String[] args) {
        String[] B = { "X.....>", "..v..X.", ".>..X..", "A......" };
        new Solution().solution(B);
    }

    private char getCharOf(String[] baseBoard, int row, int col) {
        return baseBoard[row].toCharArray()[col];
    }
}
