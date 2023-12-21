public class Board {
    char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public static void main(String[] args) {
        System.out.println("Board initialised");
    }

    void print() {
        System.out.println("    1   2   3");
        System.out.println("1   " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
        System.out.println("   ---+---+---");
        System.out.println("2   " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
        System.out.println("   ---+---+---");
        System.out.println("3   " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
        System.out.println("");
    }

    boolean check_empty(int row, int col) {
        if (board[row][col] == ' ') {
            return true;
        } else {
            return false;
        }        
    }

    void set_marker(int row, int col, char player) {
        board[row][col] = player;      
    }

    int check_win(int turn_num) {
        int win = 1;
        int draw = 2;

        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return win;
            }

            //Check columns
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return win;
            }
        }

        // Check diag
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return win;
        }

        // Check anti-diag
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return win;
        }

        if (turn_num == 9) {
            return draw;
        }

        return 0;
    }
}
