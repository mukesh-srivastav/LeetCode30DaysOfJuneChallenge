/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

For more: https://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
 */
class Day17_SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length;
        
        if (board.length == 0 || board[0].length==0)
            return;
        
        int m = board[0].length;
        
        // Assign all O as -. 
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = '-';
                }
            }
        }
        
        // Convert edged cells with - value to O - Left
        for (int i=0; i<n; i++) {
            if (board[i][0] == '-') {
                specialFloodFill(board, i, 0, '-', 'O');
            }
        }
        // Right
        for (int i=0; i<n; i++) {
            if (board[i][m-1] == '-') {
                specialFloodFill(board, i, m-1, '-', 'O');
            }
        }
        //Top
        for (int i=0; i<m; i++) {
            if (board[0][i] == '-') {
                specialFloodFill(board, 0, i, '-', 'O');
            }
        }
        //Bottom
        for (int i=0; i<m; i++) {
            if (board[n-1][i] == '-') {
                specialFloodFill(board, n-1, i, '-', 'O');
            }
        }
        // Convert remaining - to X as this will be only those which will be surrounded by X. 
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void specialFloodFill(char board[][], int x, int y, char prev, char curr)
    {
        int n = board.length;
        int m = board[0].length;
        if ((x<0 || x>=n) || (y<0 || y>=m))
            return;
        
        if (board[x][y] != prev)
            return;
        
        board[x][y] = curr;
        
        specialFloodFill(board, x-1, y, '-', 'O');
        specialFloodFill(board, x+1, y, '-', 'O');
        specialFloodFill(board, x, y-1, '-', 'O');
        specialFloodFill(board, x, y+1, '-', 'O');
    }
}