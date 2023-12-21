public class Board {
    char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public static void main(String[] args) {
        System.out.println("Board initialised");
    }

    void print() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
    }

    boolean check_empty(int row, int col) {
        if (board[row][col] == ' ') {
            return true;
        } else {
            return false;
        }        
    }

    void set_marker(int row, int col, int counter) {
        if (counter % 2 == 1) {
            board[row][col] = 'X';
        } else {
            board[row][col] = 'O';
        }        
    }

    boolean check_win() {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }

            //Check columns
            if (board[i][0] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }

        // Check diag
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }

        // Check anti-diag
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }

        return false;
    }
}
