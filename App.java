import java.util.List;
public class App {

    public static void main(String[] args) {
        // Create board
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        // prints initial board
        print_board(board);
    }


    static void print_board(char[][] board) {
        // Print board
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
    }
}